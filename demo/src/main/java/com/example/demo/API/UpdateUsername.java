package com.example.demo.API;

import jakarta.validation.constraints.NotBlank;

public class UpdateUsername {
    @NotBlank(message = "Username không được để trống")
    private String newUsername;

    public String getNewUsername() {
        return newUsername;
    }

}
