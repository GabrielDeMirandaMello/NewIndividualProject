package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.RetrieveStorys;
import com.travel.stories.travels.internal.entity.History;
import com.travel.stories.travels.internal.repository.HistoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@NoArgsConstructor
public class DefaultRetrieveStorys implements RetrieveStorys {

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public ResponseEntity<List<History>> execute(String filtrate, String buscar) {
        if (buscar != null) {
            return switch (filtrate) {
                case "name" ->
                        ResponseEntity.status(HttpStatus.OK).body(this.historyRepository.findAllByNameUserContainsIgnoreCase(buscar));
                case "title" ->
                        ResponseEntity.status(HttpStatus.OK).body(this.historyRepository.findAllByTitleContainsIgnoreCase(buscar));
                case "description" ->
                        ResponseEntity.status(HttpStatus.OK).body(this.historyRepository.findAllByDescriptionContainsIgnoreCase(buscar));
                default -> ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            };
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
