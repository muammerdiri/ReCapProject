package com.muammerdiri.rentACar.entities.concrete;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="model_year")
    private int modelYear;

    @Column(name="daily_price")
    private double dailyPrice;

    @Column(name = "car_name")
    private String carName;

    @Size(min = 2)
    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @OneToOne
    @JoinColumn(name = "brand_id",referencedColumnName = "id")
    private Brand brand;

    @ManyToOne()
    @JoinColumn(name = "color_id",referencedColumnName = "id")
    private Color color;

}
