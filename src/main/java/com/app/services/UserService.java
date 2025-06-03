package com.app.services;

import com.app.models.User;
import com.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService{
    private final UserRepository userRepository;
    private final PostsService postsService;

    @Autowired
    public UserService(UserRepository userRepository, PostsService postsService) {
        this.userRepository = userRepository;
        this.postsService = postsService;
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
        postsService.deleteByUserId(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
