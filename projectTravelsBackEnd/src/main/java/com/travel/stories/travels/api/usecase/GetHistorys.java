package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.entity.History;

import java.util.List;

public interface GetHistorys {

    List<History> execute();
}
