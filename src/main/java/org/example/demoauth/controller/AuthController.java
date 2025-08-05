package org.example.demoauth.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demoauth.dto.APIResponse;
import org.example.demoauth.dto.UserDTO;
import org.example.demoauth.entity.User;
import org.example.demoauth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public APIResponse register(@RequestBody UserDTO userDTO){
        System.out.println("register");
        System.out.println(userDTO);
        User savedUser = authService.register(userDTO);
        return new APIResponse(202,"successfully register",savedUser);
    }

    @PostMapping("/login")
    public APIResponse login(@RequestBody UserDTO userDTO, HttpServletResponse response){
        System.out.println("login");
        System.out.println(userDTO);
        String jwtToken = authService.login(userDTO);

        Cookie cookie = new Cookie("jwtToken", jwtToken);
        cookie.setHttpOnly(true);   // JS cannot read it
        cookie.setSecure(false);     // only over HTTPS if this true
        cookie.setPath("/");        // accessible to all endpoints
        cookie.setMaxAge(60 * 60 * 24 * 365);  // expires in 1 year
        response.addCookie(cookie);

        return new APIResponse(202,"jwt Token",jwtToken);
    }
}



























