package com.hendisantika.controller;

import com.hendisantika.entity.User;
import com.hendisantika.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    /**
     * Called on user's profile page, return user's profile image
     *
     * @param request  request
     * @param response response
     */
    @RequestMapping("/image")
    public void writePicture(HttpServletRequest request, HttpServletResponse response) {
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            response.getOutputStream().write(user.getProfileImage());
            response.setContentType("image/jpg");
        } catch (Exception e) {
        }
    }
}
