package com.hendisantika.service;

import com.hendisantika.entity.User;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/02/22
 * Time: 07.32
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    /**
     * Method encodes password and calls default repository implementation
     *
     * @param user user to be saved
     * @return saved user
     */
    User saveAndFlush(User user);
}
