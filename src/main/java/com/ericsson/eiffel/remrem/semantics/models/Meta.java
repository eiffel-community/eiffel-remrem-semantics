package com.ericsson.eiffel.remrem.semantics.models;



public class Meta {
    private String domainId;
    private String id;
    private String type;
    private String version;
    private long time;

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
