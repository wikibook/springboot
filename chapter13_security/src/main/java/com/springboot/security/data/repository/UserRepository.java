package com.springboot.security.data.repository;

import com.springboot.security.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 예제 13.7
public interface UserRepository extends JpaRepository<User, Long> {

    User getByUid(String uid);

}