package com.napier.DevOps4;

import java.sql.*;
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
        // Quary List
        a.query1();
        a.query2();
        a.query3();
        a.query4();
        a.query5();
        a.query6();
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

    private void country(ResultSet resultSet) throws SQLException {
        country country = new country();
        country.Code = resultSet.getString("Code");
        country.Name = resultSet.getString("Name");
        country.Continent = resultSet.getString("Continent");
        country.Region = resultSet.getString("Region");
        country.Population = resultSet.getInt("Population");
        country.Capital = resultSet.getInt("Capital");

        while (resultSet.next()) {
            System.out.println("Code - " + resultSet.getString("Code")
                    + ", Name - " + resultSet.getString("Name")
                    + ", Continent - " + resultSet.getString("Continent")
                    + ", Region - " + resultSet.getString("Region")
                    + ", Population - " + resultSet.getInt("Population")
                    + ", Capital - " + resultSet.getInt("Capital"));
        }
    }

    public void query1() {
        System.out.println("Query1 - All the countries in a continent organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * "
                            + "FROM country "
                            + "ORDER BY Continent, Population DESC";

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);

            if (resultSet.next()) {
                country(resultSet);
                System.out.println("Query1 -Finished\n");
            }
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void query2() {
        System.out.println("Query2 - All the countries in a region organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT *"
                            + "FROM country "
                            + "ORDER BY Region, Population DESC";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            if (resultSet.next()) {
                country(resultSet);
                System.out.println("Query2 -finished\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void query3() {
        System.out.println("Query3 - All the countries in the world organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT *"
                            + "FROM country "
                            + "ORDER BY Name, Population DESC";
            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            if (resultSet.next()) {
                country(resultSet);
                System.out.println("Query3 -finished\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void query4() {
        System.out.println("Query4 - The top N populated countries in the world where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of countries you would like to see - ");
        int input = scanner.nextInt();
        input += 1;

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT * "
                            + "FROM country "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            if (resultSet.next()) {
                country(resultSet);
                System.out.println("Query4 -finished\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }

    }

    public void query5() {
        System.out.println("Query5 - The top N populated countries in a region where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of countries you would like to see - ");
        int input = scanner.nextInt();
        scanner.nextLine();
        input += 1;

        System.out.println("Enter the region you would like to see - ");
        String input_region = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT * "
                            + "FROM country "
                            + "WHERE Region = \"" + input_region + "\" "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            if (resultSet.next()) {
                country(resultSet);
                System.out.println("Query5 -finished\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    public void query6() {
        System.out.println("Query6 - The top N populated countries in a continent where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of countries you would like to see - ");
        int input = scanner.nextInt();
        scanner.nextLine();
        input += 1;

        System.out.println("Enter the continent you would like to see - ");
        String input_continent = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT * "
                            + "FROM country "
                            + "WHERE Continent = \"" + input_continent + "\" "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            ResultSet resultSet = stmt.executeQuery(strSelect);
            if (resultSet.next()) {
                country(resultSet);
                System.out.println("Query6 -finished\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

}