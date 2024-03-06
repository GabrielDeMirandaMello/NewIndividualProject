package com.travel.stories.travels.internal.records;

import java.time.LocalDateTime;

public record LikededResponse(Long id, Long idStory, Long idUser, LocalDateTime datetime) {
}
