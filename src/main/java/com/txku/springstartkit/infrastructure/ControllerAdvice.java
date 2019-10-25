package com.txku.springstartkit.infrastructure;

import com.txku.springstartkit.exception.StartkitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {
    @ExceptionHandler(StartkitException.class)
    public ResponseEntity handleStartkitRuntimeException(StartkitException exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.status(exception.getStatus())
                .body(exception);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception);
    }
}
