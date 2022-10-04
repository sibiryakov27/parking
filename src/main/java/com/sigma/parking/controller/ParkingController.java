package com.sigma.parking.controller;

import com.sigma.parking.data.dto.BookingDTO;
import com.sigma.parking.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/parking")
@AllArgsConstructor
public class ParkingController {

    private ParkingService parkingService;

    @GetMapping("/booking")
    public List<BookingDTO> getAllBookings() {
        return parkingService.getAllBookings();
    }

    @PostMapping("/booking")
    public BookingDTO addNewBooking(@Valid @RequestBody BookingDTO newBooking) {
        return parkingService.saveBooking(newBooking);
    }
}
