package com.muammerdiri.rentACar.dataAccess.abstracts;

import com.muammerdiri.rentACar.entities.concrete.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageDao extends JpaRepository<CarImage,Integer> {
    @Query(value = "SELECT COUNT(c.id) FROM CarImage img INNER JOIN img.car c WHERE c.id= :id")
    int findImageByCarIdCount(int id);


    List<CarImage> findByCarId(int id);
}
