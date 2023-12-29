package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.entity.History;

public interface GetHistoryById {

    History execute(Long id);
}
