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
    //    @Test
//    void testCountryWorld()
//    {
//        try{
//            ArrayList<Country> countries = app.countryWorld();
//            for(Country country : countries){
//                country.Continent= "Asia";
//                country.Name = "China";
//                country.Code = "CHN";
//                country.Capital= "1891";
//                country.Population = 1277558000;
//                country.Region = "Eastern Asia";
//
//            }
//            System.out.print("Country world passed!");
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//
//    @Test
//    void testCountryContinent()
//    {
//        try{
//            ArrayList<Country> countries = app.countryContinent();
//            for(Country country : countries){
//                country.Continent= "Asia";
//                country.Name = "China";
//                country.Code = "CHN";
//                country.Capital= "1891";
//                country.Population = 1277558000;
//                country.Region = "Eastern Asia";
//
//            }
//            System.out.print("Country Continent passed!");
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//
//    @Test
//    void testCountryRegion()
//    {
//        try{
//            ArrayList<Country> countries = app.countryRegion();
//            for(Country country : countries){
//                country.Continent= "Asia";
//                country.Name = "China";
//                country.Code = "CHN";
//                country.Capital= "1891";
//                country.Population = 1277558000;
//                country.Region = "Eastern Asia";
//            }
//            System.out.print("Country Region Passed!");
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//
//    @Test
//    void testTopWorldCountry()
//    {
//        try{
//            ArrayList<Country> countries = app.topWorldCountry();
//            for(Country country : countries){
//                country.Continent= "Asia";
//                country.Name = "China";
//                country.Code = "CHN";
//                country.Capital= "1891";
//                country.Population = 1277558000;
//                country.Region = "Eastern Asia";
//
//            }
//            System.out.print("Top World Country Passed!");
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//
//    @Test
//    void testTopContinentCountry()
//    {
//        try{
//            ArrayList<Country> countries = app.topContinentCountry();
//            for(Country country : countries){
//                country.Continent= "Asia";
//                country.Name = "China";
//                country.Code = "CHN";
//                country.Capital= "1891";
//                country.Population = 1277558000;
//                country.Region = "Eastern Asia";
//            }
//            System.out.print("Top Country Continent Passed!");
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//
//    @Test
//    void testTopRegionCountry()
//    {
//        try{
//            ArrayList<Country> countries = app.topRegionCountry();
//            for(Country country : countries){
//                country.Continent= "Asia";
//                country.Name = "China";
//                country.Code = "CHN";
//                country.Capital= "1891";
//                country.Population = 1277558000;
//                country.Region = "Eastern Asia";
//            }
//            System.out.print("Top Country Region Passed!");
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
    //    @Test
//    void getPeopleCitiesContinentTest()
//    {
//        try{
//            ArrayList<PopulationPercent> populationPercents = app.query23();
//            for(PopulationPercent populationPercent : populationPercents){
//                populationPercent.continentName = "Oceania";
//                populationPercent.countryPopulation = Long.valueOf(30385150);
//                populationPercent.liveInCity = Long.valueOf(13886149);
//                populationPercent.liveInCityPercent = (float)45.7004;
//                populationPercent.noLiveInCity = Long.valueOf(16499001);
//                populationPercent.noLiveInCityPercent = (float)54.2996;
//            }
//            System.out.print("Population Percent check for Continent passed!");
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//    @Test
//    void getPeopleCitiesRegionTest()
//    {
//        try{
//            ArrayList<PopulationPercent> populationPercents = app.query24();
//            for(PopulationPercent populationPercent : populationPercents){
//                populationPercent.regionName = "Micronesia";
//                populationPercent.countryPopulation = Long.valueOf(543000);
//                populationPercent.liveInCity = Long.valueOf(102329);
//                populationPercent.liveInCityPercent = (float)18.8451;
//                populationPercent.noLiveInCity = Long.valueOf(440671);
//                populationPercent.noLiveInCityPercent = (float)81.1549;
//            }
//            System.out.print("Population Percent check for Region passed!");
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//    @Test
//    void getPeopleCitiesCountryTest()
//    {
//        try {
//            ArrayList<PopulationPercent> populationPercents = app.query25();
//            for (PopulationPercent populationPercent : populationPercents){
//                populationPercent.countryName = "Pitcairn";
//                populationPercent.countryPopulation = Long.valueOf(50);
//                populationPercent.liveInCity = Long.valueOf(42);
//                populationPercent.liveInCityPercent = (float)84.0000;
//                populationPercent.noLiveInCity = Long.valueOf(8);
//                populationPercent.noLiveInCityPercent = (float)16.0000;
//            }
//            System.out.print("Population Percent check for Country passed!");
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//    @Test
//    void getPopWorldTest()
//    {
//        try {
//            app.query26();
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//    @Test
//    void getPopContinentTest()
//    {
//        try {
//            ArrayList<Country> popContinent = app.query27();
//            for (Country popCon : popContinent){
//                popCon.Continent = "Oceania";
//                popCon.Population = 30401150;
//            }
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//    @Test
//    void getPopRegionTest()
//    {
//        try {
//            ArrayList<Country> popRegion = app.query28();
//            for (Country popReg : popRegion){
//                popReg.Region = "Micronesia";
//                popReg.Population = 543000;
//            }
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//    @Test
//    void getPopCountryTest()
//    {
//        try {
//            ArrayList<Country> popCountry = app.query29();
//            for (Country popCou : popCountry){
//                popCou.Name = "Pitcairn";
//                popCou.Population = 50;
//            }
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//    @Test
//    void getPopDistrictTest()
//    {
//        try {
//            ArrayList<City> popDistrict = app.query30();
//            for (City popDis : popDistrict){
//                popDis.Name = "West Island";
//                popDis.Population = 167;
//            }
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
//    @Test
//    void getPopCityTest()
//    {
//        try {
//            ArrayList<City> popCity = app.query31();
//            for (City popCty : popCity){
//                popCty.Name = "Adamstown";
//                popCty.Population = 42;
//            }
//        } catch (Exception m) {
//            m.printStackTrace();
//        }
//    }
}

