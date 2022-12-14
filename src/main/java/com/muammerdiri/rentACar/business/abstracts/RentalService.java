package com.muammerdiri.rentACar.business.abstracts;

import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.entities.concrete.Rental;
import com.muammerdiri.rentACar.entities.dtos.rental.CreateRentalDto;

import java.time.LocalDate;

public interface RentalService {
    Result add(CreateRentalDto rental);

    Result carDelivered(int carId,LocalDate deliveredDate);

}
