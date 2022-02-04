package com.hendisantika.controller;

import com.hendisantika.dto.NoteDTO;
import com.hendisantika.entity.Car;
import com.hendisantika.repository.CarRepository;
import com.hendisantika.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/02/22
 * Time: 17.20
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/profile/cars/car")
public
class HistoryController {

    private static final String HISTORY_PAGE_NAME = "history",
            REDIRECT_TO_HISTORY_PAGE_URL = "redirect:/profile/cars/car/%s/history";
    private final CarRepository carRepository;
    private final NoteRepository noteRepository;
    private Car car;

    @Autowired
    public HistoryController(CarRepository carRepository, NoteRepository noteRepository) {
        this.carRepository = carRepository;
        this.noteRepository = noteRepository;
    }

    /**
     * Response for GET, method search for car and it's notes in db and passes them to the model
     *
     * @param id    car id
     * @param model page model
     * @return name of the page with car history
     */
    @GetMapping(value = "/{id}/history")
    public String showCarHistory(@PathVariable(name = "id") String id,
                                 Model model) {

        car = carRepository.findById(Long.valueOf(id)).get();

        model.addAttribute("notes", prepareNotesToDisplayOnPage(car.getNotes()));
        model.addAttribute("noteDTO", new NoteDTO());
        model.addAttribute("id", id);

        return HISTORY_PAGE_NAME;
    }

    /**
     * Response for POST,if new note from form is submitted
     *
     * @param id            car id
     * @param form          note from form on the page
     * @param bindingResult validation result
     * @return name of the page with car history
     */
    @PostMapping(value = "/{id}/history", params = {"add"})
    public String submitAddCarHistoryNote(@PathVariable(name = "id") String id,
                                          @Valid NoteDTO form,
                                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return HISTORY_PAGE_NAME;
        }

        saveNoteInDb(form);

        return String.format(REDIRECT_TO_HISTORY_PAGE_URL, id);
    }

    /**
     * Method called when user will submit note removal
     *
     * @param id      car id
     * @param request request
     * @return history car page
     */
    @PostMapping(value = "/{id}/history", params = {"removeIndex"})
    public String submitRemoveCarHistoryNote(@PathVariable(name = "id") String id,
                                             HttpServletRequest request) {

        deleteNoteFromDb(request.getParameter("removeIndex"));

        return String.format(REDIRECT_TO_HISTORY_PAGE_URL, id);
    }
}
