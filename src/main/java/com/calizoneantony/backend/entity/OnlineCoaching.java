package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "online_coaching")
@Data
public class OnlineCoaching {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "online_coaching_id")
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "duration_days", nullable = false)
    private Integer durationDays;

    @Column(name = "price", nullable = false)
    private Float price;
}
