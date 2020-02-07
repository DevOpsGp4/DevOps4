package com.napier.DevOps4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AppTest {
    static App app;

    @BeforeAll
    static void init() {
        App a = new App();
        a.connect("localhost:33060");
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
    @Test
    void getCountryListTestEmpty() {
        //What happens when we pass null to getCountryList - Since our main doesn't do anything yet, it is not implemented yet
        app.displaylangauge(null);
    }

    @Test
    void cityWorldTestNull(){
        app.cityWorld();
    }

    @Test
    void countryContinentTestNull(){
        app.countryContinent();
    }
    @Test
    void countryRegionTestNull(){
        app.countryRegion();
    }
//    @Test
//    void topWorldCountry(){
//        app.topWorldCountry();
//    }
//
//    @Test
//    void topRegionCountry(){
//        app.topRegionCountry();
//    }
//
//    @Test
//    void topContinentCountry(){
//        app.topContinentCountry();
//    }

    @Test
    void cityContinent(){
        app.cityContinent();
    }
    @Test
    void cityRegion(){
        app.cityRegion();
    }
    @Test
    void cityCountry(){
        app.cityCountry();
    }

    @Test
    void cityDistrict(){
        app.cityDistrict();
    }
///    @Test
//    void topWorld(){
//        app.topWorld();
//    }
//    @Test
//    void topContinent(){
//        app.topContinent();
//    }
//    @Test
//    void topRegion(){
//        app.topRegion();
//    }
//    @Test
//    void topCountry(){
//        app.topCountry();
//    }
//    @Test
//    void topDistrict(){
//        app.topDistrict();
//    }
    @Test
    void queryCC1(){
        app.queryCC1();
    }
    @Test
    void queryCC2(){
        app.queryCC2();
    }
    @Test
    void queryCC3(){
        app.queryCC3();
    }
//    @Test
//    void queryCC4(){
//        app.queryCC4();
//    }
//    @Test
//    void queryCC5(){
//        app.queryCC5();
//    }
//
//    @Test
//    void queryCC6(){
//        app.queryCC6();
//    }
//

}
