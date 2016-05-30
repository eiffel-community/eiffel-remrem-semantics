package com.ericsson.eiffel.remrem.semantics.events;

import com.ericsson.eiffel.remrem.semantics.models.Data;
import com.ericsson.eiffel.remrem.semantics.models.Links;

import java.util.List;


public class EiffelArtifactPublishedEvent extends Event {

    EiffelArtifactPublishedData data;
    EiffelArtifactPublishedLinks links;

    public static class EiffelArtifactPublishedData extends Data {
        private List<Location> locations;
    }

    public static class EiffelArtifactPublishedLinks extends Links {
        private String context;
        private String artifact;
    }
}
