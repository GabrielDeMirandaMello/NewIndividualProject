package com.travel.stories.travels.internal.usecase;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.entity.UserRole;
import com.travel.stories.travels.internal.records.UserResponse;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import net.bytebuddy.pool.TypePool;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;


@SpringBootTest
class DefaultCreateUserTest {

    @InjectMocks
    private DefaultCreateUser defaultCreateUser;

    @Mock
    UserRepository userRepository;

    @Mock
    UserResponse userResponse;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Transactional
    @Disabled
    void createUserWithSucess() {
        User user = new User();
        user.setId(18L);
        user.setName("Gabriel");
        user.setEmail("Gabriel97@gmail.com");
        user.setPassword("123456789");
        user.setPhone("11976139987");
        user.setRestMonth("Janeiro");
        user.setFavoriteCompany("Minha Noiva");
        user.setRole(UserRole.USER);

        when(userRepository.findByEmail(anyString())).thenReturn(isNull());
        when(userRepository.save(user)).thenReturn(user);
        UserResponse userResponseParser = UserResponse.parserUser(user);
        when(UserResponse.parserUser(user)).thenReturn(userResponseParser);

        ResponseEntity<UserResponse> response = this.defaultCreateUser.execute(user);

        assertNotNull(response);
        assertNotNull(response.getBody());
    }
}