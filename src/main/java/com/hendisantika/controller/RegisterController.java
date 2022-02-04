package com.hendisantika.controller;

import com.hendisantika.repository.AuthorityRepository;
import com.hendisantika.repository.UserRepository;
import com.hendisantika.service.UserService;
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
 * Time: 17.41
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    private static final String REGISTRATION_PAGE_NAME = "register",
            LOGIN_PAGE_NAME = "login";
    private final UserRepository userRepository;
    private final UserService userService;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public RegisterController(UserRepository userRepository, UserService userService, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.authorityRepository = authorityRepository;
    }
}
