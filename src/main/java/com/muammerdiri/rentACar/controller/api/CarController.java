package com.muammerdiri.rentACar.controller.api;


import com.muammerdiri.rentACar.business.abstracts.CarService;
import com.muammerdiri.rentACar.core.utilities.result.*;
import com.muammerdiri.rentACar.entities.concrete.Car;
import com.muammerdiri.rentACar.entities.dtos.car.CarCreateDto;
import com.muammerdiri.rentACar.entities.dtos.car.CarDetailDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/getall")
    public DataResult<List<Car>> getAll(){
        return new SuccessDataResult<List<Car>>(carService.getAll(),"Car listed.");
    }


    @PostMapping("/add")
    public Result add(@RequestBody CarCreateDto car) {
            this.carService.add(car);
            return new SuccessResult("Car is added.");
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam int id) {
        carService.delete(id);
        return new SuccessResult("Car is deleted");
    }

    @GetMapping("/find-car-by-model-year")
    public List<Car> findCarByModelYearNamedParams(@RequestParam Integer status) {
        return carService.findCarByModelYearNamedParams(status);
    }

    @GetMapping("/find-car-by-id-named-params")
    public DataResult<Car> findCarByIdNamedParams(@RequestParam int id) {

        return new SuccessDataResult(carService.findCarByIdNamedParams(id),"Data getting");
    }

    @GetMapping("/find-by-color-name")
    public DataResult<List<Car>> findCarByColorName(@RequestParam String color){
        return carService.findCarByColorName(color);
    }
    @GetMapping("/find-by-brand-name")
    public DataResult<List<Car>> findCarByBrandName(@RequestParam String brand){
        return carService.findCarByBrandName(brand);
    }
    @GetMapping("/car-details")
    public DataResult<List<CarDetailDto>> carDetails(){
        return carService.carDtoDetails();
    }



}
