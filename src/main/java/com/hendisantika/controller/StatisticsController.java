package com.hendisantika.controller;

import com.hendisantika.entity.Car;
import com.hendisantika.repository.CarRepository;
import com.hendisantika.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/02/22
 * Time: 17.46
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/profile/cars/car")
public class StatisticsController {

    private static final String STATISTICS_PAGE_NAME = "statistics";
    private final CarRepository carRepository;
    private final NoteRepository noteRepository;
    private Car car;
    private Float serviceCost,
            partsCost,
            distanceCost,
            totalCost;

    @Autowired
    public StatisticsController(CarRepository carRepository, NoteRepository noteRepository) {
        this.carRepository = carRepository;
        this.noteRepository = noteRepository;
    }

    /**
     * Response for GET request, method passes calculated statistics to model
     *
     * @param id    current car id
     * @param cost  fuel cost from user
     * @param model view model
     * @return
     */
    @GetMapping(value = "/{id}/statistics")
    public String showCarStatisticsPage(@PathVariable(name = "id") String id,
                                        @RequestParam(name = "cost", defaultValue = "1") Float cost,
                                        Model model) {

        car = carRepository.findById(Long.valueOf(id)).get();
        calculateStatisticsForOneCar(car, cost);

        model.addAttribute("id", id);
        model.addAttribute("carPrice", car.getCarDetails().getPrice());
        model.addAttribute("serviceCost", serviceCost);
        model.addAttribute("partsCost", partsCost);
        model.addAttribute("totalCost", totalCost);
        model.addAttribute("distance", car.getMileage());
        model.addAttribute("distanceCost", distanceCost);

        return STATISTICS_PAGE_NAME;
    }

    /**
     * Method responsible for calcuating statistics for given car
     *
     * @param car      car which statistics will be calculated
     * @param fuelCost cost in PLN from user
     */
    private void calculateStatisticsForOneCar(Car car, Float fuelCost) {
        serviceCost = noteRepository.sumCarServiceCost(car.getId());
        partsCost = noteRepository.sumCarPartsCost(car.getId());
        distanceCost = ((car.getMileage() / 100) * fuelCost * car.getCarDetails().getAverageConsumption());
        totalCost = calculateTotalCost(serviceCost, partsCost, distanceCost, car.getCarDetails().getPrice());
    }

    private Float calculateTotalCost(Float serviceCost, Float partsCost, Float distanceCost, Long price) {
        Float totalCost = 0f;

        if (serviceCost != null) {
            totalCost += serviceCost;
        }

        if (partsCost != null) {
            totalCost += partsCost;
        }

        return (totalCost + distanceCost + price);
    }
}
