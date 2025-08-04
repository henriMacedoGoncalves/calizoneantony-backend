package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user_")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, name = "okta_id")
    private String oktaId;

    @Column(nullable = false, name = "email", length = 50)
    private String email;

    @Column(nullable = false, name = "name", length = 50)
    private String name;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Workout> workouts = new HashSet<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Subscription subscription;

    public void addOrder(Order order) {

        if(order != null) {
            if(this.orders == null) {
                this.orders = new HashSet<>();
            }

            this.orders.add(order);
            order.setUser(this);
        }
    }

    public void addWorkout(Workout workout) {

        if(workout != null) {
            if(this.workouts == null) {
                this.workouts = new HashSet<>();
            }

            this.workouts.add(workout);
            workout.setUser(this);
        }
    }

    public User() {
        this.subscription = new Subscription(this);
    }
}
