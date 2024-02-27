package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.GetHistorys;
import com.travel.stories.travels.internal.entity.History;
import com.travel.stories.travels.internal.repository.HistoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class DefaultGetHistorys implements GetHistorys {
    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public List<History> execute() {
        return this.historyRepository.findAll().stream().sorted(Comparator.comparing(History::getId).reversed())
                .collect(Collectors.toList());
    }
}
