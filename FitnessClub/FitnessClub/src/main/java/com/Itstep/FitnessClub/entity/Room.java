package com.Itstep.FitnessClub.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "room")
public class Room {

    @Getter
    @Setter
    @Id
    private Long id;
    private String name;
    private int capacity;

}
