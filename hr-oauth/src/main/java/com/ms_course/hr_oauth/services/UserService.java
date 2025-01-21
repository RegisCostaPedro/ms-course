package com.ms_course.hr_oauth.services;

import com.ms_course.hr_oauth.FeignClients.UserFeignClient;
import com.ms_course.hr_oauth.entities.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

 private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserFeignClient userFeignClient;

    // Método de teste
    public UserEntity findByEmail(String email) {
        UserEntity user = userFeignClient.findByEmail(email).getBody();

        if (user == null){
            logger.error("Email not found: "+email);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: "+email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userFeignClient.findByEmail(username).getBody();

        if (user == null){
            logger.error("Email not found: "+username);
            throw new IllegalArgumentException("Email not found");
        }
        logger.info("Email found: "+username);
        return user;
    }
}
