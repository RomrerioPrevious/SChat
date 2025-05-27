package com.app.repositories;

import com.app.models.Answer;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersRepository extends CassandraRepository<Answer, Long> {
    List<Answer> findByPostId(long postId);

    @AllowFiltering
    void deleteByPostId(long postID);
}
