package com.example.demo.Exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends APIException {
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, "Loi khong tim thay", message);
    }

}
