package com.calizoneantony.backend.service;

import com.calizoneantony.backend.dao.UserRepository;
import com.calizoneantony.backend.dto.OrderRequest;
import com.calizoneantony.backend.entity.Order;
import com.calizoneantony.backend.entity.OrderItem;
import com.calizoneantony.backend.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CheckoutService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void placeOrder(OrderRequest orderRequest) {

        Order order = new Order();

        Set<OrderItem> orderItemSet = orderRequest.getOrderItems();
        orderItemSet.forEach(item -> order.add(item));

        order.setAddress(orderRequest.getAddress());
        order.setPrice(orderRequest.getPrice());
        order.setOrderItemSet(orderRequest.getOrderItems());

        User user = orderRequest.getUser();

        User userDB = userRepository.findByEmail(user.getEmail());

        if(userDB != null) {
            user = userDB;
        }


        user.addOrder(order);

        userRepository.save(user);

    }
}
