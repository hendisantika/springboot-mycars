package com.hendisantika.repository;

import com.hendisantika.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/02/22
 * Time: 07.31
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
