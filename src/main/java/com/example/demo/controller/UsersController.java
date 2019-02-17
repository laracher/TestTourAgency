package com.example.demo.controller;

import com.example.demo.domain.Users;
import com.example.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UsersController {

    private final AppService appService;

    @Autowired
    public UsersController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Users> getAll(Map<String, Object> model){
        List<Users> allUsers = appService.getAllUsers();
        model.put("allUsers", allUsers);
        return allUsers;
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    public Users getOne(@PathVariable Long userId) {
        return appService.getOneUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Users addUser(@RequestBody Users user) {
        return appService.saveUser(user);
    }

    @RequestMapping(value = "{userId}",method = RequestMethod.PUT)
    public Users updateUser(@RequestBody Users users) {
        return appService.saveUser(users);
    }

    @RequestMapping(value = "{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long userId) {
        appService.removeUser(userId);
    }
}

/*        <!--<span>{{email}}</span>-->
        <!--<span>{{password}}</span>-->
        <!--<span>{{active}}</span>-->
        <!--<span>{{birthday}}</span>-->*/