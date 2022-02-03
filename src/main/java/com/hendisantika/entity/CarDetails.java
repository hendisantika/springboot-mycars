package com.hendisantika.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/02/22
 * Time: 07.24
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDetails {
    @Column(name = "INSURANCE_DATE")
    private LocalDate insuranceDate;
    @Column(name = "SERVICE_DATE")
    private LocalDate serviceDate;
    @Column(name = "ENGINE_SIZE", precision = 0)
    private Float engineSize;
    @Column(name = "HP", precision = 0)
    private Long horsePower;
    @Column(name = "AVERAGE", precision = 1)
    private Float averageConsumption;
    @Column(name = "CITY", precision = 1)
    private Float cityConsumption;
    @Column(name = "HIGHWAY", precision = 1)
    private Float highwayConsumption;
    @Column(name = "PRODUCTION_YEAR", precision = 0)
    private Long yearOfProduction;
    @Column(name = "PRICE")
    private Long price;
    @Column(name = "AVG_DISTANCE_PER_YEAR")
    private Long averageDistancePerYear;
}
