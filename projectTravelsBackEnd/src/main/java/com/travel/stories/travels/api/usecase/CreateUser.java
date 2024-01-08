package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.execption.UserAlreadyExistsExeption;

public interface CreateUser {

    User execute(User user);
}
