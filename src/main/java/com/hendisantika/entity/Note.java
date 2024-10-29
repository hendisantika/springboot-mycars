package com.hendisantika.entity;

import com.hendisantika.dto.NoteDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public void setNoteValuesFromForm(NoteDTO form) {
        this.date = form.getDate();
        this.noteContent = form.getDescription().getBytes();
        this.serviceCost = form.getServiceCost();
        this.partsCost = form.getPartsCost();
        this.title = form.getTitle();
    }

    public Note(String title, LocalDate date, Long serviceCost, Long partsCost, byte[] noteContent, Car owner) {
        this.title = title;
        this.date = date;
        this.serviceCost = serviceCost;
        this.partsCost = partsCost;
        this.noteContent = noteContent;
        this.owner = owner;
    }

}
