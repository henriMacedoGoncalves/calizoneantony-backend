package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "set_entry")
@Data
public class SetEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "set_entry_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @Column(name = "set_number", nullable = false)
    private Long setNumber;

    @Column(name = "reps")
    private Integer reps;
}
