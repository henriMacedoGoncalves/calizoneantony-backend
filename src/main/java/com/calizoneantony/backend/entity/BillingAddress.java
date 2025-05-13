package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "billing_address")
@Data
public class BillingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billing_address_id")
    private Long id;

    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "state_", nullable = false, length = 50)
    private String state;

    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;
}
