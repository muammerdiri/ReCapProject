package com.muammerdiri.rentACar.controller.api;

import com.muammerdiri.rentACar.business.abstracts.CustomerService;
import com.muammerdiri.rentACar.core.utilities.result.DataResult;
import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.core.utilities.result.SuccessDataResult;
import com.muammerdiri.rentACar.core.utilities.result.SuccessResult;
import com.muammerdiri.rentACar.entities.concrete.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody Customer customer){
        customerService.add(customer);
        return new SuccessResult("Customer is Added");
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestBody Customer customer){
        customerService.delete(customer);
        return new SuccessResult("Customer is Deleted.");
    }

    @PostMapping("/get-user-by-id")
    public DataResult getCustomerById(@RequestParam int id){

        return new SuccessDataResult(customerService.getCustomerById(id),"Customer is Added");
    }

    @GetMapping("getall")
    public DataResult<List<Customer>> getAll(){
        return new SuccessDataResult<>(customerService.getAll());
    }

}
