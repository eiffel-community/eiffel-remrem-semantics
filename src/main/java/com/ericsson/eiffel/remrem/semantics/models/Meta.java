package com.ericsson.eiffel.remrem.semantics.models;

import lombok.Setter;


public class Meta {
    private String domainId;
    private String id;
    private String type;
    private String version;
    private long time;

    public Meta(String domainId, String id, String type, String version, long time) {
        this.domainId = domainId;
        this.id = id;
        this.type = type;
        this.version = version;
        this.time = time;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setId(String id) {
        this.id = id;
    }
}
