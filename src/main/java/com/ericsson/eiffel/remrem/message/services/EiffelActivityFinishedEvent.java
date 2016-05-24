package com.ericsson.eiffel.remrem.message.services;

import java.util.List;

public class EiffelActivityFinishedEvent extends Event {

    EiffelActivityFinishedData data;
    EiffelActivityFinishedLinks links;


    public static class EiffelActivityFinishedData extends Data{
        private Data.Outcome outcome;
        private List<PersistentLog> PersistentLogs;
    }

    public static class EiffelActivityFinishedLinks extends Links{
        private String activityExecution;
    }
}
