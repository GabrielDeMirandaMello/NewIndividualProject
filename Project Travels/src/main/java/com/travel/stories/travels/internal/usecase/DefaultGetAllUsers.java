package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.GetUsers;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.repository.UserRepository;

import java.util.List;

public class DefaultGetAllUsers implements GetUsers {

    private UserRepository userRepository;

    @Override
    public List<User> execute() {
        return this.userRepository.findAll();
    }
}
