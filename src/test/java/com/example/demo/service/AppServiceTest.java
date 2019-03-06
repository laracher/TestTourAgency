package com.example.demo.service;

import com.example.demo.model.DTO.OrdersDTO;
import com.example.demo.model.DTO.ToursDTO;
import com.example.demo.model.DTO.UsersDTO;
import com.example.demo.model.domain.Tours;
import com.example.demo.model.domain.Users;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.repository.ToursRepository;
import com.example.demo.repository.UsersRepository;
import com.example.demo.utils.MappingUtils;
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
@ActiveProfiles("test") //ищет property для тестов
//очищаем БД перед выполнением каждого метода
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional //инициализируем списки у entity
public class AppServiceTest {

    //подключаем сервис и репозитории
    @Autowired
    private AppService appService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ToursRepository toursRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    //предварительно создаем пользователей, заказы и туры в тестовой БД
    @Before
    public void setUp() {
        UsersDTO user1 = new UsersDTO();
        user1.setFirstName("Vasya");
        user1.setLastName("Pupkin");
        user1.setUsername("vaspup@mail.ru");
        user1.setPassword("123");
        user1.setActive(false);
        user1.setBirthday(new Timestamp(1549811226));

        List<UsersDTO> usersList = new ArrayList<>();
        usersList.add(user1);

        ToursDTO tour1 = new ToursDTO();
        tour1.setName("Tour in Russia");
        tour1.setDescription("The best tour");
        tour1.setLocation("Russia");
        tour1.setStartDate(new Timestamp(1549811226));
        tour1.setEndDate(new Timestamp(1549811226));
        tour1.setCountLimit(15);

        List<ToursDTO> toursList = new ArrayList<>();
        toursList.add(tour1);

        OrdersDTO order1 = new OrdersDTO();
        order1.setConfirmed(false);
        order1.setTimeKey(new Timestamp(1549811226));
        order1.setUsersDTO(user1);
        order1.setToursDTO(tour1);

        List<OrdersDTO> ordersList = new ArrayList<>();
        ordersList.add(order1);

        UsersDTO user2 = new UsersDTO();
        user2.setFirstName("Ivan");
        user2.setLastName("Ivanov");
        user2.setUsername("ivanov@mail.ru");
        user2.setPassword("321");
        user2.setActive(false);
        user2.setBirthday(new Timestamp(1549811226));
        user2.setListOrders(ordersList);
        appService.saveUser(user2);

        ToursDTO tour2 = new ToursDTO();
        tour2.setName("Tour in India");
        tour2.setDescription("The best tour");
        tour2.setLocation("India");
        tour2.setStartDate(new Timestamp(1549811226));
        tour2.setEndDate(new Timestamp(1549811226));
        tour2.setCountLimit(15);
        tour2.setListOrders(ordersList);

        appService.saveTour(tour2);
        appService.saveOrder(order1);
    }

    // получение всех пользователей
    @Test
    public void getAllUsers() {
        List<Users> usersList = usersRepository.findAll();
        List<UsersDTO> newDtoList = new ArrayList<>();

        for (Users users: usersList) {
            newDtoList.add(MappingUtils.convertUsersToDTO(users));
        }
        List<UsersDTO> usersDTOList = appService.getAllUsers();
        //сравниваем список, который отправили в репозиторий и список, полученный из сервиса
        assertEquals(newDtoList, usersDTOList);
    }

