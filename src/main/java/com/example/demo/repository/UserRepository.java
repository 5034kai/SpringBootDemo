package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM user ORDER BY id DESC", nativeQuery = true)
    ArrayList<User> findAllOrderById();
}