package com.example.lab1_2_203280.service.impl;

import com.example.lab1_2_203280.model.Author;
import com.example.lab1_2_203280.model.Book;
import com.example.lab1_2_203280.model.dto.BookDto;
import com.example.lab1_2_203280.model.enumerations.Category;
import com.example.lab1_2_203280.model.exceptions.AuthorNotFoundException;
import com.example.lab1_2_203280.model.exceptions.BookNotFoundException;
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
        return bookRepository.findById(id);

    }

    @Override
    public Optional<Book> findByNameOrAuthor(String text) {
        return bookRepository.findByNameOrAuthor(text);
    }

    @Override
    public Optional<Book> create(String name, Category category, Long authorId, Integer availableCopies) {
        Author author = this.authorRepository.findById(authorId).orElseThrow(()->new AuthorNotFoundException(authorId));

        this.bookRepository.deleteByName(name);

        Book book = new Book(name,category,author,availableCopies);
        this.bookRepository.save(book);

        return Optional.of(book);

    }


    @Override
    public Optional<Book> create(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        this.bookRepository.deleteByName(bookDto.getName());

        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));

        book.setId(id);
        book.setName(name);
        book.setCategory(category);

        Author author = this.authorRepository.findById(authorId).orElseThrow(()->new AuthorNotFoundException(authorId));
        book.setAuthor(author);

        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);
        return Optional.of(book);

    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthorId()).orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthorId()));
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());

       book.setId(id);
       book.setName(bookDto.getName());
       book.setCategory(bookDto.getCategory());
       book.setAuthor(author);
       book.setAvailableCopies(bookDto.getAvailableCopies());

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public void markAsRented(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(()-> new BookNotFoundException(id));
        book.setRented(true);
        book.setAvailableCopies(book.getAvailableCopies() - 1);
    }
}
