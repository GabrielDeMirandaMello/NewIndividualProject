package com.travel.stories.travels.internal.controller;

import com.travel.stories.travels.api.controller.HistoryController;
import com.travel.stories.travels.api.usecase.CreateHistory;
import com.travel.stories.travels.api.usecase.DeleteHistoryById;
import com.travel.stories.travels.api.usecase.GetHistoryById;
import com.travel.stories.travels.api.usecase.GetHistorys;
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

    @Override
    public ResponseEntity<History> getHistory(Long id) {
        return this.getHistoryById.execute(id);
    }

    @Override
    public List<History> getAllHistory() {
        return this.getHistorys.execute();
    }

    @Override
    public ResponseEntity<History> createHistory(History history) {
        return this.createHistory.execute(history);
    }

    @Override
    public void deleteHistory(Long id) {
        this.deleteHistoryById.execute(id);
    }
}
