package com.okan.petclinic.controllers;

import com.okan.petclinic.model.Vet;
import com.okan.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

/**
 * Author:   Okan Hollander
 * Date:     29/12/2019
 * Time:     12:15
 */
@Controller
public class VetController {

    private final VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
    public String listVets(Model model) {

        Set<Vet> listVets = vetService.findAll();

        model.addAttribute("listVets", listVets);

        return "vets/index";
    }
}
