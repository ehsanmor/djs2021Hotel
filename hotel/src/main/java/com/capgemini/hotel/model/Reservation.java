package com.capgemini.hotel.model;

import java.time.LocalDate;

public class Reservation {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private LocalDate paymentDate;
    private boolean isChecked;
    private double price;
    private double additionalPrice;
    private String paymentType;
    private boolean isEnded;
    private Room room;
    private Guest guest;
    private Employee employee;

    public Reservation() {}

    public Reservation(int id, LocalDate startDate, LocalDate endDate, LocalDate checkIn, LocalDate checkOut,LocalDate paymentDate, double price, double additionalPrice, String paymentType, boolean isEnded, Room room, Guest guest, Employee employee, boolean isChecked) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.paymentDate = paymentDate;
        this.price = price;
        this.additionalPrice = additionalPrice;
        this.paymentType = paymentType;
        this.isEnded = isEnded;
        this.room = room;
        this.guest = guest;
        this.employee = employee;
        this.isChecked = isChecked;
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

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(double additionalPrice) {
        this.additionalPrice = additionalPrice;
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

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", paymentDate=" + paymentDate +
                ", isChecked=" + isChecked +
                ", price=" + price +
                ", additionalPrice=" + additionalPrice +
                ", paymentType='" + paymentType + '\'' +
                ", isEnded=" + isEnded +
                ", room=" + room +
                ", guest=" + guest +
                ", employee=" + employee +
                '}';
    }
}
