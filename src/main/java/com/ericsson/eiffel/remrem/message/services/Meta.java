package com.ericsson.eiffel.remrem.message.services;

import lombok.Setter;

/**
 * Created by ehenkan on 5/17/16.
 */
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

    public void setTime(long time) {
        this.time = time;
    }
}
