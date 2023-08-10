package com.example.vigwamgomel.DTO;

import com.example.vigwamgomel.enums.PillowType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class UserDTO {
    @NotEmpty
    @NotBlank
    private String name;
    @NotEmpty
    @NotBlank
    private String username;

    @NotEmpty
    @NotBlank
    private String email;
    @NotEmpty
    @NotBlank
    @NotNull
    private String password;
    @NotEmpty
    @NotBlank
    private String postCode;
    @NotEmpty
    @NotBlank
    private String city;
    @NotEmpty
    @NotBlank
    private String address;
    @NotEmpty
    @NotBlank
    private String phoneNumber;
    @NotEmpty
    @NotBlank
    String pillowType;



    public UserDTO() {
    }

    public UserDTO(String name, String username,
                   String email, String password,
                   String postCode, String city,
                   String address, String phoneNumber, String pillowType) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.postCode = postCode;
        this.city = city;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.pillowType = pillowType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPillowType() {
        return pillowType;
    }

    public void setPillowType(String pillowType) {
        this.pillowType = pillowType;
    }
}
