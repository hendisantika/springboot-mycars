package com.hendisantika.controller;

import com.hendisantika.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/02/22
 * Time: 17.34
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ImagesController {

    private final CarRepository carRepository;

    @Autowired
    public ImagesController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
