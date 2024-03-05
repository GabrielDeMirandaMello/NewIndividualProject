package com.travel.stories.travels.internal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"story_id", "user_id"}))
public class Likeded {

    @Id
    @ManyToOne
    private Story storyId;

    @Id
    @ManyToOne
    private User userId;

    @Column(name = "date_time")
    private LocalDateTime dateTime;
}
