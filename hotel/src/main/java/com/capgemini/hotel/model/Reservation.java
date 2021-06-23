package com.capgemini.hotel.model;

import java.time.LocalDateTime;

public class Reservation {
    private int id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int delayTime;
    private int price;
    private String paymentType;
    private boolean isEnded;
    private Room room;
    private Guest guest;
    private Receptionist receptionist;

    public Reservation() {}

    public Reservation(int id, LocalDateTime startTime, LocalDateTime endTime, int delayTime, int price, String paymentType, boolean isEnded, Room room, Guest guest, Receptionist receptionist) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.delayTime = delayTime;
        this.price = price;
        this.paymentType = paymentType;
        this.isEnded = isEnded;
        this.room = room;
        this.guest = guest;
        this.receptionist = receptionist;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
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

    public Receptionist getReceptionist() {
        return receptionist;
    }

    public void setReceptionist(Receptionist receptionist) {
        this.receptionist = receptionist;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", delayTime=" + delayTime +
                ", price=" + price +
                ", paymentType='" + paymentType + '\'' +
                ", isEnded=" + isEnded +
                ", room=" + room +
                ", guest=" + guest +
                ", receptionist=" + receptionist +
                '}';
    }
}
