package org.monese.apitest.dataobject.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserStatus {
    ACTIVE("active"),
    INACTIVE("inactive");

    @JsonValue
    private final String jsonValue;

    UserStatus(String jsonValue) {
        this.jsonValue = jsonValue;
    }
}
