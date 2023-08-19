package org.monese.apitest.dataobject.request.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.monese.apitest.dataobject.common.UserGender;
import org.monese.apitest.dataobject.common.UserStatus;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostUsersRequest {
    String email;

    String name;

    UserGender gender;

    UserStatus status;
}
