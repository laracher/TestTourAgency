package com.example.demo.repository;

import com.example.demo.model.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

// доступ к заказам в БД
public interface OrdersRepository extends JpaRepository<Orders, Long> {}
