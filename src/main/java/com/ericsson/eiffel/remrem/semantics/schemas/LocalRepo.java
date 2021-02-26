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

import com.vdurmont.semver4j.Semver;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * This class is used to Iterate over the Eiffel schemas that are cloned from
 * Eiffel repository
 * 
 * @author xdurvak
 *
 */
public class LocalRepo {
	private final Map<String, Path> jsonEventSchemas = new HashMap<>();
	private Path localSchemasPath;

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
		loadEiffelSchemas(localSchemasPath.resolve(EiffelConstants.SCHEMA_LOCATION));
	}

	/**
	 * This method is used to load all the schema files from the Eiffel Schemas
	 * folder.
	 * 
	 * @param jsonFilePath
	 *            - This parameter is used to pass Location of the Schemas
	 *            Directory
	 */
	private void loadEiffelSchemas(final Path jsonFilePath) throws IOException {
		try (DirectoryStream<Path> schemaDirStream =
					 Files.newDirectoryStream(jsonFilePath, Files::isDirectory)) {
			for (Path eventDir : schemaDirStream) {
				try (DirectoryStream<Path> eventDirStream =
							 Files.newDirectoryStream(eventDir, file -> file.toString().endsWith(".json"))) {
					// Turn the filenames into versions and find the greatest version
					Semver latestSchemaVersion = StreamSupport.stream(eventDirStream.spliterator(), false)
							.map(path -> new Semver(FilenameUtils.removeExtension(path.getFileName().toString())))
							.max(Semver::compareTo)
							.get();
					jsonEventSchemas.put(eventDir.getFileName().toString(),
							eventDir.resolve(latestSchemaVersion.toString() + ".json"));
				}
			}
		}
	}

	public Map<String, Path> getJsonEventSchemas() {
		return jsonEventSchemas;
	}
}
