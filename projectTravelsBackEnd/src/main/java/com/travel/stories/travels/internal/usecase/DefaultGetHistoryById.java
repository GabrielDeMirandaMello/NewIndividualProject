package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.GetHistoryById;
import com.travel.stories.travels.internal.entity.History;
import com.travel.stories.travels.internal.repository.HistoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@AllArgsConstructor
public class DefaultGetHistoryById implements GetHistoryById {

    private HistoryRepository historyRepository;

    @Override
    public History execute(Long id) {
        return this.historyRepository.findById(id).orElseThrow();
    }
}
