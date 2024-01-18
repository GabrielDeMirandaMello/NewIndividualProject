package com.travel.stories.travels.internal.execption;

import org.springframework.data.crossstore.ChangeSetPersister;

public class UserAlreadyExistsExeption extends ChangeSetPersister.NotFoundException {

    public UserAlreadyExistsExeption() {
        super();
    }
}
