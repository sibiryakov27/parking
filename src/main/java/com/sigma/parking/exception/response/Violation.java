package com.sigma.parking.exception.response;

import lombok.Data;

@Data
public class Violation {
    private final String fieldName;
    private final String message;
}
