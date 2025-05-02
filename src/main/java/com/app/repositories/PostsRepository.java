package com.app.repositories;

import com.app.models.Posts;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface PostsRepository extends CassandraRepository<Posts, Long> {
}
