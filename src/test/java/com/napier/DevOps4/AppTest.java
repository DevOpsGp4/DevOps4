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
    void displayCountiesTestNull()
    {
        app.displayCountries(null);
    }
    // Empty Test
    @Test
    void displayCountiesTestEmpty()
    {
        ArrayList<country> countries = new ArrayList<country>();
        app.displayCountries(countries);
    }
    // Contain  NUll Test
    @Test
    void displayCountiesContainsNull()
    {
        ArrayList<country> countries = new ArrayList<country>();
        countries.add(null);
        app.displayCountries(countries);
    }
}
