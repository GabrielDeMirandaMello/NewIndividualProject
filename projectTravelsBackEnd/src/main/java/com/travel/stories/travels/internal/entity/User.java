package com.travel.stories.travels.internal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements Serializable {

    @Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(min = 3)
    private String name;

    @Email
    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    @Column(name = "phone", unique = true)
    @NotNull
    private String phone;

    @Size(min = 12)
    @NotNull
    @Column(name = "password")
    private String password;

    @NotBlank
    @NotNull
    @Column(name = "rest_month")
    private String restMonth;

    @NotBlank
    @NotNull
    @Column(name = "favorite_company")
    private String favoriteCompany;

}
