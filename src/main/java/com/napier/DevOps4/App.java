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
        // Quary List
        a.cityWorld();
        a.cityDistrict();

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

    public void cityWorld() {
        System.out.println("All the cities in the World organised by largest population to smallest.\n");
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                        "SELECT *"
                            + "FROM city "
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next()) {
                city city = new city();
                city.Name = resultSet.getString("Name");
                city.Population = resultSet.getInt("Population");
                city.CountryCode = resultSet.getString("CountryCode");

                while (resultSet.next()) {
                    System.out.println(" Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population")
                            + ", CountryCode- " + resultSet.getString("CountryCode"));
                }
                System.out.println("All Cities in the World : Finished\n");
            }
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void cityDistrict() {
        System.out.println("All the cities in a district organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT *"
                            + "FROM city "
                            + "WHERE District = 'Adana'"
                            + "ORDER BY Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next()) {
                city city = new city();
                city.Name = resultSet.getString("Name");
                city.Population = resultSet.getInt("Population");
                city.CountryCode = resultSet.getString("CountryCode");
                city.District = resultSet.getString("District");

                while (resultSet.next()) {
                    System.out.println(" Name- " + resultSet.getString("Name")
                            + ", Population- " + resultSet.getInt("Population")
                            + ", CountryCode- " + resultSet.getString("CountryCode")
                            + ", District- " + resultSet.getString("District"));
                }
                System.out.println("All Cities in a district : Finished\n");
            }
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }




}