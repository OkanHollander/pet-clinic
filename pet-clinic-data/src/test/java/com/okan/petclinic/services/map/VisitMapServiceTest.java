package com.okan.petclinic.services.map;

import com.okan.petclinic.model.Owner;
import com.okan.petclinic.model.Pet;
import com.okan.petclinic.model.Visit;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Author:   Okan Hollander
 * Date:     01/01/2020
 * Time:     15:26
 */
class VisitMapServiceTest {

    Long visitId = 1L;
    Long petId = 1L;
    Long ownerId = 1L;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    VisitMapService visitMapService;

    @BeforeEach
    void setUp() {
        visitMapService = new VisitMapService();
        visitMapService.save(Visit.builder().id(visitId)
                .pet(Pet.builder().id(petId)
                        .owner(Owner.builder().id(ownerId)
                                .build()).build()).build());
    }

    @Test
    void findAll() {
        Set<Visit> visitSet = visitMapService.findAll();

        assertEquals(1, visitSet.size());
    }


    @Test
    void findById() {
        Visit visit = visitMapService.findById(visitId);

        assertEquals(1L, visit.getId());
    }

    @Test
    void save() throws Exception{

        Visit visit =

        visitMapService.save(Visit.builder().id(2L)
                .pet(Pet.builder().id(2L)
                        .owner(Owner.builder().id(2L)
                                .build()).build()).build());

        assertEquals(2, visit.getId());
    }


    @Test
    void delete() {
        visitMapService.delete(visitMapService.findById(visitId));

        assertEquals(0, visitMapService.findAll().size());
    }

    @Test
    void deleteById() {
        visitMapService.deleteById(visitId);

        assertEquals(0, visitMapService.findAll().size());
    }
}
