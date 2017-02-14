package com.ericsson.eiffel.remrem.semantics.schemas;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
public class SchemaFile {
	private JsonParser parser = new JsonParser();
	private boolean isEvent;
	private boolean isMeta = false;
	private boolean isEnumType = false;
	private String allEventNames;
	private String eventName = null;

	public SchemaFile(String eventNames) {
		super();
		this.allEventNames = eventNames;
	}
	/**
	 * This method is used to modify the Eiffel repo json files content
	 * 
	 * @param jsonFiles
	 *            - ArrayList of Eiffel event jsons passed as an input parameter
	 *            to this method
	 * @param eventNames-
	 *            ArrayList of Eiffel Event names passed as an input parameter
	 *            to this method
	 */
	public void modify(File jsonFile, String eventName) {
		try {
			this.eventName = eventName;
			byte[] fileBytes = Files.readAllBytes(Paths.get(jsonFile.getAbsolutePath()));
			String fileContent = new String(fileBytes);
			JsonObject jsonContent = parser.parse(fileContent).getAsJsonObject();
			JsonObject obj = new JsonObject();
			isEvent = true;

			// Added Java Types and ExtendedTypes to the Json Schema
			addAttributesToJsonSchema(jsonContent, eventName, obj);

			// Copy the jsonschema content to the file in project directory
			// (/input/schemas)
			createNewInputJsonSchema(eventName, obj);

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
				String previousObjectName = jsonElementName;
				if (name.equals(EiffelConstants.META)) {
					isMeta = true;
				}
				if (name.equals(EiffelConstants.TYPE) && isMeta) {
					isEnumType = true;
					isMeta = false;
				}
				addingItemsProperties(name, valueSet.getValue(), jsonObject, previousObjectName);
			} else {
				if (EiffelConstants.TYPE.equals(valueSet.getKey())) {
					if (EiffelConstants.OBJECTTYPE.equals(valueSet.getValue().getAsString())) {
						jsonObject.add(EiffelConstants.TYPE, valueSet.getValue());
						if (isEvent) {
							jsonObject.add(EiffelConstants.JAVA_TYPE,
									parser.parse(EiffelConstants.COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS
											.concat(StringUtils.capitalize(jsonElementName)) + "\""));
							jsonObject.add(EiffelConstants.EXTENDS_JAVA_CLASS,
									parser.parse(EiffelConstants.COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS_EVENT));
							isEvent = false;

						} else {
							jsonElementName = modifyClassName(jsonElementName);
							String newClassName = StringUtils.capitalize(jsonElementName);
							if (jsonElementName.equals(EiffelConstants.DATA)
									|| jsonElementName.equals(EiffelConstants.OUTCOME))
								jsonObject.add(EiffelConstants.JAVA_TYPE,
										parser.parse(EiffelConstants.COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS
												.concat(this.eventName + "" + newClassName) + "\""));
							else
								jsonObject.add(EiffelConstants.JAVA_TYPE, parser
										.parse(EiffelConstants.COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS.concat(newClassName)
												+ "\""));
						}
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
							jsonObject.add(valueSet.getKey(), parser.parse(allEventNames));
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
	 * @param previousObjectName
	 *            - name of the previousObject to this items object is an input
	 *            parameter to this method
	 */
	private void addingItemsProperties(String elementName, JsonElement jsonValue, JsonObject jsonObject,
			String previousObjectName) {
		if (jsonValue.isJsonObject()) {
			JsonObject newJsonObj = new JsonObject();
			if (elementName.equals(EiffelConstants.ITEMS)) {
				addAttributesToJsonSchema(jsonValue.getAsJsonObject(), modifyClassName(previousObjectName), newJsonObj);
			} else {
				addAttributesToJsonSchema(jsonValue.getAsJsonObject(), elementName, newJsonObj);
			}
			jsonObject.add(elementName, newJsonObj);
		}
	}

	/**
	 * @param jsonFileName-
	 *            name of the input json file is to be created is an input
	 *            parameter to this method
	 * @param jsonObject
	 *            - josnObject having required properties to generate events is
	 *            an input parameter to this method
	 */
	public void createNewInputJsonSchema(String jsonFileName, JsonObject jsonObject) {
		String currentWorkingDir = EiffelConstants.USER_DIR;
		FileWriter writer = null;
		String copyFilePath = currentWorkingDir + "\\" + EiffelConstants.INPUT_EIFFEL_SCHEMAS;
		String newFileName = copyFilePath + "\\" + jsonFileName + EiffelConstants.JSON_MIME_TYPE;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(jsonObject.toString());
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
