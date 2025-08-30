package com.calizoneantony.backend.controller;

import com.calizoneantony.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/verify/{subId}")
    public ResponseEntity<Boolean> userExists(@PathVariable String subId) {
        Boolean userExists = this.userService.userExists(subId);
        return new ResponseEntity<>(userExists, HttpStatus.OK);
    }

}
