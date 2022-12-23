/*
    Copyright 2018 Ericsson AB.
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
*/
package com.ericsson.eiffel.semantics.events;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ericsson.eiffel.remrem.semantics.RoutingKeyFamilies;

/**
 * This is the super class for all Eiffel event classes
 *
 */
public class Event {
    public transient Meta meta;
    public static final Logger log = LoggerFactory.getLogger(Event.class);

    /**
     * This method is used to generate UUID and time for events in meta
     * 
     * @param meta
     *            event meta class reference
     * @return event meta class reference with generated eventId and time values
     */
    public Meta generateMeta(Meta meta) {
        // The event epoch time is generated in UTC format
        meta.setTime(Instant.now(Clock.systemUTC()).toEpochMilli());
        meta.setId(UUID.randomUUID().toString());
        return meta;
    }

    /**
     * This method is used to get family based on the eventType
     * 
     * @param eventType
     *            Eiffel eventType
     * @return family based on eventType (or) error will be thrown if unknown
     *         eventType requested.
     */
    public String getFamilyRoutingKey(String eventType) {
    	
    	if(eventType != null) {
    		try {
    			return RoutingKeyFamilies.valueOf(eventType).getFamily();
    		} catch (IllegalArgumentException e) {
    			log.error("Unknown event type requested: " + eventType);
    		}
    	}else {
    		log.error("Null event type requested: " + eventType);
    	}
        
        return null;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}