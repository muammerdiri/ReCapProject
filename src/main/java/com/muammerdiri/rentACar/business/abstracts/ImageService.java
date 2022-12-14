package com.muammerdiri.rentACar.business.abstracts;

import com.muammerdiri.rentACar.core.utilities.result.DataResult;
import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.entities.concrete.CarImage;
import com.muammerdiri.rentACar.entities.dtos.image.CreateCarImageDto;

import java.util.List;


public interface ImageService {

    Result add(CreateCarImageDto[] images, int carId);
//    Result add(CarImage[] images,int carId);
    DataResult<List<CarImage>> findImageByCarId(int id);
    Result deleteByImageId(int id);
    Result updateByImageId(int id, CarImage image);

    int findImageByCarIdCount(int id);

}
