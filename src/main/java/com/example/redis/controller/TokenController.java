package com.example.redis.controller;

import com.example.redis.model.Token;
import com.example.redis.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/tokens")
@RequiredArgsConstructor
public class TokenController {

    private final TokenService tokenService;

    @GetMapping
    public Iterable<Token> findAll() {
        return tokenService.findAll();
    }

    @GetMapping("/{tokenId}")
    public Token findById(@PathVariable UUID tokenId) {
        return tokenService.findById(tokenId);
    }

    @PostMapping
    public Token createOrUpdateToken(@RequestBody Token token) {
        return tokenService.save(token);
    }

    @DeleteMapping("/{tokenId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteToken(@PathVariable UUID tokenId) {
        tokenService.deleteById(tokenId);
    }
}
