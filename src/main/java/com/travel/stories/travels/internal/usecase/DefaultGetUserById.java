package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.GetUserById;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.records.UserResponse;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class DefaultGetUserById implements GetUserById {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<UserResponse> execute(Long id) {
        Optional<User> user = this.userRepository.findById(id);

        return user.map(value -> new ResponseEntity<>(UserResponse.parserUser(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
