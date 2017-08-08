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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ericsson.eiffel.remrem.semantics.LinkTypes;

/**
 * This class is used to read required and optional links from linksValidation.properties file
 *
 */

public class LinksConfiguration {

    private ResourceBundle links;
    private List<String> linkTypes;
    private final String REQUIRED_LINKS = "requiredLinks";
    private final String OPTIONAL_LINKS = "optionalLinks";
    private final String DOT = ".";

    public LinksConfiguration() {
        links = ResourceBundle.getBundle("linksValidation", Locale.getDefault());
        linkTypes = Stream.of(LinkTypes.values()).map(LinkTypes::name).collect(Collectors.toList());
    }

    /**
     * This method is used to get required link types from property file based on event type
     * @param eventType
     * @return Required link types list if event has required link types otherwise return empty list
     */
    public List<String> getRequiredLinks(String eventType) {
        String key = eventType + DOT + REQUIRED_LINKS;
        List<String> requiredLinkslist = new ArrayList<String>();
        if(links.containsKey(key)) {
            requiredLinkslist = links.getString(key).isEmpty() ? requiredLinkslist : Arrays.asList(links.getString(key).split(","));
        }
        return requiredLinkslist;
    }

    /**
     * This method is used to get optional link types from property file based on event type
     * @param eventType
     * @return Optional link types list if event has optional link types otherwise return empty list
     */
    public List<String> getOptionalLinks(String eventType) {
        String key = eventType + DOT + OPTIONAL_LINKS;
        List<String> optionalLinkslist = new ArrayList<String>();
        if(links.containsKey(key)) {
            optionalLinkslist = links.getString(key).isEmpty() ? optionalLinkslist : Arrays.asList(links.getString(key).split(","));
        }
        return optionalLinkslist;
    }

    /**
     * This method is used to get all link types from LinkTypes Enum
     * @return link types list
     */
    public List<String> getLinkTypes() {
        return linkTypes;
    }
}
