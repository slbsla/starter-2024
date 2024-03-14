
package com.example.demo.service;

import com.example.demo.domain.SUser;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service
public class UserServiceImpl implements  UserService {

    @Autowired
    UserRepository userRepository ;

    @Override
    public List<SUser> findAll() {
        return userRepository.findAll();
    }
}
