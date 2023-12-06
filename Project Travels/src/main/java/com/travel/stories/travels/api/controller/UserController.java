package com.travel.stories.travels.api.controller;

import com.travel.stories.travels.internal.entity.User;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
@CrossOrigin(maxAge = 3600)
public interface UserController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<User> getAllUsers();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    User getUserById(@PathVariable Long id);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    User createUser(@Valid @RequestBody User user);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUserById(@PathVariable Long id);
}
