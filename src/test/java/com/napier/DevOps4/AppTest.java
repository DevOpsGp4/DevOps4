package com.napier.DevOps4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    // Null Test
    @Test
    void displayCitiesTestNull()
    {
        app.displayCities(null);
    }
    // Empty Test
    @Test
    void displayCitiesTestEmpty()
    {
        ArrayList<city> cities = new ArrayList<city>();
        app.displayCities(cities);
    }
    // Contain  NUll Test
    @Test
    void displayCitiesContainsNull()
    {
        ArrayList<city> cities = new ArrayList<city>();
        cities.add(null);
        app.displayCities(cities);
    }

    @Test
    void displayCities()
    {
        ArrayList<city> cities = new ArrayList<city>();
        city cy = new city();
        cy.setName("Adana");
       cy.setCountryCode("Turkey");
        cy.setDistrict("Adana");
        cy.setPopulation(12);
        cities.add(cy);
        app.displayCities(cities);
    }


    @Test
    void displayCapitalCitiesTestNull()
    {
        app.displayCCities(null);
    }
    // Empty Test
    @Test
    void displayCapitalCitiesTestEmpty()
    {
        ArrayList<city> cities = new ArrayList<city>();
        app.displayCCities(cities);
    }
    // Contain  NUll Test
    @Test
    void displayCapitalCitiesContainsNull()
    {
        ArrayList<city> cities = new ArrayList<city>();
        cities.add(null);
        app.displayCCities(cities);
    }

    @Test
    void displayCapitalCities()
    {
        ArrayList<city> cities = new ArrayList<city>();
        city ccy = new city();
        ccy.setName("Adana");
        ccy.setCountryCode("Turkey");
        ccy.setPopulation(12);
        cities.add(ccy);
        app.displayCCities(cities);
    }
 }