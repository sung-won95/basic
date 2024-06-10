package com.study.basicstudy2.controller;

import com.study.basicstudy2.dto.UserCreateDTO;
import com.study.basicstudy2.dto.UserPutDTO;
import com.study.basicstudy2.entity.User;
import com.study.basicstudy2.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //유저 조회
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUser(){
        List<User> userList = userService.findAllUser();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable(value = "userId")Long userId){
        User user = userService.findById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody UserCreateDTO userCreateDTO){

        User user =  userService.createUser(userCreateDTO);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "userId")Long userId){
        try {
            userService.deleteById(userId);
        } catch (EntityNotFoundException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> putUser(@PathVariable(value = "userId")Long userId,
                                        @RequestBody UserPutDTO userPutDTO
                                        ){
        User user = userService.changeUserIdFromDTO(userId,userPutDTO);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
