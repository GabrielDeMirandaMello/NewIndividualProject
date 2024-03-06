package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.entity.Likeded;
import com.travel.stories.travels.internal.records.LikededBody;
import org.springframework.http.ResponseEntity;

public interface CreateLikeded {
    ResponseEntity<Void> execute(LikededBody likededBody);
}
