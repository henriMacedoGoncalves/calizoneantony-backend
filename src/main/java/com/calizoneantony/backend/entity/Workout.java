package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="workout")
@Getter
@Setter
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "workout")
    private Set<Session> sessions = new HashSet<>();

    public void add(Session session) {

        if(session != null) {
            if(this.sessions == null) {
                this.sessions = new HashSet<>();
            }

            this.sessions.add(session);
            session.setWorkout(this);
        }
    }
}
