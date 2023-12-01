package com.example.redis.repository;

import com.example.redis.model.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepositoryV2 extends CrudRepository<Token, String> {
}
