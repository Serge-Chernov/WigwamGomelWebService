package com.example.vigwamgomel.mapper;

import com.example.vigwamgomel.DTO.TextileColorDTO;
import com.example.vigwamgomel.entity.TextileColor;

import java.io.IOException;

public class TextileColorMapper {
    public static TextileColor DTOtoEntity(TextileColorDTO dto) throws IOException {
        TextileColor entity = new TextileColor();
        entity.setName(dto.getName());
        entity.setSample(dto.getSample().getBytes());
        entity.setPath(dto.getPath());
        return entity;
    }
}
