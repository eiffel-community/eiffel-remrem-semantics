package com.ericsson.eiffel.remrem.semantics.factory;

import java.util.UUID;
import java.util.logging.Logger;
import com.ericsson.eiffel.remrem.semantics.models.Models.Meta;
import com.ericsson.eiffel.remrem.semantics.models.Models.Meta.EiffelEventType;
import com.ericsson.eiffel.remrem.semantics.models.Models.Data.Source;
import com.ericsson.eiffel.remrem.semantics.models.Models.Data.Serializer;

public class MetaFactory {
    private static final Logger log = Logger.getLogger( Meta.class.getName() );

    public static Source getSource(final String domainId, final String host, final String name, final String uri, final Serializer gav) {
        final Source.Builder source = Source.newBuilder();
        source.setDomainId(domainId);
        source.setHost(host);
        source.setName(name);
        source.setUri(uri);
        source.setSerializer(gav);
        return source.build();
    }

    public static Serializer getSerializer(final String artifactId, final String version, final String groupId) {
        final Serializer.Builder gav = Serializer.newBuilder();
        return gav.setGroupId(groupId).setArtifactId(artifactId).setVersion(version).build();
    }

    public static Meta create(final EiffelEventType type, final Source source) {
        final Meta.Builder meta = Meta.newBuilder();
        meta.setId(UUID.randomUUID().toString());
        meta.setType(type);
        meta.setTime(java.lang.System.currentTimeMillis());
        meta.setSource(source);
        return meta.build();
    }
}
