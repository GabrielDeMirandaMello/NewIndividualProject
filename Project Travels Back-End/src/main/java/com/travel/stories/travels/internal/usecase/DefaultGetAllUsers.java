package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.GetUsers;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DefaultGetAllUsers implements GetUsers {

    private UserRepository userRepository;

    @Override
    public List<User> execute() {
        return this.userRepository.findAll();
    }
}
