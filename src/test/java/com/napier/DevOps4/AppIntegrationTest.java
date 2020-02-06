package com.napier.DevOps4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void getCountryTest()
    {
        ArrayList<Country> countries  = new ArrayList<Country>();
        Country Country = new Country();
        Country.Code = "ABW";
        Country.Name = "Aruba";
        Country.Continent = "North America";
        Country.Region = "Caribbean";
    }
    @Test
    void getCitiesTest()
    {
        ArrayList<City> cities  = new ArrayList<City>();
        City city = new City();
        city.Name = "Kabul";
        city.CountryCode = "AFG";
        city.Population = 1780000;
    }
    @Test
    void getCountrylanguagesTest()
    {
        ArrayList<Countrylanguage> countrylanguages  = new ArrayList<Countrylanguage>();
        Countrylanguage Countrylanguage = new Countrylanguage();
        Countrylanguage.CountryCode = "ABW";
        Countrylanguage.Language = "Dutch";
    }
}

