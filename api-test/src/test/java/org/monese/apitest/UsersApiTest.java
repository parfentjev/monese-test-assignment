package org.monese.apitest;

import org.monese.apitest.dataobject.factory.DataObjectFactories;
import org.monese.apitest.dataobject.request.user.PostUsersRequest;
import org.monese.apitest.util.ApiConfiguration;
import org.monese.apitest.util.ApiExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class UsersApiTest {
    private ApiExecutor executor;

    @BeforeTest
    public void setUp() {
        executor = new ApiExecutor(ApiConfiguration.BASE_URL, ApiConfiguration.TOKEN);
    }

    @Test
    public void createUser() {
        PostUsersRequest request = DataObjectFactories.request().postUsersRequest();

        Long userId = executor.postUsers(request)
                .statusCode(201)
                .responseConsumer(response -> {
                    assertThat(response.getId()).isGreaterThan(0L);
                    assertThat(response.getEmail()).isEqualTo(request.getEmail());
                    assertThat(response.getName()).isEqualTo(request.getName());
                    assertThat(response.getGender()).isEqualTo(request.getGender());
                    assertThat(response.getStatus()).isEqualTo(request.getStatus());

                    return response.getId();
                });

        executor.getUsersById(userId)
                .statusCode(200)
                .responseConsumer(response -> {
                    assertThat(response.getId()).isEqualTo(userId);
                    assertThat(response.getEmail()).isEqualTo(request.getEmail());
                    assertThat(response.getName()).isEqualTo(request.getName());
                    assertThat(response.getGender()).isEqualTo(request.getGender());
                    assertThat(response.getStatus()).isEqualTo(request.getStatus());
                });
    }

    @Test
    public void createUserWithoutEmail() {
        PostUsersRequest request = DataObjectFactories.request().postUsersRequest();
        request.setEmail(null);

        executor.postUsers(request)
                .statusCode(422)
                .validatableConsumer(response -> {
                    response.body("$", hasSize(1));
                    response.body("[0].field", equalTo("email"));
                    response.body("[0].message", equalTo("can't be blank"));
                });
    }

    @Test
    public void createUserAndVerifyIdIsNull() {
        PostUsersRequest request = DataObjectFactories.request().postUsersRequest();

        executor.postUsers(request)
                .statusCode(201)
                .responseConsumer(response -> {
                    assertThat(response.getId()).isNull();
                    assertThat(response.getEmail()).isEqualTo(request.getEmail());
                    assertThat(response.getName()).isEqualTo(request.getName());
                    assertThat(response.getGender()).isEqualTo(request.getGender());
                    assertThat(response.getStatus()).isEqualTo(request.getStatus());
                });
    }
}
