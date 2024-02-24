package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.records.UserResponse;
import org.springframework.http.ResponseEntity;

public interface UpdateUser {
    ResponseEntity<UserResponse> execute(UserResponse userResponse, Long id);
}
