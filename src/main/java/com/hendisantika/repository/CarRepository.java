package com.hendisantika.repository;

import com.hendisantika.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/02/22
 * Time: 07.30
 * To change this template use File | Settings | File Templates.
 */
public interface CarRepository extends JpaRepository<Car, Long> {
}
