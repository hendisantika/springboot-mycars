package com.hendisantika.controller;

import com.hendisantika.dto.ProfileForm;
import com.hendisantika.entity.User;
import com.hendisantika.repository.UserRepository;
import com.hendisantika.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    /**
     * Called if any error connected with image file will occure
     *
     * @param locale current Locale
     * @return cars page model
     */
    @RequestMapping("/uploadError")
    public ModelAndView handleUploadError(Locale locale) {
        ModelAndView modelAndView = new ModelAndView("/profile");
        modelAndView.addObject("error", messageSource.getMessage("image.file.too.big", null, locale));
        return modelAndView;
    }

    /**
     * Called to show user profile page - adds user data to model
     *
     * @param model view model
     * @return user's profile page
     */
    @GetMapping
    public String showProfilePage(Model model) {
        user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("profileForm", ProfileForm.createProfileFormFromUser(user));
        model.addAttribute("image", user.getProfileImage() != null);

        return PROFILE_PAGE_NAME;
    }

    /**
     * Called when user will submit form and choose which image to load into db as profile image
     *
     * @param file               file chose by user
     * @param redirectAttributes
     * @param locale             current Locale
     * @return car edition page
     * @throws IOException if something gone wrong while reading bytes from file
     */
    @RequestMapping(method = RequestMethod.POST, params = {"load"})
    public String loadProfilePicture(MultipartFile file,
                                     RedirectAttributes redirectAttributes,
                                     Locale locale) throws IOException {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", messageSource.getMessage("image.file.empty", null, locale));
            return "redirect:/profile";
        } else if (!file.getContentType().startsWith("image")) {
            redirectAttributes.addFlashAttribute("error", messageSource.getMessage("image.file.invalid", null, locale));
            return "redirect:/profile";
        }

        user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setProfileImage(file.getBytes());
        userService.saveAndFlush(user);

        return "redirect:/profile";
    }

    /**
     * Called when user will save profile data
     *
     * @param profileForm   profile data from form
     * @param bindingResult result of form validation
     * @return user's profile page
     */
    @RequestMapping(method = RequestMethod.POST, params = {"save"})
    public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return PROFILE_PAGE_NAME;
        }

        user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.updateProfileFromProfileForm(profileForm);
        userService.saveAndFlush(user);

        return "redirect:/profile";
    }
}
