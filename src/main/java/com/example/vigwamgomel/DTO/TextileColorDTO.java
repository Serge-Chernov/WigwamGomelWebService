package com.example.vigwamgomel.DTO;

import jakarta.validation.constraints.Pattern;
import org.springframework.web.multipart.MultipartFile;

public class TextileColorDTO {
    @Pattern(regexp = "[A-Za-z&$#@*., -!?+=()\\[\\]{}<>\\d]*", message = "This store name contains invalid characters")
    private String name;
    private MultipartFile sample;

    public TextileColorDTO() {
    }

    public TextileColorDTO(String name, MultipartFile sample) {
        this.name = name;
        this.sample = sample;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getSample() {
        return sample;
    }

    public void setSample(MultipartFile sample) {
        this.sample = sample;
    }
}
