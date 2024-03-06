package com.travel.stories.travels.internal.repository;

import com.travel.stories.travels.internal.entity.Comment;
import com.travel.stories.travels.internal.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByStoryId(Story story);
}
