package com.okan.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Author:   Okan Hollander
 * Date:     29/12/2019
 * Time:     20:59
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    // == Fields ==
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @Builder
    public Visit(Long id, LocalDate date, String description, Pet pet) {
        super(id);
        this.date = date;
        this.description = description;
        this.pet = pet;
    }
}
