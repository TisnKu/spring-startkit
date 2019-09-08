package com.txku.springstartkit.controller;

import com.txku.springstartkit.entity.User;
import com.txku.springstartkit.repository.UserRepository;
import com.txku.springstartkit.request.LoginRequest;
import com.txku.springstartkit.utility.JsonUtil;
import com.txku.springstartkit.utility.ShaUtil;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

class TokenControllerTest extends BaseIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    void should_return_token_response_when_login_with_correct_username_and_password() {
        generateUser();

        LoginRequest request = new LoginRequest("user1", "password1");
        given().body(JsonUtil.stringify(request))
                .post("/api/token")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("$.token", Matchers.notNullValue());

    }

    @Test
    void should_return_401_when_login_with_incorrect_username_and_password() {
        generateUser();
        LoginRequest request = new LoginRequest("user1", "password2");
        given().body(JsonUtil.stringify(request))
                .post("/api/token")
                .then()
                .statusCode(HttpStatus.UNAUTHORIZED.value())
                .body("$.message", Matchers.is("Wrong username or credentials"));

    }

    private void generateUser() {
        userRepository.save(User.builder()
                .firstName("tianxi")
                .lastName("haha")
                .username("user1")
                .password(ShaUtil.sha("password1"))
                .build());
    }
}