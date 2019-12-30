package com.okan.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author:   Okan Hollander
 * Date:     29/12/2019
 * Time:     11:55
 */
@Controller
public class IndexController {

    @GetMapping({"", "/", "index", "index.html"})
    public String index() {

        return "index";
    }

    //TODO NOT IMPLEMENTED YET
    @GetMapping("/oups")
    public String errorPage() {
        return "notimplemented";
    }
}
