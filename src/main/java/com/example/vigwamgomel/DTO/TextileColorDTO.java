package com.example.vigwamgomel.DTO;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TextileColorDTO {
    @Pattern(regexp = "[A-Za-z&$#@*., -!?+=()\\[\\]{}<>\\d]*", message = "This store name contains invalid characters")
    private String name;
    @NotNull
    private MultipartFile sample;

    private String path;

    public TextileColorDTO() {
    }

    public TextileColorDTO(String name, MultipartFile sample, String path) {
        this.name = name;
        this.sample = sample;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
