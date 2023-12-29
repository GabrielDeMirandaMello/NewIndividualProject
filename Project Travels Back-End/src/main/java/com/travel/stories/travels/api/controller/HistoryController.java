package com.travel.stories.travels.api.controller;

import com.travel.stories.travels.internal.entity.History;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public interface HistoryController {

    @GetMapping("/{id}")
    History getHistory(@PathVariable Long id);

    @GetMapping("/all")
    List<History> getAllHistory();

    @PostMapping
    History createHistory(@RequestBody History history);

    @DeleteMapping("/{id}")
    void deleteHistory(@PathVariable Long id);
}
