package com.codewithflash.restapi.DTO;

public class Country {
    private  String name;
    private  int population;

    public static Country of(String name, int population) {
        Country country = new Country();
        country.setName("France");
        country.setPopulation(100);
        return  country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }
}
