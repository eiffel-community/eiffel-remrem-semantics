package com.ericsson.eiffel.remrem.message.services.models;


import java.util.List;

public class Meta {
    private String domainId;
    private String id;
    private String type;
    private String version;
    private long time;
    private List<String> tags;
    private Source source;

    public static class Source {
        private String host;
        private String name;
        private String uri;
        private Serializer serializer;
    }

    public static class Serializer {
        private String groupId;
        private String artifactId;
        private String version;
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
