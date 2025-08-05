package org.example.demoauth.controller;

import org.example.demoauth.dto.APIResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping
    public APIResponse sayHelloToCustomer(){
        return new APIResponse(202,"say hello","HELLO!");
    }
}
