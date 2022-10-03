package com.sigma.parking.data.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    @NotNull
    private Integer id;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Timestamp startTime;
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")
    private Timestamp endTime;
    private BigDecimal totalPrice;
    private CarDTO car;
    private ParkingSpaceDTO parkingSpace;
}
