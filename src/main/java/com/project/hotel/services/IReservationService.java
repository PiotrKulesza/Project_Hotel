package com.project.hotel.services;

import com.project.hotel.models.Reservation;

import java.util.List;

public interface IReservationService {

    public List<Reservation> getReservations();
    public List<Reservation> getReservationsByUser(String userId);
    public List<Reservation> getReservationsByRoom(String roomId);
    public List<Reservation> getReservationsByRoomAndUser(String roomId, String userId);
    public Reservation getReservationById(String reservationId);
    public void postReservation( String roomId, String userId, Reservation reservation);
    public void putReservation(Reservation reservation);
    public boolean deleteReservation(String reservationId);

}
