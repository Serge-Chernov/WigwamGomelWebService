package com.example.vigwamgomel.mapper;

import com.example.vigwamgomel.DTO.OrderDTO;
import com.example.vigwamgomel.DTO.UserDTO;
import com.example.vigwamgomel.entity.*;
import com.example.vigwamgomel.enums.OrderStatus;
import com.sun.jdi.IntegerValue;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class OrderMapper {
    public static Order orderDTOtoOrder(OrderDTO orderDTO) {
        Order order = new Order();

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        User user =(User) loggedInUser.getPrincipal();

        order.setUserId(user.getId());
        order.setUsername(user.getUsername());

        Wigwam wigwam = new Wigwam();
        wigwam.setSize(orderDTO.getWigwamSize());

        TextileColor wigwamColor = new TextileColor();
        wigwamColor.setName(orderDTO.getWigwamColor());

        wigwam.setColor(wigwamColor);

        wigwam.setWindowsCount(Integer.parseInt(orderDTO.getWindowsCount()));

        order.setWigwam(wigwam);

        WigwamBottom wigwamBottom = new WigwamBottom();

        wigwamBottom.setBottomType(orderDTO.getBottomType());

        TextileColor bottomColor = new TextileColor();
        bottomColor.setName(orderDTO.getBottomColor());
        wigwamBottom.setColor(bottomColor);

        order.setWigwamBottom(wigwamBottom);

        Pillow pillow = new Pillow();
        pillow.setPillowType(orderDTO.getPillowType());

        TextileColor pillowColor = new TextileColor();
        pillowColor.setName(orderDTO.getPillowColor());

        pillow.setColor(pillowColor);
        order.setPillow(pillow);

        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("d.MM.uuuu HH:mm"));
        order.setDate(date);
        order.setStatus(OrderStatus.PROCESSED.getDisplayValue());
        return order;
    }
}
