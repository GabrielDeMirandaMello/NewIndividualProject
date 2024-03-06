package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.records.CommentBody;
import org.springframework.http.ResponseEntity;

public interface CreateComment {

    ResponseEntity<CommentBody> execute(CommentBody comment);
}
