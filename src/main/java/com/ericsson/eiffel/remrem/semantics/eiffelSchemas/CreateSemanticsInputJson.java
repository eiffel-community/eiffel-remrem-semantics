package com.ericsson.eiffel.remrem.semantics.eiffelSchemas;

import java.io.File;
import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * This class is used to create the new json files in semantics input schema
 * location which are required to generate the pojo's
 * 
 * @author xdurvak
 *
 */

public class CreateSemanticsInputJson {

	/**
	 * This method is used to create json files with corresponding event name
	 * with json content
	 * 
	 * @param jsonFileName
	 *            - This parameter is used to create the json file with this
	 *            name
	 * @param jsonObject
	 *            - This parameter having the modified json object with all
	 *            required properties to generate events
	 */
	public void createNewJsonSchema(String jsonFileName, JsonObject jsonObject) {
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
