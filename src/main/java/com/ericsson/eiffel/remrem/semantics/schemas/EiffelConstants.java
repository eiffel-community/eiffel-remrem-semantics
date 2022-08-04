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
package com.ericsson.eiffel.remrem.semantics.schemas;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This is a constants class used in other classes
 * 
 * @author xdurvak
 *
 */
public final class EiffelConstants {
    public static String NUMBER = "number";
    public static String ARRAY = "array";
    public static String PROPERTIES = "properties";
    public static String BATCHES = "batches";
    public static String DEPENDENCIES = "dependencies";
    public static String ENUM = "enum";
    public static String TIME = "time";
    public static String ITEMS = "items";
    public static String OUTCOME = "outcome";
    public static String DATA = "data";
    public static String META = "meta";
    public static String ISSUE = "issue";
    public static String EXTENDS_JAVA_CLASS = "extendsJavaClass";
    public static String COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS_EVENT = "com.ericsson.eiffel.semantics.events.Event";
    public static String JAVA_TYPE = "javaType";
    public static String FORMAT = "format";
    public static String UTC_MILLISEC = "utc-millisec";
    public static String COM_ERICSSON_EIFFEL_SEMANTICS_EVENTS = "com.ericsson.eiffel.semantics.events.";
    public static String TYPE = "type";
    public static String OBJECTTYPE = "object";
    public static Path INPUT_EIFFEL_SCHEMAS = Paths.get("src", "main", "resources", "schemas", "input");
    public static String EIFFEL = "eiffel";
    public static String OPERATIONS_REPO_NAME = "eiffel-operations-extension";
    public static Path USER_DIR = Paths.get(System.getProperty("user.dir"));
    public static Path SCHEMA_LOCATION = Paths.get("schemas");
    public static String JSON_MIME_TYPE = ".json";
    public static Path USER_HOME = Paths.get(System.getProperty("user.home"));
    public static String ACTIVITY = "activity";
    public static String ARTIFACT = "artifact";
    public static String SERVICE = "service";
    public static String ALERT = "alert";
    public static String CM = "cm";
    public static String ANNOUNCEMENT = "announcement";
    public static String CONFIGURATION = "configuration";
    public static String FLOWCONTEXT = "flowcontext";
    public static String TEST = "test";
    public static String JAVA_INTERFACES = "javaInterfaces";
    public static String DEPENDENCY = "dependency";
    public static String BATCH = "batch";
    public static String PROPERTY = "property";
    public static String ANYOF = "anyOf";
    public static String STRING = "string";
    public static boolean MULTIPLE_ALLOWED = true;
    public static boolean MULTIPLE_NOT_ALLOWED = false;
    public static final String MASTER = "master";
}
