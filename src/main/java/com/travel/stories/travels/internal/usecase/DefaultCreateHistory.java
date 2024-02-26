package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.CreateHistory;
import com.travel.stories.travels.internal.entity.History;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.repository.HistoryRepository;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class DefaultCreateHistory implements CreateHistory {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<History> execute(Long id,History history) {
        User user = this.userRepository.findById(id).orElseThrow();
        history.setUsers(user);
        History historySave = this.historyRepository.save(history);
        return new ResponseEntity<>(historySave, HttpStatus.CREATED);
    }
}
