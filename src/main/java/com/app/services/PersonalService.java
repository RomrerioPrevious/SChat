package com.app.services;

import com.app.models.Personal;
import com.app.repositories.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {
    private final PersonalRepository personalRepository;

    @Autowired
    public PersonalService(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    public void save(Personal personal) {personalRepository.save(personal);}

    public Personal findById(long id) {
        return personalRepository.findById(id).orElse(null);
    }

    public List<Personal> findByChatId(long chatId) {
        return personalRepository.findByChatId(chatId);
    }

    public void deleteById(long id) {
        personalRepository.deleteById(id);
    }

    public void deleteByChatId(long chatID) {
        personalRepository.deleteByChatId(chatID);
    }
}
