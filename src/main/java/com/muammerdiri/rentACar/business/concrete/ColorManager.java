package com.muammerdiri.rentACar.business.concrete;

import com.muammerdiri.rentACar.business.abstracts.ColorService;
import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.core.utilities.result.SuccessResult;
import com.muammerdiri.rentACar.dataAccess.abstracts.ColorDao;
import com.muammerdiri.rentACar.entities.concrete.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorManager implements ColorService {
    private ColorDao colorDao;

    @Autowired
    public ColorManager(ColorDao colorDao) {
        this.colorDao = colorDao;
    }

    @Override
    public Result add(Color color) {
        colorDao.save(color);
        return new SuccessResult("Color is added.");
    }

    @Override
    public Result delete(Color color) {
        colorDao.delete(color);
        return new SuccessResult("Color is deleted");
    }

    @Override
    public List<Color> getAll() {
        return colorDao.findAll();
    }

    @Override
    public Optional<Color> getById(int id) {
        return colorDao.findById(id);
    }


}
