package com.rafaeldeluca.crudcities.view;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CityController {

    @GetMapping("/")
    public String review(Model memory) {
        
        var cities = Set.of(
            new City("Foz do Iguaçu","PR"),
            new City("Porto Alegre","RS"),
            new City("Salvador","BH"),
            new City("Canoas","RS")
        );

        memory.addAttribute("listOfCities",cities);    

        return "/crud";
    }

}