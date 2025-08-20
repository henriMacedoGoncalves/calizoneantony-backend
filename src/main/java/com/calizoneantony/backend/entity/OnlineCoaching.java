package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "online_coaching")
@Getter
@Setter
public class OnlineCoaching {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "duration_days")
    private int durationDays;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "folder_path")
    private String folderPath;
}
