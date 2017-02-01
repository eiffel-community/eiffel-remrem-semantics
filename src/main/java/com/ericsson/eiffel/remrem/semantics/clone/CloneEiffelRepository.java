package com.ericsson.eiffel.remrem.semantics.clone;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;

import com.ericsson.eiffel.remrem.semantics.eiffelSchemas.EiffelRepoJsonSchema;
import com.ericsson.eiffel.remrem.semantics.eiffelSchemas.EiffelConstants;

/**
 * This class is used to Clone the Eiffel Repo from github
 * 
 * @author xdurvak
 */

public class CloneEiffelRepository {
	private String homeDir = System.getProperty(EiffelConstants.USER_HOME);
	private static File localPath;

	private void cloneEiffelRepo(String repoURL, String branch) {
		localPath = new File(homeDir+"\\"+EiffelConstants.EIFFEL);
		try {
			System.out.println("Latest Schema's Updating...");
			if (!localPath.exists()) {
				Git.cloneRepository().setURI(repoURL).setBranch(branch).setDirectory(localPath).call();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		new EiffelRepoJsonSchema().readEiffelRepoSchemas(localPath);
	}

	public static void main(String[] args) throws IOException {
		if(Boolean.parseBoolean(args[2])){
			new CloneEiffelRepository().cloneEiffelRepo(args[0], args[1]);
		}else{
			System.out.println("Please specify the clone property in build.gradle as an argument");
		}
	}

}