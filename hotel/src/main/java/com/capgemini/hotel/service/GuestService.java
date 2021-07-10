package com.capgemini.hotel.service;

import com.capgemini.hotel.model.Guest;

import java.util.List;

public interface GuestService {

    public List<Guest> getAllGuests();

    public Guest createGuest(Guest guest);

    public Guest getGuestById(int id);

    public Guest deleteGuestById(int id);

    public Guest updateGuest(Guest guest);
}
