package com.example.vigwamgomel.mapper;

import com.example.vigwamgomel.DTO.ShowColorDTO;
import com.example.vigwamgomel.DTO.TextileColorDTO;
import com.example.vigwamgomel.entity.TextileColor;

import java.util.Base64;

public class TextileColorEntityToDTO {
    public static ShowColorDTO entityToDTO(TextileColor color){
        ShowColorDTO colorDTO = new ShowColorDTO();
        colorDTO.setName(color.getName());
        colorDTO.setSample(Base64.getEncoder().encodeToString(color.getSample()));
        colorDTO.setPath(colorDTO.getPath());
        return colorDTO;
    }
}
