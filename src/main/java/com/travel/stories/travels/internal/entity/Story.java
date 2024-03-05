package com.travel.stories.travels.internal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.stories.travels.internal.records.UserResponse;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "story")
@Data
@NoArgsConstructor
public class Story implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "like_count")
    private Long likeCount;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @JsonIgnore
    private User users;

    @Column(name = "name_user")
    private String nameUser;

    @OneToMany
    @JoinColumn(name = "story_id")
    private List<Likeded> likededs;

    @OneToMany
    @JoinColumn(name = "story_id")
    private List<Comment> comments;

//    @Nullable
//    @JsonIgnore
//    @Column(name = "travel_picture", length = 50 * 1024 * 1024)
//    private byte[] travelPicture;
}
