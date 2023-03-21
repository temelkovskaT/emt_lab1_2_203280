package com.example.lab1_2_203280.service.impl;

import com.example.lab1_2_203280.model.Author;
import com.example.lab1_2_203280.model.Book;
import com.example.lab1_2_203280.model.enumerations.Category;
import com.example.lab1_2_203280.model.exceptions.AuthorNotFoundException;
import com.example.lab1_2_203280.repository.AuthorRepository;
import com.example.lab1_2_203280.repository.BookRepository;
import com.example.lab1_2_203280.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;


    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findAll().stream().filter(b-> Objects.equals(b.getId(), id)).findFirst();
    }

    @Override
    public Optional<Book> findByNameOrAuthor(String text) {
        return bookRepository.findByNameOrAuthor(text);
    }

    @Override
    public Optional<Book> create(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findAll().stream()
                .filter(a-> a.getId().equals(authorId)).findFirst().orElseThrow(() -> new AuthorNotFoundException(authorId));

        this.bookRepository.deleteByName(name);
        return Optional.of(this.bookRepository.save(new Book(name,category,author,availableCopies)));

    }
    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }


}
