package com.okan.petclinic.services.map;

import com.okan.petclinic.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Author:   Okan Hollander
 * Date:     01/01/2020
 * Time:     15:07
 */
class SpecialityMapServiceTest {

    Long specialId = 1L;

    SpecialityMapService specialityMapService;

    @BeforeEach
    void setUp() {
        specialityMapService = new SpecialityMapService();
        specialityMapService.save(Speciality.builder().id(specialId).build());
    }

    @Test
    void findAll() {
        Set<Speciality> specialities = specialityMapService.findAll();

        assertEquals(specialId, specialities.size());
    }

    @Test
    void deleteById() {
        specialityMapService.deleteById(specialId);

        assertEquals(0, specialityMapService.findAll().size());
    }

    @Test
    void delete() {
        specialityMapService.delete(specialityMapService.findById(specialId));
        assertEquals(0, specialityMapService.findAll().size());
    }

    @Test
    void save() {
        Long id = 2L;

        Speciality speciality = Speciality.builder().id(id).build();

        specialityMapService.save(speciality);

        assertEquals(2, specialityMapService.findAll().size());
    }

    @Test
    void saveNoId() {

        Speciality savedSpeciality = Speciality.builder().build();

        assertNotNull(savedSpeciality);
    }

    @Test
    void findById() {

        Speciality speciality = specialityMapService.findById(specialId);

        assertEquals(specialId, speciality.getId());
    }
}
