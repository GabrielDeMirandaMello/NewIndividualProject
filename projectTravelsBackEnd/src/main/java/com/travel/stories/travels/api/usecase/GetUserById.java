package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.records.UserResponse;
import org.springframework.http.ResponseEntity;

public interface GetUserById {

    ResponseEntity<UserResponse> execute(Long id);
}
