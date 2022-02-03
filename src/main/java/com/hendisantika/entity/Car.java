package com.hendisantika.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/02/22
 * Time: 07.23
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "CAR")
@Data
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "BRAND")
    private String brand;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "MILEAGE", precision = 0)
    private Float mileage;
    @Column(name = "FUEL_TYPE")
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType;
    @Embedded
    private CarDetails carDetails;
    @Lob
    private byte[] carImage;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Note> notes;

    public Car() {
        notes = new ArrayList<>();
        carDetails = new CarDetails();
    }
}
