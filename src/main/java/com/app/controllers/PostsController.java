package com.app.controllers;

import com.app.models.Answer;
import com.app.services.AnswersService;
import com.app.services.PostsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
public class PostsController {
    private final PostsService postsService;
    private final AnswersService answersService;

    public PostsController(PostsService postsService, AnswersService answersService) {
        this.postsService = postsService;
        this.answersService = answersService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        long id = 1;
        Answer answer = new Answer(
                id,
                "name",
                LocalDate.now(),
                LocalTime.now(),
                id,
                id,
                id,
                ""
        );
        answersService.save(answer);
        return ResponseEntity.ok(answersService.findByPostId(1));
    }
}
