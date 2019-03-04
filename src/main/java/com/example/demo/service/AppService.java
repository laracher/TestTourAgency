package com.example.demo.service;

import com.example.demo.model.DTO.OrdersDTO;
import com.example.demo.model.DTO.ToursDTO;
import com.example.demo.model.DTO.UsersDTO;

import java.util.List;
//сервис, предоставляющий CRUD-методы для пользователей, туров и заказов
public interface AppService {
    // для USERS
    List<UsersDTO> getAllUsers();
    UsersDTO getOneUser(Long userId);
    UsersDTO saveUser(UsersDTO usersDTO);
    void removeUser(Long userId);
    //void bookedTour(Long idTour, Long idUser, Orders orders);

    // для TOURS
    List<ToursDTO> getAllTours();
    ToursDTO getOneTour(Long tourId);
    ToursDTO saveTour(ToursDTO toursDTO);
    void removeTour(Long tourId);

    // для ORDERS
    List<OrdersDTO> getAllOrders();
    OrdersDTO getOneOrder(Long orderId);
    OrdersDTO saveOrder(OrdersDTO ordersDTO);
    void removeOrder(Long ordersId);
}
