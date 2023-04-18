package com.example.lab1_2_203280.service;


import com.example.lab1_2_203280.model.Author;
import com.example.lab1_2_203280.model.Book;
import com.example.lab1_2_203280.model.dto.BookDto;
import com.example.lab1_2_203280.model.enumerations.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);


    Optional<Book> create(String name, Category category,Long authorId,  Integer availableCopies);

    Optional<Book> create(BookDto bookDto);

    Optional<Book> edit(Long id, String name,  Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> markAsRented(Long id);


    /*
    * За да се обележи книгата како изнајмена треба преку повик до API да се намали бројот на available copies
    * */





}
