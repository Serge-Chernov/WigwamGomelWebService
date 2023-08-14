package com.example.vigwamgomel.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    private String status;
    @OneToOne(cascade = CascadeType.ALL)
    private Wigwam wigwam;
    @OneToOne(cascade = CascadeType.ALL)
    private WigwamBottom wigwamBottom;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "order_pillow",
//            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "pillow_id", referencedColumnName = "id"))
//    private Set<Pillow> pillow = new HashSet<Pillow>();
    @OneToOne(cascade = CascadeType.ALL)
    private Pillow pillow;
    private BigDecimal price;

    private String date;
    public Order() {
    }

    public Order(long id, User user, String status, Wigwam wigwam, WigwamBottom wigwamBottom, Pillow pillow, BigDecimal price, String date) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.wigwam = wigwam;
        this.wigwamBottom = wigwamBottom;
        this.pillow = pillow;
        this.price = price;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
