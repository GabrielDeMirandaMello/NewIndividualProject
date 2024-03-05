package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.entity.Story;

import java.util.List;

public interface GetHistorys {

    List<Story> execute();
}
