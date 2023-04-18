package com.example.lab1_2_203280.repository;

import com.example.lab1_2_203280.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    void deleteByName(String name);


}
