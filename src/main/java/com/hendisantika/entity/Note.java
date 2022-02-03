package com.hendisantika.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/02/22
 * Time: 07.25
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "NOTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "NOTE_ID")
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DATE")
    private LocalDate date;
    @Column(name = "SERVICE_COST")
    private Long serviceCost;
    @Column(name = "PARTS_COST")
    private Long partsCost;
    @Column(name = "CONTENT")
    @Lob
    private byte[] noteContent;
    @ManyToOne
    @JoinColumn(name = "CAR_ID")
    private Car owner;
}
