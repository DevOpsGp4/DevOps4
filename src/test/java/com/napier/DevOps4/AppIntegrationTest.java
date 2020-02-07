package com.napier.DevOps4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest {
    static App app;

    @BeforeAll
    static void init() {
        App a = new App();
    }

    @Test
    void getCountryTest()
    {
        ArrayList<Country> countries  = new ArrayList<>();
        Country Ctry1 = new Country();
        Ctry1.Code = "ABW";
        Ctry1.Name = "Aruba";
        Ctry1.Continent = "North America";
        Ctry1.Region = "Caribbean";
    }
    @Test
    void getCitiesTest()
    {
        ArrayList<City> cities  = new ArrayList<>();
        City city = new City();
        city.Name = "Kabul";
        city.CountryCode = "AFG";
        city.Population = 1780000;
    }
    @Test
    void TestCountrylanguages()
    {
        ArrayList<Countrylanguage> countrylanguages  = new ArrayList<>();
        Countrylanguage Countrylanguage = new Countrylanguage();
        Countrylanguage.CountryCode = "ABW";
        Countrylanguage.Language = "Dutch";
    }
}

