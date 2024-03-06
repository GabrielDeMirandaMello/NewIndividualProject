package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.GetAllLikeded;
import com.travel.stories.travels.internal.entity.Likeded;
import com.travel.stories.travels.internal.records.LikededResponse;
import com.travel.stories.travels.internal.repository.LikededRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@ConditionalOnSingleCandidate(GetAllLikeded.class)
public class DefaultGetAllLikeded implements GetAllLikeded {

    @Autowired
    private LikededRepository likededRepository;

    @Override
    public ResponseEntity<List<LikededResponse>> execute() {
        List<LikededResponse> listLikededResponse = new ArrayList<>();
        this.likededRepository.findAll().stream().map(likeded -> {
            LikededResponse likededResponse = new LikededResponse(
                    likeded.getId(),
                    likeded.getStoryId().getId(),
                    likeded.getUserId().getId(),
                    likeded.getDateTime()
            );
            listLikededResponse.add(likededResponse);
            return null;
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listLikededResponse);
    }
}
