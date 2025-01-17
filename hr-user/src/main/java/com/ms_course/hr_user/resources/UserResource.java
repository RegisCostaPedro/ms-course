package com.ms_course.hr_user.resources;


import com.ms_course.hr_user.entities.UserEntity;
import com.ms_course.hr_user.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {


    private static Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserRepository repository;

    @GetMapping()
    public ResponseEntity<List<UserEntity>> findAllUsers(){
       List<UserEntity> listUsers = repository.findAll();
        return new ResponseEntity<>(listUsers,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Long id){
        UserEntity userObj = repository.findById(id).get();

        return new ResponseEntity<>(userObj,HttpStatus.OK);
    }


    @GetMapping(value = "/search")
    public ResponseEntity<UserEntity> findById(@RequestParam String email){
        logger.info("EMAIL ANTES= " + email);

        UserEntity userObj = repository.findByEmail(email);
        logger.info("EMAIL = " + email);
        logger.info("Object = " + userObj.getId());
        return new ResponseEntity<>(userObj,HttpStatus.OK);
    }
}
