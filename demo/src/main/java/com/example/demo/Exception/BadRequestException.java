package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends APIException {
    public BadRequestException(String msg) {
        super(HttpStatus.BAD_REQUEST, "Loi du lieu dau vao", msg);
    }

}
