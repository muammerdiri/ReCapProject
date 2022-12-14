package com.muammerdiri.rentACar.controller.api;

import com.muammerdiri.rentACar.business.abstracts.ColorService;
import com.muammerdiri.rentACar.core.utilities.result.*;
import com.muammerdiri.rentACar.entities.concrete.Color;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

    private ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Color color) {
        colorService.add(color);
        return new SuccessResult("Color is added.");
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Color color) {

        if(colorService.delete(color).isSuccess()){
            colorService.delete(color);
            return new SuccessResult("Color is deleted");
        }

        return new ErrorResult("Color cannot be deleted");
    }

    @GetMapping("/getall")
    public DataResult<List<Color>> getAll() {
        return new SuccessDataResult<>(colorService.getAll(),"Colors are listed");
    }


}
