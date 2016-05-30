package com.ericsson.eiffel.remrem.message.services.events;
import com.ericsson.eiffel.remrem.message.services.models.Data;

import java.util.List;


public class EiffelArtifactPublishedEvent extends Event {

    EiffelArtifactPublishedData data;
    EiffelArtifactPublishedLinks links;

    public static class EiffelArtifactPublishedData extends Data {
        private List<Location> locations;
    }

    public static class EiffelArtifactPublishedLinks {
        private String context;
        private String artifact;
        private String flowContext;
        private List<String> causes;
    }
}
