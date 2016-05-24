package com.ericsson.eiffel.remrem.message.services;

import java.util.List;

/**
 * Created by ehenkan on 5/19/16.
 */
public class EiffelArtifactPublishedEvent extends Event {

    EiffelArtifactPublishedData data;
    EiffelArtifactPublishedLinks links;

    public static class EiffelArtifactPublishedData extends Data{
        private List<Location> locations;
    }

    public static class EiffelArtifactPublishedLinks extends Links{
        private String context;
        private String artifact;
    }
}
