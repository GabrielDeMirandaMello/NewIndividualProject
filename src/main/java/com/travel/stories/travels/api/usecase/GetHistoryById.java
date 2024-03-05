package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.entity.Story;
import org.springframework.http.ResponseEntity;

public interface GetHistoryById {

    ResponseEntity<Story> execute(Long id);
}
