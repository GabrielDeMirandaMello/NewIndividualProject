package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.DeleteStoryById;
import com.travel.stories.travels.internal.repository.StoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DefaultDeleteById implements DeleteStoryById {
    @Autowired
    private StoryRepository storyRepository;
    @Override
    public void execute(Long id) {
        this.storyRepository.deleteById(id);
    }
}
