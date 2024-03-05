package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.UpdateDisliked;
import com.travel.stories.travels.internal.entity.Story;
import com.travel.stories.travels.internal.repository.StoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class DefaultUpdateDisliked implements UpdateDisliked {

    @Autowired
    private StoryRepository storyRepository;

    @Override
    public void execute(String id) {
        Story story = this.storyRepository.findById(Long.parseLong(id)).orElseThrow();
        story.setLikeCount(story.getLikeCount() - 1);
        this.storyRepository.save(story);
    }
}
