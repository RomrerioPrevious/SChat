package com.app.services;

import com.app.models.Chat;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ChatsServiceTest {
    private final long id;
    private final Chat chat;
    private final ChatsService chatsService;

    @TestConfiguration
    static class ChatServiceTestConfiguration {
        @Bean("id")
        public long getRandomId() {
            return 1;
        }

        @Bean
        public Chat getChat() {
            long id = 1;

            return new Chat(id);
        }
    }

    @Autowired
    public ChatsServiceTest(long id, Chat chat, ChatsService chatsService) {
        this.id = id;
        this.chat = chat;
        this.chatsService = chatsService;
    }

    @BeforeAll
    public void createAnswer() {
        chatsService.save(chat);
    }

    @Test
    public void findByIdTest() {
        Chat response = chatsService.findById(id);
        Assertions.assertEquals(response, chat);
    }

    @AfterAll
    public void deleteAnswer() {
        chatsService.deleteById(id);
    }
}
