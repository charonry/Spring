package com.init.spring.beans.annotate.service;

import com.init.spring.beans.annotate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserRepository userRepository;

    @Autowired
    @Qualifier("userRepositoryImpl")
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add() {
        System.out.println("UserServcie add..");
        userRepository.save();
    }
}
