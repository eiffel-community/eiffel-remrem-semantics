package com.ericsson.eiffel.remrem.semantics;

import java.util.HashMap;


public enum EiffelEventType {
    ARTIFACT_PUBLISHED("eiffelartifactpublished"),
    ACTIVITY_FINISHED("eiffelactivityfinished");

    private String id;

    EiffelEventType(String id) {
        this.id = id;
    }

    static HashMap<String, EiffelEventType> idMap = new HashMap<String, EiffelEventType>();

    public static EiffelEventType fromString(String id) {
        if (idMap.size() == 0) {
            for (EiffelEventType type : values())
                idMap.put(type.id, type);
        }
        return idMap.get(id);
    }
}
