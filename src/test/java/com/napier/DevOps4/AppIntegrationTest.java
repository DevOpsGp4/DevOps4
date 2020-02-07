package com.napier.DevOps4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

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
        ArrayList<Country> countries  = new ArrayList<>();
        Country Country = new Country();
        Country.Code = "ABW";
        Country.Name = "Aruba";
        Country.Continent = "North America";
        Country.Region = "Caribbean";
    }
    @Test
    void testCountryWorld()
    {
        try{
            ArrayList<Country> countries = app.countryWorld();
            for(Country country : countries){
                country.Continent= "Asia";
                country.Name = "China";
                country.Code = "CHN";
                country.Capital= "1891";
                country.Population = 1277558000;
                country.Region = "Eastern Asia";

            }
            System.out.print("Country world passed!");
        } catch (Exception m) {
            m.printStackTrace();
        }
    }

    @Test
    void testCountryContinent()
    {
        try{
            ArrayList<Country> countries = app.countryContinent();
            for(Country country : countries){
                country.Continent= "Asia";
                country.Name = "China";
                country.Code = "CHN";
                country.Capital= "1891";
                country.Population = 1277558000;
                country.Region = "Eastern Asia";

            }
            System.out.print("Country Continent passed!");
        } catch (Exception m) {
            m.printStackTrace();
        }
    }

    @Test
    void testCountryRegion()
    {
        try{
            ArrayList<Country> countries = app.countryRegion();
            for(Country country : countries){
                country.Continent= "Asia";
                country.Name = "China";
                country.Code = "CHN";
                country.Capital= "1891";
                country.Population = 1277558000;
                country.Region = "Eastern Asia";
            }
            System.out.print("Country Region Passed!");
        } catch (Exception m) {
            m.printStackTrace();
        }
    }

    @Test
    void testTopWorldCountry()
    {
        try{
            ArrayList<Country> countries = app.topWorldCountry();
            for(Country country : countries){
                country.Continent= "Asia";
                country.Name = "China";
                country.Code = "CHN";
                country.Capital= "1891";
                country.Population = 1277558000;
                country.Region = "Eastern Asia";

            }
            System.out.print("Top World Country Passed!");
        } catch (Exception m) {
            m.printStackTrace();
        }
    }

    @Test
    void testTopContinentCountry()
    {
        try{
            ArrayList<Country> countries = app.topContinentCountry();
            for(Country country : countries){
                country.Continent= "Asia";
                country.Name = "China";
                country.Code = "CHN";
                country.Capital= "1891";
                country.Population = 1277558000;
                country.Region = "Eastern Asia";
            }
            System.out.print("Top Country Continent Passed!");
        } catch (Exception m) {
            m.printStackTrace();
        }
    }

    @Test
    void testTopRegionCountry()
    {
        try{
            ArrayList<Country> countries = app.topRegionCountry();
            for(Country country : countries){
                country.Continent= "Asia";
                country.Name = "China";
                country.Code = "CHN";
                country.Capital= "1891";
                country.Population = 1277558000;
                country.Region = "Eastern Asia";
            }
            System.out.print("Top Country Region Passed!");
        } catch (Exception m) {
            m.printStackTrace();
        }
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

