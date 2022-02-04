package com.hendisantika.controller;

import com.hendisantika.repository.CarRepository;
import com.hendisantika.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/02/22
 * Time: 17.11
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/profile/cars")
public class CarController {

    private static final String REDIRECT_TO_CAR_PAGE_URL = "redirect:/profile/cars/car/%s",
            USERS_CARS_PAGE_NAME = "cars",
            CAR_DETAILS_PAGE_NAME = "car";
    private final CarRepository carRepository;
    private final MessageSource messageSource;
    private final UserRepository userRepository;

    @Autowired
    public CarController(CarRepository carRepository, MessageSource messageSource, UserRepository userRepository) {
        this.carRepository = carRepository;
        this.messageSource = messageSource;
        this.userRepository = userRepository;
    }

    /**
     * Called when IOException occurs
     *
     * @param locale current Locale
     * @return cars page model
     */
    @ExceptionHandler(IOException.class)
    public ModelAndView handleIOException(Locale locale) {

        ModelAndView modelAndView = new ModelAndView("/profile/cars");
        modelAndView.addObject("error", messageSource.getMessage("image.io.exception", null, locale));

        return modelAndView;
    }

    /**
     * Called if any error connected with image file will occure
     *
     * @param locale current Locale
     * @return cars page model
     */
    @RequestMapping("/uploadError")
    public ModelAndView handleUploadError(Locale locale) {

        ModelAndView modelAndView = new ModelAndView("/profile/cars");
        modelAndView.addObject("error", messageSource.getMessage("image.file.too.big", null, locale));

        return modelAndView;
    }
}
