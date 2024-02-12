package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.DeleteHistoryById;
import com.travel.stories.travels.internal.repository.HistoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DefaultDeleteById implements DeleteHistoryById {
    @Autowired
    private HistoryRepository historyRepository;
    @Override
    public void execute(Long id) {
        this.historyRepository.deleteById(id);
    }
}
