package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.records.CommentBody;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetrieveAllComment {
    ResponseEntity<List<CommentBody>> execute();
}
