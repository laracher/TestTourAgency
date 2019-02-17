package com.example.demo.service;

import com.example.demo.domain.Orders;
import com.example.demo.domain.Tours;
import com.example.demo.domain.Users;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.repository.ToursRepository;
import com.example.demo.repository.UsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
public class AppServiceTest {
    @Autowired
    private AppService appService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ToursRepository toursRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Before
    public void setUp() {
        Users user1 = new Users();
        user1.setFirstName("Vasya");
        user1.setLastName("Pupkin");
        user1.setEmail("vaspup@mail.ru");
        user1.setPassword("123");
        user1.setActive(false);
        user1.setBirthday(new Timestamp(1549811226));

        List<Users> usersList = new ArrayList<>();
        usersList.add(user1);

        Tours tour1 = new Tours();
        tour1.setName("Tour in Russia");
        tour1.setDescription("The best tour");
        tour1.setLocation("Russia");
        tour1.setStartDate(new Timestamp(1549811226));
        tour1.setEndDate(new Timestamp(1549811226));
        tour1.setCountLimit(15);

        List<Tours> toursList = new ArrayList<>();
        toursList.add(tour1);

        Orders order1 = new Orders();
        order1.setConfirmed(false);
        order1.setTimeKey(new Timestamp(1549811226));
        order1.setUser(user1);
        order1.setTour(tour1);
        ordersRepository.save(order1);

        List<Orders> ordersList = new ArrayList<>();
        ordersList.add(order1);

        Users user2 = new Users();
        user2.setFirstName("Ivan");
        user2.setLastName("Ivanov");
        user2.setEmail("ivanov@mail.ru");
        user2.setPassword("321");
        user2.setActive(false);
        user2.setBirthday(new Timestamp(1549811226));
        user2.setListOrders(ordersList);
        usersRepository.save(user2);

        Tours tour2 = new Tours();
        tour2.setName("Tour in India");
        tour2.setDescription("The best tour");
        tour2.setLocation("India");
        tour2.setStartDate(new Timestamp(1549811226));
        tour2.setEndDate(new Timestamp(1549811226));
        tour2.setCountLimit(15);
        tour2.setListOrders(ordersList);
        toursRepository.save(tour2);

        long countRows = usersRepository.count();
    }

//    @Test
//    public void getAllUsers() {
//        List<Users> usersListFromRepo = usersRepository.findAll();
//        List<Users> usersListFromService = appService.getAllUsers();
//        assertEquals(usersListFromService, usersListFromRepo);
//    }
//
//    @Test
//    public void getAllTours() {
//        List<Tours> toursListFromRepo = toursRepository.findAll();
//        List<Tours> toursListFromService = appService.getAllTours();
//        assertEquals(toursListFromRepo, toursListFromService);
//    }

    @Test
    public void saveUser() {
        Tours newTour = new Tours();
        newTour.setName("Tour in Latvia");
        newTour.setDescription("The best tour");
        newTour.setLocation("Latvia");
        newTour.setStartDate(new Timestamp(1549811226));
        newTour.setEndDate(new Timestamp(1549811226));
        newTour.setCountLimit(15);

        List<Tours> toursList = new ArrayList<>();
        toursList.add(newTour);

        Users newUser = new Users();
        newUser.setFirstName("Petr");
        newUser.setLastName("Karpov");
        newUser.setEmail("kotvmeshke@gmail.com");
        newUser.setPassword("456");
        newUser.setActive(false);
        newUser.setBirthday(new Timestamp(1549811226));

        List<Users> usersList = new ArrayList<>();
        usersList.add(newUser);

        Orders newOrder = new Orders();
        newOrder.setConfirmed(false);
        newOrder.setTimeKey(new Timestamp(1549811226));
        newOrder.setUser(newUser);
        newOrder.setTour(newTour);
        ordersRepository.save(newOrder);
        appService.saveUser(newUser);

        Users user = appService.getOneUser(8L);

        assertEquals(user, newUser);
    }

    @Test
    public void updateUser() {
        Users oldUser = appService.getOneUser(3L);
        oldUser.setFirstName("IGOR");

        appService.saveUser(oldUser);

        Users newUser = appService.getOneUser(3L);
        assertEquals(newUser, oldUser);
    }

    @Test
    public void removeUser() {
        long countRows = usersRepository.count();
        System.out.println("строк " + countRows);
        assertEquals(2, countRows);

        appService.removeUser(4L);

        countRows = usersRepository.count();
        assertEquals(1, countRows);
    }

    @Test
    public void saveTour() {
        Users user = new Users();
        user.setFirstName("Lilia");
        user.setLastName("Zorina");
        user.setEmail("lil@mail.ru");
        user.setPassword("555");
        user.setActive(false);
        user.setBirthday(new Timestamp(1549811226));

        List<Users> usersList = new ArrayList<>();
        usersList.add(user);

        Tours newTour = new Tours();
        newTour.setName("Tour Japan");
        newTour.setDescription("New Tour in Japan");
        newTour.setLocation("Japan");
        newTour.setStartDate(new Timestamp(1549811226));
        newTour.setEndDate(new Timestamp(1549811226));
        newTour.setCountLimit(10);

        List<Tours> toursList = new ArrayList<>();
        toursList.add(newTour);

        Orders order = new Orders();
        order.setConfirmed(false);
        order.setTimeKey(new Timestamp(1549811226));
        order.setUser(user);
        order.setTour(newTour);
        ordersRepository.save(order);

        Tours tour = appService.getOneTour(7L);
        assertEquals(tour, newTour);
    }

    @Test
    public void updateTour() {
        Tours oldTour = appService.getOneTour(2L);
        System.out.println("Название тура " + oldTour.getName());
        oldTour.setName("RUSSIA THE BEST!");
        appService.saveTour(oldTour);
        Tours newTour = appService.getOneTour(2L);
        System.out.println("Название тура " + newTour.getName());
        assertEquals(newTour, oldTour);
    }

    @Test
    public void removeTour() {
        long countRows = toursRepository.count();
        System.out.println("строк " + countRows);
        assertEquals(2, countRows);

        appService.removeTour(1L);

        countRows = toursRepository.count();
        assertEquals(1, countRows);
    }



}
