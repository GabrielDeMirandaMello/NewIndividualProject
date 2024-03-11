package com.travel.stories.travels.internal.configurations;

import com.travel.stories.travels.internal.entity.UserRole;
import com.travel.stories.travels.internal.usecase.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/users/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/users/register").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/users/update/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole(UserRole.ADMIN.name())
                        .requestMatchers(HttpMethod.GET, "/api/users").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/users/**").authenticated()


                        .requestMatchers(HttpMethod.GET, "/api/history/all").authenticated()
                        .requestMatchers(HttpMethod.GET, "/api/history/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/history/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/history/like/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/api/history/disliked/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/api/history/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/likeded").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/likeded/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/likeded/all-by-story/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/comment").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/comment/**").permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
