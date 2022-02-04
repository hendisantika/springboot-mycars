package com.hendisantika.controller;

import com.hendisantika.entity.User;
import com.hendisantika.repository.UserRepository;
import com.hendisantika.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
