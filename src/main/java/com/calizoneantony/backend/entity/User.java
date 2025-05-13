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

    @Column(nullable = false, name = "email", length = 50)
    private String email;

    @Column(nullable = false, name = "first_name", length = 50)
    private String firstName;

    @Column(name = "middle_name", length = 50)
    private String middleName;

    @Column(nullable = false, name = "last_name", length = 50)
    private String lastName;

    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(nullable = false, name = "password_", length = 50)
    private String password;

    // "GOOGLE", "LOCAL"
    @Column(nullable = false, name = "provider", length = 50)
    private String provider;

    // User id from providers
    @Column(nullable = false, name = "provider_id", length = 50)
    private String providerId;

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
