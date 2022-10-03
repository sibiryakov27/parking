package com.sigma.parking.service;

import com.sigma.parking.data.dto.BookingDTO;
import com.sigma.parking.data.entity.BookingEntity;
import com.sigma.parking.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParkingService {

    private BookingRepository bookingRepository;
    private ModelMapper modelMapper;

    public List<BookingDTO> getAllBookings() {
        List<BookingEntity> bookings = bookingRepository.findAll();
        return bookings.stream().map(entity -> modelMapper.map(entity, BookingDTO.class)).collect(Collectors.toList());
    }
}
