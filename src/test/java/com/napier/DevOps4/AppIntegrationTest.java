package com.napier.DevOps4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

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
    void getCountryTest() {

        ArrayList<country> countries = new ArrayList<country>();
        country myCountry = new country();
        myCountry.Code = "ABW";
        myCountry.Name = "Aruba";
        myCountry.Continent = "North America";
        myCountry.Region = "Caribbean";
    }
}

