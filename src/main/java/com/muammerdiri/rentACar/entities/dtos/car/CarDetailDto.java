package com.muammerdiri.rentACar.entities.dtos.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDetailDto {

    private String carName;
    private String brandName;
    private String colorName;
    private double dailyPrice;


}
