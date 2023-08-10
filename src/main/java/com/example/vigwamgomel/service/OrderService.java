package com.example.vigwamgomel.service;

import com.example.vigwamgomel.DTO.OrderDTO;
import com.example.vigwamgomel.entity.Order;
import com.example.vigwamgomel.mapper.OrderMapper;
import com.example.vigwamgomel.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    OrderRepository repository;

    public void save(OrderDTO orderDTO) {
        Order order = OrderMapper.orderDTOtoOrder(orderDTO);
        repository.save(order);
    }
}
