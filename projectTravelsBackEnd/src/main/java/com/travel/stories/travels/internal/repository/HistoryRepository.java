package com.travel.stories.travels.internal.repository;

import com.travel.stories.travels.internal.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
