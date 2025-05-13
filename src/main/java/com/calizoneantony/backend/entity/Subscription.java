package com.calizoneantony.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "subscription_")
@Data
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscription_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "is_active")
    private Boolean isActive;

    public Subscription(User user) {
        this.user = user;
        this.isActive = false;
    }

    public void checkIsActive() {
        Date date = new Date();

        if(endDate != null) {
            if(endDate.after(date)) {
                this.isActive = true;
            } else {
                this.isActive = false;
            }
        }
    }

    public void addDays(int days) {
        Calendar calendar = Calendar.getInstance();

        if(this.isActive) {
            calendar.setTime(endDate);
            calendar.add(Calendar.DAY_OF_YEAR, days);
            this.endDate = calendar.getTime();
        } else {
            Date currentDate = new Date();
            calendar.setTime(currentDate);
            this.isActive = true;
            this.startDate = calendar.getTime();
            calendar.add(Calendar.DAY_OF_YEAR, days);
            this.endDate = calendar.getTime();
        }
    }
}
