package com.muammerdiri.rentACar.entities.dtos.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalDto {

    private int customerId;
    private int carId;
    private LocalDate rentDate;
    private LocalDate returnDate;

}
