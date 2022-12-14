package com.muammerdiri.rentACar.controller.api;

import com.muammerdiri.rentACar.business.abstracts.BrandService;
import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.core.utilities.result.SuccessResult;
import com.muammerdiri.rentACar.entities.concrete.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/brands")
public class BrandController {

    private BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new SuccessResult("Brand is added.");
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Brand brand) {
        brandService.delete(brand);
        return new SuccessResult("Brand is deleted.");
    }

    @GetMapping("/getall")
    public List<Brand> findAll() {
        return brandService.findAll();
    }
}
