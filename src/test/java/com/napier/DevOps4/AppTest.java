package com.napier.DevOps4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
    }

    //Country Testing
    // Null Test
    @Test
    void displayCountiesTestNull() {
        app.displayCountries(null);
    }

    // Empty Test
    @Test
    void displayCountiesTestEmpty() {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.displayCountries(countries);
    }

    // Contain  Null Test
    @Test
    void displayCountiesContainsNull() {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCountries(countries);
    }

    //City Testing
    // Null Test
    @Test
    void displayCitiesTestNull(){
        app.displayCCities(null);
    }

    //Empty Test
    @Test
    void displayCitiesTestEmpty(){
        ArrayList<City> cities = new ArrayList<City>();
        app.displayCCities(cities);
    }

    //Contain Null Test
    @Test
    void displayCitiesContainsNull() {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.displayCCities(cities);
    }
}
