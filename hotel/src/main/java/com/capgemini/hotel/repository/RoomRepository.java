package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Room;

import java.util.List;

public interface RoomRepository {

    public List<Room> getAllRooms();

    public Room createRoom(Room room) throws Exception;

    public Room getRoomById(int id);

    public Room deleteRoomById(int id) throws Exception;

    public Room updateRoom(Room room) throws Exception;
}
