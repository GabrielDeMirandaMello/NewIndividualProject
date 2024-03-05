package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.records.LikededResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GetAllLikeded {

    ResponseEntity<List<LikededResponse>> execute();
}
