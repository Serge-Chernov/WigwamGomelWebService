package com.example.vigwamgomel.controller;

import com.example.vigwamgomel.DTO.OrderDTO;
import com.example.vigwamgomel.DTO.OrderStatusDTO;
import com.example.vigwamgomel.DTO.ShowColorDTO;
import com.example.vigwamgomel.entity.Order;
import com.example.vigwamgomel.entity.TextileColor;
import com.example.vigwamgomel.entity.User;
import com.example.vigwamgomel.enums.*;
import com.example.vigwamgomel.mapper.TextileColorEntityListToDTOList;
import com.example.vigwamgomel.service.MessageService;
import com.example.vigwamgomel.service.OrderService;
import com.example.vigwamgomel.service.TextileColorService;
import com.example.vigwamgomel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    TextileColorService colorService;
    @Autowired
    OrderService orderService;
    @Autowired
    MessageService messageService;

    @Autowired
    UserService userService;

    @GetMapping("/create")
    public String createOrder(Model model) {
        model.addAttribute("newOrder", new OrderDTO());

        Size[] sizes = Size.values();
        model.addAttribute("sizes", sizes);

        List<TextileColor> showColorDTOS = colorService.findAll();
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
    public String createOrder(@ModelAttribute("newOrder") @Valid OrderDTO orderDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            Size[] sizes = Size.values();
            model.addAttribute("sizes", sizes);

            List<TextileColor> showColorDTOS = colorService.findAll();
            model.addAttribute("colors", showColorDTOS);

            WindowsCount[] windows = WindowsCount.values();
            model.addAttribute("windows", windows);

            WigwamBottomType[] bottoms = WigwamBottomType.values();
            model.addAttribute("bottoms", bottoms);

            PillowType[] pillows = PillowType.values();
            model.addAttribute("pillows", pillows);
            return "create_order";
        } else {
            Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
            User details = (User) loggedInUser.getPrincipal();
            long userId = details.getId();

            orderService.save(orderDTO);
            messageService.sendDefaultMessage(userId);
            return "redirect:/";
        }
    }

    @GetMapping("/orders")
    public String orders() {
        return "orders";
    }

    @GetMapping("/findAllOrders")
    public String findAll(Model model) {
        List<Order> orders = orderService.findAll();
        if (!orders.isEmpty()) {
            model.addAttribute("orders", orders);
            return "all_orders";
        } else {
            model.addAttribute("orders", "В базе данных нет заказов");
        }
        return "all_orders";
    }

    @GetMapping("/orders/edit/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Optional<Order> order = orderService.findById(id);
        if (order.isPresent()) {
            Order orderById = order.get();
            model.addAttribute("orderById", orderById);

            String orderIdStringValue = String.valueOf(orderById.getId());
            model.addAttribute("orderIdStringValue", orderIdStringValue);

            String userIdStringValue = String.valueOf(orderById.getUserId());
            model.addAttribute("userIdStringValue", userIdStringValue);

            OrderStatusDTO statusDTO = new OrderStatusDTO();
            model.addAttribute("statusDTO", statusDTO);

            OrderStatus[] status = OrderStatus.values();
            model.addAttribute("status", status);
        } else {
            model.addAttribute("orderById", "Заказ не найден");
        }
        return "orderId";
    }

    @PostMapping("/orders/edit")
    public String editOrder(@ModelAttribute("statusDTO")
    OrderStatusDTO orderStatusDTO,@ModelAttribute ("orderById") Order orderById, BindingResult bindingResult, Model model) {

        orderService.updateOrder(orderStatusDTO);

        switch (orderStatusDTO.getStatus()) {
            case "Отменен" -> messageService.sendOrderCanceledMessage(orderById.getUserId());
            case "Изготавливается" -> messageService.sendOrderInProgressMessage(orderById.getUserId());
            case "Готов к выдаче" -> messageService.sendOrderCompleteMessage(orderById.getUserId());
        }

        OrderStatus[] status = OrderStatus.values();
        model.addAttribute("status", status);

        List<Order> orders = orderService.findAll();
        if (!orders.isEmpty()) {
            model.addAttribute("orders", orders);
            return "all_orders";
        } else {
            model.addAttribute("orders", "В базе данных нет заказов");
        }



        return "all_orders";
    }

}
