package org.monese.apitest.dataobject;

import static java.lang.String.format;

public enum Endpoint {
    USERS("/public/v2/users"),
    USERS_ID("/public/v2/users/%s");

    private final String value;

    Endpoint(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getValue(Object... args) {
        return format(value, args);
    }
}
