package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.records.UserResponse;
import org.springframework.http.ResponseEntity;

public interface CreateUser {

    ResponseEntity<UserResponse> execute(User user);
}
