package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Reservation;
import com.capgemini.hotel.model.Room;

import java.util.List;

public interface ReservationRepository {

    public List<Reservation> getAllReservations();

    public Reservation createReservation(Reservation reservation) throws Exception;

    public Reservation getReservationById(int id);

    public Reservation deleteReservationById(int id) throws Exception;

    public Reservation updateReservation(Reservation reservation) throws Exception;

     public double getPrice(Room room, String startDate, String endDate);
}
