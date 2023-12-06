package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.DeleteUserById;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.repository.UserRepository;

public class DefaultDeleteUserById implements DeleteUserById {

    private UserRepository userRepository;

    @Override
    public void execute(Long id) {
        this.userRepository.deleteById(id);
    }
}
