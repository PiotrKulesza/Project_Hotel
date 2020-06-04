package com.project.hotel.services;

import com.project.hotel.models.Reservation;
import com.project.hotel.repositories.ReservationRepository;
import com.project.hotel.repositories.RoomRepository;
import com.project.hotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements IReservationService{
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationsByUser(String userId) {
        return reservationRepository.findAllByUser(userRepository.findById(userId).get());
    }

    @Override
    public List<Reservation> getReservationsByRoom(String roomId) {
        return reservationRepository.findAllByRoom(roomRepository.findById(roomId).get());
    }

    @Override
    public List<Reservation> getReservationsByRoomAndUser(String roomId, String userId) {
        return reservationRepository.findAllByRoomAndUser(roomRepository.findById(roomId).get(), userRepository.findById(userId).get());
    }

    @Override
    public Reservation getReservationById(String reservationId) {
        return reservationRepository.findById(reservationId).get();
    }

    @Override
    public void postReservation(Reservation reservation) {



    }

    @Override
    public void putReservation(Reservation reservation) {

    }

    @Override
    public boolean deleteReservation(String reservationId) {
        reservationRepository.deleteById( reservationId);
        return reservationRepository.existsById(reservationId) == false;
    }
}
