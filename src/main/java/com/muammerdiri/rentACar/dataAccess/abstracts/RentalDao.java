package com.muammerdiri.rentACar.dataAccess.abstracts;

import com.muammerdiri.rentACar.entities.concrete.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalDao extends JpaRepository<Rental,Integer> {

    Rental findByCarId(int id);

}
