package com.okan.petclinic.services;

import com.okan.petclinic.model.Vet;

import java.util.Set;

/**
 * Author:   Okan Hollander
 * Date:     28/12/2019
 * Time:     21:24
 */
public interface VetService {

    Vet findById(Long id);

    Set<Vet> findAll();

    Vet save(Vet vet);
}
