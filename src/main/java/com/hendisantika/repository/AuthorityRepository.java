package com.hendisantika.repository;

import com.hendisantika.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/02/22
 * Time: 07.29
 * To change this template use File | Settings | File Templates.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByAuthority(String authority);
}
