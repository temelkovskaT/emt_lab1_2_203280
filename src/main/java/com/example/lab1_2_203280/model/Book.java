package com.example.lab1_2_203280.model;


import com.example.lab1_2_203280.model.enumerations.Category;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;


@Data
@Entity
public class Book {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

//    private boolean isRented;

    public Book() {
    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }


}
