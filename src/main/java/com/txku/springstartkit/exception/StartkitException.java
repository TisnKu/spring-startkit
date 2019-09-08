package com.txku.springstartkit.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = false)
public class StartkitException extends RuntimeException {
    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    public StartkitException(String message) {
        super(message);
    }

    public StartkitException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public StartkitException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
    }

}
