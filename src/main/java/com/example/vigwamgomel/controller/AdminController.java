package com.example.vigwamgomel.controller;

import com.example.vigwamgomel.DTO.TextileColorDTO;
import com.example.vigwamgomel.entity.Order;
import com.example.vigwamgomel.service.OrderService;
import com.example.vigwamgomel.service.TextileColorService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    TextileColorService textileColorService;

    @GetMapping("")
    public String admin() {
        return "admin";
    }

    @GetMapping("/add_color")
    public String addTextileColor(Model model) {
        model.addAttribute("color", new TextileColorDTO());
        return "add_color";
    }

    @PostMapping("/add_color")
    public String addTextileColor(@ModelAttribute("textileColor") @Valid TextileColorDTO textileColorDTO, BindingResult bindingResult, Model model, MultipartFile file) throws IOException {
        try {
            textileColorService.save(textileColorDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }

}
