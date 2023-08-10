package com.example.vigwamgomel.controller;

import com.example.vigwamgomel.DTO.OrderDTO;
import com.example.vigwamgomel.entity.Order;
import com.example.vigwamgomel.entity.TextileColor;
import com.example.vigwamgomel.enums.PillowType;
import com.example.vigwamgomel.enums.Size;
import com.example.vigwamgomel.enums.WigwamBottomType;
import com.example.vigwamgomel.enums.WindowsCount;
import com.example.vigwamgomel.service.OrderService;
import com.example.vigwamgomel.service.TextileColorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        model.addAttribute("colors", colors);

        WindowsCount[] windows = WindowsCount.values();
        model.addAttribute("windows", windows);

        WigwamBottomType[] bottoms = WigwamBottomType.values();
        model.addAttribute("bottoms", bottoms);

        PillowType[] pillows = PillowType.values();
        model.addAttribute("pillows", pillows);
        return "order";

    }

    @PostMapping("/create")
    public String registration(@ModelAttribute("createOrder") OrderDTO orderDTO) {
//        if (bindingResult.hasErrors()) {
//            System.out.println("Error!");
//            return "order";
//        } else {
        orderService.save(orderDTO);
        return "redirect:/";
//        }
    }

}
