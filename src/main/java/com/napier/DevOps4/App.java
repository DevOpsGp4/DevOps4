package com.napier.DevOps4;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.*;
import java.util.Scanner;
import java.io.BufferedReader;
public class App
{
    int number;
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        // Quary List
        /*a.query1();
        a.query2();*/
        //a.query17();
        //a.query18();
        //a.query19();
        //a.query12();
        a.query13();
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
    public void query17() {
        System.out.println("Query17 - All the capital cities in the world organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * "
                            + "FROM city "
                            + "INNER JOIN country ON city.ID=country.Capital "
                            + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            if (resultSet.next()) {
                Capitalcity(resultSet);
                System.out.println("Query4 -finished\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query18() {
        System.out.println("Query18 - All the capital cities in the Continent organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * "
                            + "FROM city "
                            + "INNER JOIN country ON city.ID=country.Capital "
                            + "WHERE country.Continent='Asia'"
                            + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            if (resultSet.next()) {
                Capitalcity(resultSet);
                System.out.println("Query4 -finished\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }
    public void query19() {
        System.out.println("Query19 - All the capital cities in the region  organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * "
                            + "FROM city "
                            + "INNER JOIN country ON city.ID=country.Capital "
                            + "WHERE country.Region='Caribbean'"
                            + "ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            if (resultSet.next()) {
                Capitalcity(resultSet);
                System.out.println("Query4 -finished\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query12() throws IOException {
        System.out.println("Query12 - The top N populated countries in the world where N is provided by the user.\n");
        System.out.print("Enter the amount of countries you would like to see - ");
        int input =Integer.parseInt(br.readLine()) + 1;

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement for N populated cities in the world
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT city.Name,city.District,city.Population,country.Name " +
                            "FROM city "
                            + "INNER JOIN country ON city.ID=country.Capital "
                            + "ORDER BY `city`.`Population` DESC "
                            +limit;
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            if (resultSet.next()) {
                city(resultSet);
                System.out.println("Query12 -finished\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query13() throws IOException {
        System.out.println("Query13 - The top N populated countries in a continent  where N is provided by the user.\n");
        System.out.print("Enter Number of populated countries in a continent - ");
        int input =Integer.parseInt(br.readLine()) + 1;

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement for N populated cities in the world
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT city.Name,city.District,city.Population,country.Name " +
                            "FROM city "
                            + "INNER JOIN country ON city.ID=country.Capital "
                            + "WHERE country.Continent='Asia'"
                            + "ORDER BY `city`.`Population` DESC "
                            +limit;
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            if (resultSet.next()) {
                city(resultSet);
                System.out.println("Query13 -finished\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }


















    private void city(ResultSet resultSet) throws SQLException {
        city city= new city();
        country country=new country();
        city.setName(resultSet.getString("Name"));
        city.Population = resultSet.getInt("Population");
        city.District=resultSet.getString("District");
        country.Name = resultSet.getString("country.Name");

        while (resultSet.next()) {
            System.out.println(" City- " + resultSet.getString("Name")
                    + ", Country- " + resultSet.getString("country.Name")
                    + ", Population- " + resultSet.getInt("Population")
                    + ", District - " + resultSet.getInt("District"));
        }
    }

    private void Capitalcity(ResultSet resultSet) throws SQLException {
        city city= new city();
        country country=new country();
        city.setName(resultSet.getString("Name"));
        city.Population = resultSet.getInt("Population");
        country.Name = resultSet.getString("country.Name");

        while (resultSet.next()) {
            System.out.println(" capital city- " + resultSet.getString("Name")
                    + ", Population- " + resultSet.getInt("Population")
                    + ", Country- " + resultSet.getString("country.Name"));
        }
    }



}