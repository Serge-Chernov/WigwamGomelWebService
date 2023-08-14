package com.example.vigwamgomel.service;

import com.example.vigwamgomel.DTO.OrderDTO;
import com.example.vigwamgomel.DTO.UserDTO;
import com.example.vigwamgomel.entity.Order;
import com.example.vigwamgomel.entity.User;
import com.example.vigwamgomel.mapper.OrderMapper;
import com.example.vigwamgomel.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderService {
    @Autowired
    OrderRepository repository;

    public void save(OrderDTO orderDTO) {
        Order order = OrderMapper.orderDTOtoOrder(orderDTO);
        repository.save(order);
    }

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Optional<Order> findById(Long id){
        Optional<Order> byId = repository.findById(id);
        return byId;
    }

    public Optional<Order> findByLoggedInUser(){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        User user =(User) loggedInUser.getPrincipal();
        Optional<Order> byUser = repository.findByUser(user);
        return byUser;
    }

    public void updateOrder(Order order, String orderStatus){
        long id = order.getId();
        Order orderToUpdate = repository.getReferenceById(id);
        orderToUpdate.setStatus(order.getStatus());
        repository.save(orderToUpdate);
    }
}
