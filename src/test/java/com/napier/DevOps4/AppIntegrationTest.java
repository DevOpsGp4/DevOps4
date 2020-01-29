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
    void getCountryTest() {

        ArrayList<country> countries = new ArrayList<>();
        country myCountry = new country();
        myCountry.Code = "ABW";
        myCountry.Name = "Aruba";
        myCountry.Continent = "North America";
        myCountry.Region = "Caribbean";
    }

    @Test
    void getcityTest() {
        ArrayList<City> cities = new ArrayList<>();
        City mycity = new City();
        mycity.Name = "Kabul";
        mycity.CountryCode = "AFG";
        mycity.Population = 1780000;
    }

    @Test
    void getcountrylanguageTest() {
        ArrayList<countrylanguage> countrylanguage = new ArrayList<>();
        countrylanguage myCountrylanguage = new countrylanguage();
        myCountrylanguage.CountryCode = "ABW";
        myCountrylanguage.Language = "Dutch";
    }
}

