package com.app.services;
import com.app.models.Personal;
import com.app.models.Post;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonalServiceTest {
    private final long id;
    private final Personal personal;
    private final PersonalService personalService;

    @TestConfiguration
    private class PersonalServiceTestConfiguration {
        @Bean("id")
        public long getRandomId() {
            return 1;
        }

        @Bean
        public Post getPost() {
            long id = 1;
            return new Post(id);
        }
    }

    @Autowired
    public PersonalServiceTest(long id, Personal personal, PersonalService personalService) {
        this.id = id;
        this.personal = personal;
        this.personalService = personalService;
    }

    @BeforeAll
    public void createAnswer() {
        personalService.save(personal);
    }

    @Test
    public void findByIdTest() {
        Personal response = personalService.findById(id);
        Assertions.assertEquals(response, personal);
    }

    @AfterAll
    public void deleteAnswer() {
        personalService.deleteById(id);
    }
}
