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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class is used to read required and optional links from linksValidation.properties file
 * 
 * @author xumakap
 *
 */
public class LinksConfiguration {

    private static final ResourceBundle links = ResourceBundle.getBundle("linksValidation", Locale.getDefault());
    private static Enumeration<String> keys = links.getKeys();

    private static final String REQUIRED_LINKS = "requiredLinks";
    private static final String OPTIONAL_LINKS = "optionalLinks";
    static HashMap<String, List<String>> requiredLinksMap = new HashMap<String, List<String>>();
    static HashMap<String, List<String>> optionalLinksMap = new HashMap<String, List<String>>();

    public static List<String> getRequiredLinks(String eventType) {

        if (requiredLinksMap.size() == 0 || optionalLinksMap.size() == 0) {
            while (keys.hasMoreElements()) {
                String key = keys.nextElement();
                if (key.contains(REQUIRED_LINKS)) {
                    List<String> requiredLinkslist = links.getString(key).isEmpty() ? null : Arrays.asList(links.getString(key).split(","));
                    requiredLinksMap.put(key.split("\\.")[0], requiredLinkslist);
                } else if (key.contains(OPTIONAL_LINKS)) {
                    List<String> optionalLinkslist = links.getString(key).isEmpty() ? null : Arrays.asList(links.getString(key).split(","));
                    optionalLinksMap.put(key.split("\\.")[0], optionalLinkslist);
                }
            }
        }
        return requiredLinksMap.get(eventType);
    }

    public static List<String> getOptionalLinks(String eventType) {
        return optionalLinksMap.get(eventType);
    }

    public static List<String> getLinks(String eventType) {
        List<String> links = new ArrayList<String>();
        if(getRequiredLinks(eventType) != null) {
            links.addAll(getRequiredLinks(eventType));
        }
        links.addAll(getOptionalLinks(eventType));
        return links;
    }
}
