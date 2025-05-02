package com.app.services;

import com.app.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PostsService {
    private PostsRepository postsRepository;

    @Autowired
    public PostsService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }
}
