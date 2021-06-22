package com.capgemini.hotel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomsController {
    @GetMapping("rooms")
    public String listRooms() {
        return "All Rooms!";
    }

}
