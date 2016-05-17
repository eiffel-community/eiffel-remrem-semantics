package com.ericsson.eiffel.remrem.message.services;

import java.util.List;

/**
 * Created by ehenkan on 5/16/16.
 */
public class Message {
    private Meta meta;
    private Data data;
    private Links links;


    public Message(Meta meta, Data data, Links links) {
        this.meta = meta;
        this.data = data;
        this.links = links;
    }

    public static class Meta {
        private String domainId;
        private String id;
        private String type;
        private String version;
        private String time;

        public Meta(String domainId, String id, String type, String version, String time) {
            this.domainId = domainId;
            this.id = id;
            this.type = type;
            this.version = version;
            this.time = time;
        }
    }

    public static class Data {
        private String name;
        private String category;
        private Trigger trigger;
        private String executionType;

        public Data(String name, String category, Trigger trigger, String executionType) {
            this.name = name;
            this.category = category;
            this.trigger = trigger;
            this.executionType = executionType;
        }
    }

    public static class Links {
        private List<Cause> causes;

        public Links(List<Cause> causes) {
            this.causes = causes;
        }
    }

    public static class Cause {
        private String type;
        private String id;

        public Cause(String type, String id) {
            this.type = type;
            this.id = id;
        }
    }

    public static class Trigger {
        private String type;
        private String description;

        public Trigger(String type, String description) {
            this.type = type;
            this.description = description;
        }
    }
}
