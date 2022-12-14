package com.muammerdiri.rentACar.core.dataAccess.abstracts;

import com.muammerdiri.rentACar.core.entities.concrete.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

    User getUserById(int id);

}
