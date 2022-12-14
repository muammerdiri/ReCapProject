package com.muammerdiri.rentACar.business.concrete;

import com.muammerdiri.rentACar.business.abstracts.CarService;
import com.muammerdiri.rentACar.business.abstracts.ImageService;
import com.muammerdiri.rentACar.core.utilities.result.*;
import com.muammerdiri.rentACar.dataAccess.abstracts.ImageDao;
import com.muammerdiri.rentACar.entities.concrete.Car;
import com.muammerdiri.rentACar.entities.concrete.CarImage;
import com.muammerdiri.rentACar.entities.dtos.image.CreateCarImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageManager implements ImageService {

    private ImageDao imageDao;
    private CarService carService;

    @Autowired
    public ImageManager(ImageDao imageDao,CarService carService) {
        this.imageDao = imageDao;
        this.carService = carService;
    }

    @Override
    public Result add(CreateCarImageDto[] images, int carId) {

        for (CreateCarImageDto image:images) {
            int carCount = imageDao.findImageByCarIdCount(carId);
            if(carCount>4)
                return new ErrorResult("Resim sayınız aştınız. Max resim sayısı:5");
            imageSave(image);
        }
        return new SuccessResult("Images added");
    }

    @Override
    public DataResult<List<CarImage>> findImageByCarId(int id) {
        return new SuccessDataResult<>(imageDao.findByCarId(id));
    }

    @Override
    public Result deleteByImageId(int id) {
        imageDao.deleteById(id);
        return new SuccessResult("Image is deleted.");
    }

    @Override
    public Result updateByImageId(int id, CarImage image) {
        Optional<CarImage> foundImage = imageDao.findById(id);
        CarImage newImage = foundImage.get();
        if (foundImage.isPresent()){
            newImage.setImagePath(image.getImagePath());
            newImage.setDate(image.getDate());
        }else
            return new ErrorResult("Image cannot found.");

        imageDao.save(newImage);
        return new SuccessResult("Image is updated.");
    }

    @Override
    public int findImageByCarIdCount(int id) {
        return imageDao.findImageByCarIdCount(id);
    }

    private void imageSave(CreateCarImageDto carImage){
        BufferedImage image = null;
        Optional<Car> car = carService.findCarByIdNamedParams(carImage.getCarId());
        String password = carImage.getImagePath();

        if (car.isPresent()){
            try {
                //Md5 hashing process.
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] digest = md.digest();
                String myHash = DatatypeConverter
                        .printHexBinary(digest).toUpperCase();

                String path ="C:\\rentACar\\images\\"+myHash+".jpg";
                image = ImageIO.read(new File(carImage.getImagePath()));


                ImageIO.write(image, "png",new File(path));
                CarImage newImage = new CarImage();
                newImage.setDate(carImage.getDate());
                newImage.setImagePath(path);
                newImage.setCar(car.get());

                imageDao.save(newImage);
            } catch (IOException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }


    }
}
