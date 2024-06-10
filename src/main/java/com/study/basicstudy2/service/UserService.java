package com.study.basicstudy2.service;

import com.study.basicstudy2.controller.UserController;
import com.study.basicstudy2.dto.UserCreateDTO;
import com.study.basicstudy2.dto.UserPutDTO;
import com.study.basicstudy2.entity.User;
import com.study.basicstudy2.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User testMethod(){
        return userRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public User createUser(UserCreateDTO userCreateDTO){
        // 1. User 인스턴스 생성
        // 2. userRepository.save({생성된 인스턴스 변수})

        User user = new User(userCreateDTO);
        return userRepository.save(user);
    }

    public void deleteById(Long userId) throws EntityNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);

        userRepository.delete(user);
    }

    @Transactional
    public User changeUserIdFromDTO(Long userId, UserPutDTO userPutDTO){
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);

        user.updateByPutDTO(userPutDTO);

        return user;
    }
}
