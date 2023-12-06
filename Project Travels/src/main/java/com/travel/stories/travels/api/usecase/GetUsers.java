package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.entity.User;

import java.util.List;

public interface GetUsers {

    List<User> execute();
}
