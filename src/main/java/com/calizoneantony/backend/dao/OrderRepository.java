package com.calizoneantony.backend.dao;

import com.calizoneantony.backend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
