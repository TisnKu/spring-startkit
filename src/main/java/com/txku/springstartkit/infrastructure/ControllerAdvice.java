package com.txku.springstartkit.infrastructure;

import com.txku.springstartkit.exception.StartkitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(value = StartkitException.class)
    public ResponseEntity handleStartkitRuntimeException(StartkitException exception) {
        logger.error(exception.getMessage(), exception);
        return ResponseEntity.status(exception.getStatus())
                .body(exception);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception exception) {
        logger.error(exception.getMessage(), exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception);
    }
}
