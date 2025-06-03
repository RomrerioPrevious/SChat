package com.app.services;

import com.app.models.Answer;
import com.app.repositories.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswersService {
    private final AnswersRepository answersRepository;

    @Autowired
    public AnswersService(AnswersRepository answersRepository) {
        this.answersRepository = answersRepository;
    }

    public void save(Answer answer) {
        answersRepository.save(answer);
    }

    public Answer findById(long id) {
        return answersRepository.findById(id).orElse(null);
    }

    public List<Answer> findByPostId(long id) {
        return answersRepository.findByPostId(id).orElseThrow();
    }

    public void deleteById(long id) {
        answersRepository.deleteById(id);
    }

    public void deleteByPostId(long postId) {
        answersRepository.deleteByPostId(postId);
    }

    public void deleteByAllPostId(List<Long> postIds) {
        for (Long postId : postIds)
            answersRepository.deleteByPostId(postId);
    }

    public List<Answer> findAll() {
        return answersRepository.findAll();
    }
}
