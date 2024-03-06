package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.GetAllByStory;
import com.travel.stories.travels.internal.entity.Likeded;
import com.travel.stories.travels.internal.entity.Story;
import com.travel.stories.travels.internal.records.LikededResponse;
import com.travel.stories.travels.internal.repository.LikededRepository;
import com.travel.stories.travels.internal.repository.StoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class DefaultGetAllByStory implements GetAllByStory {

    @Autowired
    private LikededRepository likededRepository;

    @Autowired
    private StoryRepository storyRepository;

    @Override
    public ResponseEntity<List<LikededResponse>> execute(Long id) {
        List<LikededResponse> listLikededResponse = new ArrayList<>();
        Story story = retriveStory(id);
        List<Likeded> likededs = this.likededRepository.findAllByStoryId(story).orElseThrow();
        likededs.stream().map(likeded -> {
            LikededResponse likededResponse = new LikededResponse(
                    likeded.getId(),
                    likeded.getStoryId().getId(),
                    likeded.getUserId().getId(),
                    likeded.getDateTime()
            );
            listLikededResponse.add(likededResponse);
            return null;
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listLikededResponse);
    }

    private Story retriveStory(Long id) {
        return this.storyRepository.findById(id).orElseThrow();
    }
}
