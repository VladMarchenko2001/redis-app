package com.example.redis.repository;

import com.example.redis.model.Promise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PromiseRepository extends CrudRepository<Promise, UUID> {
}
