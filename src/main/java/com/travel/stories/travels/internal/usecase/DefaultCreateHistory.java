package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.CreateHistory;
import com.travel.stories.travels.internal.entity.Story;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.repository.StoryRepository;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DefaultCreateHistory implements CreateHistory {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<Story> execute(Long id, Story story) {
        User user = this.userRepository.findById(id).orElseThrow();
        story.setUsers(user);
        Story storySave = this.storyRepository.save(story);
        return new ResponseEntity<>(storySave, HttpStatus.CREATED);
    }
}
