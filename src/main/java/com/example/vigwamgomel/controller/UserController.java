package com.example.vigwamgomel.controller;

import com.example.vigwamgomel.DTO.LoginUserDTO;
import com.example.vigwamgomel.DTO.UserDTO;
import com.example.vigwamgomel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String userPage(){
        return "user";
    }

    @GetMapping("/reg")
    public String registration(Model model) {
        model.addAttribute("newUser", new UserDTO());
            return "registration";

    }

    @PostMapping("/reg")
    public String registration(@ModelAttribute("newUser") @Valid UserDTO userDTO, BindingResult bindingUserResult) {
        if (bindingUserResult.hasErrors()) {
            System.out.println("Error!");
            return "registration";
        } else {
            userService.save(userDTO);
            return "login";
        }
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginUser", new LoginUserDTO());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginUser") @Valid LoginUserDTO loginUserDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("/change_info")
    public String changeUserInfo(Model model){
        model.addAttribute("changeUser", new UserDTO());
        return "change_info";
    }

    @PostMapping("/change_info")
    public String changeUserInfo(@ModelAttribute("changeUser") @Valid UserDTO userDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "change_info";
        } else {
            userService.updateUser(userDTO);
            return "redirect:/";
        }
    }
}
