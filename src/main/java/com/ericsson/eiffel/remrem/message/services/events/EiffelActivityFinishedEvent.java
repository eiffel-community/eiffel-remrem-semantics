package com.ericsson.eiffel.remrem.message.services.events;
import com.ericsson.eiffel.remrem.message.services.models.Data;

import java.util.List;

public class EiffelActivityFinishedEvent extends Event {

    EiffelActivityFinishedData data;
    EiffelActivityFinishedLinks links;


    public static class EiffelActivityFinishedData extends Data {
        private Data.Outcome outcome;
        private List<PersistentLog> persistentLogs;
    }

    public static class EiffelActivityFinishedLinks {
        private String activityExecution;
        private String context;
        private String flowContext;
        private List<String> causes;
    }
}
