package com.travel.stories.travels.internal.repository;

import com.travel.stories.travels.internal.entity.Likeded;
import com.travel.stories.travels.internal.entity.Story;
import com.travel.stories.travels.internal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikededRepository extends JpaRepository<Likeded, Long> {

    Optional<List<Likeded>> findAllByStoryId(Story story);

    Optional<List<Likeded>> findByUserIdAndStoryId(User idUser, Story idStory);
}
