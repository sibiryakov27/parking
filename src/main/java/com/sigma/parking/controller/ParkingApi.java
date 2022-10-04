package com.sigma.parking.controller;

import com.sigma.parking.data.dto.BookingDTO;
import com.sigma.parking.data.dto.CarDTO;
import com.sigma.parking.exception.response.BaseExceptionResponse;
import com.sigma.parking.exception.response.ValidationErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@Tag(name = "Parking", description = "Test task for sigma")
@Validated
@RequestMapping("/parking")
public interface ParkingApi {
    @Operation(summary = "Get all bookings of parking spaces")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookingDTO.class))),
    })
    @GetMapping("/booking")
    List<BookingDTO> getAllBookings();

    @Operation(summary = "Add new booking of parking space")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookingDTO.class))),
            @ApiResponse(responseCode = "400", description = "validation error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class)))
    })
    @PostMapping("/booking")
    BookingDTO addNewBooking(
            @Parameter(description = "New booking", required = true)
            @Valid @RequestBody BookingDTO newBooking
    );

    @Operation(summary = "Delete car and related data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CarDTO.class))),
            @ApiResponse(responseCode = "400", description = "validation error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Car not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseExceptionResponse.class)))
    })
    @DeleteMapping("/car/{carNumber}")
    CarDTO deleteCarAndAllRelatedData(
            @PathVariable("carNumber")
            @Parameter(
                    description = "The number of car that need to be deleted",
                    required = true,
                    example = "A111AA111"
            )
            @Pattern(regexp = "^[A-Za-z]\\d{3}[A-Za-z]{2}\\d{1,3}$")
            String carNumber
    );

    @Operation(summary = "Update info about existed booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookingDTO.class))),
            @ApiResponse(responseCode = "400", description = "validation error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Booking not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = BaseExceptionResponse.class)))
    })
    @PutMapping("/booking/{id}")
    public BookingDTO updateBooking(
            @Parameter(description = "Changing booking", required = true)
            @Valid @RequestBody BookingDTO updatedBooking,
            @Parameter(description = "Id of changing booking", required = true)
            @PathVariable Integer id
    );
}
