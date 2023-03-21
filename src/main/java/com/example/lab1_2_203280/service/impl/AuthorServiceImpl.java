package com.example.lab1_2_203280.service.impl;

import com.example.lab1_2_203280.model.Author;
import com.example.lab1_2_203280.repository.AuthorRepository;
import com.example.lab1_2_203280.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> listById(Long id) {
        return this.authorRepository.findAll().stream().filter(a -> Objects.equals(a.getId(), id)).findFirst();
    }
}
