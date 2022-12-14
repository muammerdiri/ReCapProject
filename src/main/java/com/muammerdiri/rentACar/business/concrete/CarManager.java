package com.muammerdiri.rentACar.business.concrete;

import com.muammerdiri.rentACar.business.abstracts.BrandService;
import com.muammerdiri.rentACar.business.abstracts.CarService;
import com.muammerdiri.rentACar.business.abstracts.ColorService;
import com.muammerdiri.rentACar.core.utilities.result.*;
import com.muammerdiri.rentACar.dataAccess.abstracts.CarDao;
import com.muammerdiri.rentACar.entities.concrete.Brand;
import com.muammerdiri.rentACar.entities.concrete.Car;
import com.muammerdiri.rentACar.entities.concrete.Color;
import com.muammerdiri.rentACar.entities.dtos.car.CarCreateDto;
import com.muammerdiri.rentACar.entities.dtos.car.CarDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarManager implements CarService {

    private CarDao carDao;
    private ColorService colorService;
    private BrandService brandService;

    @Autowired
    public CarManager(CarDao carDao,ColorService colorService,BrandService brandService) {
        this.carDao = carDao;
        this.brandService = brandService;
        this.colorService=colorService;
    }

    @Override
    public Result add(CarCreateDto car) {
        Optional<Color> color = colorService.getById(car.getColorId());
        Optional<Brand> brand = brandService.getById(car.getBrandId());

        if (color.isPresent()&&brand.isPresent()){
            Car newCar = new Car();

            newCar.setColor(color.get());
            newCar.setBrand(brand.get());
            newCar.setTitle(car.getTitle());
            newCar.setDescription(car.getDescription());
            newCar.setModelYear(car.getModelYear());
            newCar.setDailyPrice(car.getDailyPrice());

            carDao.save(newCar);
            return new SuccessResult("Car is added.");

        }
        return new ErrorResult("Car cannot added.");
    }

    @Override
    public Result delete(int id) {
        carDao.deleteById(id);
        return new SuccessResult("Car is deleted");
    }

    @Override
    public List<Car> getAll() {
        return carDao.findAll(Sort.by(Sort.Direction.ASC,"title"));
    }

    @Override
    public List<Car> findCarByModelYearNamedParams(Integer status) {
        return carDao.findCarByModelYearNamedParams(status);
    }

    @Override
    public Optional<Car> findCarByIdNamedParams(int id) {
        return carDao.findCarById(id);
    }

    @Override
    public DataResult<List<Car>> findCarByColorName(String colorName) {
        return new SuccessDataResult<>(carDao.findCarByColorName(colorName));
    }

    @Override
    public DataResult<List<Car>> findCarByBrandName(String brandName) {
        return new SuccessDataResult<>(carDao.findCarByBrandName(brandName));
    }

    @Override
    public DataResult<List<CarDetailDto>> carDtoDetails() {
        return new SuccessDataResult<>(carDao.carDetail());
    }


//    @Override
//    public List<CarDto> carDtoDetails() {
//        return carDao.carDtoDetails();
//    }


}
