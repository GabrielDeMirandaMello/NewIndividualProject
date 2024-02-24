package com.travel.stories.travels.internal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "history")
@Data
@NoArgsConstructor
public class History implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "comment")
    private String comment;

    @Column(name = "like_count")
    private Long likeCount;

//    @Nullable
//    @JsonIgnore
//    @Column(name = "travel_picture", length = 50 * 1024 * 1024)
//    private byte[] travelPicture;

}
