package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.GetHistorys;
import com.travel.stories.travels.internal.entity.History;
import com.travel.stories.travels.internal.repository.HistoryRepository;

import java.util.List;

public class DefaultGetHistorys implements GetHistorys {

    private HistoryRepository historyRepository;

    @Override
    public List<History> execute() {
        return this.historyRepository.findAll();
    }
}
