package com.Itstep.FitnessClub.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "training")
@Getter
@Setter
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingId;
    private String trainingName;
    private LocalDateTime trainingStart;
    private String trainerName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "booked_count")
    private int bookedCount;

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }
}
