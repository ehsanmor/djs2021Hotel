package com.capgemini.hotel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    @GetMapping("rooms")
    public String listRooms() {
        return "All Rooms!";
    }

}
