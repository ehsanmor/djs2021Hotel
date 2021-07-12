package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Employee;
import com.capgemini.hotel.model.Guest;
import com.capgemini.hotel.model.Reservation;

import java.time.LocalDate;

import com.capgemini.hotel.model.Room;
import org.springframework.stereotype.Component;

import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReservationRepositoryImpl implements ReservationRepository{

    public List<Reservation> reservations = new ArrayList<>();
    RoomRepository roomRepository = new RoomRepositoryImpl();
    GuestRepository guestRepository = new GuestRepositoryImpl();
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    public ReservationRepositoryImpl(){}

    @Override
    public double getPrice(Room room, String startDate, String endDate) {

        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate date1 = LocalDate.parse(startDate, formatter);
        LocalDate date2 = LocalDate.parse(endDate, formatter);

        long period = Period.between(date1, date2).getDays();

        return room.getPrice()*period;
    }

    @Override
    public List<Reservation> getAllReservations() {

        return reservations;
    }

    @Override
    public Reservation createReservation(Reservation reservation) throws Exception {

        for (Reservation reservationToFind : reservations) {
            if (reservationToFind.getId() == reservation.getId()) {
                throw new Exception("Reservation is exist!");
            }

            // Selected reservation start date for room is equal or earlier or than previous reservation end date for the reserved same room.
            if(reservation.getRoom().getId() == reservationToFind.getRoom().getId()){
                if(reservation.getStartDate().compareTo(reservationToFind.getEndDate()) <= 0){
                    throw new Exception("Room is already reserved at this date!");
                }
            }
        }

        Room room = reservation.getRoom();
        Room roomToFind = roomRepository.getRoomById(room.getId());

        Guest guest = reservation.getGuest();
        Guest guestToFind = guestRepository.getGuestById(guest.getId());

        Employee employee = reservation.getEmployee();
        Employee employeeToFind = employeeRepository.getEmployeeById(employee.getId());

        if(roomToFind == null){
            throw new Exception("Room doesn't exist");
        }

        if(guestToFind == null){
            throw new Exception("Guest doesn't exist");
        }

        if(employeeToFind == null){
            throw new Exception("Employee doesn't exist");
        }

        double calculatedPrice = getPrice(reservation.getRoom(), reservation.getStartDate().toString(), reservation.getEndDate().toString());

        reservation.setPrice(calculatedPrice);

        reservations.add(reservation);

        return reservation;
    }

    @Override
    public Reservation getReservationById(int id) {

        for (Reservation reservation: reservations) {

            if(reservation.getId() == id){
                return  reservation;
            }
        }

        return null;
    }

    @Override
    public Reservation deleteReservationById(int id) throws Exception {

        Reservation reservationToBeRemoved = getReservationById(id);

        if(reservationToBeRemoved == null){
            throw new Exception("Reservation is not exist!");
        }

        reservations.remove(reservationToBeRemoved);

        return reservationToBeRemoved;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) throws Exception {

        Reservation reservationToBeUpdated = getReservationById(reservation.getId());

        if(reservationToBeUpdated == null){
            throw new Exception("Reservation is not exist!");
        }

        for (Reservation reservationToFind : reservations) {
            // Selected reservation start date for room is equal or earlier or than previous reservation end date for the reserved same room.
            if(reservationToFind.getId() != reservationToBeUpdated.getId() && reservation.getRoom().getId() == reservationToFind.getRoom().getId()){
                if(reservation.getStartDate().compareTo(reservationToFind.getEndDate()) <= 0){
                    throw new Exception("Room is already reserved at this date!");
                }
            }
        }

        Room room = reservation.getRoom();
        Room roomToFind = roomRepository.getRoomById(room.getId());

        Guest guest = reservation.getGuest();
        Guest guestToFind = guestRepository.getGuestById(guest.getId());

        Employee employee = reservation.getEmployee();
        Employee employeeToFind = employeeRepository.getEmployeeById(employee.getId());

        if(roomToFind == null){
            throw new Exception("Room doesn't exist");
        }

        if(guestToFind == null){
            throw new Exception("Guest doesn't exist");
        }

        if(employeeToFind == null){
            throw new Exception("Employee doesn't exist");
        }

        double calculatedPrice = getPrice(reservation.getRoom(), reservation.getStartDate().toString(), reservation.getEndDate().toString());

        reservationToBeUpdated.setPrice(calculatedPrice);
        reservationToBeUpdated.setAdditionalPrice(reservation.getAdditionalPrice());
        reservationToBeUpdated.setCheckIn(reservation.getCheckIn());
        reservationToBeUpdated.setCheckOut(reservation.getCheckOut());
        reservationToBeUpdated.setPaymentDate(reservation.getPaymentDate());
        reservationToBeUpdated.setPaymentType(reservation.getPaymentType());
        reservationToBeUpdated.setResChecked(reservation.isResChecked());
        reservationToBeUpdated.setStartDate(reservation.getStartDate());
        reservationToBeUpdated.setEndDate(reservation.getEndDate());
        reservationToBeUpdated.setResEnded(reservation.isResEnded());
        reservationToBeUpdated.setEmployee(reservation.getEmployee());
        reservationToBeUpdated.setRoom(reservation.getRoom());
        reservationToBeUpdated.setGuest(reservation.getGuest());

        return reservationToBeUpdated;
    }
}
