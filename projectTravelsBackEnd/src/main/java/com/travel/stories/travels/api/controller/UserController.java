package com.travel.stories.travels.api.controller;

import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.records.AuthenticationLogin;
import com.travel.stories.travels.internal.records.LoginResponse;
import com.travel.stories.travels.internal.records.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public interface UserController {

    @GetMapping
    ResponseEntity<List<UserResponse>>  getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<UserResponse> getUserById(@PathVariable Long id);

    @PostMapping("/register")
    ResponseEntity<UserResponse> createUser(@Valid @RequestBody User user);

    @PostMapping("/login")
    LoginResponse login(@Valid @RequestBody AuthenticationLogin login);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteUserById(@PathVariable Long id);
}
