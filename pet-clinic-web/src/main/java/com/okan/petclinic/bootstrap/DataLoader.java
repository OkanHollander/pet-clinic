package com.okan.petclinic.bootstrap;

import com.okan.petclinic.model.*;
import com.okan.petclinic.services.*;
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
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
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

        // Create Speciality 1
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        // Create Speciality 2
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        //Create Speciality 3
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("****** Loading Specialities ******");
        System.out.println(radiology.getDescription() + " successfully loaded!");
        System.out.println(surgery.getDescription() + " successfully loaded!");
        System.out.println(dentistry.getDescription() + " successfully loaded!");

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

        // Create Visit for owner 2
        Visit catVisit = new Visit();
        catVisit.setPet(owner2Pet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Kitty almost dead");

        visitService.save(catVisit);

        // print message
        System.out.println("****** Loading Owners... ******");
        System.out.println(owner1.getFirstName() + " " + owner1.getLastName() + " successfully loaded!");
        System.out.println(owner2.getFirstName() + " " + owner2.getLastName() + " successfully loaded!");
        System.out.println("****** Loading Visits ******");
        System.out.println(catVisit.getPet().getName() + " successfully loaded!");

        // Create Vet 1
        Vet vet1 = new Vet();
        vet1.setFirstName("Geert");
        vet1.setLastName("Timmer");
        vet1.getSpecialities().add(savedDentistry);

        vetService.save(vet1);

        //Create vet 2
        Vet vet2 = new Vet();
        vet2.setFirstName("Frank");
        vet2.setLastName("Vogler");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);


        // print message
        System.out.println("****** Loading vets... ******");
        System.out.println(vet1.getFirstName() + " " + vet1.getLastName() + " successfully loaded!");
        System.out.println(vet2.getFirstName() + " " + vet2.getLastName() + " successfully loaded!");
    }
}
