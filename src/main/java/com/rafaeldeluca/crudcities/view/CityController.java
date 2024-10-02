package com.rafaeldeluca.crudcities.view;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

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
    public String create(@Valid City city, BindingResult validation) { 

        if(validation.hasErrors()==true) {
            validation  
                .getFieldErrors()
                .forEach( erro -> 
                System.out.println(
                    String.format("The atribute %s send the message: %s",
                    erro.getField(),
                    erro.getDefaultMessage())
                ));
        } else {
            cities.add(city);
        }       

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

    @GetMapping("/preparingUpdate")
    public String preparingUpdate (
        @RequestParam String name,
        @RequestParam String state,
        Model memory
    )   {
       var updateCity = cities
            .stream()
            .filter(
                city -> city.getName().equals(name) &&
                        city.getState().equals(state))
            .findAny(); 
        if(updateCity.isPresent()) {
            memory.addAttribute("updateCity",updateCity.get());
            memory.addAttribute("listOfCities", cities);
        }
        return "/crud";
    }

    @PostMapping("/update")
    public String update (@Valid
        @RequestParam String updateName,
        @RequestParam String updateState,        
        City city,
        BindingResult validation
            ) {

        cities.removeIf(updateCity -> updateCity.getName().equals(updateName) &&
                                       updateCity.getState().equals(updateState));
              
            create(city,validation);
                             
        
        return "redirect:/";
    }

}