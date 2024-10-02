package com.rafaeldeluca.crudcities.view;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// class Model of MVC
public final class City {

    @NotBlank(message="{app.city.blank}")
    @Size(min=3, max=50, message="{app.city.size}")
    private final String name;

    @NotBlank(message="{app.state.blank}")
    @Size(min=2, max=2, message="{app.state.size}")
    private final String state;

    public City (final String name, final String state) {
        this.name = name;
        this.state = state.toUpperCase();
    }

    public String getName () {
        return name;
    }   

    public String getState () {
        return state;
    }  

     

}