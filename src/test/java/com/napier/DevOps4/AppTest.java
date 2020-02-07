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
    @Test
    void displayCountiesTestNull() {
        //What happens when we pass nulls to getCountry - Since our main doesn't do anything yet, it is not implemented yet
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
    void getCityListTestEmpty() {
        //What happens when we pass null to getCityList - Since our main doesn't do anything yet, it is not implemented yet
        app.displayCCities(null);
    }
    //Capital City Testing
    @Test
    void getCityTestEmpty() {
        //What happens when we pass nulls to getCity - Since our main doesn't do anything yet, it is not implemented yet
        app.displayCities(null);
    }
    //Empty Test
    @Test
    void displayCCitiesTestEmpty() {
        ArrayList<City> cities = new ArrayList<>();
        app.displayCCities(cities);
    }
    //Contain Null Test
    @Test
    void displayCitiesContainsNull() {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.displayCCities(cities);
    }
    void getCountryListTestEmpty() {
        //What happens when we pass null to getCountryList - Since our main doesn't do anything yet, it is not implemented yet
        app.displaylangauge(null);
    }
}
