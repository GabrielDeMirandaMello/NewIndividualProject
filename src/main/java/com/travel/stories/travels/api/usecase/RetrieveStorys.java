package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.entity.History;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RetrieveStorys {

    ResponseEntity<List<History>> execute(String filtrate, String buscar);
}
