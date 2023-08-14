package com.example.vigwamgomel.service;

import com.example.vigwamgomel.DTO.UserDTO;
import com.example.vigwamgomel.entity.User;
import com.example.vigwamgomel.enums.Roles;
import com.example.vigwamgomel.mapper.UserMapper;
import com.example.vigwamgomel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void save(UserDTO userDTO) {
        User user = UserMapper.dtoToUser(userDTO);
        user.setPassword(passwordEncoder().encode(userDTO.getPassword()));
        user.setRoles(Set.of(Roles.USER));
        userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            return byUsername.get();
        }
        throw new UsernameNotFoundException("");
    }

    public void updateUser(UserDTO userDTO){
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        User details =(User) loggedInUser.getPrincipal();

        long id = details.getId();
        User userToUpdate = userRepository.getReferenceById(id);
        userToUpdate.setName(userDTO.getName());
        userRepository.save(userToUpdate);
    }

}
