package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class GuestController {

    GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping(value = "/guests", produces = "application/json")
    public ResponseEntity<List<Guest>> getGuests() {

        List<Guest> guests = guestService.getAllGuests();

        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @GetMapping(value = "/guest/{id}", produces = "application/json")
    public ResponseEntity<Guest> getGuestById(@PathVariable(name = "id", required = true) int id){

        Guest guest = guestService.getGuestById(id);

        return new ResponseEntity<Guest>(guest, HttpStatus.OK);
    }

    @DeleteMapping(value = "/guest/{id}", produces = "application/json")
    public ResponseEntity<Guest> deleteGuestById(@PathVariable(name = "id", required = true) int id){

        Guest deletedGuest = guestService.deleteGuestById(id);

        return new ResponseEntity<Guest>(deletedGuest, HttpStatus.OK);
    }

    @PostMapping(value = "/guest", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {

        Guest createdGuest = guestService.createGuest(guest);

        return new ResponseEntity<Guest>(createdGuest, HttpStatus.OK);
    }

    @PutMapping(value = "/guest/edit/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Guest> updateGuest(@RequestBody Guest guest){

        Guest updatedGuest = guestService.updateGuest(guest);

        return new ResponseEntity<Guest>(updatedGuest, HttpStatus.OK);
    }
}

