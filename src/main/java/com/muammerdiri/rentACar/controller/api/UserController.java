package com.muammerdiri.rentACar.controller.api;

import com.muammerdiri.rentACar.business.abstracts.UserService;
import com.muammerdiri.rentACar.core.entities.concrete.User;
import com.muammerdiri.rentACar.core.utilities.result.DataResult;
import com.muammerdiri.rentACar.core.utilities.result.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-user-by-id")
    public DataResult<User> getUserById(@RequestParam int id){
        return userService.getById(id);
    }

}
