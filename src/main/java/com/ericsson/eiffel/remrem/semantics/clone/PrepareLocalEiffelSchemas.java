/*
    Copyright 2017 Ericsson AB.
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
package com.ericsson.eiffel.remrem.semantics.clone;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.jgit.api.Git;
import com.ericsson.eiffel.remrem.semantics.schemas.EiffelConstants;
import com.ericsson.eiffel.remrem.semantics.schemas.LocalRepo;
import com.ericsson.eiffel.remrem.semantics.schemas.SchemaFile;

/**
 * This class is used to Clone the eiffel repo from github
 * 
 * @author xdurvak
 */

public class PrepareLocalEiffelSchemas {

    /**
     * This method is used to clone repository from github using the URL and
     * branch to local destination folder.
     * 
     * @param repoURL
     *            repository url to clone.
     * @param branch
     *            specific branch name of the repository to clone
     * @param localEiffelRepoPath
     *            destination path to clone the repo.
     */
    private static void cloneEiffelRepo(String repoURL, String branch, File localEiffelRepoPath) {
        Git localGitRepo = null;
        // checking for repository exists or not in the localEiffelRepoPath
        if (!localEiffelRepoPath.exists()) {
            try {
                // cloning github repository by using URL,branch name into local
                localGitRepo = Git.cloneRepository().setURI(repoURL).setBranch(branch).setDirectory(localEiffelRepoPath)
                        .call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // If required repository already exists
            try {
                localGitRepo = Git.open(localEiffelRepoPath);

                // adding complete remote reference to the branch name
                String remoteBranch = EiffelConstants.REMOTE_REFERENCES.concat(branch);

                // To fetch if any changes are available on remote repository.
                localGitRepo.fetch().call();

                // checkout to input branch
                localGitRepo.checkout().setName(remoteBranch).call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Read arguments from the Gradle Task.
        String eiffelRepoUrl = args[0];
        String eiffelRepoBranch = args[1];
        File localEiffelRepoPath = new File(
                System.getProperty(EiffelConstants.USER_HOME) + File.separator + EiffelConstants.EIFFEL);

        // Clone Repo from GitHub
        cloneEiffelRepo(eiffelRepoUrl, eiffelRepoBranch, localEiffelRepoPath);

        // Read and Load JsonSchemas from Cloned Directory
        LocalRepo localRepo = new LocalRepo(localEiffelRepoPath);
        localRepo.readSchemas();

        ArrayList<String> jsonEventNames = localRepo.getJsonEventNames();
        ArrayList<File> jsonEventSchemas = localRepo.getJsonEventSchemas();

        // Schema changes
        SchemaFile schemaFile = new SchemaFile();

        // Iterate the Each jsonSchema file to Add and Modify the necessary
        // properties
        if (jsonEventNames != null && jsonEventSchemas != null) {
            for (int i = 0; i < jsonEventNames.size(); i++) {
                schemaFile.modify(jsonEventSchemas.get(i), jsonEventNames.get(i));
            }
        }

    }
}