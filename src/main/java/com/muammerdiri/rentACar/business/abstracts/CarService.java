package com.muammerdiri.rentACar.business.abstracts;

import com.muammerdiri.rentACar.core.utilities.result.DataResult;
import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.entities.concrete.Car;
import com.muammerdiri.rentACar.entities.dtos.car.CarCreateDto;
import com.muammerdiri.rentACar.entities.dtos.car.CarDetailDto;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Result add(CarCreateDto car);
    Result delete(int id);
    List<Car> getAll();
    List<Car> findCarByModelYearNamedParams(Integer status);
    Optional<Car> findCarByIdNamedParams(int id);

    DataResult<List<Car>> findCarByColorName(String colorName);
    DataResult<List<Car>> findCarByBrandName(String brandName);
    DataResult<List<CarDetailDto>> carDtoDetails();




}
