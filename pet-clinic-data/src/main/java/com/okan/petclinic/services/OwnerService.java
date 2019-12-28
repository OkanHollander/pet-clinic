package com.okan.petclinic.services;

import com.okan.petclinic.model.Owner;

import java.util.Set;

/**
 * Author:   Okan Hollander
 * Date:     28/12/2019
 * Time:     21:22
 */
public interface OwnerService {

    Owner findByLastName(String lastName);

    Set<Owner> findAll();

    Owner findById(Long id);

    Owner save(Owner owner);


}
