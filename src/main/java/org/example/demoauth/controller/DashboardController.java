package org.example.demoauth.controller;

import org.example.demoauth.dto.APIResponse;
import org.example.demoauth.dto.UserDTO;
import org.example.demoauth.service.AuthService;
import org.example.demoauth.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@CrossOrigin
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping()
    public APIResponse getDashboardTitle(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDTO userDTO = dashboardService.getUserByUsername(auth.getName());
        if(userDTO!=null){
            return new APIResponse(202,"Role", userDTO.getRole());
        }
        return new APIResponse(202,"Role", null);
    }

    @GetMapping("/hello1")
    public APIResponse helloDashboard1(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("--------------------"+auth.getName());
        return new APIResponse(202,"hello dashboard 1", null);
    }

    @GetMapping("/hello2")
    @PreAuthorize("hasAuthority('ADMIN')")
    public APIResponse helloDashboard2(){
        return new APIResponse(202,"hello dashboard 2", null);
    }
}
