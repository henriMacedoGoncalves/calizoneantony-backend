package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id")
    private BillingAddress billingAddress;

    @Column(name = "tracking_number", nullable = false)
    private String trackingNumber;

    @Column(name = "price", nullable = false)
    private Float price;

    @CreationTimestamp
    @Column(name = "order_date")
    private Date orderDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private Set<OrderItem> orderItemSet = new HashSet<>();

    public void add(OrderItem item) {

        if (item != null) {
            if (orderItemSet == null) {
                orderItemSet = new HashSet<>();
            }

            orderItemSet.add(item);
            item.setOrder(this);
        }
    }
}
