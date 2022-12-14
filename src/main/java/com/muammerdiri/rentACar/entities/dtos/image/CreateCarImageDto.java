package com.muammerdiri.rentACar.entities.dtos.image;

import com.muammerdiri.rentACar.entities.concrete.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarImageDto {
    private int carId;
    private String imagePath;
    private LocalDate date;
}
