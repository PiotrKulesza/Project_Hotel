package com.project.hotel.repositories;

import com.project.hotel.models.Reservation;
import com.project.hotel.models.Room;
import com.project.hotel.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReservationRepository extends MongoRepository<Reservation,String> {

    List<Reservation> findAllByUser(User user);
    List<Reservation> findAllByRoom(Room room);
    List<Reservation> findAllByRoomAndUser(Room room, User user);

}
