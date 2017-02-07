package com.ericsson.eiffel.remrem.semantics.schemas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * This class is used to Iterate over the Eiffel schemas that are cloned from
 * Eiffel repository
 * 
 * @author xdurvak
 *
 */
public class LocalRepo {
	private List<File> jsonEventSchemas;
	private File localSchemasPath;
	private ArrayList<String> jsonEventNames;

	public LocalRepo(File localSchemasPath) {
		this.localSchemasPath = localSchemasPath;
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
		jsonEventNames = new ArrayList<String>();
		jsonEventSchemas = new ArrayList<File>();
		String filePath = localSchemasPath + EiffelConstants.SCHEMA_LOCATION;
		loadEiffelSchemas(filePath, "");
		new SchemaFile().modify(jsonEventSchemas,jsonEventNames);
	}

	/**
	 * This method is used to load all the schema files from the Eiffel Schemas
	 * folder.
	 * 
	 * @param jsonFilePath
	 *            - This parameter is used to pass Location of the Schemas
	 *            Directory
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
				jsonEventNames.add(directoryName);
				jsonEventSchemas.add(jsonFile);
			}
		}
	}

}
