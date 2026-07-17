package com.Itstep.FitnessClub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
public class Subscription {

    @Id
    private Long id;
    private int trainingsLeft;
    private String status;

}
