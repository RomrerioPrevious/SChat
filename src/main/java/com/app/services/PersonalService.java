package com.app.services;

import com.app.repositories.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonalService {
    private PersonalRepository personalRepository;

    @Autowired
    public PersonalService(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }
}
