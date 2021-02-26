/*
    Copyright 2018 Ericsson AB.
    For a full list of individual contributors, please see the commit history.
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.ericsson.eiffel.remrem.semantics.schemas;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

/**
 * This class is used to Iterate over the Eiffel schemas that are cloned from
 * Eiffel repository
 * 
 * @author xdurvak
 *
 */
public class LocalRepo {
	private ArrayList<File> jsonEventSchemas;
	private Path localSchemasPath;
	private ArrayList<String> jsonEventNames;

	public LocalRepo(Path localSchemasPath) {
		this.localSchemasPath = localSchemasPath;
	}

	/**
	 * This method is used to read Eiffel Schemas that are cloned from Eiffel
	 * Repo
	 */

	public void readSchemas() throws IOException {
		try {
			FileUtils.cleanDirectory(EiffelConstants.USER_DIR.resolve(EiffelConstants.INPUT_EIFFEL_SCHEMAS).toFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		jsonEventNames = new ArrayList<String>();
		jsonEventSchemas = new ArrayList<File>();
		loadEiffelSchemas(localSchemasPath.resolve(EiffelConstants.SCHEMA_LOCATION), Paths.get(""));
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
	private void loadEiffelSchemas(Path jsonFilePath, Path directoryName) throws IOException {
		try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(jsonFilePath)) {
			for (Path jsonFile : dirStream) {
				if (Files.isDirectory(jsonFile)) {
					loadEiffelSchemas(jsonFile.toAbsolutePath(), jsonFile.getFileName());
				} else {
					jsonEventNames.add(directoryName.toString());
					jsonEventSchemas.add(jsonFile.toFile());
				}
			}
		}
	}

	public ArrayList<File> getJsonEventSchemas() {
		return jsonEventSchemas;
	}

	public ArrayList<String> getJsonEventNames() {
		return jsonEventNames;
	}
	
	

}
