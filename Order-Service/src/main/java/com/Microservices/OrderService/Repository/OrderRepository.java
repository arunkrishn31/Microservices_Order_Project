package com.Microservices.OrderService.Repository;

import com.Microservices.OrderService.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
