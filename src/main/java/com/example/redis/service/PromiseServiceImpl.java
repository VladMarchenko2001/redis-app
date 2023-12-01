package com.example.redis.service;

import com.example.redis.model.Promise;
import com.example.redis.repository.PromiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.example.redis.constant.CacheConstants.PROMISE_CACHE;

@Service
@RequiredArgsConstructor
public class PromiseServiceImpl implements PromiseService {

    private final PromiseRepository promiseRepository;

    @CacheEvict(value = PROMISE_CACHE, allEntries = true)
    @CachePut(value = PROMISE_CACHE, key = "#promise.id.toString()", unless = "#promise != null")
    @Override
    public Promise save(Promise promise) {
        return promiseRepository.save(promise);
    }

    @CacheEvict(value = PROMISE_CACHE, allEntries = true)
    @Override
    public void deleteById(UUID promiseId) {
        promiseRepository.deleteById(promiseId);
    }

    @Cacheable(value = PROMISE_CACHE)
    @Override
    public List<Promise> findAll() {
        return (List<Promise>) promiseRepository.findAll();
    }

    @Cacheable(value = PROMISE_CACHE, key = "#promiseId.toString()", condition = "#promiseId != null")
    @Override
    public Promise findById(UUID promiseId) {
        return promiseRepository.findById(promiseId).orElseThrow();
    }
}
