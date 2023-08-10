package com.example.vigwamgomel.mapper;

import com.example.vigwamgomel.DTO.OrderDTO;
import com.example.vigwamgomel.DTO.UserDTO;
import com.example.vigwamgomel.entity.*;
import com.sun.jdi.IntegerValue;

public class OrderMapper {
    public static Order orderDTOtoOrder(OrderDTO orderDTO){
        Order order = new Order();

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
        return order;
    }
}
