package com.capgemini.hotel.service;

import com.capgemini.hotel.model.Room;
import com.capgemini.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    RoomRepository roomRepository;

    public RoomServiceImpl() {
    }

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAllRooms() {

        List<Room> rooms = roomRepository.getAllRooms();

        return rooms;
    }

    @Override
    public Room createRoom(Room room) {

        Room createdRoom = null;
        try {
            createdRoom = roomRepository.createRoom(room);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return createdRoom;
    }

    @Override
    public Room getRoomById(int id) {

        Room room = roomRepository.getRoomById(id);

        return room;
    }

    @Override
    public Room deleteRoomById(int id) {

        Room deletedRoom = null;
        try {
            deletedRoom = roomRepository.deleteRoomById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deletedRoom;
    }

    @Override
    public Room updateRoom(Room room) {

        Room updatedRoom = null;
        try {
            updatedRoom = roomRepository.updateRoom(room);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updatedRoom;
    }
}
