package com.okan.petclinic.model;

/**
 * Author:   Okan Hollander
 * Date:     29/12/2019
 * Time:     21:03
 */
public class Speciality extends BaseEntity{

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
