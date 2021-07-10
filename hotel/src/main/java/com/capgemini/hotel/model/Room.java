package com.capgemini.hotel.model;

import java.time.LocalDate;
import java.util.Arrays;

public class Room {
    private int id; // InventoryId
    private String type;
    private String[] facilities;
    private int capacity;
    private double price;
    private boolean underConstruction;
    private LocalDate lastBigCleaningDate;
    private int numberOfDaysAfterBigClean;
//    private boolean roomNeedsCleaning;

    public Room(){}

    public Room(int id, String type, String[] facilities, double price, LocalDate lastBigCleaningDate, int numberOfDaysAfterBigClean, int capacity, boolean underConstruction) {
        this.id = id;
        this.type = type;
        this.facilities = facilities;
        this.capacity = capacity;
        this.price = price;
        this.underConstruction = underConstruction;
        this.lastBigCleaningDate = lastBigCleaningDate;
        this.numberOfDaysAfterBigClean = numberOfDaysAfterBigClean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getFacilities() {
        return facilities;
    }

    public void setFacilities(String[] facilities) {
        this.facilities = facilities;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isUnderConstruction() {
        return underConstruction;
    }

    public void setUnderConstruction(boolean underConstruction) {
        this.underConstruction = underConstruction;
    }

    public LocalDate getLastBigCleaningDate() {
        return lastBigCleaningDate;
    }

    public void setLastBigCleaningDate(LocalDate lastBigCleaningDate) {
        this.lastBigCleaningDate = lastBigCleaningDate;
    }

    public int getNumberOfDaysAfterBigClean() {
        return numberOfDaysAfterBigClean;
    }

    public void setNumberOfDaysAfterBigClean(int numberOfDaysAfterBigClean) {
        this.numberOfDaysAfterBigClean = numberOfDaysAfterBigClean;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", facilities=" + Arrays.toString(facilities) +
                ", capacity=" + capacity +
                ", price=" + price +
                ", underConstruction=" + underConstruction +
                ", lastBigCleaningDate=" + lastBigCleaningDate +
                ", numberOfDaysAfterBigClean=" + numberOfDaysAfterBigClean +
                '}';
    }
}
