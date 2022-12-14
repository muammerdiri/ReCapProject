package com.muammerdiri.rentACar.business.abstracts;

import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.entities.concrete.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandService {
    Result add(Brand brand);
    Result delete(Brand brand);
    List<Brand> findAll();
    Optional<Brand> getById(int id);

}
