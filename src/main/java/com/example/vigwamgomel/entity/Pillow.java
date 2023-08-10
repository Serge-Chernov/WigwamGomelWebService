package com.example.vigwamgomel.entity;

import com.example.vigwamgomel.enums.PillowType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Pillow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pillowType;

    @OneToOne(cascade = CascadeType.ALL)
    private TextileColor color;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "order_pillow",
//            joinColumns = @JoinColumn(name = "pillow_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"))
//    private Set<Order> orders = new HashSet<Order>();

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
