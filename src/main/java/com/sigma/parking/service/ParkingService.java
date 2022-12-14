package com.sigma.parking.service;

import com.sigma.parking.data.dto.BookingDTO;
import com.sigma.parking.data.dto.CarDTO;
import com.sigma.parking.data.entity.BookingEntity;
import com.sigma.parking.data.entity.CarEntity;
import com.sigma.parking.data.entity.ParkingSpaceEntity;
import com.sigma.parking.exception.NotFoundException;
import com.sigma.parking.repository.BookingRepository;
import com.sigma.parking.repository.CarRepository;
import com.sigma.parking.repository.ParkingSpaceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParkingService {

    private BookingRepository bookingRepository;
    private CarRepository carRepository;
    private ParkingSpaceRepository parkingSpaceRepository;
    private ModelMapper modelMapper;

    public List<BookingDTO> getAllBookings() {
        List<BookingEntity> bookings = bookingRepository.findAll();
        return bookings.stream().map(entity -> modelMapper.map(entity, BookingDTO.class)).collect(Collectors.toList());
    }

    public BookingDTO saveBooking(BookingDTO booking) {
        BookingEntity bookingEntity = modelMapper.map(booking, BookingEntity.class);
        Optional<CarEntity> car = carRepository.findByCarNumber(booking.getCar().getCarNumber());
        Optional<ParkingSpaceEntity> parkingSpace = parkingSpaceRepository.findById(booking.getParkingSpace().getId());
        if (car.isPresent()) {
            bookingEntity.setCar(car.get());
        }
        if (parkingSpace.isPresent()) {
            bookingEntity.setParkingSpace(parkingSpace.get());
        }
        bookingEntity = bookingRepository.save(bookingEntity);
        return modelMapper.map(bookingEntity, BookingDTO.class);
    }

    public BookingDTO updateBooking(BookingDTO booking, Integer id) {
        Optional<BookingEntity> bookingEntity = bookingRepository.findById(id);
        if (bookingEntity.isEmpty()) {
            throw new NotFoundException("Booking with such id cannot be found [id = " + id + "]");
        }
        booking.setId(id);
        return saveBooking(booking);
    }

    public CarDTO deleteCarAndAllRelatedData(String carNumber) {
        Optional<CarEntity> car = carRepository.findByCarNumber(carNumber);
        if (car.isEmpty()) {
            throw new NotFoundException("Car with such number cannot be found [carNumber = " + carNumber + "]");
        }
        carRepository.delete(car.get());
        return modelMapper.map(car.get(), CarDTO.class);
    }
}
