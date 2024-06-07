package com.study.basicstudy2.controller;

import com.study.basicstudy2.entity.User;
import com.study.basicstudy2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/api/test")
    public ResponseEntity<User> testController(){
        User user = userService.testMethod();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
