package com.example.vigwamgomel.entity;

import com.example.vigwamgomel.enums.PillowType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String username;

    private String email;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private UserAddress address;
    @OneToOne(cascade = CascadeType.ALL)
    private UserPhone phone;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<Order>();

    public User() {
    }

    public User(long id, String name,
                String username, String email,
                String password, UserAddress address,
                UserPhone phone, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    public UserPhone getPhone() {
        return phone;
    }

    public void setPhone(UserPhone phone) {
        this.phone = phone;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                ", phone=" + phone +
                ", orders=" + orders +
                '}';
    }
}
