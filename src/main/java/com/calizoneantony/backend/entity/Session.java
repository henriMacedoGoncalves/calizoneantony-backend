package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "session_")
@Data
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id")
    private Long sessionId;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @Column(name = "session_number", nullable = false)
    private Long sessionNumber;
}
