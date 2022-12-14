package com.muammerdiri.rentACar.business.concrete;

import com.muammerdiri.rentACar.business.abstracts.CarService;
import com.muammerdiri.rentACar.business.abstracts.CustomerService;
import com.muammerdiri.rentACar.core.utilities.result.Result;
import com.muammerdiri.rentACar.core.utilities.result.SuccessResult;
import com.muammerdiri.rentACar.dataAccess.abstracts.CustomerDao;
import com.muammerdiri.rentACar.entities.concrete.Car;
import com.muammerdiri.rentACar.entities.concrete.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerManager implements CustomerService {

    private CustomerDao customerDao;
    @Autowired
    public CustomerManager(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.findAll();
    }

    @Override
    public Result add(Customer customer) {
        customerDao.save(customer);
        return new SuccessResult("Customer is successfully added.");
    }

    @Override
    public Result delete(Customer customer) {
        customerDao.delete(customer);
        return new SuccessResult("Customer is deleted");
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        return customerDao.findById(id) ;
    }


}
