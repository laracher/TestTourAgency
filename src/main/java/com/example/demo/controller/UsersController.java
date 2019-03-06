package com.example.demo.controller;

import com.example.demo.model.DTO.UsersDTO;
import com.example.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
//контроллер для пользователей
@RestController
@RequestMapping("users")
public class UsersController {

    private final AppService appService;

    @Autowired
    public UsersController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UsersDTO> getAllUsers(Map<String, Object> model){
        return appService.getAllUsers();
    }

    @RequestMapping(value = "/all/{userId}", method = RequestMethod.GET)
    public UsersDTO getOneUser(@PathVariable Long userId) {
        return appService.getOneUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UsersDTO addUser(@RequestBody UsersDTO user) {
        return appService.saveUser(user);
    }

    @RequestMapping(value = "{userId}",method = RequestMethod.PUT)
    public UsersDTO updateUser(@RequestBody UsersDTO users) {
        return appService.saveUser(users);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long userId) {
        appService.removeUser(userId);
    }
}
