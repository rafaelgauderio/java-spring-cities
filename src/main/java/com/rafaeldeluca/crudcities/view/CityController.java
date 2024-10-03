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
    public String create(@Valid City city, BindingResult validation, Model memory) { 

        if(validation.hasErrors()==true) {
            validation 
                .getFieldErrors()                 
                .forEach( error ->                
                    memory.addAttribute(error.getField(),
                    error.getDefaultMessage())
                 );
            memory.addAttribute("providedName",city.getName());
            memory.addAttribute("providedState", city.getState());
            memory.addAttribute("listOfCities",cities);
            return ("/crud");
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
            city.getName().equalsIgnoreCase(name) &&
            city.getState().equalsIgnoreCase(state));
         
         return "redirect:/";
    }

    @GetMapping("/preparingUpdate")
    public String preparingUpdate (
        @RequestParam String name,
        @RequestParam String state,       
        Model memory)   {

            
       var updateCity = cities
            .stream()
            .filter(
                city -> city.getName().equalsIgnoreCase(name) &&
                        city.getState().equalsIgnoreCase(state))
            .findAny(); 
        if(updateCity.isPresent()) {
            memory.addAttribute("updateCity",updateCity.get());
            memory.addAttribute("listOfCities",cities);
        }
        return "/crud";
    }

    @PostMapping("/update")
    public String update (@Valid
        @RequestParam String updateName,
        @RequestParam String updateState,        
        @Valid City city,
        BindingResult validation,
        Model memory) {

        if (validation.hasErrors()==true) {
            validation 
                .getFieldErrors()                 
                .forEach( error ->                
                    memory.addAttribute(error.getField(),
                    error.getDefaultMessage())
                 );
            memory.addAttribute("providedName",city.getName());
            memory.addAttribute("providedState", city.getState());
            memory.addAttribute("listOfCities",cities);   
        }           
       
             cities.removeIf(updateCity -> 
                                updateCity.getName().equalsIgnoreCase(updateName) &&
                                updateCity.getState().equalsIgnoreCase(updateState));
            create(city, validation, memory);
            return "redirect:/";
        }    
    

}