package com.rafaeldeluca.crudcities.view;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CityController {

    private Set<City> cities;

    // constructor
    public CityController() {
        cities = new HashSet<>();
    }    

    @GetMapping("/")
    public String review(Model memory) {
                
        /*
        var cities = Set.of(
            new City("Foz do Iguaçu","PR"),
            new City("Porto Alegre","RS"),
            new City("Salvador","BH"),
            new City("Canoas","RS")
        );
        */

        memory.addAttribute("listOfCities",cities);    

        return "/crud";
    }

    @PostMapping("/create")
    public String create(City city) {
        cities.add(city);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteCity(
        @RequestParam String name,
        @RequestParam String state
    ) {
        cities.removeIf( city -> 
            city.getName().equals(name) &&
            city.getState().equals(state));
         
         return "redirect:/";
    }

}