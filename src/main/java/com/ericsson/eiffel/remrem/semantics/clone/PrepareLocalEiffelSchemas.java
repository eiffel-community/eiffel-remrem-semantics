package com.ericsson.eiffel.remrem.semantics.clone;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;

import com.ericsson.eiffel.remrem.semantics.eiffelSchemas.LocalRepo;
import com.ericsson.eiffel.remrem.semantics.eiffelSchemas.EiffelConstants;

/**
 * This class is used to Clone the Eiffel Repo from github
 * 
 * @author xdurvak
 */

public class PrepareLocalEiffelSchemas {

	/**
	 * this method is used to clone Eiffel repository from github.
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
		if (Boolean.parseBoolean(args[2])) {
			File localEiffelRepoPath = new File(
					System.getProperty(EiffelConstants.USER_HOME) + "\\" + EiffelConstants.EIFFEL);
			cloneEiffelRepo(args[0], args[1], localEiffelRepoPath);
			new LocalRepo(localEiffelRepoPath).readSchemas();
		} else {
			System.out.println("Please specify the clone property in build.gradle as an argument");
		}
	}
}