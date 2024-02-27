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
    private RetrieveStorys retrieveStorys;
    private UpdateDisliked updateDisliked;

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
    public void updateLike(String id) {
        this.updateLike.execute(id);
    }

    @Override
    public void updateDisliked(String id) {
        this.updateDisliked.execute(id);
    }

    @Override
    public ResponseEntity<List<History>> retrieveStorys(String type, String filtrate, String buscar) {
        return this.retrieveStorys.execute(type, filtrate, buscar);
    }
}
