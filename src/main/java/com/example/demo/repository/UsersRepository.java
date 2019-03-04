package com.example.demo.repository;

import com.example.demo.model.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
//доступ к пользователям в БД
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username); //метод для авторизации
}
