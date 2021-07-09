package com.capgemini.hotel.service;

import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    GuestRepository guestRepository;

    public GuestServiceImpl() {
    }

    @Autowired
    public GuestServiceImpl(GuestRepository guestRepository) {

        this.guestRepository = guestRepository;
    }

    @Override
    public List<Guest> getAllGuests() {

        List<Guest> guests = guestRepository.getAllGuests();

        return guests;
    }

    @Override
    public Guest createGuest(Guest guest) {

        Guest createdGuest = null;
        try {
            createdGuest = guestRepository.createGuest(guest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return createdGuest;
    }

    @Override
    public Guest getGuestById(int id) {

        Guest guest = guestRepository.getGuestById(id);

        return guest;
    }

    @Override
    public Guest deleteGuestById(int id) {

        Guest deletedGuest = null;
        try {
            deletedGuest = guestRepository.deleteGuestById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deletedGuest;
    }

    @Override
    public Guest updateGuest(Guest guest) {

        Guest updatedGuest = null;
        try {
            updatedGuest = guestRepository.updateGuest(guest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updatedGuest;
    }
}
