package com.example.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(APIException.class)
    public ResponseEntity<Map<String, Object>> hanlderAPI(APIException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", ex.getStatus().value());
        body.put("error", ex.getError());
        body.put("message", ex.getMessage());

        return ResponseEntity
                .status(ex.getStatus())
                .body(body);
    }

    // Bắt đúng loại exception mà @Valid ném ra
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(
            MethodArgumentNotValidException ex) {

        // Tạo Map để chứa lỗi dạng:
        // key = tên field (username, password, email)
        // value = message lỗi tương ứng
        Map<String, String> errors = new LinkedHashMap<>();

        // ex.getBindingResult()
        // → chứa toàn bộ lỗi validation
        ex.getBindingResult()

                // Lấy danh sách lỗi theo từng field
                .getFieldErrors()

                // Duyệt từng lỗi
                .forEach(error ->

                // error.getField()
                // → tên field bị lỗi (username / password / email)
                // error.getDefaultMessage()
                // → message mày viết trong annotation
                errors.put(
                        error.getField(),
                        error.getDefaultMessage()));

        // Trả về cho client:
        // HTTP 400 + JSON lỗi
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

}
