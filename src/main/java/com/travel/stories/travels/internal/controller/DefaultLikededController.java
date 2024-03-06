package com.travel.stories.travels.internal.controller;

import com.travel.stories.travels.api.controller.LikededController;
import com.travel.stories.travels.api.usecase.CreateLikeded;
import com.travel.stories.travels.api.usecase.GetAllByStory;
import com.travel.stories.travels.api.usecase.GetAllLikeded;
import com.travel.stories.travels.internal.entity.Likeded;
import com.travel.stories.travels.internal.records.LikededBody;
import com.travel.stories.travels.internal.records.LikededResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@ConditionalOnSingleCandidate(LikededController.class)
public class DefaultLikededController implements LikededController {

    private CreateLikeded createLikeded;
    private GetAllLikeded getAllLikeded;
    private GetAllByStory getAllByStory;

    @Override
    public ResponseEntity<Void> createLikeded(LikededBody likededBody) {
       return this.createLikeded.execute(likededBody);
    }

    @Override
    public ResponseEntity<List<LikededResponse>> getAllLikeded() {
        return this.getAllLikeded.execute();
    }

    @Override
    public ResponseEntity<List<LikededResponse>> getAllByStory(Long id) {
        return this.getAllByStory.execute(id);
    }
}
