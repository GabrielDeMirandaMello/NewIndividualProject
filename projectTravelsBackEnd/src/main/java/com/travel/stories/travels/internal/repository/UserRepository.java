package com.travel.stories.travels.internal.repository;

import com.travel.stories.travels.internal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}