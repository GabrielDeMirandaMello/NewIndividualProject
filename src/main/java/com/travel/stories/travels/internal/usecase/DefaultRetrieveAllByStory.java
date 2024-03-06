package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.RetrieveAllByStory;
import com.travel.stories.travels.internal.entity.Comment;
import com.travel.stories.travels.internal.entity.Story;
import com.travel.stories.travels.internal.records.CommentBody;
import com.travel.stories.travels.internal.repository.CommentRepository;
import com.travel.stories.travels.internal.repository.StoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class DefaultRetrieveAllByStory implements RetrieveAllByStory {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private StoryRepository storyRepository;

    @Override
    public ResponseEntity<List<CommentBody>> execute(Long id) {
        List<CommentBody> allCommentResponse = new ArrayList<>();
        List<Comment> allComment = this.commentRepository.findAllByStoryId(
                this.storyRepository.findById(id).orElseThrow()
        );
        if (!allComment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(parseCommentToCommentBody(allComment, allCommentResponse));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    private List<CommentBody> parseCommentToCommentBody(List<Comment> allComment, List<CommentBody> allCommentResponse){
        allComment.stream().map(comment -> {
            CommentBody newComment = new CommentBody(
                    comment.getUserId().getName(),
                    comment.getStoryId().getId(),
                    comment.getDescription()
            );
            allCommentResponse.add(newComment);
            return null;
        }).collect(Collectors.toList());
        return allCommentResponse;
    }
}
