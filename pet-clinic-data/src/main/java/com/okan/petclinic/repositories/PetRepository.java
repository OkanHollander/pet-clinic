package com.okan.petclinic.repositories;

import com.okan.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * Author:   Okan Hollander
 * Date:     31/12/2019
 * Time:     11:05
 */
public interface PetRepository extends CrudRepository<Pet, Long> {


}
