package com.app.repositories;

import com.app.models.Post;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface PostsRepository extends CassandraRepository<Post, Long> {
    List<Long> getPostsIdsByUserId(long id);
    void deleteByUserId(long id);
}
