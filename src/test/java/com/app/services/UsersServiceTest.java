package com.app.services;
import com.app.models.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsersServiceTest {
    private final long id;
    private final User user;
    private final UserService userService;

    @TestConfiguration
    static class UsersServiceTestConfiguration {
        @Bean("id")
        public long getRandomId() {
            return 1;
        }

        @Bean
        public User getUser() {
            long id = 1;
            return new User(id);
        }
    }

    @Autowired
    public UsersServiceTest(long id, User user, UserService userService) {
        this.id = id;
        this.user = user;
        this.userService = userService;
    }

    @BeforeAll
    public void createAnswer() {
        userService.save(user);
    }

    @Test
    public void findByIdTest() {
        User response = userService.findById(id);
        Assertions.assertEquals(response, user);
    }

    @AfterAll
    public void deleteAnswer() {
        userService.deleteById(id);
    }
}
