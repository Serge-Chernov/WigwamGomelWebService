package com.example.vigwamgomel.entity;

import jakarta.persistence.*;

@Entity
public class Wigwam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String size;
    private int windowsCount;
    @OneToOne(cascade = CascadeType.ALL)
    private TextileColor color;

    public Wigwam() {
    }

    public Wigwam(long id, String size, int windowsCount, TextileColor color) {
        this.id = id;
        this.size = size;
        this.windowsCount = windowsCount;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getWindowsCount() {
        return windowsCount;
    }

    public void setWindowsCount(int windowsCount) {
        this.windowsCount = windowsCount;
    }

    public TextileColor getColor() {
        return color;
    }

    public void setColor(TextileColor color) {
        this.color = color;
    }
}
