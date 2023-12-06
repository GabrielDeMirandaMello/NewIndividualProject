package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.GetUserById;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.repository.UserRepository;

public class DefaultGetUserById implements GetUserById {

    private UserRepository userRepository;

    @Override
    public User execute(Long id) {
        return this.userRepository.findById(id).orElseThrow();
    }
}
