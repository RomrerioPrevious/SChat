package com.app.repositories;

import com.app.models.Personal;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface PersonalRepository extends CassandraRepository<Personal, Long> {
    List<Personal> findByChatId(long chatId);

    @AllowFiltering
    void deleteByChatId(long chatID);
}
