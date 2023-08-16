package com.example.vigwamgomel.controller;

import com.example.vigwamgomel.entity.Message;
import com.example.vigwamgomel.entity.User;
import com.example.vigwamgomel.enums.OrderStatus;
import com.example.vigwamgomel.repository.MessageRepository;
import com.example.vigwamgomel.service.MessageService;
import com.example.vigwamgomel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;
    @Autowired
    UserService userService;

    @GetMapping("/messages")
    public String findUserMessages(Model model) {
        User user = userService.getLoggedInUser();
        List<Message> findAll = messageService.findByRecipientId(user.getId());
        if (findAll.isEmpty()) {
            model.addAttribute("messages", "Сообщения не найдены");
        } else {
            model.addAttribute("messages", findAll);
        }
        return "messages";
    }
}
