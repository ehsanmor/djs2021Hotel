package com.capgemini.hotel.service;

import com.capgemini.hotel.model.Employee;
import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.model.Reservation;
import com.capgemini.hotel.model.Room;
import com.capgemini.hotel.repository.EmployeeRepository;
import com.capgemini.hotel.repository.GuestRepository;
import com.capgemini.hotel.repository.ReservationRepository;
import com.capgemini.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    ReservationRepository reservationRepository;
    RoomRepository roomRepository;
    EmployeeRepository employeeRepository;
    GuestRepository guestRepository;

    public ReservationServiceImpl() {
    }

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, RoomRepository roomRepository, EmployeeRepository employeeRepository, GuestRepository guestRepository) {

        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.employeeRepository = employeeRepository;

        if(this.reservationRepository.getAllReservations().size() == 0){

            Room room1 = this.roomRepository.getAllRooms().get(0);
            Room room2 = this.roomRepository.getAllRooms().get(1);
            Room room3 = this.roomRepository.getAllRooms().get(2);
            Guest guest1 = this.guestRepository.getAllGuests().get(0);
            Guest guest2 = this.guestRepository.getAllGuests().get(1);
            Guest guest3 = this.guestRepository.getAllGuests().get(2);
            Employee employee1 = this.employeeRepository.getAllEmployees().get(1);

            try {
                this.reservationRepository.createReservation(new Reservation(1, LocalDate.now(), LocalDate.now().plusDays(7), LocalDate.now(), LocalDate.now().plusDays(7), LocalDate.now(), 0, 0, "Cash", false, room1, guest1, employee1, true));
                this.reservationRepository.createReservation(new Reservation(2, LocalDate.now(), LocalDate.now().plusDays(8), LocalDate.now(), LocalDate.now().plusDays(8), LocalDate.now(), 8*30, 0, "Cash", false, room2, guest2, employee1, true));
                this.reservationRepository.createReservation(new Reservation(3, LocalDate.now(), LocalDate.now().plusDays(9), LocalDate.now(), LocalDate.now().plusDays(9), LocalDate.now(), 9*35, 0, "Cash", false, room3, guest3, employee1, true));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public double getPrice(Room room, String startDate, String endDate) {

        double price = reservationRepository.getPrice(room, startDate, endDate);

        return price;
    }

    @Override
    public List<Reservation> getAllReservations() {

        List<Reservation> reservations = reservationRepository.getAllReservations();

        return reservations;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {

        Reservation createdReservation = null;
        try {
            createdReservation = reservationRepository.createReservation(reservation);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return createdReservation;
    }

    @Override
    public Reservation getReservationById(int id) {

        Reservation reservation = reservationRepository.getReservationById(id);

        return reservation;
    }

    @Override
    public Reservation deleteReservationById(int id) {

        Reservation deletedReservation = null;
        try {
            deletedReservation = reservationRepository.deleteReservationById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deletedReservation;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {

        Reservation updatedReservation = null;
        try {
            updatedReservation = reservationRepository.updateReservation(reservation);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updatedReservation;
    }
}
