package com.ericsson.eiffel.remrem.semantics.clone;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/*
 * To add properties JavaType, ExtendedJavaType and other required properties to the input Schema's to generate pojo's
*/
public class ChangeProperties {
	private static final String PROPERTIES = "properties";
	private static final String BATCHES = "batches";
	private static final String DEPENDENCIES = "dependencies";
	private static final String ENUM = "enum";
	private static final String TIME = "time";
	private static final String ITEMS = "items";
	private static final String OUTCOME = "outcome";
	private static final String DATA = "data";
	private static final String META = "meta";
	private static final String EXTENDS_JAVA_CLASS = "extendsJavaClass";
	private static final String COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS_EVENT = "\"com.ericsson.eiffel.semantics.events.Event\"";
	private static final String JAVA_TYPE = "javaType";
	private static final String FORMAT = "format";
	private static final String UTC_MILLISEC = "utc-millisec";
	private static final String COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS = "\"com.ericsson.eiffel.semantics.events.";
	static String fileContent;
	final static JsonParser parser = new JsonParser();
	final static String type = "type";
	final static String objectType = "object";
	static int count = 0;
	static FileWriter writer;
	static boolean isItemObject = false;
	static String oldName = "";
	private static String currentWorkingDir = System.getProperty("user.dir");
	static String fileName;
	static boolean isMeta = false;
	static boolean isEnumType = false;

	/*
	 * To modify the input schema's cloned from eiffel repo to generate pojo's
	 * using jsonSchema2pojo plugin.
	 * 
	 */
	public static void modifyFileContent(File newFile, String name) {
		try {
			fileName = name;
			byte[] fileBytes = Files.readAllBytes(Paths.get(newFile.getAbsolutePath()));
			fileContent = new String(fileBytes);
			JsonObject jsonContent = parser.parse(fileContent).getAsJsonObject();
			count = 0;
			JsonObject obj = new JsonObject();
			addingProperties(jsonContent, name, obj);
			createNewJsonFile(obj);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * To add javaType and ExtendedJavaType and other required properties to
	 * generate pojo's
	 */
	public static void addingProperties(JsonObject object, String newElementName, JsonObject obj) {
		Set<Entry<String, JsonElement>> values = object.entrySet();
		Iterator<Entry<String, JsonElement>> keyValue = values.iterator();
		while (keyValue.hasNext()) {
			Entry<String, JsonElement> valueSet = keyValue.next();
			if (valueSet.getValue().isJsonObject()) {
				String name = valueSet.getKey();
				oldName = newElementName;
				if (name.equals(META)) {
					isMeta = true;
				}
				if (name.equals(type) && isMeta) {
					isEnumType = true;
					isMeta = false;
				}
				addingItemsProperties(name, valueSet.getValue(), obj);
			} else {
				if (type.equals(valueSet.getKey())) {
					if (objectType.equals(valueSet.getValue().getAsString())) {
						obj.add(type, valueSet.getValue());
						if (count == 0) {
							obj.add(JAVA_TYPE, parser.parse(
									COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS.concat(StringUtils.capitalize(newElementName))
											+ "\""));
							obj.add(EXTENDS_JAVA_CLASS, parser.parse(COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS_EVENT));

						} else {
							newElementName = modifyClassName(newElementName);
							/* Class Name first letter should be in caps */
							String nameInCaps = StringUtils.capitalize(newElementName);
							if (newElementName.equals(DATA))
								/* Data is different for each and every event */
								obj.add(JAVA_TYPE,
										parser.parse(
												COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS.concat(fileName + "" + nameInCaps)
														+ "\""));
							else if (newElementName.equals(OUTCOME))
								/* Outcome is different for different events */
								obj.add(JAVA_TYPE,
										parser.parse(
												COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS.concat(fileName + "" + nameInCaps)
														+ "\""));
							else
								obj.add(JAVA_TYPE,
										parser.parse(COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS.concat(nameInCaps) + "\""));
						}
						count++;
					} else {
						obj.add(type, valueSet.getValue());
						if (newElementName.equals(TIME)) {
							obj.add(FORMAT, parser.parse(UTC_MILLISEC));
						}
					}
				} else {
					obj.add(valueSet.getKey(), valueSet.getValue());
					if (valueSet.getKey().equals(ENUM)) {
						if (isEnumType) {
							obj.add(valueSet.getKey(), parser.parse(CloneRemoteRepository.fileNames.toString()));
							isEnumType = false;
						}
					}
				}
			}
		}
		if (values.isEmpty()) {
			obj.add(type, parser.parse("string"));
		}
	}

	/* Renaming some classes which are ending with 's' letter */
	public static String modifyClassName(String className) {
		String newName = className;
		if (className.endsWith("s")) {
			if (className.equals(DEPENDENCIES)) {
				newName = "dependency";
			} else if (className.equals(BATCHES)) {
				newName = "batch";
			} else if (className.equals(PROPERTIES)) {
				newName = "property";
			} else {
				newName = StringUtils.chop(className);
			}
		}
		return newName;
	}

	/*
	 * Items is an array of object so we are using recursive functionality to
	 * get json elements from the Items array
	 */
	public static void addingItemsProperties(String name, JsonElement value, JsonObject obj) {
		if (value.isJsonObject()) {
			JsonObject newJsonObj = new JsonObject();
			if (name.equals(ITEMS)) {
				addingProperties(value.getAsJsonObject(), modifyClassName(oldName), newJsonObj);
			} else {
				addingProperties(value.getAsJsonObject(), name, newJsonObj);
			}
			obj.add(name, newJsonObj);
		}
	}

	/*
	 * To Create new Json files with all added properties in the location of
	 * semantics resources folder.
	 */
	public static void createNewJsonFile(JsonObject obj) {
		Properties property = CloneRemoteRepository.getPropertiesFromFile();
		String copyFilePath = currentWorkingDir + "\\" + property.getProperty("inputSchemas");
		String newFileName = copyFilePath.concat("\\").concat(fileName).concat(".json");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(obj.toString());
		String prettyJsonString = gson.toJson(je);
		try {
			writer = new FileWriter(newFileName);
			writer.write(prettyJsonString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
