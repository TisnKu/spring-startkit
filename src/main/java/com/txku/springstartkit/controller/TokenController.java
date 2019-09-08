package com.txku.springstartkit.controller;

import com.txku.springstartkit.request.LoginRequest;
import com.txku.springstartkit.response.TokenResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/token")
public class TokenController {

    @PostMapping
    public TokenResponse login(@RequestBody LoginRequest request) {
        return new TokenResponse(String.format("token of: %s + %s", request.getUsername(), request.getPassword()));
    }
}
