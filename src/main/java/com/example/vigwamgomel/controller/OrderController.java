package com.example.vigwamgomel.controller;

import com.example.vigwamgomel.DTO.OrderDTO;
import com.example.vigwamgomel.DTO.ShowColorDTO;
import com.example.vigwamgomel.entity.Order;
import com.example.vigwamgomel.entity.TextileColor;
import com.example.vigwamgomel.enums.*;
import com.example.vigwamgomel.mapper.TextileColorEntityListToDTOList;
import com.example.vigwamgomel.service.OrderService;
import com.example.vigwamgomel.service.TextileColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    TextileColorService colorService;

    @Autowired
    OrderService orderService;

    @GetMapping("/create")
    public String createOrder(Model model) {
        model.addAttribute("newOrder", new OrderDTO());

        Size[] sizes = Size.values();
        model.addAttribute("sizes", sizes);

        List<TextileColor> colors = colorService.findAll();
        List<ShowColorDTO> showColorDTOS = TextileColorEntityListToDTOList.entityToDTO(colors);
        model.addAttribute("colors", showColorDTOS);

        WindowsCount[] windows = WindowsCount.values();
        model.addAttribute("windows", windows);

        WigwamBottomType[] bottoms = WigwamBottomType.values();
        model.addAttribute("bottoms", bottoms);

        PillowType[] pillows = PillowType.values();
        model.addAttribute("pillows", pillows);
        return "create_order";

    }

    @PostMapping("/create")
    public String registration(@ModelAttribute("createOrder") OrderDTO orderDTO) {
        orderService.save(orderDTO);
        return "redirect:/";
//        }
    }
    @GetMapping("/orders")
    public String orders(){
        return "orders";
    }

    @GetMapping("/findAllOrders")
    public String findAll(Model model){
        List<Order> allOrders = orderService.findAll();
        if (!allOrders.isEmpty()) {
            model.addAttribute("allOrders", allOrders);
            return "all_orders";
        }else {
            model.addAttribute("allOrders", "В базе данных нет закахов");
        }
        return "all_orders";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Optional<Order> orderById = orderService.findById(id);
        if(orderById.isPresent()) {
            model.addAttribute("orderById", orderById);
        }else {
            model.addAttribute("orderById", "Заказ не найден");
        }
        return "orderList";
    }
    @GetMapping("/{id}/edit")
    public String editOrder(@PathVariable Long id, @ModelAttribute("orderById") Optional<Order> orderById, Model model){

        OrderStatus[] status = OrderStatus.values();
        model.addAttribute("status", status);
        return "edit_order";
    }

    @PostMapping("/orders/edit/{id}")
    public String editOrder(@PathVariable Long id, @ModelAttribute("orderById") Optional<Order> orderById, Model model, String orderStatus){

        if(orderById.isPresent()) {
            Order order = orderById.get();
            orderService.updateOrder(order, orderStatus);
            return "edit_order";
        }else {
            model.addAttribute("orderError", "Ошибка");
        }
        return "edit_order";
    }
}
