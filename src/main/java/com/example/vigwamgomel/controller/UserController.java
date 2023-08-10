package com.example.vigwamgomel.controller;

import com.example.vigwamgomel.DTO.UserDTO;
import com.example.vigwamgomel.entity.Pillow;
import com.example.vigwamgomel.entity.User;
import com.example.vigwamgomel.enums.PillowType;
import com.example.vigwamgomel.mapper.UserMapper;
import com.example.vigwamgomel.service.UserService;
import com.sun.jdi.IntegerValue;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/reg")
    public String registration(Model model) {
        model.addAttribute("newUser", new UserDTO());

        PillowType[] pillows = PillowType.values();

        model.addAttribute("pillows", pillows);

        return "registration";
    }

    @PostMapping("/reg")
    public String registration(@ModelAttribute("newUser") @Valid UserDTO userDTO, BindingResult bindingUserResult, @ModelAttribute("pillows")  PillowType[] pillows, BindingResult bindingPillowResult) {
        if (bindingUserResult.hasErrors()) {
            System.out.println("Error!");
            return "registration";
        } else {
            userService.save(userDTO);
        return "redirect:/";
    }
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login() {
        return "login";
    }
}
