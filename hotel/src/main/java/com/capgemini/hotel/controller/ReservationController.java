package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Reservation;
import com.capgemini.hotel.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class ReservationController {

    ReservationService reservationService;

    public ReservationController(){}

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping(value = "/reservations", produces = "application/json")
    public ResponseEntity<List<Reservation>> getReservations() {

        List<Reservation> reservations = reservationService.getAllReservations();

        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @GetMapping(value = "/reservation/{id}", produces = "application/json")
    public ResponseEntity<Reservation> getReservationById(@PathVariable(name = "id", required = true) int id){

        Reservation reservation = reservationService.getReservationById(id);

        return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
    }

    @DeleteMapping(value = "/reservation/{id}", produces = "application/json")
    public ResponseEntity<Reservation> deleteReservationById(@PathVariable(name = "id", required = true) int id){

        Reservation deletedReservation = reservationService.deleteReservationById(id);

        return new ResponseEntity<Reservation>(deletedReservation, HttpStatus.OK);
    }

    @PostMapping(value = "/reservation", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {

        Reservation createdReservation = reservationService.createReservation(reservation);

        return new ResponseEntity<Reservation>(createdReservation, HttpStatus.OK);
    }

    @PutMapping(value = "/reservation", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {

        Reservation updatedReservation = reservationService.updateReservation(reservation);

        return new ResponseEntity<Reservation>(updatedReservation, HttpStatus.OK);
    }
}

