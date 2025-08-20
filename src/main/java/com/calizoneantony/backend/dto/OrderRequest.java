package com.calizoneantony.backend.dto;

import com.calizoneantony.backend.entity.Address;
import com.calizoneantony.backend.entity.OrderItem;
import com.calizoneantony.backend.entity.User;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class OrderRequest {

    private User user;
    private Address address;
    private Set<OrderItem> orderItems;
    private BigDecimal price;
}
