package com.napier.DevOps4;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class
 */
public class App
{
    public static void main(String args[]) {
        // disconnect to database
        Scanner console = new Scanner(System.in);
        char c;
        int n = 0;

        //This is the main menu that will be displayed first.
        System.out.println("  World Population ");
        System.out.println("===============================================");
        System.out.println("1. Country Report");
        System.out.println("2. City Report");
        System.out.println("3. Capital City Report");
        System.out.println("4. Population ");
        System.out.println("5. EXIT PROGRAM");
        System.out.println("===============================================");

        while (n != 5)// Exits the program when 4 is pressed
        {
            System.out.print("\n Please enter option 1-4 to continue...: ");
            n = Integer.parseInt(System.console().readLine());
            // Reads user input and takes them to selected code.
            if (n > 5 || n < 1) {
                System.out.print("Invalid input, please try again...");
                continue;
            }
            if (n == 1)
            {
                // country report
//                subMenu1();
            }

            if (n == 2)
            {
                subMenu2();
                // city report
            }
            if (n == 3)
            {
                // capital city report
            }
            if (n == 4)
            {
                // population report

            }
        }
    }


    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
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
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
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
    public void disconnect ()
    {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public static void subMenu2() {
        Scanner console = new Scanner(System.in);
        // Create new Application
        App a = new App();
        // Connect to database
        a.connect("localhost:33060");
        char c;
        int n = 0;

        // this will be the sub menu that gets displayed.
        System.out.println("  Country Report ");
        System.out.println("===============================================");
        System.out.println("6. All the countries in the world organised by largest population to smallest");
        System.out.println("7. All the countries in a continent organised by largest population to smallest");
        System.out.println("8. All the countries in a region organised by largest population to smallest");
        System.out.println("9. The top N populated countries in the world where N is provided by the user");
        System.out.println("10. The top N populated countries in a continent where N is provided by the user");
         System.out.println("===============================================");
        System.out.println("7. EXIT SUB MENU");

        while (n != 11)// Exits the program when 5 is pressed
        {
            System.out.print("\n Please enter option 1-10 to continue...: ");
            n = Integer.parseInt(System.console().readLine());
            // Reads user input and takes them to selected code.
            if (n > 10 || n < 1) {
                System.out.print("Invalid input, please try again...");
            }
            if (n == 6)
            {
                ArrayList<city> cities = a.query6();
                a.displayCities(cities);
                continue;
            }

            if (n == 7)
            {
                ArrayList<city> cities = a.query7();
                a.displayCities(cities);
                continue;
            }
            if (n == 8)
            {
                ArrayList<city> cities = a.query8();
                a.displayCities(cities);
                continue;
            }
            if (n == 9)
            {
                ArrayList<city> cities = a.query9();
                a.displayCities(cities);
                continue;
            }
            if (n == 10)
            {
                ArrayList<city> cities = a.query10();
                a.displayCities(cities);
                continue;
            }

        }
    }


    /**
     * Display a list of countries.
     * @param cities The list of countries to display.
     */
    public void displayCities (ArrayList < city > cities) {
        // Check employees is not null
//        if (cities == null)
//        {
//            System.out.println("No countries");
//            return;
//        }
        for (city cy : cities) {
            System.out.format("%1$-20s %2$-25s %3$-25s %4$-20s \n", cy.getName(),cy.getCountryCode(),cy.getDistrict(),cy.getPopulation());
        }
    }
    /**
     * Set Methods
     * @return An array list of all countries
     */
    public ArrayList<city> getcities  (Statement stmt, String strSelect) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(strSelect);
        // Extract country information
        ArrayList<city> cities = new ArrayList<city>();
        while (resultSet.next()) {
            city cy = new city();
            cy.setName(resultSet.getString(1));
            cy.setCountryCode(resultSet.getString(2));
            cy.setDistrict(resultSet.getString(3));
            cy.setPopulation(resultSet.getInt(4));
            cities.add(cy);
        }
        return cities;
    }

    /**
     * Get the The top N populated cities in the world where N is provided by the user
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<city> query6 () {
        System.out.println("Query6 - The top N populated cities in the world where N is provided by the user\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int limit = scanner.nextInt();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code ORDER BY Population DESC LIMIT "+limit;

            // Execute SQL statement
            return getcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
    /**
     * Get theThe top N populated cities in a continent where N is provided by the user.
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<city> query7 () {
        System.out.println("Query7 - The top N populated cities in a continent where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of  Cities - ");
        int input = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the Name of continent- ");
        String Ncon  = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();


            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";

                 String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code AND country.Continent='"+Ncon+"' ORDER BY Population DESC  "+limit;

            // Execute SQL statement
            return getcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
    /**
     * Get The top N populated cities in a region where N is provided by the user.
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<city> query8 () {
        System.out.println("Query8 - The top N populated cities in a region where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int input = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the name of region - ");
        String Nreg  = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";
             String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code AND country.region='"+Nreg+"' ORDER BY Population DESC   "+limit;

            // Execute SQL statement
            return getcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
    /**
     * Get The top N populated cities in a country where N is provided by the user.
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<city> query9 () {
        System.out.println("Query9 - The top N populated cities in a country where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int input = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Enter the name of country - ");
        String Ncou  = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";
            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code AND country.Name='"+Ncou+"' ORDER BY Population DESC  "+limit;

            // Execute SQL statement
            return getcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }


    /**
     * Get The top N populated cities in a district where N is provided by the user.
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<city> query10 () {
        System.out.println("Query9 - The top N populated cities in a district where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int input = scanner.nextInt();
        scanner.nextLine();


        System.out.println("Enter the name of district - ");
        String Ndis = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";
             String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code AND city.District='"+Ndis+"' ORDER BY Population DESC  "+limit;

            // Execute SQL statement
            return getcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

}