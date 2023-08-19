package org.monese.apitest.dataobject.factory;

import org.monese.apitest.dataobject.common.UserGender;
import org.monese.apitest.dataobject.common.UserStatus;
import org.monese.apitest.dataobject.request.user.PostUsersRequest;

import static java.lang.String.format;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class RequestFactory {
    public PostUsersRequest postUsersRequest() {
        return PostUsersRequest.builder()
                .email(format("%s@monese.com", randomAlphabetic(10)))
                .name(randomAlphabetic(10))
                .gender(UserGender.FEMALE)
                .status(UserStatus.ACTIVE)
                .build();
    }
}
