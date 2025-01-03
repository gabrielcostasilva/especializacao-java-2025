package com.example.demo;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest
public class TodoRestControllerTest {

    @MockBean
    private TodoRepository repository;

    @Autowired
    private WebTestClient client;
    
    @Test
    public void lerTodos() {

        Todo todo1 = new Todo(
                            UUID.randomUUID().toString(), 
                            "Participar de reunião", 
                            "", 
                            false);

        Todo todo2 = new Todo(
                            UUID.randomUUID().toString(), 
                            "Verificar mensagens", 
                            "", 
                            false);
        
        Mockito
            .when(repository.findAll())
            .thenReturn(Flux.just(todo1,todo2));

        client
            .get()
            .uri("/todos")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
                .jsonPath("@.[0].titulo").isEqualTo("Participar de reunião")
                .jsonPath("@.[1].titulo").isEqualTo("Verificar mensagens");
    }

    @Test
    public void lerTodosByFeito() {

        Todo todo1 = new Todo(
                            UUID.randomUUID().toString(), 
                            "Participar de reunião", 
                            "", 
                            false);
        
        Mockito
            .when(repository.findByFeito(false))
            .thenReturn(Flux.just(todo1));

        client
            .get()
            .uri("/todos/false")
            .exchange()
            .expectStatus().isOk()
            .expectBody()
                .jsonPath("@.[0].titulo").isEqualTo("Participar de reunião");
    }

    @Test
    public void criarTodo() {

        Todo todo = new Todo(
                            UUID.randomUUID().toString(), 
                            "Participar de reunião", 
                            "", 
                            false);
        
        Mockito
            .when(repository.save(todo))
            .thenReturn(Mono.just(todo));

        client
            .post()
            .uri("/todos")
            .body(BodyInserters.fromValue(todo))
            .exchange()
            .expectStatus().is2xxSuccessful();
    }

    @Test
    public void deletarTodo() {

        String id = UUID.randomUUID().toString();

        Mockito
            .when(repository.deleteById(id))
            .thenReturn(Mono.empty());

        client
            .delete()
            .uri("/todos/" + id)
            .exchange()
            .expectStatus().isOk();
    }

    @Test
    public void atualizarFeito() {

        String id = UUID.randomUUID().toString();

        Todo todo1 = new Todo(
                        id, 
                        "Participar de reunião", 
                        "", 
                        false);

        Todo todo2 = new Todo(
                        id, 
                        "Participar de reunião", 
                        "", 
                        true);                        
        Mockito
            .when(repository.findById(id))
            .thenReturn(Mono.just(todo1));

        Mockito
            .when(repository.save(todo2))
            .thenReturn(Mono.just(todo2));

        client
            .put()
            .uri("/todos/" + id)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
                .jsonPath("@.feito").isEqualTo("true");
    }
}
