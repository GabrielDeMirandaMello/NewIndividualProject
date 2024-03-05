package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.entity.Story;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetrieveStorys {

    ResponseEntity<List<Story>> execute(String type, String filtrate, String buscar);
}
