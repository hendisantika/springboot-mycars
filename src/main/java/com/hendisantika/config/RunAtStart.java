package com.hendisantika.config;

import com.hendisantika.entity.Authority;
import com.hendisantika.entity.Car;
import com.hendisantika.entity.User;
import com.hendisantika.repository.AuthorityRepository;
import com.hendisantika.repository.CarRepository;
import com.hendisantika.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/02/22
 * Time: 07.08
 * To change this template use File | Settings | File Templates.
 */
@Component
public class RunAtStart {
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final AuthorityRepository authorityRepository;

    @Autowired
    public RunAtStart(UserRepository userRepository, CarRepository carRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
        this.authorityRepository = authorityRepository;
    }

    /**
     * Method used to initialize application sample data
     */
    @PostConstruct
    public void initialize() {
        User user = generateSampleUser();
        Authority authority = new Authority("USER");
        Car car1 = generateSampleCar();
        Car car2 = generateSampleCar2();

        userRepository.saveAndFlush(user);
        authorityRepository.saveAndFlush(authority);
        carRepository.saveAndFlush(car1);
        carRepository.saveAndFlush(car2);

        Set<Car> cars = new HashSet<>();
        cars.add(car1);
        cars.add(car2);

        Set<Authority> authorities = new HashSet<>();
        authorities.add(authority);

        user.setCars(cars);
        user.setAuthorities(authorities);

        userRepository.saveAndFlush(user);
    }

    private User generateSampleUser() {
        User user = new User();
        user.setLogin("login");
        user.setPassword(new BCryptPasswordEncoder().encode("1234"));
        user.setFirstName("Uchiha");
        user.setLastName("Sasuke");
        user.setPhone("111-111-111");
        user.setEmail("sasuke@mail.com");
        return user;
    }
}
