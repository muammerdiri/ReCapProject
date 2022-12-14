package com.muammerdiri.rentACar.business.concrete;

import com.muammerdiri.rentACar.business.abstracts.CarService;
import com.muammerdiri.rentACar.business.abstracts.CustomerService;
import com.muammerdiri.rentACar.business.abstracts.RentalService;
import com.muammerdiri.rentACar.core.utilities.result.ErrorResult;
import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.core.utilities.result.SuccessResult;
import com.muammerdiri.rentACar.dataAccess.abstracts.CustomerDao;
import com.muammerdiri.rentACar.dataAccess.abstracts.RentalDao;
import com.muammerdiri.rentACar.entities.concrete.Car;
import com.muammerdiri.rentACar.entities.concrete.Customer;
import com.muammerdiri.rentACar.entities.concrete.Rental;
import com.muammerdiri.rentACar.entities.dtos.rental.CreateRentalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class RentalManager implements RentalService {

    private RentalDao rentalDao;
    private CarService carService;
    private CustomerService customerService;
    private final CustomerDao customerDao;

    @Autowired
    public RentalManager(RentalDao rentalDao,CarService carService,CustomerService customerService,
                         CustomerDao customerDao) {
        this.rentalDao = rentalDao;
        this.carService = carService;
        this.customerService = customerService;
        this.customerDao = customerDao;
    }

    @Override
    public Result add(CreateRentalDto rental) {
        Optional<Car> car = carService.findCarByIdNamedParams(rental.getCarId());
        Rental foundRental = rentalDao.findByCarId(rental.getCarId());
        Optional<Customer> customer = customerService.getCustomerById(rental.getCustomerId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate rentDate = LocalDate.parse(rental.getRentDate().toString(), formatter);

        if(carAndCustomerFoundRegister(rental)) {

                  Rental rental1 = new Rental();
                  rental1.setCar(car.get());
                  rental1.setCustomer(customer.get());
                  rental1.setRentDate(rental.getRentDate());
                  rentalDao.save(rental1);

                  return new SuccessResult("Car is successfuly rental.");

        }
        return new ErrorResult("Car was cannot be added.");
    }

    @Override
    public Result carDelivered(int carId, LocalDate deliveredDate) {
       Rental foundRentalCar = rentalDao.findByCarId(carId);



       foundRentalCar.setReturnDate(deliveredDate);
       rentalDao.save(foundRentalCar);

       return new SuccessResult("Car is delivered.");
    }


    private boolean carAndCustomerFoundRegister(CreateRentalDto rental){
        Optional<Car> car = carService.findCarByIdNamedParams(rental.getCarId());
        Optional<Customer> customer = customerService.getCustomerById(rental.getCustomerId());

        if (car.isPresent()&&customer.isPresent()){
            return true;
        }
        return false;
    }


}
