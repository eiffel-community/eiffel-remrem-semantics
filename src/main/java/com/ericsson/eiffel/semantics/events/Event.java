/*
    Copyright 2017 Ericsson AB.
    For a full list of individual contributors, please see the commit history.
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/package com.ericsson.eiffel.semantics.events;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ericsson.eiffel.remrem.semantics.RoutingKeyTypes;
import com.ericsson.eiffel.remrem.semantics.SemanticsService;

public class Event {
	public transient Meta meta;
	public static final Logger log = LoggerFactory.getLogger(Event.class);

	public Meta generateMeta(Meta meta) {
		meta.setTime(System.currentTimeMillis());
		meta.setId(UUID.randomUUID().toString());
		return meta;
	}

	public static String getFamilyRoutingKey(String eventType) {
		try {
			return RoutingKeyTypes.valueOf(eventType).getFamily();
		} catch (Exception e) {
			log.error("Unknown event type requested: " + eventType);
		}
		return null;
	}

	public static String getTypeRoutingKey(String eventType) {
		try {
			return RoutingKeyTypes.valueOf(eventType).getType();
		} catch (Exception e) {
			log.error("Unknown event type requested: " + eventType);
		}
		return null;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
	/**
	 * @return void
	 */
	public void generateSerializerGav() {
		if (SemanticsService.getSemanticsGAV().get("groupId") != null) {
			if (this.getMeta().getSource() == null) {
				this.getMeta().setSource(new Source());
				this.getMeta().getSource().setSerializer(new Serializer());
			} else if (this.getMeta().getSource().getSerializer() == null) {
				this.getMeta().getSource().setSerializer(new Serializer());
			}
			this.getMeta().getSource().getSerializer().setGroupId(SemanticsService.getSemanticsGAV().get("groupId"));
			this.getMeta().getSource().getSerializer()
					.setArtifactId(SemanticsService.getSemanticsGAV().get("artifactId"));
			this.getMeta().getSource().getSerializer().setVersion(SemanticsService.getSemanticsGAV().get("version"));
		}
	}
}