package com.ericsson.eiffel.remrem.message.services;

/**
 * Created by ehenkan on 5/17/16.
 */
public class Data {

    public static class Outcome {
        private String verdict;
        private String description;
    }

    public static class PersistentLog {
        private String name;
        private String uris;
    }

    public static class Location {
        private String type;
        private String uri;
    }

    public static class Cause {
        private String type;
        private String id;
    }

    public static class Trigger {
        private String type;
        private String description;
    }
}
