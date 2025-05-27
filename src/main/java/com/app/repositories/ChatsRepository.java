package com.app.repositories;

import com.app.models.Chat;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ChatsRepository extends CassandraRepository<Chat, Long> {
}
