package com.example.vigwamgomel.mapper;

import com.example.vigwamgomel.DTO.ShowColorDTO;
import com.example.vigwamgomel.entity.TextileColor;

import java.util.ArrayList;
import java.util.List;

public class TextileColorEntityListToDTOList {
    public static List<ShowColorDTO> entityToDTO(List<TextileColor> colors){
        List<ShowColorDTO> showColors = new ArrayList<>();
        for (TextileColor color: colors) {
            ShowColorDTO showColorDTO = TextileColorEntityToDTO.entityToDTO(color);
            showColors.add(showColorDTO);
        }
        return showColors;
    }
}
