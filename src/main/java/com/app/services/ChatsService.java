package com.app.services;

import com.app.repositories.ChatsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ChatsService {
    private ChatsRepository chatsRepository;

    @Autowired
    public ChatsService(ChatsRepository chatsRepository) {
        this.chatsRepository = chatsRepository;
    }
}
