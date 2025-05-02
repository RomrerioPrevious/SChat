package com.app.services;

import com.app.repositories.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AnswersService {
    private AnswersRepository answersRepository;

    @Autowired
    public AnswersService(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }
}
