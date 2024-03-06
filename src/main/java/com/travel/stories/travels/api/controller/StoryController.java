package com.travel.stories.travels.api.controller;

import com.travel.stories.travels.internal.entity.Story;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/story")
@CrossOrigin
public interface StoryController {

    @GetMapping("/{id}")
    ResponseEntity<Story> getStory(@PathVariable Long id);

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<Story> getAllStory();

    @PostMapping("/create/{id}")
    ResponseEntity<Story> createStory(@PathVariable Long id, @RequestBody Story story);

    @DeleteMapping("/{id}")
    void deleteStory(@PathVariable Long id);

    @GetMapping("/{type}/{filtrate}/{buscar}")
    ResponseEntity<List<Story>> retrieveStorys(@PathVariable String type, @PathVariable String filtrate, @PathVariable String buscar );
}
