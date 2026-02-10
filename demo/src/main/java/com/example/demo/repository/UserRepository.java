package com.example.demo.repository;

import java.util.*;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);// check username nếu đã có = true;

    Optional<User> findByUsername(String username);
}
// JpaRepository<User, Integer>
// User là :Entity
// Integer là: kiểu của khoá chính
