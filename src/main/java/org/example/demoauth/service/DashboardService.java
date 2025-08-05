package org.example.demoauth.service;

import org.example.demoauth.dto.UserDTO;
import org.example.demoauth.entity.User;
import org.example.demoauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserByUsername(String username) {

        User user = userRepository.findByUsername(username);
        if(user!=null) {
            return new UserDTO(user.getId(),user.getEmail(),user.getUsername(),user.getPassword(),user.getRole());
        }
        return null;
    }
}


































