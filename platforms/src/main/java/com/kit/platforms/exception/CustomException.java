package com.kit.platforms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Author: carwen
 * Date:   16-3-29
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }

    public CustomException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
