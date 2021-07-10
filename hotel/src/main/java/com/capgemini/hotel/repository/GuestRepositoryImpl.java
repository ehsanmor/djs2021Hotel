package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Guest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GuestRepositoryImpl implements GuestRepository{

    public List<Guest> guests = new ArrayList<>();

    public GuestRepositoryImpl(){

        guests.add(new Guest(1, "Veli", "Ataseven", "veliataseven@mail.com", "password1", "0612345678", "regular", 1));
        guests.add(new Guest(2, "Yonas", "Berhe Woldemichael", "yonasberhe@gmail.com", "password2", "0622345678", "regular", 1));
        guests.add(new Guest(3, "Esra", "Tepebasi", "esratepebasi@outlook.com", "password3", "0632345678", "loyal", 4));
        guests.add(new Guest(4, "Ehsan", "Moradi", "ehsanmoradi@gmail.com", "password4", "0642345678", "VIP", 7));
        guests.add(new Guest(5, "Onder", "Icyer", "ondericyer@mail.com", "password5", "0652345678", "business", 3));
    }

    @Override
    public List<Guest> getAllGuests() {

        return guests;
    }

    @Override
    public Guest createGuest(Guest guest) throws Exception {

        for (Guest guestToFind : guests) {
            if (guestToFind.getId() == guest.getId()) {
                throw new Exception("Guest is exist!");
            }
        }

        guests.add(guest);

        return guest;
    }

    @Override
    public Guest getGuestById(int id) {

        for (Guest guest: guests) {

            if(guest.getId() == id){
                return  guest;
            }
        }

        return null;
    }

    @Override
    public Guest deleteGuestById(int id) throws Exception {

        Guest guestToBeRemoved = getGuestById(id);

        if(guestToBeRemoved == null){
            throw new Exception("Guest is not exist!");
        }

        guests.remove(guestToBeRemoved);

        return guestToBeRemoved;
    }

    @Override
    public Guest updateGuest(Guest guest) throws Exception {

        Guest guestToBeUpdated = getGuestById(guest.getId());

        if(guestToBeUpdated == null){
            throw new Exception("Room is not exist!");
        }

        guestToBeUpdated.setNumberOfReservation(guest.getNumberOfReservation());
        guestToBeUpdated.setType(guest.getType());
        guestToBeUpdated.setEmail(guest.getEmail());
        guestToBeUpdated.setFirstName(guest.getFirstName());
        guestToBeUpdated.setLastName(guest.getLastName());
        guestToBeUpdated.setPassword(guest.getPassword());
        guestToBeUpdated.setTelephoneNumber(guest.getTelephoneNumber());

        return guestToBeUpdated;
    }
}
