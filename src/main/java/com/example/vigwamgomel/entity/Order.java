package com.example.vigwamgomel.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //    @ManyToOne(cascade = CascadeType.ALL)
//    private User user;

    private long userId;

    private String username;

    private String status;
    @OneToOne(cascade = CascadeType.ALL)
    private Wigwam wigwam;
    @OneToOne(cascade = CascadeType.ALL)
    private WigwamBottom wigwamBottom;
    @OneToOne(cascade = CascadeType.ALL)
    private Pillow pillow;
    private BigDecimal price;

    private String date;

    public Order() {
    }

    public Order(long id, long userId, String username, String status, Wigwam wigwam, WigwamBottom wigwamBottom, Pillow pillow, BigDecimal price, String date) {
        this.id = id;
//        this.user = user;
        this.userId = userId;
        this.username = username;
        this.status = status;
        this.wigwam = wigwam;
        this.wigwamBottom = wigwamBottom;
        this.pillow = pillow;
        this.price = price;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Wigwam getWigwam() {
        return wigwam;
    }

    public void setWigwam(Wigwam wigwam) {
        this.wigwam = wigwam;
    }

    public WigwamBottom getWigwamBottom() {
        return wigwamBottom;
    }

    public void setWigwamBottom(WigwamBottom wigwamBottom) {
        this.wigwamBottom = wigwamBottom;
    }

    public Pillow getPillow() {
        return pillow;
    }

    public void setPillow(Pillow pillow) {
        this.pillow = pillow;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ID заказа: " + id +
                "; ID пользователя: " + userId +
                "; Статус: " + status +
                "; Цена: " + price +
                "; Дата: " + date;
    }
}
