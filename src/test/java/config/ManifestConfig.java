package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManifestConfig {
    @Bean
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
