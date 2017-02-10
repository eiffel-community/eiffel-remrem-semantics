package com.ericsson.eiffel.remrem.semantics.clone;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.api.Git;

import com.ericsson.eiffel.remrem.semantics.schemas.EiffelConstants;
import com.ericsson.eiffel.remrem.semantics.schemas.LocalRepo;
import com.ericsson.eiffel.remrem.semantics.schemas.SchemaFile;

/**
 * This class is used to Clone the Eiffel Repo from github
 * 
 * @author xdurvak
 */

public class PrepareLocalEiffelSchemas {

	/**
	 * This method is used to clone Eiffel repository from github.
	 * 
	 * @param repoURL-
	 *            repository url to clone as an input parameter
	 * @param branch-
	 *            specific branch name as an input parameter
	 * @param localEiffelRepoPath
	 *            - destination path to place the cloned repo as an input
	 *            parameter
	 */
	private static void cloneEiffelRepo(String repoURL, String branch, File localEiffelRepoPath) {
		try {
			System.out.println("Latest Schema's Updating...");
			if (!localEiffelRepoPath.exists()) {
				Git.cloneRepository().setURI(repoURL).setBranch(branch).setDirectory(localEiffelRepoPath).call();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {

		// IsClonable checking from build.gradle
		if (Boolean.parseBoolean(args[2])) {

			File localEiffelRepoPath = new File(System.getProperty(EiffelConstants.USER_HOME) + "\\" + EiffelConstants.EIFFEL);

			// Clone Repo from GitHub
			cloneEiffelRepo(args[0], args[1], localEiffelRepoPath);

			// Read and Load JsonSchemas from Cloned Directory
			LocalRepo localRepo = new LocalRepo(localEiffelRepoPath);
			localRepo.readSchemas();
			
			ArrayList<String> jsonEventNames = localRepo.getJsonEventNames();
			ArrayList<File> jsonEventSchemas = localRepo.getJsonEventSchemas();

			// Schema changes
			SchemaFile schemaFile = new SchemaFile(jsonEventNames.toString());
			// Iterate the Each jsonSchema file for Add and Modify properties
			if (jsonEventNames != null && jsonEventSchemas != null) {
				for (int i = 0; i < jsonEventNames.size(); i++) {
					schemaFile.modify(jsonEventSchemas.get(i), jsonEventNames.get(i));
				}
			}

		} else {
			System.out.println("Please specify the clone property in build.gradle as an argument");
		}
	}
}