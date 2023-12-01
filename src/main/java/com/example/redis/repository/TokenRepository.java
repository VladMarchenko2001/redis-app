package com.example.redis.repository;

import com.example.redis.model.Token;

import java.util.List;

public interface TokenRepository {

    Token save(Token token);

    void deleteById(String tokenId);

    List<Token> findAll();
}
