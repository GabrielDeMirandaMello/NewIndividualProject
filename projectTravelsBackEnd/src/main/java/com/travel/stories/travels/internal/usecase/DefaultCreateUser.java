package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.CreateUser;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.execption.UserAlreadyExistsExeption;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DefaultCreateUser implements CreateUser {

    private UserRepository userRepository;

    @Override
    public User execute(User user) {
        if(this.userRepository.findByEmail(user.getEmail()) != null){
            System.out.println("Usuario não encontrado");
        } else {
            String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
            user.setPassword(encodedPassword);
        }

        return this.userRepository.save(user);
    }
}
