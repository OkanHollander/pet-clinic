package com.okan.petclinic.repositories;

import com.okan.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Author:   Okan Hollander
 * Date:     31/12/2019
 * Time:     11:04
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);


}
