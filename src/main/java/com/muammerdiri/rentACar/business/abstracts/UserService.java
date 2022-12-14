package com.muammerdiri.rentACar.business.abstracts;

import com.muammerdiri.rentACar.core.entities.concrete.User;
import com.muammerdiri.rentACar.core.utilities.result.DataResult;
import com.muammerdiri.rentACar.core.utilities.result.Result;

import java.util.List;

public interface UserService {
    Result add(User user) throws Exception;
    Result delete(User user );
    List<User> getAll();
    DataResult<User> getById(int id);
}
