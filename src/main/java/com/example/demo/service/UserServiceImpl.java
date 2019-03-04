package com.example.demo.service;

import com.example.demo.model.DTO.LoginDTO;
import com.example.demo.model.DTO.UsersDTO;
import com.example.demo.model.domain.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.utils.MappingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//реализация сервиса авторизации пользователей
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //из полученных в форме входа Spring данных берем значения свойств
    // LoginDTO и устанавливаем их у UsersDTO,
    //затем сохраняем конвертированную сущность в БД
    @Override
    public UsersDTO createUser(LoginDTO loginDTO) {
        UsersDTO userDTO = new UsersDTO();
        userDTO.setUsername(loginDTO.getLogin());
        userDTO.setPassword(bCryptPasswordEncoder.encode(loginDTO.getPassword()));
        userDTO.setActive(true);

        Users userEntity = MappingUtils.convertUsersDtoToEntity(userDTO);

        userRepository.save(userEntity);

        UsersDTO newUserDTO = MappingUtils.convertUsersToDTO(userEntity);
        return newUserDTO;
    }

    //находим пользователя по его login в БД для входа в систему,
    // т. е. проверяем, существует ли пользователь с таким Username
    @Override
    public UsersDTO findByLogin(String username) {
        Users newUser = userRepository.findByUsername(username);
        UsersDTO userDTO = MappingUtils.convertUsersToDTO(newUser);

        return userDTO;
    }

    //получение данных пользователя по его username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users byUsername = userRepository.findByUsername(username);

        return byUsername;
    }
}