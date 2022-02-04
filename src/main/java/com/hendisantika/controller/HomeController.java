package com.hendisantika.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping(value = "/home")
public class HomeController {

    private static final String HOME_PAGE_NAME = "home";

    /**
     * Displays home page of application
     *
     * @return application home page
     */
    @GetMapping
    public String showHomePage() {
        return HOME_PAGE_NAME;
    }
}
