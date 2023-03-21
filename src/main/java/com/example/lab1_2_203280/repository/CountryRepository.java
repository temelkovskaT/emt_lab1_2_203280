package com.example.lab1_2_203280.repository;

import com.example.lab1_2_203280.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CountryRepository extends JpaRepository<Country, Long> {
}
