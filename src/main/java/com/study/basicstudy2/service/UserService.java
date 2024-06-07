package com.study.basicstudy2.service;

import com.study.basicstudy2.controller.UserController;
import com.study.basicstudy2.entity.User;
import com.study.basicstudy2.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User testMethod(){
        return userRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
    }
}
