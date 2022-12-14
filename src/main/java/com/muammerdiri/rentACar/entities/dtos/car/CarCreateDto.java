package com.muammerdiri.rentACar.entities.dtos.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarCreateDto {

    private int modelYear;
    private double dailyPrice;
    private String title;
    private String description;
    private int brandId;
    private int colorId;
}
