package com.example.redis.controller;

import com.example.redis.model.Promise;
import com.example.redis.service.PromiseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/promises")
@RequiredArgsConstructor
public class PromiseController {

    private final PromiseService promiseService;

    @GetMapping
    public Iterable<Promise> findAll() {
        return promiseService.findAll();
    }

    @GetMapping("/{promiseId}")
    public Promise findById(@PathVariable UUID promiseId) {
        return promiseService.findById(promiseId);
    }

    @PostMapping
    public Promise createOrUpdateToken(@RequestBody Promise token) {
        return promiseService.save(token);
    }

    @DeleteMapping("/{promiseId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteToken(@PathVariable UUID promiseId) {
        promiseService.deleteById(promiseId);
    }
}
