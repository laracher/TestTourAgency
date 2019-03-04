package com.example.demo.service;

import com.example.demo.model.DTO.OrdersDTO;
import com.example.demo.model.DTO.ToursDTO;
import com.example.demo.model.DTO.UsersDTO;
import com.example.demo.model.domain.Orders;
import com.example.demo.model.domain.Tours;
import com.example.demo.model.domain.Users;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.repository.ToursRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// реализация сервиса с CRUD-методами
// нельзя из контроллера напрямую обращаться в репозиторий, сделаем сервисный слой
// также нельзя отдавать контроллеру сущности, поэтому методы сервиса конвертируют сущности в DTO
@Service
public class AppServiceImpl implements AppService {
    //подключаем репозитории
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ToursRepository toursRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    //получаем список всех пользователей из репозитория,
    // конвертируем его в список DTO и возвращаем контроллеру
    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> usersList = usersRepository.findAll();
        List<UsersDTO> usersDTOList = new ArrayList<>();
        for (Users users : usersList) {
            usersDTOList.add(MappingUtils.convertUsersToDTO(users));
        }
        return usersDTOList;
    }

    //получаем одного пользователя из репозитория, ковертируем в DTO для контроллера
    @Override
    public UsersDTO getOneUser(Long userId) {
        Users byId = usersRepository.getOne(userId);
        UsersDTO usersDTO = MappingUtils.convertUsersToDTO(byId);
        return usersDTO;
    }

    //чтобы сохранить пользователя в БД, нужно пришедшего из контроллера DTO
    //конвертировать в сущность, сохранить и обратно конвертировать в DTO, чтобы вернуть в контроллер
    @Override
    public UsersDTO saveUser(UsersDTO usersDTO) {
        Users users = MappingUtils.convertUsersDtoToEntity(usersDTO);
        usersRepository.save(users);
        UsersDTO newUserDTO = MappingUtils.convertUsersToDTO(users);
        return newUserDTO;
    }

    //операции удаления пользователя из БД
    @Override
    public void removeUser(Long userId) {
        usersRepository.deleteById(userId);
    }

    //CRUD для туров аналогичен пользовательскому
    @Override
    public List<ToursDTO> getAllTours() {
        List<Tours> toursList = toursRepository.findAll();
        List<ToursDTO> toursDTOList = new ArrayList<>();
        for (Tours tour : toursList) {
            toursDTOList.add(MappingUtils.convertToursToDTO(tour));
        }
        return toursDTOList;
    }

    @Override
    public ToursDTO getOneTour(Long tourId) {
        Tours byId = toursRepository.getOne(tourId);
        ToursDTO toursDTO = MappingUtils.convertToursToDTO(byId);
        return toursDTO;
    }

    @Override
    public ToursDTO saveTour(ToursDTO toursDTO) {
        Tours tours = MappingUtils.convertToursDtoToEntity(toursDTO);
        toursRepository.save(tours);
        ToursDTO dto = MappingUtils.convertToursToDTO(tours);
        return dto;
    }

    @Override
    public void removeTour(Long tourId) {
        toursRepository.deleteById(tourId);
    }
    //CRUD для заказов аналогичен пользовательскому
    @Override
    public List<OrdersDTO> getAllOrders() {
        List<Orders> ordersList = ordersRepository.findAll();
        List<OrdersDTO> ordersDTOList = new ArrayList<>();
        for (Orders orders : ordersList) {
            ordersDTOList.add(MappingUtils.convertOrdersToDTO(orders));
        }
        return ordersDTOList;
    }

    @Override
    public OrdersDTO getOneOrder(Long orderId) {
        Orders byId = ordersRepository.getOne(orderId);
        OrdersDTO ordersDTO = MappingUtils.convertOrdersToDTO(byId);
        return ordersDTO;
    }

    @Override
    public OrdersDTO saveOrder(OrdersDTO ordersDTO) {
        Orders orders = MappingUtils.convertOrdersDtoToEntity(ordersDTO);
        ordersRepository.save(orders);
        OrdersDTO dto = MappingUtils.convertOrdersToDTO(orders);
        return dto;
    }

    @Override
    public void removeOrder(Long ordersId) {
        ordersRepository.deleteById(ordersId);
    }

}
