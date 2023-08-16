package com.example.vigwamgomel.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Pillow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pillowType;

    @OneToOne(cascade = CascadeType.ALL)
    private TextileColor color;

    private BigDecimal price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPillowType() {
        return pillowType;
    }

    public void setPillowType(String pillowType) {
        this.pillowType = pillowType;
    }

    public TextileColor getColor() {
        return color;
    }

    public void setColor(TextileColor color) {
        this.color = color;
    }

//    public Set<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Set<Order> orders) {
//        this.orders = orders;
//    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
