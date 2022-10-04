package com.sigma.parking.data.dto;

import com.sigma.parking.data.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.Pattern;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {
    @Pattern(regexp = "^[A-Za-z]\\d{3}[A-Za-z]{2}\\d{1,3}$")
    private String carNumber;
    private CarType carType;
    private String registrationCertificate;
    private String carModel;
}
