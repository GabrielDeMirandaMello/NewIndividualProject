package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.CreateComment;
import com.travel.stories.travels.internal.entity.Comment;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.records.CommentBody;
import com.travel.stories.travels.internal.repository.CommentRepository;
import com.travel.stories.travels.internal.repository.StoryRepository;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class DefaultCreateComment implements CreateComment {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private StoryRepository storyRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<CommentBody> execute(CommentBody commentBody) {
        Comment comment = new Comment();
        Optional<User> user = this.userRepository.findByName(commentBody.name());
        if (user.isPresent()) {
            comment.setUserId(user.orElseThrow());
            comment.setStoryId(this.storyRepository.findById(commentBody.idStory()).orElseThrow());
            comment.setDescription(commentBody.description());
            comment.setDateTime(LocalDateTime.now());
            this.commentRepository.save(comment);
            return ResponseEntity.status(HttpStatus.CREATED).body(commentBody);
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
}
