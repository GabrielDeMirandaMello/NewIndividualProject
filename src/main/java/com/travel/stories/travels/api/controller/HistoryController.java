package com.travel.stories.travels.api.controller;

import com.travel.stories.travels.internal.entity.History;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@CrossOrigin()
public interface HistoryController {

    @GetMapping("/{id}")
    ResponseEntity<History> getHistory(@PathVariable Long id);

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    List<History> getAllHistory();

    @PostMapping("/create/{id}")
    ResponseEntity<History> createHistory(@PathVariable Long id, @RequestBody History history);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteHistory(@PathVariable Long id);

    @PutMapping("/like/{id}")
    void updateLike(@PathVariable Long id);
}
