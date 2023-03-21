package com.example.lab1_2_203280.model.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(Long id) {
        super(String.format("Author with id:%d is not found", id));
    }
}
