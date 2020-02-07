package com.napier.DevOps4;

import java.sql.*;
import java.util.ArrayList;

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
        ArrayList<PopulationPercent> populationPerCon = new ArrayList<PopulationPercent>();
        populationPerCon = a.query23();
        System.out.println("All continents of the world including both population numbers and percent");
        System.out.println(String.format("%-25s %-25s %-25s %-25s %-25s %-25s", "Continent Name", "Total Population", "City Population", "City Population (%)", "Non-city Population", "Non-city Population (%)"));
        for (PopulationPercent per:populationPerCon)
        {
            System.out.println(String.format("%-25s %-25s %-25s %-25s %-25s %-25s", per.getContinentName(), per.getCountryPopulation(), per.getLiveInCity(), per.getLiveInCityPercent(), per.getNoLiveInCity(), per.getNoLiveInCityPercent()));
        }
        System.out.println("========================================================================================================================================================================================================");

        ArrayList<PopulationPercent> populationPerReg = new ArrayList<PopulationPercent>();
        populationPerReg = a.query24();
        System.out.println("Top 10 populated regions including both population numbers and percent");
        System.out.println(String.format("%-25s %-25s %-25s %-25s %-25s %-25s", "Region Name", "Total Population", "City Population", "City Population (%)", "Non-city Population", "Non-city Population (%)"));
        for (PopulationPercent per:populationPerReg)
        {
            System.out.println(String.format("%-25s %-25s %-25s %-25s %-25s %-25s", per.getRegionName(), per.getCountryPopulation(), per.getLiveInCity(), per.getLiveInCityPercent(), per.getNoLiveInCity(), per.getNoLiveInCityPercent()));
        }
        System.out.println("========================================================================================================================================================================================================");

        ArrayList<PopulationPercent> populationPerCou = new ArrayList<PopulationPercent>();
        populationPerCou = a.query25();
        System.out.println("Top 10 populated countries including both population numbers and percent");
        System.out.println(String.format("%-25s %-25s %-25s %-25s %-25s %-25s", "Country Name", "Total Population", "City Population", "City Population (%)", "Non-city Population", "Non-city Population (%)"));
        for (PopulationPercent per:populationPerCou)
        {
            System.out.println(String.format("%-25s %-25s %-25s %-25s %-25s %-25s", per.getCountryName(), per.getCountryPopulation(), per.getLiveInCity(), per.getLiveInCityPercent(), per.getNoLiveInCity(), per.getNoLiveInCityPercent()));
        }
        System.out.println("========================================================================================================================================================================================================");

        a.query26();
        System.out.println("====================================================================================================");

        ArrayList<country> continents = new ArrayList<country>();
        continents = a.query27();
        System.out.println("Population of all continents");
        System.out.println(String.format("%-25s %-25s", "Continent Name", "Continent Population"));
        for (country cont:continents)
        {
            System.out.println(String.format("%-25s %-25s", cont.getContinent(), cont.getPopulation()));
        }
        System.out.println("====================================================================================================");

        ArrayList<country> regions = new ArrayList<country>();
        regions = a.query28();
        System.out.println("Top 10 populated regions");
        System.out.println(String.format("%-25s %-25s", "Region Name", "Region Population"));
        for (country reg:regions)
        {
            System.out.println(String.format("%-25s %-25s", reg.getRegion(), reg.getPopulation()));
        }
        System.out.println("====================================================================================================");

        ArrayList<country> countries = new ArrayList<country>();
        countries = a.query29();
        System.out.println("Top 10 populated countries");
        System.out.println(String.format("%-25s %-25s", "Country Name", "Country Population"));
        for (country cs:countries)
        {
            System.out.println(String.format("%-25s %-25s", cs.getName(), cs.getPopulation()));
        }
        System.out.println("====================================================================================================");

        ArrayList<city> districts = new ArrayList<city>();
        districts = a.query30();
        System.out.println("Top 10 populated districts");
        System.out.println(String.format("%-25s %-25s", "District Name", "City Population"));
        for (city d:districts)
        {
            System.out.println(String.format("%-25s %-25s", d.getDistrict(), d.getPopulation()));
        }
        System.out.println("====================================================================================================");

        ArrayList<city> cities = new ArrayList<city>();
        cities = a.query31();
        System.out.println("Top 10 populated cities");
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

    public ArrayList<PopulationPercent> query23 () {
        try {
            ArrayList<PopulationPercent> populationPerCon=new ArrayList<>();
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT country.Continent AS NAME, " +
                    "SUM(DISTINCT country.Population) AS total, " +
                    "SUM(city.Population) AS yeslive, " +
                    "( (SUM(city.Population) / SUM(DISTINCT country.Population)) * 100 ) AS yesper, " +
                    "SUM(DISTINCT country.Population) - SUM(city.Population) AS nolive, " +
                    "( ((SUM(DISTINCT country.Population) - SUM(city.Population)) / SUM(DISTINCT country.Population)) * 100 ) AS noper " +
                    "FROM city, country " +
                    "WHERE city.CountryCode = country.Code " +
                    "GROUP BY country.Continent " +
                    "ORDER BY total DESC " +
                    "LIMIT 10";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while (resultSet.next()) {
                PopulationPercent popPer = new PopulationPercent();
                popPer.setContinentName(resultSet.getString("name"));
                popPer.setCountryPopulation(resultSet.getLong("total"));
                popPer.setLiveInCity(resultSet.getLong("yeslive"));
                popPer.setLiveInCityPercent(resultSet.getFloat("yesper"));
                popPer.setNoLiveInCity(resultSet.getLong("nolive"));
                popPer.setNoLiveInCityPercent(resultSet.getFloat("noper"));
                populationPerCon.add(popPer);
            }
            return populationPerCon;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    public ArrayList<PopulationPercent> query24 () {
        ArrayList<PopulationPercent> populationPerReg=new ArrayList<PopulationPercent>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT country.Region AS name, " +
                    "SUM(DISTINCT country.Population) AS total, " +
                    "SUM(city.Population) AS yeslive, " +
                    "( ( SUM(city.Population) / SUM(DISTINCT country.Population) ) * 100 ) AS yesper, " +
                    "SUM(DISTINCT country.Population) - SUM(city.Population) AS nolive, " +
                    "( ( ( SUM(DISTINCT country.Population) - SUM(city.Population) ) / SUM(DISTINCT country.Population) ) * 100 ) AS noper " +
                    "FROM city, country " +
                    "WHERE city.CountryCode = country.Code " +
                    "GROUP BY country.Region " +
                    "ORDER BY yeslive DESC " +
                    "LIMIT 10";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while (resultSet.next()) {
                PopulationPercent popPer = new PopulationPercent();
                popPer.setRegionName(resultSet.getString("name"));
                popPer.setCountryPopulation(resultSet.getLong("total"));
                popPer.setLiveInCity(resultSet.getLong("yeslive"));
                popPer.setLiveInCityPercent(resultSet.getFloat("yesper"));
                popPer.setNoLiveInCity(resultSet.getLong("nolive"));
                popPer.setNoLiveInCityPercent(resultSet.getFloat("noper"));
                populationPerReg.add(popPer);
            }
            return populationPerReg;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    public ArrayList<PopulationPercent> query25 () {
        ArrayList<PopulationPercent> populationPerCou=new ArrayList<PopulationPercent>();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT country.Name as name, country.Population as total, " +
                    "SUM(city.Population) as yeslive, " +
                    "(SUM(city.Population)*100/country.Population) as yesper, " +
                    "(country.Population-SUM(city.Population)) as nolive, " +
                    "((country.Population-SUM(city.Population))*100/country.Population) as noper " +
                    "FROM country " +
                    "INNER JOIN city " +
                    "ON city.CountryCode=country.Code " +
                    "GROUP BY country.Name, country.Population " +
                    "ORDER BY country.Population DESC " +
                    "LIMIT 10";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            while (resultSet.next()) {
                PopulationPercent popPer = new PopulationPercent();
                popPer.setCountryName(resultSet.getString("name"));
                popPer.setCountryPopulation(resultSet.getLong("total"));
                popPer.setLiveInCity(resultSet.getLong("yeslive"));
                popPer.setLiveInCityPercent(resultSet.getFloat("yesper"));
                popPer.setNoLiveInCity(resultSet.getLong("nolive"));
                popPer.setNoLiveInCityPercent(resultSet.getFloat("noper"));
                populationPerCou.add(popPer);
            }
            return populationPerCou;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

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