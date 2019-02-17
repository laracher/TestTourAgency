package com.example.demo.service;

import com.example.demo.domain.Orders;
import com.example.demo.domain.Tours;
import com.example.demo.domain.Users;

import java.util.List;

public interface AppService {
    // для USERS
    List<Users> getAllUsers();
    Users getOneUser(Long userId);
    Users saveUser(Users user);
    void removeUser(Long userId);
    //void bookedTour(Long idTour, Long idUser, Orders orders);

    // для TOURS
    List<Tours> getAllTours();
    Tours getOneTour(Long tourId);
    Tours saveTour(Tours tour);
    void removeTour(Long tourId);
    // для ORDERS
}
