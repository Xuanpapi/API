package com.example.demo.API;

import jakarta.validation.constraints.*;

public class UserRequest {
    @NotBlank(message = "Username không được để trống")
    private String username;

    @Size(min = 6, message = "Password toi thieu tư 6 ki tự trở lên")
    @NotBlank(message = "Password khong duoc de trong")
    private String password;

    @NotBlank(message = "Email khong duoc de trong ")
    @Email(message = "Email khong dung dinh dang")
    private String email;

    public UserRequest() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
