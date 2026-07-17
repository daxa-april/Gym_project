package com.Itstep.FitnessClub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Booking {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "subscription_info")
    private Subscription subscription;

}
