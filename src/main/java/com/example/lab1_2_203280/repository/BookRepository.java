package com.example.lab1_2_203280.repository;

import com.example.lab1_2_203280.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByNameOrAuthor(String name);
    void deleteByName(String name);


}
