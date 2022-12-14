package com.muammerdiri.rentACar.dataAccess.abstracts;

import com.muammerdiri.rentACar.entities.concrete.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorDao extends JpaRepository<Color,Integer> {
}
