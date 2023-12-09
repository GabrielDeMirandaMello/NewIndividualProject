package com.travel.stories.travels.api.controller;

import com.travel.stories.travels.internal.entity.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public interface UserController {

    @GetMapping
    List<User> getAllUsers();

    @GetMapping("/{id}")
    User getUserById(@PathVariable Long id);

    @PostMapping
    User createUser(@Valid @RequestBody User user);

    @DeleteMapping("/{id}")
    void deleteUserById(@PathVariable Long id);
}
