package com.hendisantika.controller;

import com.hendisantika.entity.Car;
import com.hendisantika.repository.CarRepository;
import com.hendisantika.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/02/22
 * Time: 17.46
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/profile/cars/car")
public class StatisticsController {

    private static final String STATISTICS_PAGE_NAME = "statistics";
    private final CarRepository carRepository;
    private final NoteRepository noteRepository;
    private Car car;
    private Float serviceCost,
            partsCost,
            distanceCost,
            totalCost;

    @Autowired
    public StatisticsController(CarRepository carRepository, NoteRepository noteRepository) {
        this.carRepository = carRepository;
        this.noteRepository = noteRepository;
    }
}
