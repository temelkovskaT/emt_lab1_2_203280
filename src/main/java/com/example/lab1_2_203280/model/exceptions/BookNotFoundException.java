package com.example.lab1_2_203280.model.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id) {
        super(String.format("Book with id %d is not found", id));
    }
}
