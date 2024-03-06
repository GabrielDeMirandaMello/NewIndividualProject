package com.travel.stories.travels.internal.repository;

import com.travel.stories.travels.internal.entity.Story;
import com.travel.stories.travels.internal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoryRepository extends JpaRepository<Story, Long> {

    Optional<List<Story>> findAllByUsers(User user);

    List<Story> findAllByNameUserContainsIgnoreCase(String buscar);
    List<Story> findAllByTitleContainsIgnoreCase(String buscar);
    List<Story> findAllByDescriptionContainsIgnoreCase(String buscar);
}
