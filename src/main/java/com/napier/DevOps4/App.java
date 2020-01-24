package com.napier.DevOps4;
import java.util.ArrayList;
import java.sql.*;
import java.util.Scanner;
public class App
{


    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();
        // Disconnect from database



        // Quary List

      // a.query12();
/*        ArrayList<city> cities = a.query13();
        a.displayCities(cities);*/
       // a.query13();
     a.query14();
       // a.query15()
        //a.query17();
//        a.query18();
//        a.query19();
        a.disconnect();
    }

    /*** Connection to MySQL database*/
    private Connection con = null;

    /** Connect to the MySQL database.*/
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

    /**
     * 12 - Get the top N populated cities in the world where N is provided by the user.
     */
    public void query12 () {
        System.out.println("Query12 - The top N populated cities  in the world where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of Cities you would like to see - ");
        int input = scanner.nextInt();


        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            String strSelect =
              "SELECT city.Name,country.Name,city.District,city.Population FROM city "
                    + "INNER JOIN country ON city.ID=country.Capital "
                    + "ORDER BY `city`.`Population` DESC LIMIT "+ input;

            // Execute SQL statement
         getcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");

        }
    }
    /**
     * 13 - Get the top N populated countries in a region where N is provided by the user.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<city> query13 () {
        System.out.println("Query13 - The top N populated cities  in a continent  where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of countries you would like to see - ");
        int input = scanner.nextInt();
        scanner.nextLine();
        input += 1;

        System.out.println("Enter Name of a continent - ");
        String Ncon = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT city.Name,city.District,city.Population,country.Name " +
                            "FROM city "
                            + "INNER JOIN country ON city.ID=country.Capital "
                            + "WHERE country.Continent='"+Ncon+"'"
                            + "ORDER BY `city`.`Population` DESC "
                            +limit;
            // Execute SQL statement
            getcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
        return null;
    }
    /**
     * 14 - Get the top N populated countries in a region where N is provided by the user.
     */
    public void query14 () {
        System.out.println("Query14 - The top N populated cities  in a region   where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities you would like to see - ");
        int input = scanner.nextInt();
        scanner.nextLine();
        input += 1;

        System.out.println("Enter Name of region  - ");
        String Nreg = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT city.Name,city.District,city.Population,country.Name " +
                            "FROM city "
                            + "INNER JOIN country ON city.ID=country.Capital "
                            + "WHERE country.Region='"+Nreg+"'"
                            + "ORDER BY `city`.`Population` DESC "
                            +limit;
            // Execute SQL statement
      getcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");

        }
    }
/*    *//**
     * 15 - Get the top N populated countries in a region where N is provided by the user.
     * @return A list of all countries and population, or null if there is an error.
     *//*
    public ArrayList<city> query15 () {
        System.out.println("Query15 - The top N populated cities in a country where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities you would like to see - ");
        int input = scanner.nextInt();
        scanner.nextLine();
        input += 1;

        System.out.println("Enter the name of country  - ");
        String Ncou = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

            String strSelect =
                    "SELECT city.Name,city.District,city.Population,country.Name " +
                            "FROM city "
                            + "INNER JOIN country ON city.ID=country.Capital "
                            + "WHERE country.Name='"+Ncou+"'"
                            + "ORDER BY `city`.`Population` DESC "
                            +limit;
            // Execute SQL statement
            return getcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }*/


    /**
     * Gets all the countries in a continent by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */

    public ArrayList<country> query17 () {
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
            getCapitalcity(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");

        }
        return null;
    }
/*


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

    }*/
    /**
     * Set Methods
     */
    public void getcities (Statement stmt, String strSelect) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(strSelect);
        // Extract country information
        ArrayList<city> cities = new ArrayList<>();
        while (resultSet.next()) {
            city city= new city();
           country country=new country();
            city.setName(resultSet.getString("Name"));
  /*          city.setCountryCode(resultSet.getString("Country"));*/
            city.setPopulation(resultSet.getInt("Population"));
            city.setDistrict(resultSet.getString("District"));
            country.setName(resultSet.getString("country.Name"));
        /*    cities.add(city);*/

            System.out.println(" City- " + city.getName()
                    + ", Country- " + country.getName()
                    + ", Population- " + city.getPopulation()
                    + ", District - " + city.getDistrict());


        }
    }

    /**
     * Set Methods
     * @return An array list of all countries
     */
    private void getCapitalcity (Statement stmt, String strSelect) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(strSelect);
        // Extract country information
        ArrayList<city> getCapitalcity = new ArrayList<>();
        while (resultSet.next()) {
            city city= new city();
            country country=new country();
            city.setName(resultSet.getString("Name"));
            city.setPopulation(resultSet.getInt("Population"));
            country.setName(resultSet.getString("country.Name"));

                System.out.println(" capital city- " + city.getName()
                        + ", Population- " + city.getPopulation()
                        + ", Country- " + country.getName());

        }

    }







}






