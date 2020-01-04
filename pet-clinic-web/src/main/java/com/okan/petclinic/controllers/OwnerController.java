package com.okan.petclinic.controllers;

import com.okan.petclinic.model.Owner;
import com.okan.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
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

    // different implementation to use model and view at the same time
    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));

        return mav;
    }

}
