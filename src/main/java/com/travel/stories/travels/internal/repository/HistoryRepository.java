package com.travel.stories.travels.internal.repository;

import com.travel.stories.travels.internal.entity.History;
import com.travel.stories.travels.internal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History, Long> {

    Optional<List<History>> findAllByUsersId(User user);
}
