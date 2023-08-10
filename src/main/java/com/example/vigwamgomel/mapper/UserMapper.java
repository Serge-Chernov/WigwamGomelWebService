package com.example.vigwamgomel.mapper;

import com.example.vigwamgomel.DTO.UserDTO;
import com.example.vigwamgomel.entity.User;
import com.example.vigwamgomel.entity.UserAddress;
import com.example.vigwamgomel.entity.UserPhone;
import com.example.vigwamgomel.enums.PillowType;
import org.springframework.stereotype.Component;

public class UserMapper {
    public static User dtoToUser(UserDTO userDTO){
        User user = new User();

        UserAddress address = new UserAddress();
        address.setPostCode(userDTO.getPostCode());
        address.setCity(userDTO.getCity());
        address.setAddress(userDTO.getAddress());
        user.setAddress(address);

        UserPhone phone = new UserPhone();
        phone.setPhoneNumber(userDTO.getPhoneNumber());
        user.setPhone(phone);

        user.setName(userDTO.getName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(user.getPassword());

        return user;
    }
}
