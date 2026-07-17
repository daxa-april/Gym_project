package com.Itstep.FitnessClub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Client {

    @Id
    private Long id;
    private String fullName;
    private String email;
    private String phone;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_info")
    private Subscription subscription;

}
