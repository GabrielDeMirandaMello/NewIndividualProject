package com.travel.stories.travels.api.controller;

import com.travel.stories.travels.internal.entity.Story;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@CrossOrigin
public interface HistoryController {

    @GetMapping("/{id}")
    ResponseEntity<Story> getHistory(@PathVariable Long id);

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<Story> getAllHistory();

    @PostMapping("/create/{id}")
    ResponseEntity<Story> createHistory(@PathVariable Long id, @RequestBody Story history);

    @DeleteMapping("/{id}")
    void deleteHistory(@PathVariable Long id);

    @PutMapping("/like/{id}")
    void updateLike(@PathVariable String id);

    @PutMapping("/disliked/{id}")
    void updateDisliked(@PathVariable String id);

    @GetMapping("/{type}/{filtrate}/{buscar}")
    ResponseEntity<List<Story>> retrieveStorys(@PathVariable String type, @PathVariable String filtrate, @PathVariable String buscar );
}
