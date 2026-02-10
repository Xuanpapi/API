package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends APIException {
    public ConflictException(String msg) {
        super(HttpStatus.CONFLICT, "Loi trung du lieu", msg);
    }

}
