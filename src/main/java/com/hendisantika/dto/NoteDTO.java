package com.hendisantika.dto;

import com.hendisantika.entity.Note;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-mycars
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 03/02/22
 * Time: 07.19
 * To change this template use File | Settings | File Templates.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDTO {
    private Long id;
    @NotNull
    private LocalDate date;
    @NotNull
    @NotEmpty
    private String title;
    @NotNull
    @NotEmpty
    private String description;
    @DecimalMin(value = "0")
    @NotNull
    private Long partsCost;
    @DecimalMin(value = "0")
    @NotNull
    private Long serviceCost;

    public NoteDTO(Note note) {
        this.id = note.getId();
        this.date = note.getDate();
        this.description = new String(note.getNoteContent());
        this.partsCost = note.getPartsCost();
        this.serviceCost = note.getServiceCost();
        this.title = note.getTitle();
    }
}
