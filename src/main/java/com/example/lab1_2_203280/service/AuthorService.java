package com.example.lab1_2_203280.service;

import com.example.lab1_2_203280.model.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> listAll();

    Optional<Author> listById(Long id);




}
