package com.example.vigwamgomel.service;

import com.example.vigwamgomel.DTO.TextileColorDTO;
import com.example.vigwamgomel.entity.TextileColor;
import com.example.vigwamgomel.mapper.TextileColorMapper;
import com.example.vigwamgomel.repository.TextileColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class TextileColorService {
    @Autowired
    TextileColorRepository repository;

    public void save(TextileColorDTO textileColorDTO) throws IOException {
        TextileColor color = TextileColorMapper.DTOtoEntity(textileColorDTO);

//        String base64 = Base64.getEncoder().encodeToString(color.getSample());
//        byte[] data = DatatypeConverter.parseBase64Binary(base64);
//        String fileName = color.getName();
//        String path = "src/main/resources/static/images/" + fileName + ".png";
//        File file = new File(path);
//
//        color.setPath("/" + path);
//
//       try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))){
//           outputStream.write(data);
//       } catch (Exception e){
//           e.printStackTrace();
//       }
//        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
//        outputStream.write(data);
        repository.save(color);
        System.out.println(color.getPath());
    }

    public Optional <TextileColor> findById(long id) {
       Optional<TextileColor> byId = repository.findById(id);
       if (byId.isPresent()){
           TextileColor color = byId.get();
           return Optional.of(color);
       }
       return Optional.empty();
    }

    public Optional <TextileColor> findByName(String name) {
        Optional<TextileColor> byName = repository.findByName(name);
        if (byName.isPresent()){
            TextileColor color = byName.get();
            return Optional.of(color);
        }
        return Optional.empty();
    }

    public List<TextileColor> findAll() {
        return repository.findAll();
    }

    public void delete(TextileColor color){
        repository.delete(color);
    }
}
