package com.example.demo.repository;

import com.example.demo.domain.Tours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToursRepository extends JpaRepository<Tours, Long> {}
