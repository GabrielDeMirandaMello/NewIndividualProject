package com.travel.stories.travels.internal.usecase;

import com.travel.stories.travels.api.usecase.AuthLogin;
import com.travel.stories.travels.internal.entity.User;
import com.travel.stories.travels.internal.records.AuthenticationLogin;
import com.travel.stories.travels.internal.records.LoginResponse;
import com.travel.stories.travels.internal.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class DefaultAuthLogin implements AuthLogin {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    DefaultTokenService defaultTokenService;

    @Override
    public LoginResponse execute(AuthenticationLogin login) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(login.email(), login.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = defaultTokenService.generateToken((User) auth.getPrincipal());

        return new LoginResponse(token);
    }
}
