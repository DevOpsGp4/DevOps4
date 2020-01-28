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
        Menus();
        }

    public static void Menus() {
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
            System.out.print("\n Please enter option 1-4 to continue or 5 to exit...: ");
            n = Integer.parseInt(System.console().readLine());
            // Reads user input and takes them to selected code.
            if (n > 6 || n < 1) {
                //invalid input
                System.out.print("Invalid input, please try again...");
                continue;
            }
            if (n == 5) {
                // Exit output
                System.out.print("Thank for using the Program...");
                System.exit(0);
            }
            if (n == 1) {
                // country report
                //subMenu1();
            }

            if (n == 2) {
                // city report
                subMenu2();
            }
            if (n == 3) {
                // capital city report
                subMenu3();
            }
            if (n == 4) {
                // population report

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
        System.out.println("  City Report ");
        System.out.println("===============================================");
        System.out.println("1. All the cities in the world organised by largest population to smallest");
        System.out.println("2. All the cities in a continent organised by largest population to smallest");
        System.out.println("3. All the cities in a region organised by largest population to smallest");
        System.out.println("4. All the cities in a country organised by largest population to smallest");
        System.out.println("5. All the cities in a district organised by largest population to smallest");
        System.out.println("6. The top N populated cities in the world where N is provided by the user");
        System.out.println("7. The top N populated cities in a continent where N is provided by the user");
        System.out.println("8. The top N populated cities in a region where N is provided by the user");
        System.out.println("9. The top N populated cities in a country where N is provided by the user");
        System.out.println("10. The top N populated cities in a district where N is provided by the user");
        System.out.println("===============================================");
        System.out.println("11. EXIT SUB MENU");

        while (n != 11)// Exits the program when 5 is pressed
        {
            System.out.print("\n Please enter option 1-10 to continue or 11 to exit...: ");
            n = Integer.parseInt(System.console().readLine());
            // Reads user input and takes them to selected code.

            if (n > 11 || n < 1) {
                //Invalid input
                System.out.print("Invalid input, please try again...");
            }
            if (n == 11){
                // Exit output
                System.out.print("Back to Menus...");
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Menus();
            }
            if (n == 1)
            {
                ArrayList<city> cities = a.query1();
                a.displayCities(cities);
                continue;
            }
            if (n == 2)
            {
                ArrayList<city> cities = a.query2();
                a.displayCities(cities);
                continue;
            }
            if (n == 3)
            {
                ArrayList<city> cities = a.query3();
                a.displayCities(cities);
                continue;
            }
            if (n == 4)
            {
                ArrayList<city> cities = a.query4();
                a.displayCities(cities);
                continue;
            }
            if (n == 5)
            {
                ArrayList<city> cities = a.query5();
                a.displayCities(cities);
                continue;
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

    /**
     * Display a list of countries.
     * @param cities The list of countries to display.
     */
    public void displayCities (ArrayList < city > cities) {
        // Check search data is not null
        if (cities == null)
        {
            System.out.println("No countries");
            return;
        }
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
     * Gets all the cities in the world by largest population to smallest.
     * @return A list of all cities and population, or null if there is an error.
     */

    public ArrayList<city> query1 () {
        System.out.println("1 - All the cities in the world organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population FROM city, country WHERE city.CountryCode=country.Code ORDER BY city.Population DESC";
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
     * Gets all the cities in a continent by largest population to smallest.
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<city> query2 () {
        System.out.println("2 - All the cities in a continent organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population FROM city INNER JOIN country ON city.CountryCode=country.Code WHERE country.Continent  = 'South America' ORDER BY city.Population DESC";
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
     * Gets all the cities in a region  by largest population to smallest.
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<city> query3 () {
        System.out.println("3 - All the cities in a region  organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population FROM city INNER JOIN country ON city.CountryCode=country.Code WHERE country.Region = 'Caribbean' ORDER BY city.Population DESC";
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
     * Gets all the cities in a country by largest population to smallest.
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<city> query4 () {
        System.out.println("4 - All the cities in a country organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population FROM city INNER JOIN country ON city.CountryCode=country.Code WHERE country.Name  = 'Angola' ORDER BY city.Population DESC";
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
     * Gets all the cities in a district by largest population to smallest.
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<city> query5 () {
        System.out.println("5 - All the cities in a district organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population FROM city INNER JOIN country ON city.CountryCode=country.Code WHERE city.District = 'Adana' ORDER BY city.Population DESC";
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
     * Get the The top N populated cities in the world where N is provided by the user
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<city> query6 () {
        System.out.println("6 - The top N populated cities in the world where N is provided by the user\n");
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
        System.out.println("7 - The top N populated cities in a continent where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of  Cities - ");
        int limit = scanner.nextInt();


        System.out.println("Enter the Name of continent- ");
        String Ncon  = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code AND country.Continent='"+Ncon+"' ORDER BY Population DESC LIMIT "+limit;

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
        System.out.println("8 - The top N populated cities in a region where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int limit = scanner.nextInt();


        System.out.println("Enter the name of region - ");
        String Nreg  = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code AND country.region='"+Nreg+"' ORDER BY Population DESC LIMIT "+limit;

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
        System.out.println("9 - The top N populated cities in a country where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int limit = scanner.nextInt();


        System.out.println("Enter the name of country - ");
        String Ncou  = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement


            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code AND country.Name='"+Ncou+"' ORDER BY Population DESC LIMIT "+limit;

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
        System.out.println("10 - The top N populated cities in a district where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int limit = scanner.nextInt();


        System.out.println("Enter the name of district - ");
        String Ndis = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code AND city.District='"+Ndis+"' ORDER BY Population DESC LIMIT "+limit;

            // Execute SQL statement
            return getcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /*Sub Menus3*/
    public static void subMenu3() {
        Scanner console = new Scanner(System.in);
        // Create new Application
        App a = new App();
        // Connect to database
        a.connect("localhost:33060");
        char c;
        int n = 0;

        // this will be the sub menu that gets displayed.
        System.out.println("  Capital City Report ");
        System.out.println("===============================================");
        System.out.println("1. All the capital cities in the world organised by largest population to smallest.");
        System.out.println("2. All the capital cities in a continent organised by largest population to smallest.");
        System.out.println("3. All the capital cities in a region organised by largest to smallest.");
        System.out.println("4. The top N populated capital cities in the world where N is provided by the user.");
        System.out.println("5. The top N populated capital cities in a continent where N is provided by the user.");
        System.out.println("6. The top N populated capital cities in a region where N is provided by the user.");
        System.out.println("===============================================");
        System.out.println("7. EXIT SUB MENU");

        while (n != 7)// Exits the program when 5 is pressed
        {
            System.out.print("\n Please enter option 1-6 to continue or 7 to exit...: ");
            n = Integer.parseInt(System.console().readLine());
            // Reads user input and takes them to selected code.
            if (n > 7 || n < 1) {
                //Invalid input
                System.out.print("Invalid input, please try again...");
            }
            if (n == 7){
                // Exit output
                System.out.print("Back to Menus...");
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Menus();
            }
            /*if (n == 1)
            {
                ArrayList<city> cities = a.queryCC1();
                a.displayCCities(cities);
                continue;
            }

            if (n == 2)
            {
                ArrayList<city> cities = a.queryCC2();
                a.displayCCities(cities);
                continue;
            }
            if (n == 3)
            {
                ArrayList<city> cities = a.queryCC3();
                a.displayCCities(cities);
                continue;
            }*/
            if (n == 4)
            {
                ArrayList<city> Ccities = a.queryCC4();
                a.displayCCities(Ccities);
                continue;
            }
            if (n == 5)
            {
                ArrayList<city> Ccities = a.queryCC5();
                a.displayCCities(Ccities);
                continue;
            }
            if (n == 6)
            {
                ArrayList<city> Ccities = a.queryCC6();
                a.displayCCities(Ccities);
                continue;
            }
        }
    }
    /**
     * Set Methods
     * @return An array list of all countries
     */
    public ArrayList<city> getCcities  (Statement stmt, String strSelect) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(strSelect);
        // Extract country information
        ArrayList<city> Ccities = new ArrayList<city>();
        while (resultSet.next()) {
            city ccy = new city();
            ccy.setName(resultSet.getString(1));
            ccy.setCountryCode(resultSet.getString(2));
            ccy.setPopulation(resultSet.getInt(3));
            Ccities.add(ccy);
        }
        return Ccities;
    }
    /**
     * Display a list of Capital Cities.
     //* @param Capital Cities The list of countries to display.
     */
    public void displayCCities (ArrayList < city > Ccities) {
        //Check cities is not null
        if (Ccities == null)
        {
            System.out.println("No Capital Cities");
            return;
        }
        for (city ccy : Ccities) {
            if (ccy == null)
                continue;
            System.out.format("%1$-20s %2$-25s %3$-25s \n", ccy.getName(),ccy.getCountryCode(),ccy.getPopulation());
        }
    }

    /**
     * Get The top N populated capital cities in a district where N is provided by the user.
     * @return A list of capital cities and population, or null if there is an error.
     */
    public ArrayList<city> queryCC4 () {
        System.out.println("4 - The top N populated capital cities in the world where N is provided by the user\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int limit = scanner.nextInt();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT city.Name, country.Name,city.Population from city, country WHERE city.CountryCode=country.Code ORDER BY city.Population DESC LIMIT "+limit;

            // Execute SQL statement
            return getCcities(stmt, strSelect);
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
    public ArrayList<city> queryCC5 () {
        System.out.println("5 - The top N populated cities in a continent where N is provided by the user.\n");
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
                    "SELECT city.Name, country.Name,city.Population from city, country WHERE city.CountryCode=country.Code AND country.Continent='"+Ncon+"' ORDER BY city.Population DESC  "+limit;

            // Execute SQL statement
            return getCcities(stmt, strSelect);
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
    public ArrayList<city> queryCC6 () {
        System.out.println("6 - The top N populated cities in a region where N is provided by the user.\n");
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
                    "SELECT city.Name, country.Name,city.Population from city, country WHERE city.CountryCode=country.Code AND country.region='"+Nreg+"' ORDER BY Population DESC   "+limit;

            // Execute SQL statement
            return getCcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
}