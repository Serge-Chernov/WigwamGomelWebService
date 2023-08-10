package com.example.vigwamgomel.service;

import com.example.vigwamgomel.entity.Order;

public class OrderStatusService {

    public void changeStatus(Order order, String status){
        order.setStatus(status);
    };
}
