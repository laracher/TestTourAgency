package com.example.demo.repository;

import com.example.demo.model.domain.Tours;
import org.springframework.data.jpa.repository.JpaRepository;
 //доступ к турам в БД
public interface ToursRepository extends JpaRepository<Tours, Long> {}