    //тестирование сохранения пользователя.
    // Для этого создаем пользователя, тур и заказ
    // в соответствиии с отношениями между таблицами в БД
    @Test
    public void saveUser() {
        ToursDTO newTour = new ToursDTO();
        newTour.setName("Tour in Latvia");
        newTour.setDescription("The best tour");
        newTour.setLocation("Latvia");
        newTour.setStartDate(new Timestamp(1549811226));
        newTour.setEndDate(new Timestamp(1549811226));
        newTour.setCountLimit(15);

        List<ToursDTO> toursList = new ArrayList<>();
        toursList.add(newTour);

        UsersDTO newUser = new UsersDTO();
        newUser.setFirstName("Petr");
        newUser.setLastName("Karpov");
        newUser.setUsername("kotvmeshke@gmail.com");
        newUser.setPassword("456");
        newUser.setActive(false);
        newUser.setBirthday(new Timestamp(1549811226));

        List<UsersDTO> usersList = new ArrayList<>();
        usersList.add(newUser);

        OrdersDTO newOrder = new OrdersDTO();
        newOrder.setConfirmed(false);
        newOrder.setTimeKey(new Timestamp(1549811226));
        newOrder.setUsersDTO(newUser);
        newOrder.setToursDTO(newTour);

        appService.saveUser(newUser);
        appService.saveTour(newTour);
        UsersDTO user = appService.getOneUser(6L);

        assertEquals(user, newUser);
    }

    //изменение пользователя
    @Test
    public void updateUser() {
        //получаем пользователя из сервиса, изменяем его имя
        UsersDTO oldUser = appService.getOneUser(1L);
        oldUser.setFirstName("IGOR");
        // сохраняем измененного пользователя в сервис

        appService.saveUser(oldUser);

        UsersDTO newUser = appService.getOneUser(1L);
        //сравниваем пользователя, полученного после изменения
        // и пользователя, которого получили перед изменением
        assertEquals(newUser, oldUser);
    }
    //удаление пользователя
    @Test
    public void removeUser() {
        // считаем количество строк в тестовой БД
        long countRows = usersRepository.count();
        System.out.println("строк " + countRows);
        assertEquals(1, countRows);
        // удаляем пользователя
        appService.removeUser(1L);
        //снова считаем количество строк в БД и сравниваем его с первым значением,
        // если строк меньше, значит удаление прошло успешно
        countRows = usersRepository.count();
        assertEquals(0, countRows);
    }

    // тестирование CRUD для туров
    @Test
    public void getAllTours() {
        List<Tours> toursList = toursRepository.findAll();
        List<ToursDTO> newDtoList = new ArrayList<>();

        for (Tours tours: toursList) {
            newDtoList.add(MappingUtils.convertToursToDTO(tours));
        }
        List<ToursDTO> toursDTOList = appService.getAllTours();
        assertEquals(newDtoList, toursDTOList);
    }

    @Test
    public void saveTour() {
        UsersDTO user = new UsersDTO();
        user.setFirstName("Lilia");
        user.setLastName("Zorina");
        user.setUsername("lil@mail.ru");
        user.setPassword("555");
        user.setActive(false);
        user.setBirthday(new Timestamp(1549811226));

        List<UsersDTO> usersList = new ArrayList<>();
        usersList.add(user);

        ToursDTO newTour = new ToursDTO();
        newTour.setName("Tour Japan");
        newTour.setDescription("New Tour in Japan");
        newTour.setLocation("Japan");
        newTour.setStartDate(new Timestamp(1549811226));
        newTour.setEndDate(new Timestamp(1549811226));
        newTour.setCountLimit(10);

        List<ToursDTO> toursList = new ArrayList<>();
        toursList.add(newTour);

        OrdersDTO order = new OrdersDTO();
        order.setConfirmed(false);
        order.setTimeKey(new Timestamp(1549811226));
        order.setUsersDTO(user);
        order.setToursDTO(newTour);

        appService.saveUser(user);
        appService.saveTour(newTour);
        appService.saveOrder(order);

        ToursDTO tour = appService.getOneTour(7L);

        assertEquals(tour, newTour);
    }

    @Test
    public void updateTour() {
        ToursDTO oldTour = appService.getOneTour(3L);
        System.out.println("Название тура " + oldTour.getName());
        oldTour.setName("RUSSIA THE BEST!");
        appService.saveTour(oldTour);
        ToursDTO newTour = appService.getOneTour(3L);
        System.out.println("Название тура " + newTour.getName());
        assertEquals(newTour, oldTour);
    }

    @Test
    public void removeTour() {
        long countRows = toursRepository.count();
        System.out.println("строк " + countRows);
        assertEquals(1, countRows);

        appService.removeTour(3L);

        countRows = toursRepository.count();
        assertEquals(0, countRows);
    }
}
