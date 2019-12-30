package com.okan.petclinic.controllers;

import com.okan.petclinic.model.Owner;
import com.okan.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

/**
 * Author:   Okan Hollander
 * Date:     29/12/2019
 * Time:     12:28
 */
@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }


    @GetMapping({"", "/", "/index", "/index.html"})
    public String listOwners(Model model) {

        Set<Owner> listOwners = ownerService.findAll();

        model.addAttribute("listOwners", listOwners);

        return "owners/index";
    }


    //TODO NOT IMPLEMENTED YET
    @GetMapping("/find")
    public String findOwners() {
        return "notimplemented";
    }
}
