package com.travel.stories.travels.api.controller;

import com.travel.stories.travels.internal.records.CommentBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public interface CommentController {

    @PostMapping("/create")
    ResponseEntity<CommentBody> createComment(@RequestBody CommentBody comment);

    @GetMapping("/all")
    ResponseEntity<List<CommentBody>> retrieveAllComment();

    @GetMapping("/all-by-story/{id}")
    ResponseEntity<List<CommentBody>> retrieveAllByStory(@PathVariable Long id);
}
