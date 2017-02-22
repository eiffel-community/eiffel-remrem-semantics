package com.ericsson.eiffel.semantics.events;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ericsson.eiffel.remrem.semantics.RoutingKeyTypes;

public class Event {
	public transient Meta meta;
	public static final Logger log = LoggerFactory.getLogger(Event.class);

	public Meta generateMeta(Meta meta) {
		meta.setTime(System.currentTimeMillis());
		meta.setId(UUID.randomUUID().toString());
		return meta;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
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

}