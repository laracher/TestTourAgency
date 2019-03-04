package com.example.demo.utils;

import com.example.demo.model.DTO.OrdersDTO;
import com.example.demo.model.DTO.ToursDTO;
import com.example.demo.model.DTO.UsersDTO;
import com.example.demo.model.domain.Orders;
import com.example.demo.model.domain.Tours;
import com.example.demo.model.domain.Users;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

//класс утилит для конвертации entity в DTO и DTO в entity
public final class MappingUtils {
    private MappingUtils(){}

    //метод для конвертации Users в UsersDTO
    public static UsersDTO convertUsersToDTO(Users users) {
        ModelMapper modelMapper = new ModelMapper();    //маппер

        //получаем список заказов у объекта сущности Users и конвертируем его в список заказов-ДТО
        List<Orders> ordersList = users.getListOrders();
        List<OrdersDTO> ordersDTOList = new ArrayList<>();
        if (ordersList != null) {
            for (Orders order: ordersList) {
                ordersDTOList.add(modelMapper.map(order, OrdersDTO.class));
            }
        }
        UsersDTO usersDTO = modelMapper.map(users, UsersDTO.class);
        users.setListOrders(ordersList);

        return usersDTO;

    }
    //метод для конвертации UsersDTO в сущность Users
    public static Users convertUsersDtoToEntity(UsersDTO usersDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Users user = modelMapper.map(usersDTO, Users.class);
        return user;
    }
    //метод для конвертации Tours в ToursDTO
    public static ToursDTO convertToursToDTO(Tours tours) {
        ModelMapper modelMapper = new ModelMapper();

        //получаем список заказов у объекта сущности Tours и конвертируем его в список заказов-ДТО
        List<Orders> ordersList = tours.getListOrders();
        List<OrdersDTO> ordersDTOList = new ArrayList<>();
        if (ordersList != null) {
            for (Orders order: ordersList) {
                ordersDTOList.add(modelMapper.map(order, OrdersDTO.class));
            }
        }
        ToursDTO toursDTO = modelMapper.map(tours, ToursDTO.class);
        toursDTO.setListOrders(ordersDTOList);

        return toursDTO;
    }
    //метод для конвертации ToursDTO в сущность Tours
    public static Tours convertToursDtoToEntity(ToursDTO toursDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Tours tour = modelMapper.map(toursDTO, Tours.class);
        return tour;
    }
    //метод для конвертации Orders в OrdersDTO
    public static OrdersDTO convertOrdersToDTO(Orders orders) {
        ModelMapper modelMapper = new ModelMapper();
        OrdersDTO ordersDTO = modelMapper.map(orders, OrdersDTO.class);
        return ordersDTO;
    }
    //метод для конвертации OrdersDTO в сущность Orders
    public static Orders convertOrdersDtoToEntity(OrdersDTO ordersDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Orders orders = modelMapper.map(ordersDTO, Orders.class);
        return orders;
    }

}
