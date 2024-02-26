package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.entity.History;
import org.springframework.http.ResponseEntity;

public interface CreateHistory {

    ResponseEntity<History> execute(Long id, History history);
}
