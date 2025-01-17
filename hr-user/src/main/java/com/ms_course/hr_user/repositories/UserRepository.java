package com.ms_course.hr_user.repositories;

import com.ms_course.hr_user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity,Long>{


        UserEntity findByEmail(String email);
}
