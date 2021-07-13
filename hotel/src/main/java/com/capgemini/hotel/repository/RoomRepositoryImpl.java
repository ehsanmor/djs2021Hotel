package com.capgemini.hotel.repository;

import com.capgemini.hotel.model.Room;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoomRepositoryImpl implements RoomRepository {

    public List<Room> rooms = new ArrayList<>();

    public RoomRepositoryImpl(){
        rooms.add(new Room(101, "Economy", new String[]{"lake view"}, 35.00, LocalDate.of(2021, 6, 26), 20,2, false, true));
        rooms.add(new Room(102, "Economy", new String[]{"mountain view"}, 30.00, LocalDate.of(2021, 6, 26), 7,2, false, false));
        rooms.add(new Room(103, "Economy", new String[]{"lake view"}, 35.00, LocalDate.of(2021, 6, 26), 18,3, false, true));
        rooms.add(new Room(104, "Economy", new String[]{"mountain view"}, 30.00, LocalDate.of(2021, 6, 26), 7,3, false, false));
        rooms.add(new Room(105, "Economy", new String[]{"lake view"}, 35.00, LocalDate.of(2021, 6, 26), 7,3, false, false));
        rooms.add(new Room(106, "Economy", new String[]{"mountain view"}, 30.00, LocalDate.of(2021, 6, 26), 7,3, false, true));
        rooms.add(new Room(107, "Economy", new String[]{"lake view"}, 35.00, LocalDate.of(2021, 6, 26), 7,4, false, true));
        rooms.add(new Room(108, "Economy", new String[]{"mountain view"}, 30.00, LocalDate.of(2021, 6, 26), 7,4, false, true));
        rooms.add(new Room(109, "Normal", new String[]{"TV", "lake view"}, 50.00, LocalDate.of(2021, 6, 27), 7,4, false, true));
        rooms.add(new Room(110, "Normal", new String[]{"TV", "mountain view"}, 45.00, LocalDate.of(2021, 6, 27), 7,4, false, true));
        rooms.add(new Room(201, "Normal", new String[]{"TV", "lake view"}, 50.00, LocalDate.of(2021, 6, 27), 7,2, false, true));
        rooms.add(new Room(202, "Normal", new String[]{"TV", "mountain view"}, 45.00, LocalDate.of(2021, 6, 27), 7,2, false, true));
        rooms.add(new Room(203, "Normal", new String[]{"TV", "lake view"}, 50.00, LocalDate.of(2021, 6, 27), 7,2, false, true));
        rooms.add(new Room(204, "Normal", new String[]{"TV", "mountain view"}, 45.00, LocalDate.of(2021, 6, 27), 7,2, false, true));
        rooms.add(new Room(205, "Normal", new String[]{"TV", "lake view"}, 50.00, LocalDate.of(2021, 6, 28), 7,3, false, true));
        rooms.add(new Room(206, "Normal", new String[]{"TV", "mountain view"}, 45.00, LocalDate.of(2021, 6, 28), 7,3, false, true));
        rooms.add(new Room(207, "Normal", new String[]{"TV", "lake view"}, 50.00, LocalDate.of(2021, 6, 28), 7,3, true, true));
        rooms.add(new Room(208, "Normal", new String[]{"TV", "mountain view"}, 45.00, LocalDate.of(2021, 6, 28), 7,4, false, true));
        rooms.add(new Room(209, "Luxurious", new String[]{"TV", "Mini bar", "Sauna", "lake view"}, 80.00, LocalDate.of(2021, 6, 29), 7,4, false, true));
        rooms.add(new Room(210, "Luxurious", new String[]{"TV", "Mini bar", "Sauna", "mountain view"}, 75.00, LocalDate.of(2021, 6, 29), 7,4, false, true));
        rooms.add(new Room(301, "Normal", new String[]{"TV", "lake view"}, 50.00, LocalDate.of(2021, 6, 28), 7,3, false, true));
        rooms.add(new Room(302, "Luxurious", new String[]{"TV", "Mini bar", "Sauna", "mountain view"}, 75.00, LocalDate.of(2021, 6, 29), 7,4, false, true));
        rooms.add(new Room(303, "Normal", new String[]{"TV", "lake view"}, 50.00, LocalDate.of(2021, 6, 28), 7,3, true, true));
        rooms.add(new Room(304, "Luxurious", new String[]{"TV", "Mini bar", "Sauna", "mountain view"}, 75.00, LocalDate.of(2021, 6, 29), 7,4, false, true));
        rooms.add(new Room(305, "Normal", new String[]{"TV", "lake view"}, 50.00, LocalDate.of(2021, 6, 28), 7,3, true, true));
        rooms.add(new Room(306, "Luxurious", new String[]{"TV", "Mini bar", "Sauna", "mountain view"}, 75.00, LocalDate.of(2021, 6, 29), 7,4, false, true));
        rooms.add(new Room(307, "Normal", new String[]{"TV", "lake view"}, 50.00, LocalDate.of(2021, 6, 28), 7,3, false, true));
        rooms.add(new Room(308, "Luxurious", new String[]{"TV", "Mini bar", "Sauna", "lake view"}, 80.00, LocalDate.of(2021, 6, 29), 7,4, false, true));
        rooms.add(new Room(309, "Normal", new String[]{"TV", "lake view"}, 50.00, LocalDate.of(2021, 6, 29), 7,6, false, true));
        rooms.add(new Room(310, "Luxurious", new String[]{"TV", "Mini bar", "Sauna", "lake view"}, 80.00, LocalDate.of(2021, 6, 29), 7,6, false, true));
        rooms.add(new Room(401, "Luxurious", new String[]{"TV", "Mini bar", "Sauna", "mountain view"}, 75.00, LocalDate.of(2021, 6, 29), 7,6, false, true));
        rooms.add(new Room(402, "Luxurious", new String[]{"TV", "Mini bar", "Sauna", "lake view"}, 80.00, LocalDate.of(2021, 6, 29), 7,6, false, true));
        rooms.add(new Room(403, "Luxurious", new String[]{"TV", "Mini bar", "Sauna", "mountain view"}, 75.00, LocalDate.of(2021, 6, 29), 7,6, false, true));
        rooms.add(new Room(404, "Luxurious", new String[]{"TV", "Mini bar", "Sauna", "lake view"}, 80.00, LocalDate.of(2021, 6, 29), 7,6, true, true));
        rooms.add(new Room(405, "Luxurious", new String[]{"TV", "Mini bar", "Sauna", "mountain view"}, 75.00, LocalDate.of(2021, 6, 29), 7,6, true, true));
    }

    @Override
    public List<Room> getAllRooms() {

        return rooms;
    }

    @Override
    public Room createRoom(Room room) throws Exception {

        for (Room roomToFind : rooms) {
            if (roomToFind.getId() == room.getId()) {
                throw new Exception("Room is exist!");
            }
        }

        rooms.add(room);

        return room;
    }

    @Override
    public Room getRoomById(int id) {

        for (Room room: rooms) {

            if(room.getId() == id){
                return  room;
            }
        }

        return null;
    }

    @Override
    public Room deleteRoomById(int id) throws Exception {

        Room roomToBeRemoved = getRoomById(id);

        if(roomToBeRemoved == null){
            throw new Exception("Room is not exist!");
        }

        rooms.remove(roomToBeRemoved);

        return roomToBeRemoved;
    }

    @Override
    public Room updateRoom(Room room) throws Exception {

        Room roomToBeUpdated = getRoomById(room.getId());

        if(roomToBeUpdated == null){
            throw new Exception("Room is not exist!");
        }

        roomToBeUpdated.setType(room.getType());
        roomToBeUpdated.setFacilities(room.getFacilities());
        roomToBeUpdated.setCapacity(room.getCapacity());
        roomToBeUpdated.setPrice(room.getPrice());
        roomToBeUpdated.setUnderConstruction(room.isUnderConstruction());
        roomToBeUpdated.setLastBigCleaningDate(room.getLastBigCleaningDate());
        roomToBeUpdated.setNumberOfDaysAfterBigClean(room.getNumberOfDaysAfterBigClean());

        return roomToBeUpdated;
    }
}
