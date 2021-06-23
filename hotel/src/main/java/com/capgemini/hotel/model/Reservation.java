package com.capgemini.hotel.model;

import java.time.LocalDate;

public class Reservation {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int price;
    private String paymentType;
    private boolean isEnded;
    private Room room;
    private Guest guest;
    private Employee employee;

    public Reservation() {}

    public Reservation(int id, LocalDate startDate,LocalDate endDate, int price, String paymentType, boolean isEnded, Room room, Guest guest, Employee employee) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.paymentType = paymentType;
        this.isEnded = isEnded;
        this.room = room;
        this.guest = guest;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public boolean isEnded() {
        return isEnded;
    }

    public void setEnded(boolean ended) {
        isEnded = ended;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startTime=" + startDate +
                ", endTime=" + endDate +
                ", price=" + price +
                ", paymentType='" + paymentType + '\'' +
                ", isEnded=" + isEnded +
                ", room=" + room +
                ", guest=" + guest +
                ", employee=" + employee +
                '}';
    }
}
