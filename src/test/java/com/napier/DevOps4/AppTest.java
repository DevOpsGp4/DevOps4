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

    //country Testing
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

    // Contain  NUll Test
    @Test
    void displayCountiesContainsNull() {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.displayCountries(countries);
    }
    //City Testing

}
