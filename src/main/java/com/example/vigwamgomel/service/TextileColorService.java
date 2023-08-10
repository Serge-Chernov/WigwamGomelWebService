package com.example.vigwamgomel.service;

import com.example.vigwamgomel.entity.TextileColor;
import com.example.vigwamgomel.repository.TextileColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TextileColorService {
    @Autowired
    TextileColorRepository repository;

    public void save(TextileColor textileColor) {
        repository.save(textileColor);
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
