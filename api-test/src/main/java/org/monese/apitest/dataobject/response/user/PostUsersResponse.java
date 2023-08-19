package org.monese.apitest.dataobject.response.user;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.monese.apitest.dataobject.common.UserGender;
import org.monese.apitest.dataobject.common.UserStatus;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostUsersResponse {
    Long id;

    String email;

    String name;

    UserGender gender;

    UserStatus status;
}
