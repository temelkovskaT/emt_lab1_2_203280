package com.example.lab1_2_203280.service;


import com.example.lab1_2_203280.model.Author;
import com.example.lab1_2_203280.model.Book;
import com.example.lab1_2_203280.model.enumerations.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByNameOrAuthor(String text);

    Optional<Book> create(String name, Category category,Long authorId,  Integer availableCopies);
    /*
    * Види дали да правиш за Dto
    * */

    Optional<Book> edit(Long id, String name,  Category category, Long authorId, Integer availableCopies);

    void deleteById(Integer id);

    /*
    * За да се обележи книгата како изнајмена треба преку повик до API да се намали бројот на available copies
    * */





}
