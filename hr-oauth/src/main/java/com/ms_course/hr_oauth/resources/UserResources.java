package com.ms_course.hr_oauth.resources;

import com.ms_course.hr_oauth.entities.UserEntity;
import com.ms_course.hr_oauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService userService;

     @GetMapping(value = "/search")
    public ResponseEntity<UserEntity> findByEmail(@RequestParam String email){
       try {
           UserEntity user = userService.findByEmail(email);

           return ResponseEntity.ok(user);
       }catch (IllegalArgumentException error){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
     }
}
