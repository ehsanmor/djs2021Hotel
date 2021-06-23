package com.capgemini.hotel.model;

public class Room {
    private int id;
    private String number;
    private String type;
    private String description;
    private int capacity;
    private int price;

    public Room(){}

    public Room(int id, String number, String type, String description, int capacity, int price) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.description = description;
        this.capacity = capacity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
