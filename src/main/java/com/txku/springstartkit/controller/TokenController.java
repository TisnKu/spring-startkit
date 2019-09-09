package com.txku.springstartkit.controller;

import com.txku.springstartkit.request.LoginRequest;
import com.txku.springstartkit.response.TokenResponse;
import com.txku.springstartkit.service.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/token")
public class TokenController {

    private TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    public TokenResponse login(@RequestBody LoginRequest request) {
        return tokenService.generateToken(request);
    }
}
