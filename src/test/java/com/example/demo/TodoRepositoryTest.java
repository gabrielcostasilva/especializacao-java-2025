package com.example.demo;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@DataMongoTest
public class TodoRepositoryTest {

    @Autowired
    private ReactiveMongoTemplate template;
    
    @Autowired
    private TodoRepository repository;

    @Test
    public void todoValido() {
        Todo todo = new Todo(
                        UUID.randomUUID().toString(), 
                        "Participar de reunião", 
                        "Reunião de discussão", 
                        false);

        var aTodo = template.save(todo);
        
        StepVerifier
            .create(aTodo)
            .expectNextMatches(
                item -> item.descricao().equals("Reunião de discussão"))
            .verifyComplete();
    }

    @Test
    public void recuperaPorFeito() {
        
        var results = repository
                        .deleteAll()
                        .thenMany(
                            Flux
                                .just("Participar de reunião", "Verificar mensagens")
                                .map(todo -> new Todo(UUID.randomUUID().toString(), todo, todo, false))
                                .flatMap(repository::save))
                        .thenMany(repository.findByFeito(false));

        StepVerifier
            .create(results)
            .expectNextCount(2)
            .verifyComplete();
    }
}