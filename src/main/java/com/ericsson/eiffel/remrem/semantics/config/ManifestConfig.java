package com.ericsson.eiffel.remrem.semantics.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.inject.Named;


@Named
public class ManifestConfig {
    
    public Attributes getManifestAttributes() {
        InputStream manifestStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("/META-INF/MANIFEST.MF");
        try {
            Manifest manifest = new Manifest(manifestStream);
            return manifest.getMainAttributes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
