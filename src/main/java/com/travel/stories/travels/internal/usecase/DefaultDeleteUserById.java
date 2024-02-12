package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.DeleteUserById;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DefaultDeleteUserById implements DeleteUserById {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void execute(Long id) {
        this.userRepository.deleteById(id);
    }
}
