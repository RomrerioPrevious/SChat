package com.app.controllers;

import com.app.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {
    @GetMapping("/login")
    public ResponseEntity<User> login() {
        return null;
    }

    @GetMapping("/registration")
    public String registration() {
        return "";
    }

    @GetMapping("/user/{id:long}")
    public String getProfile(long id) {
        return "";
    }

    @PatchMapping("/user/{id:int}")
    public boolean updateProfile(long id) {
        return false;
    }
}
