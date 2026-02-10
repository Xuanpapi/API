package com.example.demo.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.demo.repository.UserRepository;
import com.example.demo.Exception.BadRequestException;
import com.example.demo.Exception.ConflictException;
import com.example.demo.Exception.NotFoundException;
import com.example.demo.entity.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // lấy toàn bộ danh sách
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // lấy theo id
    public UserRespone getbyID(Integer id) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Khong tim thay ID"));
        UserRespone user_res = new UserRespone(u.getId(), u.getUsername(), u.getEmail());
        return user_res;
    }

    // Them user
    public void createUser(UserRequest u) {

        if (userRepository.existsByUsername(u.getUsername())) {
            throw new ConflictException("Username da ton tai !");
        }
        User user = new User(u.getUsername(), u.getEmail(), u.getPassword());
        userRepository.save(user);
    }

    // Sửa thông tin user (Username)
    public void UpdateUser(Integer id, UpdateUsername req) {
        User u = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Khong tim thay ID"));
        if (userRepository.existsByUsername(req.getNewUsername())) {
            throw new ConflictException("Username da ton tai !");
        }
        u.setUsername(req.getNewUsername());
        userRepository.save(u);

    }

}
