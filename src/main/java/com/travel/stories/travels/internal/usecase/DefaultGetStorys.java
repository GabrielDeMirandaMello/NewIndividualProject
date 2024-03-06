package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.GetStorys;
import com.travel.stories.travels.internal.entity.Story;
import com.travel.stories.travels.internal.repository.StoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class DefaultGetStorys implements GetStorys {
    @Autowired
    private StoryRepository storyRepository;

    @Override
    public List<Story> execute() {
        return this.storyRepository.findAll().stream().sorted(Comparator.comparing(Story::getId).reversed())
                .collect(Collectors.toList());
    }
}
