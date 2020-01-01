package com.okan.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Author:   Okan Hollander
 * Date:     29/12/2019
 * Time:     21:03
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity{

    @Column(name = "description")
    private String description;

    @Builder
    public Speciality(Long id, String description) {
        super(id);
        this.description = description;
    }
}
