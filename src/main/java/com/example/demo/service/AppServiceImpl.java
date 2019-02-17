package com.example.demo.service;

import com.example.demo.domain.Orders;
import com.example.demo.domain.Tours;
import com.example.demo.domain.Users;
import com.example.demo.repository.ToursRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ToursRepository toursRepository;

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getOneUser(Long userId) {
        return usersRepository.getOne(userId);
    }

    @Override
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public void removeUser(Long userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public List<Tours> getAllTours() {
        return toursRepository.findAll();
    }

    @Override
    public Tours getOneTour(Long tourId) {
        return toursRepository.getOne(tourId);
    }

    @Override
    public Tours saveTour(Tours tour) {
        return toursRepository.save(tour);
    }

    @Override
    public void removeTour(Long tourId) {
        toursRepository.deleteById(tourId);
    }

//    @Override
//    public void bookedTour(Long idTour, Long idUser, Orders orders) {
//
//        toursRepository.getOne(idTour).getTourId();
//        usersRepository.getOne(idUser).getUserId();
//        orders.setUser(usersRepository.getOne(idUser));
//        orders.setTour(toursRepository.getOne(idTour));
//    }
}
