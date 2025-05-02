package com.app.repositories;

import com.app.models.Personal;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface PersonalRepository extends CassandraRepository<Personal, Long> {
}
