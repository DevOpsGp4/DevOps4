package com.napier.DevOps4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect();
    }

    @Test
    void getCountryTest() {

        ArrayList<Country> countries = new ArrayList<>();
        Country Country = new Country();
        Country.Code = "ABW";
        Country.Name = "Aruba";
        Country.Continent = "North America";
        Country.Region = "Caribbean";
    }

    @Test
    void getcityTest() {
        ArrayList<City> cities = new ArrayList<>();
        City City = new City();
        City.Name = "Kabul";
        City.CountryCode = "AFG";
        City.Population = 1780000;
    }

    @Test
    void getcountrylanguageTest() {
        ArrayList<Countrylanguage> countrylanguage = new ArrayList<>();
        Countrylanguage Countrylanguage = new Countrylanguage();
        Countrylanguage.CountryCode = "ABW";
        Countrylanguage.Language = "Dutch";
    }
}

