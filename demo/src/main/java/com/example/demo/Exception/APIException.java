package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

public class APIException extends RuntimeException {
    private HttpStatus status;
    private String error;

    public APIException(HttpStatus status, String error, String message) {
        super(message);
        this.status = status;
        this.error = error;
    }

    public APIException() {
    };

    public HttpStatus getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}
