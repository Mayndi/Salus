package com.platform.salus.common.config;

import com.platform.salus.user.model.UserEntity;
import com.platform.salus.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Check {

    private final UserRepository userRepository;

    @Autowired
    public Check(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean healthCheck(){

        UserEntity userEntity = new UserEntity();

        userRepository.save(userEntity);

        userRepository.delete(userEntity);

        return true;
    }
}