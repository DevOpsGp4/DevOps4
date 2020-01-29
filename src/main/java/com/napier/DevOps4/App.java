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
        System.out.println("5. Language Report");
        System.out.println("6. EXIT PROGRAM");
        System.out.println("===============================================");

        while (n != 6)// Exits the program when 4 is pressed
        {
            System.out.print("\n Please enter option 1-5 to continue or 6 to exit...: ");
            n = Integer.parseInt(System.console().readLine());
            // Reads user input and takes them to selected code.
            if (n > 6 || n < 1) {
                //invalid input
                System.out.print("Invalid input, please try again...");
                continue;
            }
            if (n == 6) {
                // Exit output
                System.out.print("Thank for using the Program...");
                System.exit(0);
            }
            if (n == 1) {
                // country report
                CountryReport();
            }

            if (n == 2) {
                // city report
                CityReport();
            }
            if (n == 3) {
                // capital city report
                CapitalCityReport();
            }
            if (n == 4) {
                // population report

            }
            if (n == 5) {
                // Language report
                LanguageReport();
            }

        }
    }

    /* SubMenu1 Country Report*/
    public static void CountryReport() {
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
        System.out.println("1. All the countries in the world organised by largest population to smallest");
        System.out.println("2. All the countries in a continent organised by largest population to smallest");
        System.out.println("3. All the countries in a region organised by largest population to smallest");
        System.out.println("4. The top N populated countries in the world where N is provided by the user");
        System.out.println("5. The top N populated countries in a continent where N is provided by the user");
        System.out.println("6. The top N populated countries in a region where N is provided by the user");
        System.out.println("===============================================");
        System.out.println("7. EXIT SUB MENU");

        while (n != 7)// Exits the program when 5 is pressed
        {
            System.out.print("\n Please enter option 1-6 to continue to 7 exit...: ");
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
            if (n == 1)
            {
                ArrayList<Country> countries = a.countryWorld();
                a.displayCountries(countries);
                continue;
            }

            if (n == 2)
            {
                ArrayList<Country> countries = a.countryContinent();
                a.displayCountries(countries);
                continue;
            }
            if (n == 3)
            {
                ArrayList<Country> countries = a.countryRegion();
                a.displayCountries(countries);
                continue;
            }
            if (n == 4)
            {
                ArrayList<Country> countries = a.topWorldCountry();
                a.displayCountries(countries);
                continue;
            }
            if (n == 5)
            {
                ArrayList<Country> countries = a.topContinentCountry();
                a.displayCountries(countries);
                continue;
            }
            if (n == 6)
            {
                ArrayList<Country> countries = a.topRegionCountry();
                a.displayCountries(countries);
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
            Class.forName("com.mysql.cj.jdbc.Driver");
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
     * @param countries The list of countries to display.
     */
    public void displayCountries (ArrayList < Country > countries) {
        // Check employees is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        for (Country cy : countries) {
            System.out.println(cy);
        }
    }
    /**
     * Set Methods
     * @return An array list of all countries
     */
    public ArrayList<Country> getCountries (Statement stmt, String strSelect) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(strSelect);
        // Extract country information
        ArrayList<Country> countries = new ArrayList<>();
        while (resultSet.next()) {
            Country cy = new Country();
            cy.setCode(resultSet.getString("country.Code"));
            cy.setName(resultSet.getString("country.Name"));
            cy.setContinent(resultSet.getString("country.Continent"));
            cy.setRegion(resultSet.getString("country.Region"));
            cy.setPopulation(resultSet.getInt("country.Population"));
            cy.setCapital(resultSet.getString("country.Capital"));
            countries.add(cy);
        }
        return countries;
    }

    /**
     * Gets all the countries in a continent by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */

    public ArrayList<Country> countryContinent () {
        System.out.println("1 - All the countries in a continent organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT country.code, country.Name, country.continent, country.Region, country.Population, country.Capital " +
                    "FROM country ORDER BY continent, Population DESC ";

            // Execute SQL statement
            return getCountries(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
    /**
     * Get all the countries in a region organised by largest population to smallest
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> countryRegion () {
        System.out.println("2 - All the countries in a region organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.Name, country.continent, country.Region, country.Population, country.Capital " +
                            "FROM country ORDER BY Region, Population DESC ";
            // Execute SQL statement
            return getCountries(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
    /**
     * Get the countries in the world organised by largest population to smallest
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> countryWorld () {
        System.out.println("3 - All the countries in the world organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.Name, country.continent, country.Region, country.Population, country.Capital " +
                            "FROM country ORDER BY Name, Population DESC ";
            // Execute SQL statement
            return getCountries(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
    /**
     * Get the top N populated countries in the world where N is provided by the user.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> topWorldCountry () {
        System.out.println("4 - The top N populated countries in the world where N is provided by the user.\n");
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
                    "SELECT country.code, country.Name, country.continent, country.Region, country.Population, country.Capital  " +
                            "FROM country  ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            return getCountries(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
    /**
     * Get the top N populated countries in a region where N is provided by the user.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> topRegionCountry () {
        System.out.println("5 - The top N populated countries in a region where N is provided by the user.\n");
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
                    "SELECT country.code, country.Name, country.continent, country.Region, country.Population, country.Capital  " +
                            "FROM country WHERE Region = \"" + input_region + "\" " +
                            "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            return getCountries(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
    /**
     * Get the top N populated countries in a continent where N is provided by the user.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> topContinentCountry () {
        System.out.println("6 - The top N populated countries in a continent where N is provided by the user.\n");
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
                    "SELECT country.code, country.Name, country.continent, country.Region, country.Population, country.Capital " +
                            "FROM country WHERE Continent = \"" + input_continent + "\" "
                            + "ORDER BY Population DESC "
                            + limit;

            // Execute SQL statement
            return getCountries(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /*Sub Menus2 City Report*/
    public static void CityReport() {
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
                ArrayList<City> cities = a.cityWorld();
                a.displayCities(cities);
                continue;
            }
            if (n == 2)
            {
                ArrayList<City> cities = a.cityContinent();
                a.displayCities(cities);
                continue;
            }
            if (n == 3)
            {
                ArrayList<City> cities = a.cityRegion();
                a.displayCities(cities);
                continue;
            }
            if (n == 4)
            {
                ArrayList<City> cities = a.cityCountry();
                a.displayCities(cities);
                continue;
            }
            if (n == 5)
            {
                ArrayList<City> cities = a.cityDistrict();
                a.displayCities(cities);
                continue;
            }
            if (n == 6)
            {
                ArrayList<City> cities = a.topWorld();
                a.displayCities(cities);
                continue;
            }

            if (n == 7)
            {
                ArrayList<City> cities = a.topContinent();
                a.displayCities(cities);
                continue;
            }
            if (n == 8)
            {
                ArrayList<City> cities = a.topRegion();
                a.displayCities(cities);
                continue;
            }
            if (n == 9)
            {
                ArrayList<City> cities = a.topCountry();
                a.displayCities(cities);
                continue;
            }
            if (n == 10)
            {
                ArrayList<City> cities = a.topDistrict();
                a.displayCities(cities);
                continue;
            }

        }
    }

    /**
     * Display a list of countries.
     * @param cities The list of countries to display.
     */
    public void displayCities (ArrayList < City > cities) {
        // Check search data is not null
        if (cities == null)
        {
            System.out.println("No countries");
            return;
        }
        for (City cy : cities) {
            System.out.format("%1$-20s %2$-25s %3$-25s %4$-20s \n", cy.getName(),cy.getCountryCode(),cy.getDistrict(),cy.getPopulation());
        }
    }
    /**
     * Set Methods
     * @return An array list of all countries
     */
    public ArrayList<City> getcities  (Statement stmt, String strSelect) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(strSelect);
        // Extract country information
        ArrayList<City> cities = new ArrayList<City>();
        while (resultSet.next()) {
            City cy = new City();
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
    public ArrayList<City> cityWorld () {
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
    public ArrayList<City> cityContinent () {
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
    public ArrayList<City> cityRegion () {
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
    public ArrayList<City> cityCountry () {
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
    public ArrayList<City> cityDistrict () {
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
    public ArrayList<City> topWorld () {
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
    public ArrayList<City> topContinent () {
        System.out.println("7 - The top N populated cities in a continent where N is provided by the user.\n");
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
    public ArrayList<City> topRegion () {
        System.out.println("8 - The top N populated cities in a region where N is provided by the user.\n");
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
    public ArrayList<City> topCountry () {
        System.out.println("9 - The top N populated cities in a country where N is provided by the user.\n");
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
    public ArrayList<City> topDistrict () {
        System.out.println("9 - The top N populated cities in a district where N is provided by the user.\n");
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

    /*Sub Menus Capital City Report*/
    public static void CapitalCityReport() {
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
            System.out.print("\n Please enter option 1-7 to continue...: ");
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
            if (n == 1)
            {
                ArrayList<City> Ccities = a.queryCC1();
                a.displayCCities(Ccities);
                continue;
            }

            if (n == 2)
            {
                ArrayList<City> Ccities = a.queryCC2();
                a.displayCCities(Ccities);
                continue;
            }
            if (n == 3)
            {
                ArrayList<City> Ccities = a.queryCC3();
                a.displayCCities(Ccities);
                continue;
            }
            if (n == 4)
            {
                ArrayList<City> Ccities = a.queryCC4();
                a.displayCCities(Ccities);
                continue;
            }
            if (n == 5)
            {
                ArrayList<City> Ccities = a.queryCC5();
                a.displayCCities(Ccities);
                continue;
            }
            if (n == 6)
            {
                ArrayList<City> Ccities = a.queryCC6();
                a.displayCCities(Ccities);
                continue;
            }
        }
    }
    /**
     * Set Methods
     * @return An array list of all countries
     */
    public ArrayList<City> getCcities  (Statement stmt, String strSelect) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(strSelect);
        // Extract country information
        ArrayList<City> Ccities = new ArrayList<City>();
        while (resultSet.next()) {
            City ccy = new City();
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
    public void displayCCities (ArrayList < City > Ccities) {
        //Check cities is not null
        if (Ccities == null)
        {
            System.out.println("No Capital Cities");
            return;
        }
        for (City ccy : Ccities) {
            if (ccy == null)
                continue;
            System.out.format("%1$-20s %2$-25s %3$-25s \n", ccy.getName(),ccy.getCountryCode(),ccy.getPopulation());
        }
    }
    /**
     * Gets all the Capitalcities in the world by largest population to smallest.
     * @return A list of all cities and population, or null if there is an error.
     */

    public ArrayList<City> queryCC1 () {
        System.out.println("1 - All the Captialcities in the world organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name,city.Population from city, country WHERE city.CountryCode=country.Code ORDER BY city.Population DESC";
            // Execute SQL statement
            return getCcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    public ArrayList<City> queryCC2 () {
        System.out.println("2 - All the capital cities in the Continent organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name,city.Population from city, country WHERE city.CountryCode=country.Code AND country.Continent='Asia' ORDER BY city.Population DESC";
            // Execute SQL statement
            return getCcities(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    public ArrayList<City> queryCC3 () {
        System.out.println("3 - All the capital cities in the region  organised by largest population to smallest.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name,city.Population from city, country WHERE city.CountryCode=country.Code AND country.Region='Caribbean' ORDER BY city.Population DESC";
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
     * Get The top N populated capital cities in a district where N is provided by the user.
     * @return A list of capital cities and population, or null if there is an error.
     */
    public ArrayList<City> queryCC4 () {
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
    public ArrayList<City> queryCC5 () {
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
    public ArrayList<City> queryCC6 () {
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

    /*sub Menus5 Language Report*/
    public static void LanguageReport() {
        Scanner console = new Scanner(System.in);
        // Create new Application
        App a = new App();
        // Connect to database
        a.connect("localhost:33060");
        char c;
        int n = 0;

        // this will be the sub menu that gets displayed.
        System.out.println("  Language Report ");
        System.out.println("===============================================");
        System.out.println("1. Chinese");
        System.out.println("2. English");
        System.out.println("3. Hindi");
        System.out.println("4. Spanish");
        System.out.println("5. Arabic");
        System.out.println("===============================================");
        System.out.println("6. EXIT SUB MENU");

        while (n != 6)// Exits the program when 5 is pressed
        {
            System.out.print("\n Please enter option 1-5 to continue or 6 to exit...: ");
            n = Integer.parseInt(System.console().readLine());
            // Reads user input and takes them to selected code.
            if (n > 6 || n < 1) {
                //Invalid input
                System.out.print("Invalid input, please try again...");
            }
            if (n == 6){
                // Exit output
                System.out.print("Back to Menus...");
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Menus();
            }
            if (n == 1)
            {
                ArrayList<Countrylanguage> languages = a.chineseL();
                a.displayLanguage(languages);
                continue;
            }

            if (n == 2)
            {
                ArrayList<Countrylanguage> languages = a.englishL();
                a.displayLanguage(languages);
                continue;
            }
            if (n == 3)
            {
                ArrayList<Countrylanguage> languages = a.hindiL();
                a.displayLanguage(languages);
                continue;
            }
            if (n == 4)
            {
                ArrayList<Countrylanguage> languages = a.spanishL();
                a.displayLanguage(languages);
                continue;
            }
            if (n == 5)
            {
                ArrayList<Countrylanguage> languages = a.arabicL();
                a.displayLanguage(languages);
                continue;
            }
        }
    }
    /**
     * Set Methods
     * @return An array list of all countries
     */
    public ArrayList<Countrylanguage> getLanguage  (Statement stmt, String strSelect) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(strSelect);
        // Extract country information
        ArrayList<Countrylanguage> languages = new ArrayList<>();
        while (resultSet.next()) {
            Countrylanguage cl = new Countrylanguage();
            cl.setName(resultSet.getString(1));
            cl.setCountryCode(resultSet.getString(2));
            cl.setPopulation(resultSet.getString(3));
            cl.setIsOfficial(resultSet.getString(4));
            cl.setPercentage(resultSet.getFloat(5));
            languages.add(cl);
        }
        return languages;
    }

    /**
     * Display a list of languages.
     //* @param languages The list of countries to display.
     */
    public void displayLanguage (ArrayList < Countrylanguage > languages) {
        //Check languages is not null
        if (languages == null)
        {
            System.out.println("No Languages");
            return;
        }
        for (Countrylanguage cl : languages) {
            if (cl == null)
                continue;
            System.out.format("%1$-20s %2$-25s %3$-25s %4$-25s %5$-25s\n", cl.getName(),cl.getCountryCode(),cl.getPopulation(),cl.getIsOfficial(),cl.getPercentage());
        }
    }
    /**
     * Gets Chinese Language usage by largest number to smallest.
     * @return A list of Chinese Language usage, or null if there is an error.
     */

    public ArrayList<Countrylanguage> chineseL () {
        System.out.println("1 - Chinese.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, countrylanguage.CountryCode, country.Population, countrylanguage.IsOfficial, countrylanguage.Percentage FROM `countrylanguage`,`country` WHERE countrylanguage.CountryCode=country.Code AND countrylanguage.Language='Chinese' ORDER BY `countrylanguage`.`Percentage` DESC";
            // Execute SQL statement
            return getLanguage(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
    /**
     * Gets English Language usage by largest number to smallest.
     * @return A list of Chinese Language usage, or null if there is an error.
     */

    public ArrayList<Countrylanguage> englishL () {
        System.out.println("1 - Chinese.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, countrylanguage.CountryCode, countrylanguage.Language, countrylanguage.IsOfficial, countrylanguage.Percentage FROM `countrylanguage`,`country` WHERE countrylanguage.CountryCode=country.Code AND countrylanguage.Language='English' ORDER BY `countrylanguage`.`Percentage` DESC";
            // Execute SQL statement
            return getLanguage(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * Gets Hindi Language usage by largest number to smallest.
     * @return A list of Hindi Language usage, or null if there is an error.
     */

    public ArrayList<Countrylanguage> hindiL () {
        System.out.println("1 - Chinese.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, countrylanguage.CountryCode, countrylanguage.Language, countrylanguage.IsOfficial, countrylanguage.Percentage FROM `countrylanguage`,`country` WHERE countrylanguage.CountryCode=country.Code AND countrylanguage.Language='Hindi' ORDER BY `countrylanguage`.`Percentage` DESC";
            // Execute SQL statement
            return getLanguage(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * Gets Spanish Language usage by largest number to smallest.
     * @return A list of Spanish Language usage, or null if there is an error.
     */

    public ArrayList<Countrylanguage> spanishL () {
        System.out.println("1 - Chinese.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, countrylanguage.CountryCode, countrylanguage.Language, countrylanguage.IsOfficial, countrylanguage.Percentage FROM `countrylanguage`,`country` WHERE countrylanguage.CountryCode=country.Code AND countrylanguage.Language='Spanish' ORDER BY `countrylanguage`.`Percentage` DESC";
            // Execute SQL statement
            return getLanguage(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * Gets Arabic Language usage by largest number to smallest.
     * @return A list of Arabic Language usage, or null if there is an error.
     */

    public ArrayList<Countrylanguage> arabicL () {
        System.out.println("1 - Chinese.\n");
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, countrylanguage.CountryCode, countrylanguage.Language, countrylanguage.IsOfficial, countrylanguage.Percentage FROM `countrylanguage`,`country` WHERE countrylanguage.CountryCode=country.Code AND countrylanguage.Language='Arabic' ORDER BY `countrylanguage`.`Percentage` DESC";
            // Execute SQL statement
            return getLanguage(stmt, strSelect);
        } catch (Exception e) //Catch any errors and print error message
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

}