package com.travel.stories.travels.internal.controller;

import com.travel.stories.travels.api.controller.CommentController;
import com.travel.stories.travels.api.usecase.CreateComment;
import com.travel.stories.travels.api.usecase.RetrieveAllByStory;
import com.travel.stories.travels.api.usecase.RetrieveAllComment;
import com.travel.stories.travels.internal.records.CommentBody;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@ConditionalOnSingleCandidate(CommentController.class)
public class DefaultCommentController implements CommentController {

    private CreateComment createComment;
    private RetrieveAllComment retrieveAllComment;
    private RetrieveAllByStory retrieveAllByStory;

    @Override
    public ResponseEntity<CommentBody> createComment(CommentBody comment) {
        return this.createComment.execute(comment);
    }

    @Override
    public ResponseEntity<List<CommentBody>> retrieveAllComment() {
        return this.retrieveAllComment.execute();
    }

    @Override
    public ResponseEntity<List<CommentBody>> retrieveAllByStory(Long id) {
        return this.retrieveAllByStory.execute(id);
    }
}
