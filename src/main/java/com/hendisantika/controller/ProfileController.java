package com.hendisantika.controller;

import com.hendisantika.entity.User;
import com.hendisantika.repository.UserRepository;
import com.hendisantika.service.UserService;
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
 * Time: 17.38
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    private static final String PROFILE_PAGE_NAME = "profile";
    private final UserService userService;
    private final UserRepository userRepository;
    private final MessageSource messageSource;
    private User user;

    @Autowired
    public ProfileController(UserService userService, UserRepository userRepository, MessageSource messageSource) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.messageSource = messageSource;
    }

    /**
     * Called when IOException occurs
     *
     * @param locale current Locale
     * @return cars page model
     */
    @ExceptionHandler(IOException.class)
    public ModelAndView handleIOException(Locale locale) {
        ModelAndView modelAndView = new ModelAndView("/profile");
        modelAndView.addObject("error", messageSource.getMessage("image.io.exception", null, locale));
        return modelAndView;
    }

}
