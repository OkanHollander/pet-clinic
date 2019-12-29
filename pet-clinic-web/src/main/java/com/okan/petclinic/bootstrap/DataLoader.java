package com.okan.petclinic.bootstrap;

import com.okan.petclinic.model.Owner;
import com.okan.petclinic.model.Pet;
import com.okan.petclinic.model.PetType;
import com.okan.petclinic.model.Vet;
import com.okan.petclinic.services.OwnerService;
import com.okan.petclinic.services.PetTypeService;
import com.okan.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Author:   Okan Hollander
 * Date:     29/12/2019
 * Time:     12:34
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Create PetType 1
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        // Create PetType 2
        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        // print message
        System.out.println("****** Loading Pet Types... ******");
        System.out.println(dog.getName() + " successfully loaded!");
        System.out.println(cat.getName() + " successfully loaded!");


        // Create owner 1
        Owner owner1 = new Owner();
        owner1.setFirstName("Okan");
        owner1.setLastName("Hollander");
        owner1.setAddress("123 Street");
        owner1.setCity("Rotterdam");
        owner1.setTelephone("123456789");
        // Create Pet for owner 1
        Pet owner1Pet = new Pet();
        owner1Pet.setName("Doggy");
        owner1Pet.setPetType(dog);
        owner1Pet.setBirthDate(LocalDate.of(2015, 5, 14));
        owner1Pet.setOwner(owner1);

        owner1.getPets().add(owner1Pet);
        ownerService.save(owner1);


        // Create owner 2
        Owner owner2 = new Owner();
        owner2.setFirstName("Lavinia");
        owner2.setLastName("Petcu");
        owner2.setAddress("456 Street");
        owner2.setCity("Rotterdam");
        owner2.setTelephone("987654321");
        // Create Pet for owner 2
        Pet owner2Pet = new Pet();
        owner2Pet.setName("Kitty");
        owner2Pet.setPetType(cat);
        owner2Pet.setBirthDate(LocalDate.of(2012, 10, 11));
        owner2Pet.setOwner(owner2);

        owner2.getPets().add(owner2Pet);
        ownerService.save(owner2);

        // print message
        System.out.println("****** Loading Owners... ******");
        System.out.println(owner1.getFirstName() + " " + owner1.getLastName() + " successfully loaded!");
        System.out.println(owner2.getFirstName() + " " + owner2.getLastName() + " successfully loaded!");

        // Create Vet 1
        Vet vet1 = new Vet();
        vet1.setFirstName("Geert");
        vet1.setLastName("Timmer");

        vetService.save(vet1);

        //Create vet 2
        Vet vet2 = new Vet();
        vet2.setFirstName("Frank");
        vet2.setLastName("Vogler");

        vetService.save(vet2);


        // print message
        System.out.println("****** Loading vets... ******");
        System.out.println(vet1.getFirstName() + " " + vet1.getLastName() + " successfully loaded!");
        System.out.println(vet2.getFirstName() + " " + vet2.getLastName() + " successfully loaded!");


    }
}
