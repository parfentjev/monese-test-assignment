package org.monese.apitest.util;

import org.monese.shared.Configuration;

public class ApiConfiguration {
    public static final String BASE_URL;
    public static final String TOKEN;

    static {
        Configuration configuration = new Configuration(ApiConfiguration.class.getClassLoader().getResourceAsStream("api-test.properties"));
        BASE_URL = configuration.getString("baseUrl");
        TOKEN = configuration.getString("token");
    }
}
