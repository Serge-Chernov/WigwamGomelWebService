package com.example.vigwamgomel.service;

import com.example.vigwamgomel.DTO.UserDTO;
import com.example.vigwamgomel.entity.User;
import com.example.vigwamgomel.enums.PillowType;
import com.example.vigwamgomel.mapper.UserMapper;
import com.example.vigwamgomel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(UserDTO userDTO) {
        User user = UserMapper.dtoToUser(userDTO);
        userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
