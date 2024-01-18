package com.travel.stories.travels.api.usecase;

import com.travel.stories.travels.internal.records.AuthenticationLogin;
import com.travel.stories.travels.internal.records.LoginResponse;

public interface AuthLogin {

    LoginResponse execute(AuthenticationLogin login);
}
