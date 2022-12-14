package com.muammerdiri.rentACar.controller.api;

import com.muammerdiri.rentACar.business.abstracts.CarService;
import com.muammerdiri.rentACar.business.abstracts.RentalService;
import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.core.utilities.result.SuccessResult;
import com.muammerdiri.rentACar.entities.concrete.Car;
import com.muammerdiri.rentACar.entities.concrete.Rental;
import com.muammerdiri.rentACar.entities.dtos.rental.CreateRentalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    private RentalService rentalService;


    @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;

    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateRentalDto rental){
        rentalService.add(rental);
        return new SuccessResult("Congratulations");
    }

    @PutMapping("/car-delivered")
    public Result carDelivered(int carId, String carDeliveredDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate returnDate = LocalDate.parse(carDeliveredDate, formatter);
        return rentalService.carDelivered(carId,returnDate);
    }
}
