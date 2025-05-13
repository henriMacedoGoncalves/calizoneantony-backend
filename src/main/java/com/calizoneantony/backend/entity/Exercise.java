package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="exercise")
@Data
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="exercise_id")
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "folder_path", nullable = false, length = 50)
    private String folderPath;
}
