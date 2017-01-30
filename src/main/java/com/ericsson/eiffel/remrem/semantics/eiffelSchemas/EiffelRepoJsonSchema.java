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
	private static ArrayList<String> jsonFileNames;

	/**
	 * This method is used to read Eiffel Schemas that are cloned from Eiffel
	 * Repo
	 * 
	 * @param localPath
	 *            - The Cloned Eiffel Repo path is sent as a parameter
	 */
	public void readEiffelRepoSchemas(File localPath) {
		try {
			FileUtils.cleanDirectory(new File(EiffelConstants.USER_DIR + "\\" + EiffelConstants.INPUT_EIFFEL_SCHEMAS));
		} catch (IOException e) {
			e.printStackTrace();
		}
		jsonFileNames = new ArrayList<String>();
		jsonFiles = new HashMap<String, File>();
		String filePath = localPath + EiffelConstants.SCHEMA_LOCATION;
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
	 * @param filePath
	 *            - This parameter is used to pass Location of the Schemas Directory
	 * @param name
	 *            - This parameter is used to rename the File with corresponding
	 *            event name.
	 * 
	 */
	private void loadEiffelSchemas(String filePath, String name) {
		File file = new File(filePath);
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				loadEiffelSchemas(f.getAbsolutePath(), f.getName());
			} else {
				jsonFileNames.add(name);
				jsonFiles.put(name, f);
			}
		}
	}

}
