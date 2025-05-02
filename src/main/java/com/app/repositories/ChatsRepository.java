package com.app.repositories;

import com.app.models.Chats;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ChatsRepository extends CassandraRepository<Chats, Long> {
}
