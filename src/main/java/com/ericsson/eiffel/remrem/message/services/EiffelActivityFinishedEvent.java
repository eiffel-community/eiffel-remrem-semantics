package com.ericsson.eiffel.remrem.message.services;


import com.google.gson.annotations.SerializedName;

public class EiffelActivityFinishedEvent extends Event {

    EiffelActivityFinishedData data;
    EiffelActivityFinishedLinks links;


    public static class EiffelActivityFinishedData extends Data{
        private Data.Outcome outcome;
    }

    public static class EiffelActivityFinishedLinks extends Links{
        private String activityExecution;
    }
}
