package com.example.vigwamgomel.DTO;

public class ShowColorDTO {
    private String name;
    private String sample;

    private String path;

    public ShowColorDTO() {
    }

    public ShowColorDTO(String name, String sample, String path) {
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

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
