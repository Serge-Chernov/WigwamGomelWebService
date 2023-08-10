//package com.example.vigwamgomel.entity;
//
//import com.example.vigwamgomel.enums.TextileType;
//import jakarta.persistence.*;
//
//@Entity
//public class Textile {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private TextileType type;
//    @OneToOne
//    private TextileColor color;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public TextileType getType() {
//        return type;
//    }
//
//    public void setType(TextileType type) {
//        this.type = type;
//    }
//
//    public TextileColor getColor() {
//        return color;
//    }
//
//    public void setColor(TextileColor color) {
//        this.color = color;
//    }
//}
