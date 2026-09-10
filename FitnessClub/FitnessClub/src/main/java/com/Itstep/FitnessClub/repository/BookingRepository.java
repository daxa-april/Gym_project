package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.entity.Booking;
import com.Itstep.FitnessClub.entity.Client;
import com.Itstep.FitnessClub.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Хранит записи на тренировки.
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Integer countByTraining(Training training);

    boolean existsByClientAndTraining(Client client, Training training);

}
