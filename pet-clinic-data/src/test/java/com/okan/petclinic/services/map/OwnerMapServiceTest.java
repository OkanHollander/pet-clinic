package com.okan.petclinic.services.map;

import com.okan.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author:   Okan Hollander
 * Date:     01/01/2020
 * Time:     12:48
 */
class OwnerMapServiceTest {

    final Long ownerId = 1L;
    final String lastName = "Hollander";

    OwnerMapService ownerMapService;

    @BeforeEach
    void setUp() {

        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerMapService.findAll();

        assertEquals(ownerId, ownerSet.size());
    }

    @Test
    void deleteById() {

        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());

    }

    @Test
    void delete() {

        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());

    }

    @Test
    void saveExistingId() {

        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id, savedOwner.getId());

    }

    @Test
    void saveNoId() {

        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {

        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(1, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerMapService.findByLastName(lastName);

        assertNotNull(owner);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerMapService.findByLastName("foo");

        assertNull(owner);
    }
}
