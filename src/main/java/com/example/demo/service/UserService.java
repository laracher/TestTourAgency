package com.example.demo.service;

import com.example.demo.model.DTO.LoginDTO;
import com.example.demo.model.DTO.UsersDTO;
//сервис для авторизации пользователей
public interface UserService {
    UsersDTO createUser(LoginDTO loginDTO);
    UsersDTO findByLogin(String username);
}
