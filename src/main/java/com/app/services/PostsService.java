package com.app.services;

import com.app.models.Post;
import com.app.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostsService {
    private final PostsRepository postsRepository;
    private final AnswersService answersService;

    @Autowired
    public PostsService(PostsRepository postsRepository, AnswersService answersService) {
        this.postsRepository = postsRepository;
        this.answersService = answersService;
    }

    public void save(Post posts) {postsRepository.save(posts);}

    public Post findById(long id) {
        return postsRepository.findById(id).orElse(null);
    }

    public void deleteById(long id) {
        postsRepository.deleteById(id);
    }

    public void deleteByUserId(long id) {
        List<Long> posts = postsRepository.getPostsIdsByUserId(id);
        postsRepository.deleteByUserId(id);
        answersService.deleteByAllPostId(posts);
    }
}
