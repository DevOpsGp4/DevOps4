package com.napier.DevOps4;

import java.sql.*;

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

        // Query List
//        a.query23();
//        a.query24();
        a.query25();
//        a.query26();
//        a.query27();
//        a.query28();
//        a.query29();
//        a.query30();
//        a.query31();

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

    public void query25 () {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            Statement stmt1 = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(country.Population), Continent "
                    + "FROM country "
                    + "GROUP BY Continent "
                    + "HAVING SUM(country.Population) > 0 "
                    + "ORDER BY Continent";
            String strSelect1 = "SELECT SUM(city.Population), Continent "
                    + "FROM city, country "
                    + "WHERE city.CountryCode = country.Code "
                    + "GROUP BY Continent "
                    + "ORDER BY Continent";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            ResultSet resultSet1 = stmt1.executeQuery(strSelect1);
            System.out.println(String.format("%-25s %-25s %-25s %-25s", "Continent", "Population", "City Population", "Non-city Population"));
            while (resultSet.next()) {
                resultSet1.next();
                String con = resultSet.getString("Continent");
                Long result = resultSet.getLong("SUM(country.Population)");
                Long result1 = resultSet1.getLong("SUM(city.Population)");
                System.out.println(String.format("%-25s %-25s %-25s %-25s", con, result, result1, (result-result1)));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void query26 () {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) "
                    + "FROM country";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            if (resultSet.next()) {
                String result = resultSet.getString("SUM(Population)");
                System.out.println("Total population of the world \n" + result + "\n------------------------------");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void query27 () {
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
            System.out.println(String.format("%-25s %-25s", "Continent", "Population"));
            while (resultSet.next()) {
                String con = resultSet.getString("Continent");
                String result = resultSet.getString("SUM(Population)");
                System.out.println(String.format("%-25s %-25s", con, result));
            }
            System.out.println("------------------------------");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void query28 () {
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
            System.out.println(String.format("%-25s %-25s", "Region", "Population"));
            while (resultSet.next()) {
                String reg = resultSet.getString("Region");
                String result = resultSet.getString("SUM(Population)");
                System.out.println(String.format("%-25s %-25s", reg, result));
            }
            System.out.println("------------------------------");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void query29 () {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population), Name "
                    + "FROM country "
                    + "Group By Name "
                    + "Order By SUM(Population) DESC "
                    + "LIMIT 10";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            System.out.println(String.format("%-25s %-25s", "Country Name", "Population"));
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String result = resultSet.getString("SUM(Population)");
                System.out.println(String.format("%-25s %-25s", name, result));
            }
            System.out.println("------------------------------");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void query30 () {
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
            System.out.println(String.format("%-25s %-25s", "District Name", "Population"));
            while (resultSet.next()) {
                String dname = resultSet.getString("district");
                String result = resultSet.getString("SUM(Population)");
                System.out.println(String.format("%-25s %-25s", dname, result));
            }
            System.out.println("------------------------------");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void query31 () {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population), name "
                    + "FROM city "
                    + "Group By name "
                    + "Order By SUM(Population) DESC "
                    + "LIMIT 10";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            System.out.println(String.format("%-25s %-25s", "City Name", "Population"));
            while (resultSet.next()) {
                String cname = resultSet.getString("name");
                String result = resultSet.getString("SUM(Population)");
                System.out.println(String.format("%-25s %-25s", cname, result));
            }
            System.out.println("------------------------------");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }
}