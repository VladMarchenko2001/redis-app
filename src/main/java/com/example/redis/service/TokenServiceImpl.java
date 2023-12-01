package com.example.redis.service;

import com.example.redis.config.RedisConfig;
import com.example.redis.model.Token;
import com.example.redis.repository.TokenRepository;
import com.example.redis.repository.TokenRepositoryV2;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.redis.constant.CacheConstants.TOKEN_CACHE;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final TokenRepositoryV2 tokenRepositoryV2;
    private final RedisConfig redisConfig;

    @CacheEvict(value = TOKEN_CACHE, allEntries = true)
    @CachePut(value = TOKEN_CACHE, key = "#token.id", unless = "#token != null")
    @Override
    public Token save(Token token) {
        return tokenRepositoryV2.save(token.setExpiration(redisConfig.getTtl()));
    }

    @CacheEvict(value = TOKEN_CACHE, condition = "#tokenId != null", allEntries = true)
    @Override
    public void deleteById(UUID tokenId) {
        tokenRepositoryV2.deleteById(tokenId.toString());
    }

    @Cacheable(value = TOKEN_CACHE)
    @Override
    public List<Token> findAll() {
        return (List<Token>) tokenRepositoryV2.findAll();
    }

    @Cacheable(value = TOKEN_CACHE, key = "#tokenId", condition = "#tokenId != null")
    @Override
    public Token findById(UUID tokenId) {
        return tokenRepositoryV2.findById(tokenId.toString()).orElseThrow();
    }
}
