package com.example.demo.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;
    @Autowired
    private UserService userService;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/db")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }

    @GetMapping("/findid/{id}")
    public ResponseEntity<UserRespone> getUserByID(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getbyID(id));
    }

    @PostMapping("/post/db")
    public ResponseEntity<?> postMethodName(@Valid @RequestBody UserRequest u) {
        userService.createUser(u);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ThongBao("Them user thanh cong"));
    }

    @PutMapping("path/{id}")
    public ResponseEntity<?> putMethodName(@PathVariable Integer id, @Valid @RequestBody UpdateUsername req) {
        userService.UpdateUser(id, req);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ThongBao("Doi username thanh cong"));
    }
}
