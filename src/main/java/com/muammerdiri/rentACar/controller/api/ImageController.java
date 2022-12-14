package com.muammerdiri.rentACar.controller.api;

import com.muammerdiri.rentACar.business.abstracts.ImageService;
import com.muammerdiri.rentACar.core.utilities.result.DataResult;
import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.entities.concrete.CarImage;
import com.muammerdiri.rentACar.entities.dtos.image.CreateCarImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/images")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateCarImageDto[] images, @RequestParam int carId){
        return imageService.add(images,carId);
    }

    @GetMapping("/car/id/{id}")
    DataResult<List<CarImage>> findImageByCarId(@PathVariable int id){
        return imageService.findImageByCarId(id);
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteByImageId(@PathVariable int id){
        return imageService.deleteByImageId(id);
    }

    @PutMapping("/update/{id}")
    public Result updateByImageId(@PathVariable int id, @RequestBody CarImage image){
        return imageService.updateByImageId(id,image);
    }


}
