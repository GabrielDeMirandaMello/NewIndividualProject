package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.CreateUser;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.execption.UserAlreadyExistsExeption;
import com.travel.stories.travels.internal.records.UserResponse;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.annotation.Nullable;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
@Transactional
@AllArgsConstructor
public class DefaultCreateUser implements CreateUser {

    private UserRepository userRepository;

    @Override
    public ResponseEntity<UserResponse> execute(User user) {
        if(this.userRepository.findByEmail(user.getEmail()) != null){
           return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } else {
            String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
            user.setPassword(encodedPassword);
        }
        return new ResponseEntity<>(UserResponse.parserUser(this.userRepository.save(user)), HttpStatus.CREATED);
    }
}
