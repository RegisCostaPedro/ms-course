package com.ms_course.hr_oauth.services;

import com.ms_course.hr_oauth.FeignClients.UserFeignClient;
import com.ms_course.hr_oauth.entities.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

 private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserFeignClient userFeignClient;

    public UserEntity findByEmail(String email) {
        UserEntity user = userFeignClient.findByEmail(email).getBody();

        if (user == null){
            logger.error("Email not found: "+email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: "+email);
        return user;
    }
}
