package com.muammerdiri.rentACar.dataAccess.abstracts;

import com.muammerdiri.rentACar.entities.concrete.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

}
