package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.entity.User;

public interface GetUserById {

    User execute(Long id);
}
