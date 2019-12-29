package com.okan.petclinic.bootstrap;

import com.okan.petclinic.model.Owner;
import com.okan.petclinic.model.Vet;
import com.okan.petclinic.services.OwnerService;
import com.okan.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Author:   Okan Hollander
 * Date:     29/12/2019
 * Time:     12:34
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Create owner 1
        Owner owner1 = new Owner();
        owner1.setFirstName("Okan");
        owner1.setLastName("Hollander");

        ownerService.save(owner1);

        // Create owner 2
        Owner owner2 = new Owner();
        owner2.setFirstName("Lavinia");
        owner2.setLastName("Petcu");

        ownerService.save(owner2);

        // print message
        System.out.println("Loading Owners...");
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
        System.out.println("Loading vets...");
        System.out.println(vet1.getFirstName() + " " + vet1.getLastName() + " successfully loaded!");
        System.out.println(vet2.getFirstName() + " " + vet2.getLastName() + " successfully loaded!");


    }
}
