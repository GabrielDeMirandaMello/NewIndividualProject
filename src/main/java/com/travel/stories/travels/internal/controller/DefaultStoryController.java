package com.travel.stories.travels.internal.controller;

import com.travel.stories.travels.api.controller.StoryController;
import com.travel.stories.travels.api.usecase.*;
import com.travel.stories.travels.internal.entity.Story;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@ConditionalOnSingleCandidate(StoryController.class)
public class DefaultStoryController implements StoryController {

    private CreateStory createStory;
    private GetStoryById getStoryById;
    private GetStorys getStorys;
    private DeleteStoryById deleteStoryById;
    private RetrieveStorys retrieveStorys;

    @Override
    public ResponseEntity<Story> getStory(Long id) {
        return this.getStoryById.execute(id);
    }

    @Override
    public List<Story> getAllStory() {
        return this.getStorys.execute();
    }

    @Override
    public ResponseEntity<Story> createStory(Long id, Story story) {
        return this.createStory.execute(id, story);
    }

    @Override
    public void deleteStory(Long id) {
        this.deleteStoryById.execute(id);
    }

    @Override
    public ResponseEntity<List<Story>> retrieveStorys(String type, String filtrate, String buscar) {
        return this.retrieveStorys.execute(type, filtrate, buscar);
    }
}
