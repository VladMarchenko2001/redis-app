package com.example.redis.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@RedisHash(value = "promise", timeToLive = 1000)
public class Promise implements Serializable {

    @Serial
    private static final long serialVersionUID = -1027546001655886178L;


    @Id
    private UUID id;
    private String name;
}
