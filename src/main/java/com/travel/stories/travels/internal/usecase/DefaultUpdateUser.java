package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.UpdateUser;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.records.UserResponse;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
@NoArgsConstructor
@AllArgsConstructor
public class DefaultUpdateUser implements UpdateUser {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<UserResponse> execute(UserResponse userResponse, Long id) {
        User user = this.userRepository.findById(id).orElseThrow();
        user.setName(userResponse.name());
        user.setPhone(userResponse.phone());
        user.setEmail(userResponse.email());
        user.setRestMonth(userResponse.restMonth());
        user.setFavoriteCompany(userResponse.favoriteCompany());
        return ResponseEntity.status(HttpStatus.OK).body(UserResponse.parserUser(this.userRepository.save(user)));
    }
}
