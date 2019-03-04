package com.example.demo.controller;

import com.example.demo.model.DTO.OrdersDTO;
import com.example.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//контроллер для заказов
@Controller
@RequestMapping("orders")
public class OrdersController {
    private final AppService appService;

    @Autowired
    public OrdersController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<OrdersDTO> getAllOrders() {
        return appService.getAllOrders();
    }

    @RequestMapping(value = "{orderId}", method = RequestMethod.GET)
    public OrdersDTO getOneOrder(@PathVariable("orderId") Long orderId) {
        return appService.getOneOrder(orderId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public OrdersDTO addOrder(@RequestBody OrdersDTO order) {
        return appService.saveOrder(order);
    }

    @RequestMapping(value = "{orderId}", method = RequestMethod.PUT)
    public OrdersDTO updateOrder(@RequestBody OrdersDTO ordersDTO) {
        return appService.saveOrder(ordersDTO);
    }

    @RequestMapping(value = "{orderId}", method = RequestMethod.DELETE)
    public void removeOrder(@PathVariable("orderId") Long orderId) {
        appService.removeOrder(orderId);
    }
}
