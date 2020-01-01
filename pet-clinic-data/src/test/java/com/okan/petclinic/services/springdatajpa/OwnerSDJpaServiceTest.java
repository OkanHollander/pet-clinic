package com.okan.petclinic.services.springdatajpa;

import com.okan.petclinic.model.Owner;
import com.okan.petclinic.repositories.OwnerRepository;
import com.okan.petclinic.repositories.PetRepository;
import com.okan.petclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

/**
 * Author:   Okan Hollander
 * Date:     01/01/2020
 * Time:     16:17
 */
@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    final String LAST_NAME = "Derpson";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner owner;

    @BeforeEach
    void setUp() {

        owner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(owner);


        Owner owner = ownerSDJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(2L).build());
        ownerSet.add(Owner.builder().id(3L).build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2, ownerSet.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(this.owner));

        Owner owner = ownerSDJpaService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = ownerSDJpaService.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {

        Owner ownerToSave = Owner.builder().id(2L).build();

        when(ownerRepository.save(ownerToSave)).thenReturn(this.owner);

        Owner savedOwner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(savedOwner);

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {

        ownerSDJpaService.delete(owner);


        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);

        // times() is ommited because it is optional
        verify(ownerRepository).deleteById(anyLong());

    }
}
