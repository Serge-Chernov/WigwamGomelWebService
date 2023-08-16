package com.example.vigwamgomel.mapper;

import com.example.vigwamgomel.DTO.UpdateUserDTO;
import com.example.vigwamgomel.DTO.UserDTO;
import com.example.vigwamgomel.entity.User;
import com.example.vigwamgomel.entity.UserAddress;
import com.example.vigwamgomel.entity.UserPhone;
import com.example.vigwamgomel.enums.PillowType;
import org.springframework.stereotype.Component;
import org.springframework.ws.soap.addressing.server.annotation.Address;

public class UserMapper {
    public static User DTOToUser(UserDTO userDTO) {
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
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }
    public static UpdateUserDTO UserToUpdateUserDTO(User user){
        UpdateUserDTO updateUserDTO = new UpdateUserDTO();
        updateUserDTO.setName(user.getName());
        updateUserDTO.setUsername(user.getUsername());
        updateUserDTO.setEmail(user.getEmail());

        UserAddress userAddress = user.getAddress();
        updateUserDTO.setPostCode(userAddress.getPostCode());
        updateUserDTO.setCity(userAddress.getCity());
        updateUserDTO.setAddress(userAddress.getAddress());

        UserPhone userPhone = user.getPhone();
        updateUserDTO.setPhoneNumber(userPhone.getPhoneNumber());

        return updateUserDTO;
    }

    public static User updateUserDTOtoUser(UpdateUserDTO updateUserDTO, User userToUpdate){
        userToUpdate.setName(updateUserDTO.getName());
        userToUpdate.setUsername(updateUserDTO.getUsername());
        userToUpdate.setEmail(updateUserDTO.getEmail());

        UserAddress address = new UserAddress();
        address.setPostCode(updateUserDTO.getPostCode());
        address.setCity(updateUserDTO.getCity());
        address.setAddress(updateUserDTO.getAddress());
        userToUpdate.setAddress(address);

        UserPhone phone = new UserPhone();
        phone.setPhoneNumber(updateUserDTO.getPhoneNumber());
        userToUpdate.setPhone(phone);

        return userToUpdate;
    }
}
