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
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ericsson.eiffel.remrem.semantics.LinkType;

/**
 * This class is used to read required and optional link types from linksValidation.properties file
 *
 */

public class LinksConfiguration {

    private ResourceBundle links;
    private List<String> allLinkTypes;
    private final String REQUIRED_LINKS = "requiredLinks";
    private final String OPTIONAL_LINKS = "optionalLinks";
    private final String DOT = ".";

    /**
     * Initializes links of type ResourceBundle from linksValidation property file and
     *        allLinkTypes of type list from LinkType Enum class
     */
    public LinksConfiguration() {
        links = ResourceBundle.getBundle("linksValidation", Locale.getDefault());
        allLinkTypes = Stream.of(LinkType.values()).map(LinkType::name).collect(Collectors.toList());
    }

    /**
     * This method is used to get required link types based on event type
     * @param eventType of an Eiffel event
     *          For Eg: eiffelartifactpublished, eiffelactivityfinished
     * @return list of link types required for an event else return an empty list
     */
    public List<String> getRequiredLinkTypes(String eventType) {
        String key = eventType + DOT + REQUIRED_LINKS;
        return getLinkTypesFromConfiguration(key);
    }

    private List<String> getLinkTypesFromConfiguration(String key) {
        List<String> linkTypeList = new ArrayList<String>();
        try {
            if (!links.getString(key).isEmpty()) {
                linkTypeList = Arrays.asList(links.getString(key).split(","));
            }
            return linkTypeList;
        } catch (MissingResourceException e) {
            return linkTypeList;
        }
    }
    /**
     * This method is used to get optional link types based on event type
     * @param eventType of an Eiffel event
     *          For Eg: eiffelartifactpublished, eiffelactivityfinished
     * @return list of optional link types for an event else return an empty list
     */
    public List<String> getOptionalLinkTypes(String eventType) {
        String key = eventType + DOT + OPTIONAL_LINKS;
        return getLinkTypesFromConfiguration(key);
    }

    /*private List<String> getLinkTypesFromConfiguration(String key) {
        List<String> linkTypeList = new ArrayList<String>();
        try {
            if (!links.getString(key).isEmpty()) {
                linkTypeList = Arrays.asList(links.getString(key).split(","));
            }
            return linkTypeList;
        } catch (MissingResourceException e) {
            return linkTypeList;
        }
    }*/

    /**
     * This method is used to get all link types from LinkTypes Enum
     * @return list of all link types
     */
    public List<String> getAllLinkTypes() {
        return allLinkTypes;
    }
}
