package com.example.vigwamgomel.entity;

import jakarta.persistence.*;

@Entity
public class WigwamBottom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String bottomType;

    @OneToOne(cascade = CascadeType.ALL)
    private TextileColor color;

    public WigwamBottom() {
    }

    public WigwamBottom(long id, String bottomType, TextileColor color) {
        this.id = id;
        this.bottomType = bottomType;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBottomType() {
        return bottomType;
    }

    public void setBottomType(String bottomType) {
        this.bottomType = bottomType;
    }


    public TextileColor getColor() {
        return color;
    }

    public void setColor(TextileColor color) {
        this.color = color;
    }
}
