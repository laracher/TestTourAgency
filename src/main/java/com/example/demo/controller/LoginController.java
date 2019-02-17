package com.example.demo.controller;

import com.example.demo.domain.Users;
import com.example.demo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/reg")
public class LoginController {

    private final AppService appService;

    @Autowired
    public LoginController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping(value = "/registation", method = RequestMethod.POST)
    public void saveUser(Map<String, Object> model, String name, String login, String password) {
        Users user = new Users();
        user.setFirstName(name);
        user.setEmail(login);
        user.setPassword(password);
        appService.saveUser(user);

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(String login, String password) {
        //HttpSession httpSession = null;

//        return httpSession.getId();

        return "login";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String main(Map<String, Object> model) {
        model.put("some", "hello, World");
        return "main";
    }

}
