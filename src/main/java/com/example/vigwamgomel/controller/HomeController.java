package com.example.vigwamgomel.controller;

import com.example.vigwamgomel.DTO.ShowColorDTO;
import com.example.vigwamgomel.entity.TextileColor;
import com.example.vigwamgomel.mapper.TextileColorEntityListToDTOList;
import com.example.vigwamgomel.service.TextileColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    TextileColorService colorService;
    @GetMapping("/")
    public String homepage(){
        return "homepage";
    }
    @GetMapping("/colors")
    public String colorGallery(Model model){
        List<TextileColor> colors = colorService.findAll();
        List<ShowColorDTO> showColorDTOS = TextileColorEntityListToDTOList.entityToDTO(colors);
        model.addAttribute("colors", showColorDTOS);

        return "color_gallery";
    }

    @GetMapping("/gallery")
    public String photoGallery() {
        return "photo_gallery";
    }
}
