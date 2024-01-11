package com.travel.stories.travels.internal.controller;

import com.travel.stories.travels.api.controller.UserController;
import com.travel.stories.travels.api.usecase.CreateUser;
import com.travel.stories.travels.api.usecase.DeleteUserById;
import com.travel.stories.travels.api.usecase.GetUserById;
import com.travel.stories.travels.api.usecase.GetUsers;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.execption.UserAlreadyExistsExeption;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
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

    @Override
    public List<User> getAllUsers() {
        return this.getUsers.execute();
    }

    @Override
    public User getUserById(Long id) {
        return this.getUserById.execute(id);
    }

    @Override
    public User createUser(User user) {
        return this.createUser.execute(user);
    }

    @Override
    public void deleteUserById(Long id) {
        this.deleteUserById.execute(id);
    }
}
