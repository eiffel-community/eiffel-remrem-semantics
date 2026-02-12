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
package com.ericsson.eiffel.remrem.semantics.util;

import com.ericsson.eiffel.remrem.semantics.validator.EiffelValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class PropertiesUtil {
    public static final Logger log = LoggerFactory.getLogger(PropertiesUtil.class);

    public static <T> T getProperty(HashMap<String, Object> validationProperties, String property) {
        return getProperty(validationProperties, property, null);
    }

    public static <T> T getProperty(HashMap<String, Object> validationProperties, String property, T defValue) {
        Object object = validationProperties.get(property);
        if (object == null)
            return defValue;
        if (object instanceof Boolean) {
            return (T)object;
        }
        else {
            log.error("Value of property '{}' should be a boolean, but is '{}'; returning default value '{}'",
                    property, object.getClass().getName(), defValue);
            return defValue;
        }
    }
}
