package com.ericsson.eiffel.remrem.semantics.eiffelSchemas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

/**
 * This class is used to Iterate over the Eiffel schemas that are cloned from
 * Eiffel repository
 * 
 * @author xdurvak
 *
 */
public class EiffelRepoJsonSchema {
	private HashMap<String, File> jsonFiles;
	private File localSchemasPath;
	private static ArrayList<String> jsonFileNames;
	
	public EiffelRepoJsonSchema(File localSchemasPath) {
		this.localSchemasPath=localSchemasPath;
	}

	/**
	 * This method is used to read Eiffel Schemas that are cloned from Eiffel
	 * Repo
	 */
	
	public void readSchemas() {
		try {
			FileUtils.cleanDirectory(new File(EiffelConstants.USER_DIR + "\\" + EiffelConstants.INPUT_EIFFEL_SCHEMAS));
		} catch (IOException e) {
			e.printStackTrace();
		}
		jsonFileNames = new ArrayList<String>();
		jsonFiles = new HashMap<String, File>();
		String filePath = localSchemasPath + EiffelConstants.SCHEMA_LOCATION;
		File file = new File(filePath);
		if (file.isDirectory()) {
			loadEiffelSchemas(filePath, "");
		}
		Iterator<String> iter = jsonFileNames.iterator();
		while (iter.hasNext()) {
			String filename = iter.next();
			File jsonFile = jsonFiles.get(filename);
			new ChangeJsonSchemaProperty().modifyJsonFileContent(jsonFile, filename, jsonFileNames);
		}
	}

	/**
	 * This method is used to load all the files from the Eiffel Schemas folder.
	 * 
	 * @param jsonFilePath
	 *            - This parameter is used to pass Location of the Schemas Directory
	 * @param directoryName
	 *            - This parameter is used to rename the File with corresponding
	 *            event name.
	 * 
	 */
	private void loadEiffelSchemas(String jsonFilePath, String directoryName) {
		File file = new File(jsonFilePath);
		File[] files = file.listFiles();
		for (File jsonFile : files) {
			if (jsonFile.isDirectory()) {
				loadEiffelSchemas(jsonFile.getAbsolutePath(), jsonFile.getName());
			} else {
				jsonFileNames.add(directoryName);
				jsonFiles.put(directoryName, jsonFile);
			}
		}
	}

}
