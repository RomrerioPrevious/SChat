package com.app.repositories;

import com.app.models.Personal;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;

public interface PersonalRepository extends CassandraRepository<Personal, Long> {
    @Query("SELECT * FROM personal WHERE chat_id = ?0 ALLOW FILTERING;")
    List<Personal> findByChatId(long chatId);

    @AllowFiltering
    void deleteByChatId(long chatID);
}
