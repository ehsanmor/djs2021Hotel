package com.capgemini.hotel.service;

import com.capgemini.hotel.model.Reservation;
import com.capgemini.hotel.model.Room;

import java.util.List;

public interface ReservationService {

    public List<Reservation> getAllReservations();

    public Reservation createReservation(Reservation reservation);

    public Reservation getReservationById(int id);

    public Reservation deleteReservationById(int id);

    public Reservation updateReservation(Reservation reservation);

     public double getPrice(Room room, String startDate, String endDate);
}
