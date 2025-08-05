package org.example.demoauth.service;

import org.example.demoauth.dto.UserDTO;
import org.example.demoauth.entity.User;
import org.example.demoauth.repository.UserRepository;
import org.example.demoauth.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;

    public User register(UserDTO userDTO) {

        try{
            User user = new User(userDTO.getEmail(),userDTO.getUsername(),userDTO.getPassword());
            return userRepository.save(user);

        } catch (RuntimeException e) {
            throw new RuntimeException("Unable To Register, Server Error, Try Again Later!");
        }
    }

    public String login(UserDTO userDTO) {

        User user = userRepository.findByUsername(userDTO.getUsername());
        if(user==null){
            throw new RuntimeException("User not found please sign up first!");
        }
        if(!user.getPassword().equals(userDTO.getPassword())){
            throw new RuntimeException("Password is incorrect!");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}
