package org.monese.shared;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.String.format;

public class Configuration {
    private final Properties properties;

    public Configuration(InputStream inputStream) {
        properties = new Properties();

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties", e);
        }
    }

    public String getString(String key) {
        String value = properties.getProperty(key);

        if (value == null) {
            throw new RuntimeException(format("Property '%s' is not defined.", key));
        }

        return value;
    }

    public int getInteger(String key) {
        return Integer.parseInt(getString(key));
    }
}
