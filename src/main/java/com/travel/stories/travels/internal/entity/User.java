package com.travel.stories.travels.internal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(min = 3)
    private String name;

    @Email
    @Column(name = "email", unique = true)
    @NotNull
    private String email;

    @Column(name = "phone", unique = true)
    @NotNull
    private String phone;

    @Size(min = 12)
    @NotNull
    @Column(name = "password")
    private String password;

    @NotBlank
    @NotNull
    @Column(name = "rest_month")
    private String restMonth;

    @NotBlank
    @NotNull
    @Column(name = "favorite_company")
    private String favoriteCompany;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "users")
    private List<History> histories;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role != UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
