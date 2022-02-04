package com.hendisantika.controller;

import com.hendisantika.dto.ProfileForm;
import com.hendisantika.repository.AuthorityRepository;
import com.hendisantika.repository.UserRepository;
import com.hendisantika.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

    /**
     * Called when user wants to register
     *
     * @param model View model
     * @return registration page name
     */
    @GetMapping
    public String showRegistrationPage(Model model) {
        model.addAttribute("profileForm", new ProfileForm());
        return REGISTRATION_PAGE_NAME;
    }

    /**
     * Called when user submits registration form
     *
     * @param profileForm   new user form
     * @param bindingResult form's validation result
     * @param model         View model
     * @return registration page name
     */
    @PostMapping
    public String submitRegistrationForm(@Valid ProfileForm profileForm,
                                         BindingResult bindingResult,
                                         Model model) {

        if (bindingResult.hasErrors()) {
            return REGISTRATION_PAGE_NAME;
        }

        if (userRepository.findByLogin(profileForm.getLogin()) != null) {
            model.addAttribute("error", true);
            return REGISTRATION_PAGE_NAME;
        } else {
            model.addAttribute("error", false);
        }

        registerUserInDb(profileForm);

        return LOGIN_PAGE_NAME;
    }

}
