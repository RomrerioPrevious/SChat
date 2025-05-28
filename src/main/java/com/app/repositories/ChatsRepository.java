package com.app.repositories;

import com.app.models.Chat;
import com.app.models.Personal;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface ChatsRepository extends CassandraRepository<Chat, Long> {
}
