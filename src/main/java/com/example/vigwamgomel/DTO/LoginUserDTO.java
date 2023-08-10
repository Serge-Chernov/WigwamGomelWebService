package com.example.vigwamgomel.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class LoginUserDTO {

    @NotEmpty
    @NotBlank
    private String email;

    @NotEmpty
    @NotBlank
    private String password;

    public LoginUserDTO() {
    }

    public LoginUserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
