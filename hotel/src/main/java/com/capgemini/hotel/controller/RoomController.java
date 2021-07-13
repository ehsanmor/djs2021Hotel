package com.capgemini.hotel.controller;

import com.capgemini.hotel.model.Room;
import com.capgemini.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class RoomController {

    RoomService roomService;

    public RoomController() {
    }

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(value = "/rooms", produces = "application/json")
    public ResponseEntity<List<Room>> getRooms() {

        List<Room> rooms = roomService.getAllRooms();

        return new ResponseEntity<>(rooms, HttpStatus.OK);

    }

    @GetMapping(value = "/room/{id}", produces = "application/json")
    public ResponseEntity<Room> getRoomById(@PathVariable(name = "id", required = true) int id){

        Room room = roomService.getRoomById(id);

        return new ResponseEntity<Room>(room, HttpStatus.OK);
    }

    @DeleteMapping(value = "/room/{id}", produces = "application/json")
    public ResponseEntity<Room> deleteRoomById(@PathVariable(name = "id", required = true) int id){

        Room deletedRoom = roomService.deleteRoomById(id);

        return new ResponseEntity<Room>(deletedRoom, HttpStatus.OK);
    }

    @PostMapping(value = "/room", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {

        Room createdRoom = roomService.createRoom(room);

        return new ResponseEntity<Room>(createdRoom, HttpStatus.OK);

    }

    @PutMapping(value = "/room/edit/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {

        Room updatedRoom = roomService.updateRoom(room);

        return new ResponseEntity<Room>(updatedRoom, HttpStatus.OK);

    }
}

