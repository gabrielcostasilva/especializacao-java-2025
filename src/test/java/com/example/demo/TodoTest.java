package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TodoTest {
    
    @Test
    public void newInstance() {
        Todo todo = new Todo("a", "Participar de reunião", "Reunião de discussão", false);
        assertNotNull(todo);
    }

    @Test
    public void tituloNulo() {
        assertThrows(
            IllegalArgumentException.class, 
            () -> new Todo("a", null, "Reunião de discussão", false), 
            "Um título maior que 3 caracteres é necessário.");
    }

    @Test
    public void tituloCurto() {
        assertThrows(
            IllegalArgumentException.class, 
            () -> new Todo("a", "ab", "Reunião de discussão", false), 
            "Um título maior que 3 caracteres é necessário.");
    }
}
