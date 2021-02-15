package com.example.examapp.demo.controller;

import com.example.examapp.demo.dto.RegistrationRequest;
import com.example.examapp.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Registration;

@RestController
@RequestMapping(path = "/api/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public void registerUser(@RequestBody RegistrationRequest request) {
        registrationService.register(request);
    }

    // TODO: Confirm registration

}
