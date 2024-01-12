package com.travel.stories.travels.api.controller;

import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.records.AuthenticationLogin;
import com.travel.stories.travels.internal.records.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public interface UserController {

    @GetMapping
    List<User> getAllUsers();

    @GetMapping("/{id}")
    User getUserById(@PathVariable Long id);

    @PostMapping("/register")
    User createUser(@Valid @RequestBody User user);

    @PostMapping("/login")
    LoginResponse login(@Valid @RequestBody AuthenticationLogin login);

    @DeleteMapping("/{id}")
    void deleteUserById(@PathVariable Long id);
}
