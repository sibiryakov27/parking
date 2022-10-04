package com.sigma.parking.controller;

import com.sigma.parking.data.dto.BookingDTO;
import com.sigma.parking.data.dto.CarDTO;
import com.sigma.parking.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ParkingController implements ParkingApi {

    private ParkingService parkingService;

    @Override
    public List<BookingDTO> getAllBookings() {
        return parkingService.getAllBookings();
    }

    @Override
    public BookingDTO addNewBooking(BookingDTO newBooking) {
        return parkingService.saveBooking(newBooking);
    }

    @Override
    public CarDTO deleteCarAndAllRelatedData(String carNumber) {
        return parkingService.deleteCarAndAllRelatedData(carNumber);
    }

    @Override
    public BookingDTO updateBooking(BookingDTO updatedBooking, Integer id) {
        return parkingService.updateBooking(updatedBooking, id);
    }
}
