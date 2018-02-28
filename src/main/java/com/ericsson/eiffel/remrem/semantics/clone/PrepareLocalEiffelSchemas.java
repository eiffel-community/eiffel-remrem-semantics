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
package com.ericsson.eiffel.remrem.semantics.clone;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
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
                // cloning github repository by using URL and branch name into local
                localGitRepo = Git.cloneRepository().setURI(repoURL).setBranch("master").setDirectory(localEiffelRepoPath)
                        .call();
                localGitRepo.checkout().setName(branch).call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // If required repository already exists
            try {
                localGitRepo = Git.open(localEiffelRepoPath);

                // Reset to normal if uncommitted changes are present
                localGitRepo.reset().call();

                //Checkout to master before pull the changes
                localGitRepo.checkout().setName(EiffelConstants.MASTER).call();

                // To get the latest changes from remote repository.
                localGitRepo.pull().call();

                //checkout to input branch after changes pulled into local
                localGitRepo.checkout().setName(branch).call();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * @param operationsRepoPath    local operations repository url
     * @param eiffelRepoPath        local eiffel repository url
     */
    private static void copyOperationSchemas(String operationsRepoPath, String eiffelRepoPath) {
        File operationSchemas =new File(operationsRepoPath+File.separator+EiffelConstants.SCHEMA_LOCATION);
        File eiffelSchemas =new File(eiffelRepoPath+File.separator+EiffelConstants.SCHEMA_LOCATION);
        if(operationSchemas.isDirectory())
        {
            try {
                FileUtils.copyDirectory(operationSchemas, eiffelSchemas);
            } catch (IOException e) {
                System.out.println("Exception occured while copying schemas from operations repository to eiffel repository");
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        // Read arguments from the Gradle Task.
        String eiffelRepoUrl = args[0];
        String eiffelRepoBranch = args[1];
        String operationRepoUrl =args[2];
        String operationRepoBranch =args[3];
        File localEiffelRepoPath = new File(
                System.getProperty(EiffelConstants.USER_HOME) + File.separator + EiffelConstants.EIFFEL);
        File localOperationsRepoPath = new File(
                System.getProperty(EiffelConstants.USER_HOME) + File.separator + EiffelConstants.OPERATIONS_REPO_NAME);

        // Clone Eiffel Repo from GitHub
         cloneEiffelRepo(eiffelRepoUrl, eiffelRepoBranch, localEiffelRepoPath);

        //Clone Eiffel operations Repo from GitHub
        cloneEiffelRepo(operationRepoUrl, operationRepoBranch, localOperationsRepoPath);

        //Copy operations repo Schemas to location where Eiffel repo schemas available
        copyOperationSchemas(localOperationsRepoPath.getAbsolutePath(),localEiffelRepoPath.getAbsolutePath());

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