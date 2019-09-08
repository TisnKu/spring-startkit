package com.txku.springstartkit.service;

import com.txku.springstartkit.entity.User;
import com.txku.springstartkit.exception.StartkitException;
import com.txku.springstartkit.repository.UserRepository;
import com.txku.springstartkit.request.LoginRequest;
import com.txku.springstartkit.response.TokenResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TokenServiceTest {

    @InjectMocks
    private TokenService tokenService;

    @Mock
    private UserRepository userRepository;

    @Test
    void should_generate_token_successfully_with_correct_username_and_password() {
        LoginRequest request = new LoginRequest("username1", "password1");
        when(userRepository.findByUsername(request.getUsername())).thenReturn(User.builder().build());
        TokenResponse tokenResponse = tokenService.generateToken(request);
        assertNotNull(tokenResponse.getToken());
    }

    @Test
    void should_throw_exception_when_user_does_not_exists() {
        LoginRequest request = new LoginRequest("username1", "password1");
        when(userRepository.findByUsername(request.getUsername())).thenReturn(null);
        StartkitException startkitException = assertThrows(StartkitException.class, () -> tokenService.generateToken(request));
        assertEquals("Invalid username or password.", startkitException.getMessage());
        assertEquals(HttpStatus.UNAUTHORIZED, startkitException.getStatus());
    }
}