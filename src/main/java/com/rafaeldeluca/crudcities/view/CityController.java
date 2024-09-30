package com.rafaeldeluca.crudcities.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CityController {

    @GetMapping("/")
    public String review() {
        return "crud.html";
    }

}