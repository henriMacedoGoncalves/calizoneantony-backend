package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "session_")
@Getter
@Setter
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long sessionId;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;

    @Column(name = "session_number")
    private Long sessionNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "session")
    private Set<SetEntry> setEntrySet = new HashSet<>();

    public void add(SetEntry set) {

        if (set != null) {
            if(this.setEntrySet == null) {
                this.setEntrySet = new HashSet<>();
            }

            this.setEntrySet.add(set);
            set.setSession(this);
        }
    }
}
