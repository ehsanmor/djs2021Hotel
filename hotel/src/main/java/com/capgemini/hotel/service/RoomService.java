package com.capgemini.hotel.service;

import com.capgemini.hotel.model.Room;

import java.util.List;

public interface RoomService {

    public List<Room> getAllRooms();

    public Room createRoom(Room room);

    public Room getRoomById(int id);

    public Room deleteRoomById(int id);

    public Room updateRoom(Room room);
}
