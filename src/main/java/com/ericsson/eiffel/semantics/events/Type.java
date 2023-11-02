/**
 *     Copyright 2018 Ericsson AB.
 *     For a full list of individual contributors, please see the commit history.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.ericsson.eiffel.semantics.events;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public enum Type {

    @SerializedName("ACCESSIBILITY")
    ACCESSIBILITY("ACCESSIBILITY"),
    @SerializedName("BACKUP_RECOVERY")
    BACKUP_RECOVERY("BACKUP_RECOVERY"),
    @SerializedName("COMPATIBILITY")
    COMPATIBILITY("COMPATIBILITY"),
    @SerializedName("CONVERSION")
    CONVERSION("CONVERSION"),
    @SerializedName("DISASTER_RECOVERY")
    DISASTER_RECOVERY("DISASTER_RECOVERY"),
    @SerializedName("FUNCTIONAL")
    FUNCTIONAL("FUNCTIONAL"),
    @SerializedName("INSTALLABILITY")
    INSTALLABILITY("INSTALLABILITY"),
    @SerializedName("INTEROPERABILITY")
    INTEROPERABILITY("INTEROPERABILITY"),
    @SerializedName("LOCALIZATION")
    LOCALIZATION("LOCALIZATION"),
    @SerializedName("MAINTAINABILITY")
    MAINTAINABILITY("MAINTAINABILITY"),
    @SerializedName("PERFORMANCE")
    PERFORMANCE("PERFORMANCE"),
    @SerializedName("PORTABILITY")
    PORTABILITY("PORTABILITY"),
    @SerializedName("PROCEDURE")
    PROCEDURE("PROCEDURE"),
    @SerializedName("RELIABILITY")
    RELIABILITY("RELIABILITY"),
    @SerializedName("SECURITY")
    SECURITY("SECURITY"),
    @SerializedName("STABILITY")
    STABILITY("STABILITY"),
    @SerializedName("USABILITY")
    USABILITY("USABILITY");
    private final String value;
    private final static Map<String, Type> CONSTANTS = new HashMap<String, Type>();

    static {
        for (Type c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    Type(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String value() {
        return this.value;
    }

    public static Type fromValue(String value) {
        Type constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
