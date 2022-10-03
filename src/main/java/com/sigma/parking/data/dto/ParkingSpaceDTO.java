package com.sigma.parking.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSpaceDTO {
    @NotNull
    private Integer id;
    @NotNull
    private Boolean occupied;
}
