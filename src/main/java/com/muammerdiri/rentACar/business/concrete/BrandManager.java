package com.muammerdiri.rentACar.business.concrete;

import com.muammerdiri.rentACar.business.abstracts.BrandService;
import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.core.utilities.result.SuccessResult;
import com.muammerdiri.rentACar.dataAccess.abstracts.BrandDao;
import com.muammerdiri.rentACar.entities.concrete.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandManager implements BrandService {

    private BrandDao brandDao;

    @Autowired
    public BrandManager(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    @Override
    public Result add(Brand brand) {
        brandDao.save(brand);
        return new SuccessResult("Brand is added.");
    }

    @Override
    public Result delete(Brand brand) {
        brandDao.delete(brand);
        return new SuccessResult("Brand is deleted.");
    }

    @Override
    public List<Brand> findAll() {
        return brandDao.findAll();
    }

    @Override
    public Optional<Brand> getById(int id) {

        return brandDao.findById(id);
    }


}
