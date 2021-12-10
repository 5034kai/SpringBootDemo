package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    //一覧
    public List<User> findAll() {
        return userRepository.findAllOrderById();
    }

    //追加
    public void insert(User user) {
        userRepository.save(user);
    }

    //更新
    public void update(User user) {
        userRepository.save(user);
    }

    //削除
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    //1件選択
    public Optional<User> selectById(Integer id) {
        return userRepository.findById(id);
    }
}