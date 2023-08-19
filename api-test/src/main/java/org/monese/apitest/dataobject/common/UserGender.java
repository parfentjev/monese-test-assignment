package org.monese.apitest.dataobject.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserGender {
    MALE("male"),
    FEMALE("female");

    @JsonValue
    private final String jsonValue;

    UserGender(String jsonValue) {
        this.jsonValue = jsonValue;
    }
}
