package com.Itstep.FitnessClub.repository;

import com.Itstep.FitnessClub.entity.Room;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Хранит информацию о залах: вместительность + свободные места.
 */
@Repository
@RequiredArgsConstructor
@Getter
@Setter
public class RoomRepository {

    List<Room> rooms = new ArrayList<>(3);

    public Room createRoom(Room room) {
        rooms.add(room);
        return room;
    }

}
