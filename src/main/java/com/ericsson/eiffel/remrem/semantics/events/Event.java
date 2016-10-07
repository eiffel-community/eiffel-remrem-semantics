package com.ericsson.eiffel.remrem.semantics.events;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.ericsson.eiffel.remrem.semantics.models.Meta;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.jar.Attributes;
import java.util.jar.Manifest;


public abstract class Event {
    public Meta meta;
    public static String  version = "0.1.4";

    public void generateMeta(String msgType, JsonObject msgNodes) {
        meta = new Gson().fromJson(msgNodes.get("meta"), Meta.class);
        meta.setType(msgType);
        meta.setTime(System.currentTimeMillis());
        // TO DO unit tests are not working
//        String version = getCurrentVersion();
        meta.setVersion(version);
        meta.setId(UUID.randomUUID().toString());
    }

    public String getCurrentVersion() {
    	InputStream manifestStream = Thread.currentThread()
    			.getContextClassLoader()
    			.getResourceAsStream("/META-INF/MANIFEST.MF");
    	try {
    		Manifest manifest = new Manifest(manifestStream);
    		Attributes attributes = manifest.getMainAttributes();
    		return attributes.getValue("Semantics-Version");
    	}
    	catch(IOException ex) {
    		
    	}
    	
    	return null;
    }
}