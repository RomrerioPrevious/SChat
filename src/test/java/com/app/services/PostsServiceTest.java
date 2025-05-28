package com.app.services;
import com.app.models.Post;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostsServiceTest {
    private final long id;
    private final Post post;
    private final PostsService postsService;

    @TestConfiguration
    private class PostsServiceTestConfiguration {
        @Bean("id")
        public long getRandomId() {
            return 1;
        }

        @Bean
        public Post getPost() {
            return new Post(1);
        }
    }

    @Autowired
    public PostsServiceTest(long id, Post post, PostsService postsService) {
        this.id = id;
        this.post = post;
        this.postsService = postsService;
    }

    @BeforeAll
    public void createAnswer() {
        postsService.save(post);
    }

    @Test
    public void findByIdTest() {
        Post response = postsService.findById(id);
        Assertions.assertEquals(response, post);
    }

    @AfterAll
    public void deleteAnswer() {
        postsService.deleteById(id);
    }
}
