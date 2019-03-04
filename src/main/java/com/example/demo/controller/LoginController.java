package com.example.demo.controller;

import com.example.demo.model.DTO.LoginDTO;
import com.example.demo.model.DTO.UsersDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//контроллер для входа пользователей в систему
@RestController
@RequestMapping("/reg")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String createUser() {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String createUser(@RequestBody LoginDTO loginDTO) {

        UsersDTO createdUser = userService.createUser(loginDTO);

        return "loginSuccessful";
    }

}
