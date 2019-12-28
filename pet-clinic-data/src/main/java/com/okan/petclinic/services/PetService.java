package com.okan.petclinic.services;

import com.okan.petclinic.model.Pet;

import java.util.Set;

/**
 * Author:   Okan Hollander
 * Date:     28/12/2019
 * Time:     21:25
 */
public interface PetService {

    Set<Pet> findAll();

    Pet findById(Long id);

    Pet save(Pet pet);
}
