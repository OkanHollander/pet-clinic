package com.okan.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author:   Okan Hollander
 * Date:     29/12/2019
 * Time:     12:15
 */
@Controller
@RequestMapping("/vets")
public class VetController {


    @GetMapping({"", "/", "index", "index.html"})
    public String listVets() {

        return "vets/index";
    }
}
