package com.ericsson.eiffel.remrem.message.services.events;

import com.ericsson.eiffel.remrem.message.services.events.Event;
import com.ericsson.eiffel.remrem.message.services.models.Data;
import com.ericsson.eiffel.remrem.message.services.models.Links;

import java.util.List;

public class EiffelActivityFinishedEvent extends Event {

    EiffelActivityFinishedData data;
    EiffelActivityFinishedLinks links;


    public static class EiffelActivityFinishedData extends Data {
        private Data.Outcome outcome;
        private List<PersistentLog> persistentLogs;
    }

    public static class EiffelActivityFinishedLinks extends Links {
        private String activityExecution;
    }
}
