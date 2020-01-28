package com.napier.DevOps4;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class
 */
public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Query output List
//        ArrayList<country> popContinent = new ArrayList<country>();
//        popContinent = a.query25();
//        System.out.println(String.format("%-25s %-25s %-25s %-25s", "Continent Name", "Continent Population", "Living in Cities", "Not living in Cities"));
//        for (country popCon:popContinent)
//        {
//            System.out.println(String.format("%-25s %-25s %-25s %-25s", popCon.getName(), a, b, (a-b)));
//        }
//        System.out.println("====================================================================================================");

        a.query26();
        System.out.println("====================================================================================================");

        ArrayList<country> continents = new ArrayList<country>();
        continents = a.query27();
        System.out.println(String.format("%-25s %-25s", "Continent Name", "Continent Population"));
        for (country cont:continents)
        {
            System.out.println(String.format("%-25s %-25s", cont.getContinent(), cont.getPopulation()));
        }
        System.out.println("====================================================================================================");

        ArrayList<country> regions = new ArrayList<country>();
        regions = a.query28();
        System.out.println(String.format("%-25s %-25s", "Region Name", "Region Population"));
        for (country reg:regions)
        {
            System.out.println(String.format("%-25s %-25s", reg.getRegion(), reg.getPopulation()));
        }
        System.out.println("====================================================================================================");

        ArrayList<country> countries = new ArrayList<country>();
        countries = a.query29();
        System.out.println(String.format("%-25s %-25s", "Country Name", "Country Population"));
        for (country cs:countries)
        {
            System.out.println(String.format("%-25s %-25s", cs.getName(), cs.getPopulation()));
        }
        System.out.println("====================================================================================================");

        ArrayList<city> districts = new ArrayList<city>();
        districts = a.query30();
        System.out.println(String.format("%-25s %-25s", "District Name", "City Population"));
        for (city d:districts)
        {
            System.out.println(String.format("%-25s %-25s", d.getDistrict(), d.getPopulation()));
        }
        System.out.println("====================================================================================================");

        ArrayList<city> cities = new ArrayList<city>();
        cities = a.query31();
        System.out.println(String.format("%-25s %-25s", "City Name", "City Population"));
        for (city c:cities)
        {
          System.out.println(String.format("%-25s %-25s", c.getName(), c.getPopulation()));
        }
        System.out.println("====================================================================================================");


        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(10000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

//    public void query23 () {
//        try {
//            // Create an SQL statement
//            Statement stmt = con.createStatement();
//            Statement stmt1 = con.createStatement();
//            // Create string for SQL statement
//            String strSelect = "SELECT SUM(country.Population), Continent "
//                    + "FROM country "
//                    + "GROUP BY Continent "
//                    + "HAVING SUM(country.Population) > 0 "
//                    + "ORDER BY Continent "
//                    + "LIMIT 10";
//            String strSelect1 = "SELECT SUM(city.Population), Continent "
//                    + "FROM city, country "
//                    + "WHERE city.CountryCode = country.Code "
//                    + "GROUP BY Continent "
//                    + "ORDER BY Continent "
//                    + "LIMIT 10";
//            // Execute SQL statement
//            ResultSet resultSet = stmt.executeQuery(strSelect);
//            ResultSet resultSet1 = stmt1.executeQuery(strSelect1);
//            System.out.println(String.format("%-25s %-25s %-25s %-25s", "Continent", "Population", "City Population", "Non-city Population"));
//            while (resultSet.next()) {
//                resultSet1.next();
//                String con = resultSet.getString("Continent");
//                Long result = resultSet.getLong("SUM(country.Population)");
//                Long result1 = resultSet1.getLong("SUM(city.Population)");
//                System.out.println(String.format("%-25s %-25s %-25s %-25s", con, result, result1, (result-result1)));
//            }
//            System.out.println("------------------------------------------------------------------------------------------");
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("Failed to get details");
//        }
//    }
//
//    public void query24 () {
//        try {
//            // Create an SQL statement
//            Statement stmt = con.createStatement();
//            Statement stmt1 = con.createStatement();
//            // Create string for SQL statement
//            String strSelect = "SELECT SUM(country.Population), Region "
//                    + "FROM country "
//                    + "GROUP BY Region "
//                    + "HAVING SUM(country.Population) > 0 "
//                    + "ORDER BY Region "
//                    + "LIMIT 10";
//
//            String strSelect1 = "SELECT SUM(city.Population), Region "
//                    + "FROM city, country "
//                    + "WHERE city.CountryCode = country.Code "
//                    + "GROUP BY Region "
//                    + "ORDER BY Region "
//                    + "LIMIT 10";
//            // Execute SQL statement
//            ResultSet resultSet = stmt.executeQuery(strSelect);
//            ResultSet resultSet1 = stmt1.executeQuery(strSelect1);
//            System.out.println(String.format("%-25s %-25s %-25s %-25s", "Region", "Population", "City Population", "Non-city Population"));
//            while (resultSet.next()) {
//                resultSet1.next();
//                String reg = resultSet.getString("Region");
//                Long result = resultSet.getLong("SUM(country.Population)");
//                Long result1 = resultSet1.getLong("SUM(city.Population)");
//                System.out.println(String.format("%-25s %-25s %-25s %-25s", reg, result, result1, (result-result1)));
//            }
//            System.out.println("------------------------------------------------------------------------------------------");
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("Failed to get details");
//        }
//    }
//
//    public ArrayList<country> query25 () {
//        ArrayList<country> popContinent=new ArrayList<country>();
//        try {
//            // Create an SQL statement
//            Statement stmt = con.createStatement();
//            Statement stmt1 = con.createStatement();
//            // Create string for SQL statement
//            String strSelect = "SELECT SUM(country.Population), Name "
//                    + "FROM country "
//                    + "GROUP BY Name "
//                    + "HAVING SUM(country.Population) > 0 "
//                    + "ORDER BY SUM(country.Population) DESC "
//                    + "LIMIT 10";
//            String strSelect1 = "SELECT SUM(city.Population), country.Name "
//                    + "FROM city, country "
//                    + "WHERE city.CountryCode = country.Code "
//                    + "GROUP BY country.Name "
//                    + "ORDER BY SUM(country.Population) DESC "
//                    + "LIMIT 10";
//            // Execute SQL statement
//            ResultSet resultSet = stmt.executeQuery(strSelect);
//            ResultSet resultSet1 = stmt1.executeQuery(strSelect1);
////            System.out.println(String.format("%-25s %-25s %-25s %-25s", "Country Name", "Population", "City Population", "Non-city Population"));
//            while (resultSet.next()) {
//                resultSet1.next();
//                country popCon = new country();
////                String name = resultSet.getString("Name");
////                Long result = resultSet.getLong("SUM(country.Population)");
////                Long result1 = resultSet1.getLong("SUM(city.Population)");
////                System.out.println(String.format("%-25s %-25s %-25s %-25s", name, result, result1, (result-result1)));
//                popCon.setName(resultSet.getString("Name"));
//                long a;
//                long b;
//                a = resultSet.getLong("SUM(country.Population)");
////                popCon.setPopulation(resultSet1.getLong("SUM(city.Population)"));
//                b = resultSet1.getLong("SUM(city.Population)");
//                popContinent.add(popCon);
//            }
//            return popContinent;
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("Failed to get details");
//            return null;
//        }
//    }

    public void query26() {
        ArrayList<country> world=new ArrayList<country>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) "
                    + "FROM country";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            System.out.println("The World Total Population");
            if (resultSet.next()) {
                System.out.println(resultSet.getLong("SUM(Population)"));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public ArrayList<country> query27 () {
        ArrayList<country> continents=new ArrayList<country>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population), Continent "
                    + "FROM country "
                    + "Group By Continent "
                    + "Order By SUM(Population) DESC";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while (resultSet.next()) {
                country cont = new country();
                cont.setContinent(resultSet.getString("Continent"));
                cont.setPopulation(resultSet.getLong("SUM(Population)"));
                continents.add(cont);
            }
            return continents;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    public ArrayList<country> query28 () {
        ArrayList<country> regions=new ArrayList<country>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population), Region "
                    + "FROM country "
                    + "Group By Region "
                    + "Order By SUM(Population) DESC "
                    + "LIMIT 10";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while (resultSet.next()) {
                country reg = new country();
                reg.setRegion(resultSet.getString("Region"));
                reg.setPopulation(resultSet.getLong("SUM(Population)"));
                regions.add(reg);
            }
            return regions;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    public ArrayList<country> query29 () {
        ArrayList<country> countries=new ArrayList<country>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT Population, Name "
                    + "FROM country "
                    + "Order By Population DESC "
                    + "LIMIT 10";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while (resultSet.next()) {
                country cs = new country();
                cs.setName(resultSet.getString("Name"));
                cs.setPopulation(resultSet.getLong("Population"));
                countries.add(cs);
            }
            return countries;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    public ArrayList<city> query30 () {
        ArrayList<city> districts=new ArrayList<city>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population), district "
                    + "FROM city "
                    + "Group By district "
                    + "Order By SUM(Population) DESC "
                    + "LIMIT 10";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while (resultSet.next()) {
                city d = new city();
                d.setDistrict(resultSet.getString("district"));
                d.setPopulation(resultSet.getInt("SUM(Population)"));
                districts.add(d);
            }
            return districts;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    public ArrayList<city> query31 () {
        ArrayList<city> cities=new ArrayList<city>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT Population, name "
                    + "FROM city "
                    + "Order By Population DESC "
                    + "LIMIT 10";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while (resultSet.next()) {
                city c = new city();
                c.setName(resultSet.getString("name"));
                c.setPopulation(resultSet.getInt("Population"));
                cities.add(c);
            }
            return cities;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
}