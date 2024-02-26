package com.travel.stories.travels.internal.controller;

import com.travel.stories.travels.api.controller.HistoryController;
import com.travel.stories.travels.api.usecase.*;
import com.travel.stories.travels.internal.entity.History;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@ConditionalOnSingleCandidate(HistoryController.class)
public class DefaultHistoryController implements HistoryController {

    private CreateHistory createHistory;
    private GetHistoryById getHistoryById;
    private GetHistorys getHistorys;
    private DeleteHistoryById deleteHistoryById;
    private UpdateLike updateLike;

    @Override
    public ResponseEntity<History> getHistory(Long id) {
        return this.getHistoryById.execute(id);
    }

    @Override
    public List<History> getAllHistory() {
        return this.getHistorys.execute();
    }

    @Override
    public ResponseEntity<History> createHistory(Long id, History history) {
        return this.createHistory.execute(id, history);
    }

    @Override
    public void deleteHistory(Long id) {
        this.deleteHistoryById.execute(id);
    }

    @Override
    public void updateLike(Long id) {
        this.updateLike.execute(id);
    }
}
