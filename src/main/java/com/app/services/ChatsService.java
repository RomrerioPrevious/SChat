package com.app.services;

import com.app.models.Chat;
import com.app.models.Personal;
import com.app.repositories.ChatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatsService {
    private final ChatsRepository chatsRepository;

    @Autowired
    public ChatsService(ChatsRepository chatsRepository) {
        this.chatsRepository = chatsRepository;
    }

    public void save(Chat chat) {chatsRepository.save(chat);}

    public Chat findById(long id) {
        return chatsRepository.findById(id).orElse(null);
    }

    public void deleteById(long id) {
        chatsRepository.deleteById(id);
    }
}
