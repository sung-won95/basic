package com.study.basicstudy2.entity;

import com.study.basicstudy2.dto.UserCreateDTO;
import com.study.basicstudy2.dto.UserPutDTO;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String userName;

    @Column
    String password;

    public User(UserCreateDTO userCreateDTO){
        this.userName = userCreateDTO.getUserName();
        this.password = userCreateDTO.getPassword();
    }

    public User(){

    }
    public void updateByPutDTO(UserPutDTO userPutDTO){
        this.userName = userPutDTO.getUserName();
        this.password = userPutDTO.getPassword();
    }
}
