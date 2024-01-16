package com.travel.stories.travels.internal.records;


import com.travel.stories.travels.internal.entity.User;

public record UserResponse(
        Long id,
        String name,
        String email,
        String phone,
        String restMonth,
        String favoriteCompany
        ) {

        public static UserResponse parserUser(User user) {
                return new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getRestMonth(),
                        user.getFavoriteCompany()
                );
        }
}
