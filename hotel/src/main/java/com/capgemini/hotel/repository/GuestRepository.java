package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Guest;

import java.util.List;

public interface GuestRepository {

    public List<Guest> getAllGuests();

    public Guest createGuest(Guest guest) throws Exception;

    public Guest getGuestById(int id);

    public Guest deleteGuestById(int id) throws Exception;

    public Guest updateGuest(Guest guest) throws Exception;

}
