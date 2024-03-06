package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.CreateLikeded;
import com.travel.stories.travels.internal.entity.Likeded;
import com.travel.stories.travels.internal.entity.Story;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.records.LikededBody;
import com.travel.stories.travels.internal.repository.LikededRepository;
import com.travel.stories.travels.internal.repository.StoryRepository;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
public class DefaultCreateLikeded implements CreateLikeded {

    @Autowired
    private LikededRepository likededRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StoryRepository storyRepository;

    @Override
    public ResponseEntity<Void> execute(LikededBody likededBody) {
        Optional<User> userByName = this.userRepository.findByName(likededBody.name());
        Optional<Story> storyById = this.storyRepository.findById(likededBody.idStory());

        if (userByName.isPresent()){
            Likeded likeded = new Likeded();
            likeded.setUserId(userByName.orElseThrow());
            likeded.setStoryId(storyById.orElseThrow());
            likeded.setDateTime(LocalDateTime.now());
            this.likededRepository.save(likeded);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
