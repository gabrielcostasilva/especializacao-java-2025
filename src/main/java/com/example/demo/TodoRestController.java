package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TodoRestController {
    
    private final TodoRepository repository;

    public TodoRestController(final TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    public Flux<Todo> lerTodos() {
        return repository.findAll();
    }

    @GetMapping("/todos/{feito}")
    public Flux<Todo> lerByFeito(@PathVariable boolean feito) {
        return repository.findByFeito(feito);
    }

    @PostMapping("/todos")
    public Mono<Todo> criar(@RequestBody Todo todo) {
        return repository.save(todo);
    }

    @DeleteMapping("/todos/{id}")
    public Mono<Void> deletar(@PathVariable String id) {
        return repository.deleteById(id);
    }

    @PutMapping("/todos/{id}")
    public Mono<Todo> atualizar(@PathVariable String id) {

        return repository
                    .findById(id)
                    .map(todoAtual -> new Todo(id, 
                                            todoAtual.titulo(), 
                                            todoAtual.descricao(), 
                                            !todoAtual.feito()))
                    .flatMap(repository::save)
                    .onTerminateDetach();
    }

}
