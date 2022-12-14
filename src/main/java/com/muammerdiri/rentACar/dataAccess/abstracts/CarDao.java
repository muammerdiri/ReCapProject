package com.muammerdiri.rentACar.dataAccess.abstracts;

import com.muammerdiri.rentACar.entities.concrete.Car;
import com.muammerdiri.rentACar.entities.dtos.car.CarDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarDao extends JpaRepository<Car,Integer> {

    @Query("SELECT u FROM Car u WHERE u.modelYear = :modelYear" )
    List<Car> findCarByModelYearNamedParams(@Param("modelYear") Integer status);

//    @Query("Select c from Car c WHERE c.id = :id")
//    Car findCarByIdNamedParams(@Param("id") int id);

    Optional<Car> findCarById(int id);

    List<Car> findCarByColorName(String colorName);
    List<Car> findCarByBrandName(String brandName);

    @Query(value = "SELECT new com.muammerdiri.rentACar.entities.dtos.car.CarDetailDto(c.carName,b.name,co.name,c.dailyPrice) " +
            "FROM Car c INNER JOIN c.brand b INNER JOIN c.color co")
    List<CarDetailDto> carDetail();




}
