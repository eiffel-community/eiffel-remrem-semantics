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
