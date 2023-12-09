package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.CreateUser;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DefaultCreateUser implements CreateUser {

    private UserRepository userRepository;

    @Override
    public User execute(User user) {
        return this.userRepository.save(user);
    }
}
