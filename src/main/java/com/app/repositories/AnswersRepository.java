package com.app.repositories;

import com.app.models.Answers;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersRepository extends CassandraRepository<Answers, Long> {
}
