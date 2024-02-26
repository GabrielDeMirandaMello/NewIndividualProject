package com.travel.stories.travels.internal.controller;

import com.travel.stories.travels.api.controller.UserController;
import com.travel.stories.travels.api.usecase.*;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.execption.UserAlreadyExistsExeption;
import com.travel.stories.travels.internal.records.AuthenticationLogin;
import com.travel.stories.travels.internal.records.LoginResponse;
import com.travel.stories.travels.internal.records.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@ConditionalOnSingleCandidate(UserController.class)
public class DefaultUserController implements UserController {

    private CreateUser createUser;
    private DeleteUserById deleteUserById;
    private GetUsers getUsers;
    private GetUserById getUserById;
    private AuthLogin authLogin;
    private UpdateUser updateUser;

    @Override
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return this.getUsers.execute();
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(Long id) {
        return this.getUserById.execute(id);
    }

    @Override
    public ResponseEntity<UserResponse> createUser(User user) {
        return this.createUser.execute(user);
    }

    @Override
    public LoginResponse login(AuthenticationLogin login) {
        return this.authLogin.execute(login);
    }

    @Override
    public void deleteUserById(Long id) {
        this.deleteUserById.execute(id);
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(UserResponse userResponse, Long id) {
        return this.updateUser.execute(userResponse, id);
    }
}
