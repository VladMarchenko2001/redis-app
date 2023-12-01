package com.example.redis.service;

import com.example.redis.model.Promise;

import java.util.List;
import java.util.UUID;

public interface PromiseService {

    Promise save(Promise promise);

    void deleteById(UUID promiseId);

    List<Promise> findAll();

    Promise findById(UUID promiseId);
}
