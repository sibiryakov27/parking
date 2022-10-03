package com.sigma.parking.data.dto;

import com.sigma.parking.data.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    @NotNull
    private String carNumber;
    private CarType carType;
    private String registrationCertificate;
    private String carModel;
}
