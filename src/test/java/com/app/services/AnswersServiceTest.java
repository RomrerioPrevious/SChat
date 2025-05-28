package com.app.services;

import com.app.models.Answer;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AnswersServiceTest {
    private final long id;
    private final Answer answer;
    private final AnswersService answersService;

    @TestConfiguration
    static class AnswersServiceTestConfiguration {
        @Bean("id")
        public long getId() {
            return 1;
        }

        @Bean
        public Answer getAnswer() {
            long id = 1;

            return new Answer(
                    id,
                    "name",
                    LocalDate.now(),
                    LocalTime.now(),
                    id,
                    id,
                    id,
                    ""
        );
        }
    }


    @Autowired
    public AnswersServiceTest(long id, Answer answer, AnswersService answersService) {
        this.id = id;
        this.answer = answer;
        this.answersService = answersService;
    }

    @BeforeAll
    public void createAnswer() {
        answersService.save(answer);
    }

    @Test
    public void findByIdTest() {
        Answer response = answersService.findById(id);
        Assertions.assertEquals(response, answer);
    }

    @AfterAll
    public void deleteAnswer() {
        answersService.deleteById(id);
    }
}
