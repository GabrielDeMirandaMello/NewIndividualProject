package com.travel.stories.travels.internal.repository;

import com.travel.stories.travels.internal.entity.Likeded;
import com.travel.stories.travels.internal.entity.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikededRepository extends JpaRepository<Likeded, Long> {

    Optional<List<Likeded>> findAllByStoryId(Story story);
}
