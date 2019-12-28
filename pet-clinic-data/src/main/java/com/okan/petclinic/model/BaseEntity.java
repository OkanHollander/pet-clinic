package com.okan.petclinic.model;

import java.io.Serializable;

/**
 * Author:   Okan Hollander
 * Date:     28/12/2019
 * Time:     21:31
 */
public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
