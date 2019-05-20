package com.github.richygreat.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class EchoController {
    @GetMapping("/{message}")
    public Mono<String> echo(@PathVariable() String message) {
        return Mono.just(message);
    }
}
