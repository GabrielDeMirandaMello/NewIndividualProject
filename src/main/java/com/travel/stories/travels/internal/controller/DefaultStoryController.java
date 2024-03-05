package com.travel.stories.travels.internal.controller;

import com.travel.stories.travels.api.controller.StoryController;
import com.travel.stories.travels.api.usecase.*;
import com.travel.stories.travels.internal.entity.Story;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@ConditionalOnSingleCandidate(StoryController.class)
public class DefaultStoryController implements StoryController {

    private CreateStory createHistory;
    private GetStoryById getStoryById;
    private GetStorys getHistorys;
    private DeleteStoryById deleteStoryById;
    private UpdateLike updateLike;
    private RetrieveStorys retrieveStorys;
    private UpdateDisliked updateDisliked;

    @Override
    public ResponseEntity<Story> getHistory(Long id) {
        return this.getStoryById.execute(id);
    }

    @Override
    public List<Story> getAllHistory() {
        return this.getHistorys.execute();
    }

    @Override
    public ResponseEntity<Story> createHistory(Long id, Story story) {
        return this.createHistory.execute(id, story);
    }

    @Override
    public void deleteHistory(Long id) {
        this.deleteStoryById.execute(id);
    }

    @Override
    public void updateLike(String id) {
        this.updateLike.execute(id);
    }

    @Override
    public void updateDisliked(String id) {
        this.updateDisliked.execute(id);
    }

    @Override
    public ResponseEntity<List<Story>> retrieveStorys(String type, String filtrate, String buscar) {
        return this.retrieveStorys.execute(type, filtrate, buscar);
    }
}
