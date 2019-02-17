//package com.example.demo.service;
//
//import com.example.demo.domain.Users;
//import com.example.demo.repository.UsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.util.StringUtils;
//
//import java.util.Collection;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//public class UserService implements UserDetailsService {
//    @Autowired
//    private UsersRepository userRepo;
//
//
////    @Override
////    @Transactional(readOnly = true)
////    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        Users user = userRepo.findByUsername(username);
////
////        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
////        for (Role role : user.getRoles()){
////            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
////        }
////
////        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
////    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users user = userRepo.findByUsername(username);
//        return new UserServiceImpl(user);
//    }
//
//
//}
