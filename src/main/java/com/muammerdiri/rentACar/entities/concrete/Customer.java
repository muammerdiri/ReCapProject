package com.muammerdiri.rentACar.entities.concrete;

import com.muammerdiri.rentACar.core.entities.concrete.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "company_name")
    private String companyName;


    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;



}
