package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.CreateHistory;
import com.travel.stories.travels.internal.entity.History;
import com.travel.stories.travels.internal.repository.HistoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DefaultCreateHistory implements CreateHistory {

    private HistoryRepository historyRepository;

    @Override
    public History execute(History history) {
        return this.historyRepository.save(history);
    }
}
