package com.example.lab1_2_203280.model.dto;


import com.example.lab1_2_203280.model.Author;
import com.example.lab1_2_203280.model.enumerations.Category;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class BookDto {

    private String name;

    private Category category;

    private Long authorId;

    private Integer availableCopies;

    private boolean isRented;

    public BookDto(String name, Category category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
        this.isRented = false;
    }
}
