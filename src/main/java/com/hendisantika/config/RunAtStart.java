package com.hendisantika.config;

import com.hendisantika.repository.AuthorityRepository;
import com.hendisantika.repository.CarRepository;
import com.hendisantika.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
