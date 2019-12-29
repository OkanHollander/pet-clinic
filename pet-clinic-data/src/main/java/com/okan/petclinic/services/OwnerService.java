package com.okan.petclinic.services;

import com.okan.petclinic.model.Owner;

/**
 * Author:   Okan Hollander
 * Date:     28/12/2019
 * Time:     21:22
 */
public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
