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
package com.ericsson.eiffel.remrem.semantics.config;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class is used to read required and optional links from linksValidation.properties file
 *
 */

public class LinksConfiguration {

    private ResourceBundle links;
    private final String REQUIRED_LINKS = "requiredLinks";
    private final String OPTIONAL_LINKS = "optionalLinks";
    private final String DOT = ".";

    public LinksConfiguration() {
        links = ResourceBundle.getBundle("linksValidation", Locale.getDefault());
    }

    /**
     * This method is used to get required link types from property file based on event type
     * @param eventType
     * @return Required link types list
     */
    public List<String> getRequiredLinks(String eventType) {
        String key = eventType + DOT + REQUIRED_LINKS;
        List<String> requiredLinkslist = null;
        if(links.containsKey(key)) {
            requiredLinkslist = links.getString(key).isEmpty() ? null : Arrays.asList(links.getString(key).split(","));
        }
        return requiredLinkslist;
    }

    /**
     * This method is used to get optional link types from property file based on event type
     * @param eventType
     * @return Optional link types list
     */
    public List<String> getOptionalLinks(String eventType) {
        String key = eventType + DOT + OPTIONAL_LINKS;
        List<String> optionalLinkslist = null;
        if(links.containsKey(key)) {
            optionalLinkslist = links.getString(key).isEmpty() ? null : Arrays.asList(links.getString(key).split(","));
        }
        return optionalLinkslist;
    }
}
