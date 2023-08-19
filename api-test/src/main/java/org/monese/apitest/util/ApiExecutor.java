package org.monese.apitest.util;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.monese.apitest.dataobject.Endpoint;
import org.monese.apitest.dataobject.request.user.PostUsersRequest;
import org.monese.apitest.dataobject.response.ExtendedResponse;
import org.monese.apitest.dataobject.response.user.GetUsersByIdResponse;
import org.monese.apitest.dataobject.response.user.PostUsersResponse;

import static io.restassured.RestAssured.given;

public class ApiExecutor {
    private final String baseUrl;
    private final String token;

    public ApiExecutor(String baseUrl, String token) {
        this.baseUrl = baseUrl;
        this.token = token;
    }

    private RequestSpecification restAssured() {
        return given()
                .baseUri(baseUrl)
                .header("Authorization", "Bearer " + token)
                .log().everything();
    }

    private RequestSpecification restAssured(Object object) {
        return restAssured().body(object).contentType(ContentType.JSON);
    }

    public ExtendedResponse<PostUsersResponse> postUsers(PostUsersRequest request) {
        return new ExtendedResponse<>(restAssured(request).post(Endpoint.USERS.getValue()), PostUsersResponse.class);
    }

    public ExtendedResponse<GetUsersByIdResponse> getUsersById(Long id) {
        return new ExtendedResponse<>(restAssured().get(Endpoint.USERS_ID.getValue(id)), GetUsersByIdResponse.class);
    }
}
