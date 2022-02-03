package com.hendisantika.repository;

import com.hendisantika.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query(value = "SELECT SUM(SERVICE_COST) FROM Note WHERE CAR_ID = :id", nativeQuery = true)
    Float sumCarServiceCost(@Param(value = "id") Long id);

    @Query(value = "SELECT SUM(PARTS_COST) FROM Note WHERE CAR_ID = :id", nativeQuery = true)
    Float sumCarPartsCost(@Param(value = "id") Long id);
}
