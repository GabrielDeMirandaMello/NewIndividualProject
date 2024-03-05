package com.travel.stories.travels.api.controller;

import com.travel.stories.travels.internal.entity.Likeded;
import com.travel.stories.travels.internal.records.LikededBody;
import com.travel.stories.travels.internal.records.LikededResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likeded")
public interface LikededController {

    @PostMapping
    ResponseEntity<Void> createLikeded(@RequestBody LikededBody likededBody);

    @GetMapping("/all")
    ResponseEntity<List<LikededResponse>> getAllLikeded();

    @GetMapping("/all-by-story/{id}")
    ResponseEntity<List<LikededResponse>> getAllByStory(@PathVariable Long id);
}
