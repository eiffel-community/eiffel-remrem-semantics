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

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.lib.StoredConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.eiffel.remrem.semantics.schemas.EiffelConstants;
import com.ericsson.eiffel.remrem.semantics.schemas.LocalRepo;
import com.ericsson.eiffel.remrem.semantics.schemas.SchemaFile;

/**
 * This class is used to Clone the eiffel repo from github
 * 
 * @author xdurvak
 */

public class PrepareLocalEiffelSchemas {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrepareLocalEiffelSchemas.class);
    private final static ResourceBundle resource = ResourceBundle.getBundle("proxy", Locale.getDefault());
    private final static String httpProxyUrl = resource.getString("http.proxy.url");
    private final static String httpProxyPort = resource.getString("http.proxy.port");
    private final static String httpProxyUsername = resource.getString("http.proxy.username");
    private final static String httpProxyPassword = resource.getString("http.proxy.password");

    /**
     * This method is used to clone repository from github using the URL and branch to local destination folder.
     * 
     * @param repoURL
     *            repository url to clone.
     * @param branch
     *            specific branch name of the repository to clone
     * @param localEiffelRepoPath
     *            destination path to clone the repo.
     */
    private void cloneEiffelRepo(final String repoURL, final String branch, final Path localEiffelRepoPath) {
        Git localGitRepo = null;
        
        // checking for repository exists or not in the localEiffelRepoPath
        try {
            if (Files.notExists(localEiffelRepoPath)) {
                // cloning github repository by using URL and branch name into local
                localGitRepo = Git.cloneRepository().setURI(repoURL).setBranch("master").setDirectory(localEiffelRepoPath.toFile()).call();
            } else {
                // If required repository already exists
                localGitRepo = Git.open(localEiffelRepoPath.toFile());

                // Reset to normal if uncommitted changes are present
                localGitRepo.reset().call();

                //Checkout to master before pull the changes
                localGitRepo.checkout().setName(EiffelConstants.MASTER).call();

                // To get the latest changes from remote repository.
                localGitRepo.pull().call();
            }

            //checkout to input branch after changes pulled into local
            localGitRepo.checkout().setName(branch).call();

        } catch (Exception e) {
            LOGGER.info("please check proxy settings if proxy enabled update proxy.properties file to clone behind proxy");
            e.printStackTrace();
        }
    }

    /**
     * This method is used to get set the proxy to clone the repositories under this proxy
     * 
     * @param proxy proxy instance created by using proxy details provided by user
     */
    private void setProxy(final Proxy proxy) {
        ProxySelector.setDefault(new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                return Arrays.asList(proxy);
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                if (uri == null || sa == null || ioe == null) {
                    throw new IllegalArgumentException("Arguments can not be null.");
                }
            }

        });

    }

    /**
     * This method is used get the proxy instance by using user provided proxy details
     * 
     * @param httpProxyUrl proxy url configured in property file
     * @param httpProxyPort proxy port configured in property file
     * @param httpProxyUsername proxy username to authenticate
     * @param httpProxyPassword proxy password to authenticate
     * @return proxy instance
     */
    private Proxy getProxy(final String httpProxyUrl,final String httpProxyPort,final String httpProxyUsername,final String httpProxyPassword  ) {
        if (!httpProxyUrl.isEmpty() && !httpProxyPort.isEmpty()) {
            final InetSocketAddress socket = InetSocketAddress.createUnresolved(httpProxyUrl, Integer.parseInt(httpProxyPort));
            if (!httpProxyUsername.isEmpty() && !httpProxyPassword.isEmpty()) {
                Authenticator authenticator = new Authenticator() {
                    public PasswordAuthentication getPasswordAuthentication() {
                        LOGGER.info("proxy authentication called");
                        return (new PasswordAuthentication(httpProxyUsername, httpProxyPassword.toCharArray()));
                    }
                };
                Authenticator.setDefault(authenticator);
            }
            return new Proxy(Proxy.Type.HTTP, socket);
        }
        return null;
    }

    /**
     * This method is used to copy eiffeloperations schemas to eiffelrepo schemas location
     * 
     * @param operationsRepoPath
     *            local operations repository url
     * @param eiffelRepoPath
     *            local eiffel repository url
     */
    private void copyOperationSchemas(final Path operationsRepoPath, final Path eiffelRepoPath) {
        final Path operationSchemas = operationsRepoPath.resolve(EiffelConstants.SCHEMA_LOCATION);
        final Path eiffelSchemas = eiffelRepoPath.resolve(EiffelConstants.SCHEMA_LOCATION);
        if (Files.isDirectory(operationSchemas)) {
            try {
                FileUtils.copyDirectory(operationSchemas.toFile(), eiffelSchemas.toFile());
            } catch (IOException e) {
                System.out.println("Exception occurred while copying schemas from operations repository to eiffel repository");
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        final PrepareLocalEiffelSchemas prepareLocalSchema = new PrepareLocalEiffelSchemas();
        final Proxy proxy = prepareLocalSchema.getProxy(httpProxyUrl,httpProxyPort,httpProxyUsername,httpProxyPassword);
        if(proxy != null){
            prepareLocalSchema.setProxy(proxy);
        }
        final String eiffelRepoUrl = args[0];
        final String eiffelRepoBranch = args[1];
        final String operationRepoUrl = args[2];
        final String operationRepoBranch = args[3];

        final Path localEiffelRepoPath = EiffelConstants.USER_HOME.resolve(EiffelConstants.EIFFEL);
        final Path localOperationsRepoPath = EiffelConstants.USER_HOME.resolve(EiffelConstants.OPERATIONS_REPO_NAME);

        // Clone Eiffel Repo from GitHub 
        prepareLocalSchema.cloneEiffelRepo(eiffelRepoUrl, eiffelRepoBranch, localEiffelRepoPath);

        //Clone Eiffel operations Repo from GitHub 
        prepareLocalSchema.cloneEiffelRepo(operationRepoUrl, operationRepoBranch, localOperationsRepoPath);

        //Copy operations repo Schemas to location where Eiffel repo schemas available
        prepareLocalSchema.copyOperationSchemas(localOperationsRepoPath.toAbsolutePath(), localEiffelRepoPath.toAbsolutePath());

        // Read and Load JsonSchemas from Cloned Directory 
        final LocalRepo localRepo = new LocalRepo(localEiffelRepoPath);
        localRepo.readSchemas();

        // Schema changes
        final SchemaFile schemaFile = new SchemaFile();

        // Iterate over available input schemas and create new and patched files
        for (Map.Entry<String, Path> event : localRepo.getJsonEventSchemas().entrySet()) {
             schemaFile.modify(event.getValue().toFile(), event.getKey());
        }
    }
}
