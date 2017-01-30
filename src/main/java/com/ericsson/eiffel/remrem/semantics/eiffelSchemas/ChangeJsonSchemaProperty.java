package com.ericsson.eiffel.remrem.semantics.eiffelSchemas;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 
 * This class is used to add the required properties to generate the pojo's
 * using jsonSchema2pojo plugin.
 * 
 * @author xdurvak
 *
 */
public class ChangeJsonSchemaProperty {
	private static String fileContent;
	private final static JsonParser parser = new JsonParser();
	private static int count = 0;
	static boolean isItemObject = false;
	private static String oldName = "";
	private static String fileName;
	private static boolean isMeta = false;
	private static boolean isEnumType = false;
	private ArrayList<String> allFileNames;

	/**
	 * 
	 * This method is used to modify the Eiffel repo json files content
	 * 
	 * @param jsonFile-
	 *            Eiffel repo json schema file is sent as an input parameter
	 * @param name-
	 *            name of the json schema file sent as an input parameter used
	 *            to rename the file with that name
	 * @param fileNames-this
	 *            parameter is used to set enum constants in meta and it
	 *            contains all events names
	 * 
	 */
	public void modifyJsonFileContent(File jsonFile, String name, ArrayList<String> fileNames) {
		allFileNames = fileNames;
		try {
			fileName = name;
			byte[] fileBytes = Files.readAllBytes(Paths.get(jsonFile.getAbsolutePath()));
			fileContent = new String(fileBytes);
			JsonObject jsonContent = parser.parse(fileContent).getAsJsonObject();
			count = 0;
			JsonObject obj = new JsonObject();
			addAttributesToJsonSchema(jsonContent, name, obj);
			new CreateSemanticsInputJson().createNewJsonSchema(fileName, obj);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * This method is used to adding the attributes JavaType ,ExtendsJavaType
	 * and other required properties to input jsons
	 * 
	 * @param jsonContent-
	 *            Eiffel repo json file content sent as an input parameter to
	 *            this method
	 * @param jsonElementName
	 *            - Name of the json elements as an input parameter to this
	 *            method
	 * @param jsonObject
	 *            - Json object is sent as an input to this to add required json
	 *            properties to generate event pojo's
	 */
	private void addAttributesToJsonSchema(JsonObject jsonContent, String jsonElementName, JsonObject jsonObject) {
		Set<Entry<String, JsonElement>> values = jsonContent.entrySet();
		Iterator<Entry<String, JsonElement>> keyValue = values.iterator();
		while (keyValue.hasNext()) {
			Entry<String, JsonElement> valueSet = keyValue.next();
			if (valueSet.getValue().isJsonObject()) {
				String name = valueSet.getKey();
				oldName = jsonElementName;
				if (name.equals(EiffelConstants.META)) {
					isMeta = true;
				}
				if (name.equals(EiffelConstants.TYPE) && isMeta) {
					isEnumType = true;
					isMeta = false;
				}
				addingItemsProperties(name, valueSet.getValue(), jsonObject);
			} else {
				if (EiffelConstants.TYPE.equals(valueSet.getKey())) {
					if (EiffelConstants.OBJECTTYPE.equals(valueSet.getValue().getAsString())) {
						jsonObject.add(EiffelConstants.TYPE, valueSet.getValue());
						if (count == 0) {
							jsonObject.add(EiffelConstants.JAVA_TYPE,
									parser.parse(EiffelConstants.COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS
											.concat(StringUtils.capitalize(jsonElementName)) + "\""));
							jsonObject.add(EiffelConstants.EXTENDS_JAVA_CLASS,
									parser.parse(EiffelConstants.COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS_EVENT));

						} else {
							jsonElementName = modifyClassName(jsonElementName);
							String newClassName = StringUtils.capitalize(jsonElementName);
							if (jsonElementName.equals(EiffelConstants.DATA)
									|| jsonElementName.equals(EiffelConstants.OUTCOME))
								jsonObject.add(EiffelConstants.JAVA_TYPE,
										parser.parse(EiffelConstants.COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS
												.concat(fileName + "" + newClassName) + "\""));
							else
								jsonObject.add(EiffelConstants.JAVA_TYPE, parser
										.parse(EiffelConstants.COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS.concat(newClassName)
												+ "\""));
						}
						count++;
					} else {
						jsonObject.add(EiffelConstants.TYPE, valueSet.getValue());
						if (jsonElementName.equals(EiffelConstants.TIME)) {
							jsonObject.add(EiffelConstants.FORMAT, parser.parse(EiffelConstants.UTC_MILLISEC));
						}
					}
				} else {
					jsonObject.add(valueSet.getKey(), valueSet.getValue());
					if (valueSet.getKey().equals(EiffelConstants.ENUM)) {
						if (isEnumType) {
							jsonObject.add(valueSet.getKey(), parser.parse(allFileNames.toString()));
							isEnumType = false;
						}
					}
				}
			}
		}
		if (values.isEmpty()) {
			jsonObject.add(EiffelConstants.TYPE, parser.parse("string"));
		}
	}

	/**
	 * 
	 * This method is used to rename the classes which names are ending with the
	 * letter 's'
	 * 
	 * @param className-
	 *            This parameter having class names to check which are ending
	 *            with 's' or not.
	 * @return String -this returns modified class name
	 * 
	 */
	private String modifyClassName(String className) {
		String newClassName = className;
		if (className.endsWith("s")) {
			if (className.equals(EiffelConstants.DEPENDENCIES)) {
				newClassName = "dependency";
			} else if (className.equals(EiffelConstants.BATCHES)) {
				newClassName = "batch";
			} else if (className.equals(EiffelConstants.PROPERTIES)) {
				newClassName = "property";
			} else {
				newClassName = StringUtils.chop(className);
			}
		}
		return newClassName;
	}

	/**
	 * 
	 * This method is used to iterate over the items array because items is an
	 * array of jsonObject
	 * 
	 * @param elementName
	 *            - Json element name as an input parameter to this method
	 * @param jsonValue
	 *            - Json element value as an input parameter to this method
	 * @param jsonObject
	 *            - JsonObject which is having property 'Items' is an input to
	 *            this method
	 * 
	 */
	private void addingItemsProperties(String elementName, JsonElement jsonValue, JsonObject jsonObject) {
		if (jsonValue.isJsonObject()) {
			JsonObject newJsonObj = new JsonObject();
			if (elementName.equals(EiffelConstants.ITEMS)) {
				addAttributesToJsonSchema(jsonValue.getAsJsonObject(), modifyClassName(oldName), newJsonObj);
			} else {
				addAttributesToJsonSchema(jsonValue.getAsJsonObject(), elementName, newJsonObj);
			}
			jsonObject.add(elementName, newJsonObj);
		}
	}
}
