package com.txku.springstartkit.service;

import com.txku.springstartkit.entity.User;
import com.txku.springstartkit.exception.StartkitException;
import com.txku.springstartkit.repository.UserRepository;
import com.txku.springstartkit.request.LoginRequest;
import com.txku.springstartkit.response.TokenResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class TokenService {
    private UserRepository userRepository;

    public TokenService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TokenResponse generateToken(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        // todo validate password
        if (Objects.isNull(user)) {
            throw new StartkitException(HttpStatus.UNAUTHORIZED, "Invalid username or password.");
        }
        return new TokenResponse(UUID.randomUUID().toString());
    }
}
