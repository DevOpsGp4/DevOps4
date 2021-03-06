package com.napier.DevOps4;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class
 */
public class App {
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    public static void main(String[] args) {
        Menus();
    }

    /**
     * THis is Main Menu
     */
    public static void Menus() {
        Scanner console = new Scanner(System.in);
        char c;
        int n = 0;

        //This is the main menu that will be displayed first.
        System.out.println("  World Population ");
        System.out.println("===============================================");
        System.out.println("All the Reports are ordered by largest to smallest");
        System.out.println("1. Country Report");
        System.out.println("2. City Report");
        System.out.println("3. Capital City Report");
        System.out.println("4. Population ");
        System.out.println("5. Language Report");
        System.out.println("6. EXIT PROGRAM");
        System.out.println("===============================================");
        while (true)// Exits the program when 6 is pressed
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
                App a = new App();
                a.disconnect();
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
                PopulationReport();
            }
            if (n == 5) {
                // Language report
                App a = new App();
                a.connect("localhost:33060");
                // Extract population of living in cities and not
                ArrayList<Countrylanguage> language = a.Languagelist();
                // Print format function for population living and not living in cities
                a.displaylangauge(language);
            }

        }
    }

    /**
     * SubMenu1 Country Report
     */
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
        System.out.println("=========================================================");
        System.out.println("1. All the countries in the world organised by largest population to smallest");
        System.out.println("2. All the countries in a continent organised by largest population to smallest");
        System.out.println("3. All the countries in a region organised by largest population to smallest");
        System.out.println("4. The top N populated countries in the world where N is provided by the user");
        System.out.println("5. The top N populated countries in a continent where N is provided by the user");
        System.out.println("6. The top N populated countries in a region where N is provided by the user");
        System.out.println("========================================================");
        System.out.println("7. EXIT SUB MENU");
        while (n != 7)// Exits the program when 7 is pressed
        {
            System.out.print("\n Please enter option 1-6 to continue to 7 exit...: ");
            n = Integer.parseInt(System.console().readLine());
            // Reads user input and takes them to selected code.
            if (n > 7 || n < 1) {
                //Invalid input
                System.out.print("Invalid input, please try again...");
            }
            if (n == 7) {
                // Exit output
                System.out.print("Back to Menus...");
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Menus();
            }
            if (n == 1) {
                ArrayList<Country> countries = a.countryWorld();
                a.displayCountries(countries);
            }

            if (n == 2) {
                ArrayList<Country> countries = a.countryContinent();
                a.displayCountries(countries);
            }
            if (n == 3) {
                ArrayList<Country> countries = a.countryRegion();
                a.displayCountries(countries);
            }
            if (n == 4) {
                ArrayList<Country> countries = a.topWorldCountry();
                a.displayCountries(countries);
            }
            if (n == 5) {
                ArrayList<Country> countries = a.topContinentCountry();
                a.displayCountries(countries);
            }
            if (n == 6) {
                ArrayList<Country> countries = a.topRegionCountry();
                a.displayCountries(countries);
            }
        }
    }

    /**
     * Sub Menus2 City Report
     */
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
            if (n == 11) {
                // Exit output
                System.out.print("Back to Menus...");
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Menus();
            }
            if (n == 1) {
                ArrayList<City> cities = a.cityWorld();
                a.displayCities(cities);
            }
            if (n == 2) {
                ArrayList<City> cities = a.cityContinent();
                a.displayCities(cities);
            }
            if (n == 3) {
                ArrayList<City> cities = a.cityRegion();
                a.displayCities(cities);
            }
            if (n == 4) {
                ArrayList<City> cities = a.cityCountry();
                a.displayCities(cities);
            }
            if (n == 5) {
                ArrayList<City> cities = a.cityDistrict();
                a.displayCities(cities);
            }
            if (n == 6) {
                ArrayList<City> cities = a.topWorld();
                a.displayCities(cities);
            }

            if (n == 7) {
                ArrayList<City> cities = a.topContinent();
                a.displayCities(cities);
            }
            if (n == 8) {
                ArrayList<City> cities = a.topRegion();
                a.displayCities(cities);
            }
            if (n == 9) {
                ArrayList<City> cities = a.topCountry();
                a.displayCities(cities);
            }
            if (n == 10) {
                ArrayList<City> cities = a.topDistrict();
                a.displayCities(cities);
            }

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

        while (n != 7)// Exits the program when 7 is pressed
        {
            System.out.print("\n Please enter option 1-6 to continue or 7 to exit...: ");
            n = Integer.parseInt(System.console().readLine());
            // Reads user input and takes them to selected code.
            if (n > 7 || n < 1) {
                //Invalid input
                System.out.print("Invalid input, please try again...");
            }
            if (n == 7) {
                // Exit output
                System.out.print("Back to Menus...");
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Menus();
            }
            if (n == 1) {
                ArrayList<City> Ccities = a.queryCC1();
                a.displayCCities(Ccities);

            }
            if (n == 2) {
                ArrayList<City> Ccities = a.queryCC2();
                a.displayCCities(Ccities);

            }
            if (n == 3) {
                ArrayList<City> Ccities = a.queryCC3();
                a.displayCCities(Ccities);

            }
            if (n == 4) {
                ArrayList<City> Ccities = a.queryCC4();
                a.displayCCities(Ccities);

            }
            if (n == 5) {
                ArrayList<City> Ccities = a.queryCC5();
                a.displayCCities(Ccities);

            }
            if (n == 6) {
                ArrayList<City> Ccities = a.queryCC6();
                a.displayCCities(Ccities);

            }
        }
    }

    /**
     * sub Menus5 Population Report
     */
    public static void PopulationReport() {
        Scanner console = new Scanner(System.in);
        // Create new Application
        App a = new App();
        // Connect to database
        a.connect("localhost:33060");
        char c;
        int n = 0;
        // this will be the sub menu that gets displayed.
        System.out.println("  Population Report ");
        System.out.println("===============================================");
        System.out.println("1. Population of people, people living in cities, and people not living in cities in each continent");
        System.out.println("2. Population of people, people living in cities, and people not living in cities in each region.");
        System.out.println("3. Population of people, people living in cities, and people not living in cities in each country");
        System.out.println("4. The population of the world");
        System.out.println("5. The population of a continent");
        System.out.println("6. The population of a region");
        System.out.println("7. The population of a country");
        System.out.println("8. The population of a district");
        System.out.println("9. The population of a city");
        System.out.println("===============================================");
        System.out.println("10. EXIT SUB MENU");
        while (n != 10)// Exits the program when 10 is pressed
        {
            System.out.print("\n Please enter option 1-9 to continue or 10 to exit...: ");
            n = Integer.parseInt(System.console().readLine());
            // Reads user input and takes them to selected code.
            if (n > 9 || n < 1) {
                //Invalid input
                System.out.print("Invalid input, please try again...");
            }
            if (n == 10) {
                // Exit output
                System.out.print("Back to Menus...");
                System.out.print("\033[H\033[2J");
                System.out.flush();
                Menus();
            }
            if (n == 1) {
                ArrayList<PopulationPercent> populationPerCon;
                populationPerCon = a.query23();
                System.out.println(String.format("%-25s %-25s %-25s %-25s %-25s %-25s", "Country Name", "Total Population", "City Population", "City Population (%)", "Non-city Population", "Non-city Population (%)"));
                for (PopulationPercent per : populationPerCon) {
                    System.out.println(String.format("%-25s %-25s %-25s %-25s %-25s %-25s", per.getContinentName(), per.getCountryPopulation(), per.getLiveInCity(), per.getLiveInCityPercent(), per.getNoLiveInCity(), per.getNoLiveInCityPercent()));
                }
                System.out.println("====================================================================================================");
            }
            if (n == 2) {
                ArrayList<PopulationPercent> populationPerReg;
                populationPerReg = a.query24();
                System.out.println(String.format("%-25s %-25s %-25s %-25s %-25s %-25s", "Country Name", "Total Population", "City Population", "City Population (%)", "Non-city Population", "Non-city Population (%)"));
                for (PopulationPercent per : populationPerReg) {
                    System.out.println(String.format("%-25s %-25s %-25s %-25s %-25s %-25s", per.getRegionName(), per.getCountryPopulation(), per.getLiveInCity(), per.getLiveInCityPercent(), per.getNoLiveInCity(), per.getNoLiveInCityPercent()));
                }
                System.out.println("====================================================================================================");
            }
            if (n == 3) {
                ArrayList<PopulationPercent> populationPerCou;
                populationPerCou = a.query25();
                System.out.println(String.format("%-25s %-25s %-25s %-25s %-25s %-25s", "Country Name", "Total Population", "City Population", "City Population (%)", "Non-city Population", "Non-city Population (%)"));
                for (PopulationPercent per : populationPerCou) {
                    System.out.println(String.format("%-25s %-25s %-25s %-25s %-25s %-25s", per.getCountryName(), per.getCountryPopulation(), per.getLiveInCity(), per.getLiveInCityPercent(), per.getNoLiveInCity(), per.getNoLiveInCityPercent()));
                }
                System.out.println("====================================================================================================");
            }
            if (n == 4) {
                a.query26();
            }
            if (n == 5) {
                ArrayList<Country> continents;
                continents = a.query27();
                System.out.println(String.format("%-25s %-25s", "Continent Name", "Continent Population"));
                for (Country cont : continents) {
                    System.out.println(String.format("%-25s %-25s", cont.getContinent(), cont.getPopulation()));
                }
            }
            if (n == 6) {
                ArrayList<Country> regions;
                regions = a.query28();
                System.out.println(String.format("%-25s %-25s", "Region Name", "Region Population"));
                for (Country reg : regions) {
                    System.out.println(String.format("%-25s %-25s", reg.getRegion(), reg.getPopulation()));
                }
            }
            if (n == 7) {
                ArrayList<Country> countries;
                countries = a.query29();
                System.out.println(String.format("%-25s %-25s", "Country Name", "Country Population"));
                for (Country cs : countries) {
                    System.out.println(String.format("%-25s %-25s", cs.getName(), cs.getPopulation()));
                }
            }
            if (n == 8) {
                ArrayList<City> districts;
                districts = a.query30();
                System.out.println(String.format("%-25s %-25s", "District Name", "City Population"));
                for (City d : districts) {
                    System.out.println(String.format("%-25s %-25s", d.getDistrict(), d.getPopulation()));
                }
            }
            if (n == 9) {
                ArrayList<City> cities;
                cities = a.query31();
                System.out.println(String.format("%-25s %-25s", "City Name", "City Population"));
                for (City cc : cities) {
                    System.out.println(String.format("%-25s %-25s", cc.getName(), cc.getPopulation()));
                }
            }
        }
    }
    /**
     * Connect to the MySQL database.
     */
    public void connect(String location) {
        try {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(10000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
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
     *
     * @param countries The list of countries to display.
     */
    public void displayCountries(ArrayList<Country> countries) {
        // Check employees is not null
        if (countries == null) {
            System.out.println("No countries");
            return;
        }
        for (Country cy : countries) {
            System.out.println(cy);
        }
    }

    /**
     * Set Methods
     *
     * @return An array list of all countries
     */
    public ArrayList<Country> getCountries(Statement stmt, String strSelect) throws SQLException {
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
     *
     * @return A list of all countries and population, or null if there is an error.
     */

    public ArrayList<Country> countryContinent() {
        System.out.println("2 - All the countries in a continent organised by largest population to smallest.\n");
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
     *
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> countryRegion() {
        System.out.println("3 - All the countries in a region organised by largest population to smallest.\n");
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
     *
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> countryWorld() {
        System.out.println("1 - All the countries in the world organised by largest population to smallest.\n");
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
     *
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> topWorldCountry() {
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
     *
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> topRegionCountry() {
        System.out.println("6 - The top N populated countries in a region where N is provided by the user.\n");
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
     *
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> topContinentCountry() {
        System.out.println("5 - The top N populated countries in a continent where N is provided by the user.\n");
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

    /**
     * Display a list of countries.
     *
     * @param cities The list of countries to display.
     */
    public void displayCities(ArrayList<City> cities) {
        // Check search data is not null
        if (cities == null) {
            System.out.println("No Cities");
            return;
        }
        System.out.println(String.format("%1$-20s %2$-25s %3$-25s %4$-20s", "Name", "Country","District","Population"));
        for (City cy : cities) {
            System.out.format("%1$-20s %2$-25s %3$-25s %4$-20s \n", cy.getName(), cy.getCountryCode(), cy.getDistrict(), cy.getPopulation());
        }
    }

    /**
     * Set Methods
     *
     * @return An array list of all countries
     */
    public ArrayList<City> getcities(Statement stmt, String strSelect) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(strSelect);
        // Extract country information
        ArrayList<City> cities = new ArrayList<>();
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
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> cityWorld() {
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
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> cityContinent() {
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
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> cityRegion() {
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
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> cityCountry() {
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
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> cityDistrict() {
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
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> topWorld() {
        System.out.println("6 - The top N populated cities in the world where N is provided by the user\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int limit = scanner.nextInt();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect = "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code ORDER BY Population DESC LIMIT " + limit;

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
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> topContinent() {
        System.out.println("7 - The top N populated cities in a continent where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of  Cities - ");
        int input = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the Name of continent- ");
        String Ncon = scanner.nextLine();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";
            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code AND country.Continent='" + Ncon + "' ORDER BY Population DESC  " + limit;
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
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> topRegion() {
        System.out.println("8 - The top N populated cities in a region where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int input = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the name of region - ");
        String Nreg = scanner.nextLine();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";
            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code AND country.region='" + Nreg + "' ORDER BY Population DESC   " + limit;

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
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> topCountry() {
        System.out.println("9 - The top N populated cities in a country where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int input = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the name of country - ");
        String Ncou = scanner.nextLine();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";
            String strSelect =
                    "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code AND country.Name='" + Ncou + "' ORDER BY Population DESC  " + limit;

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
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> topDistrict() {
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
                    "SELECT city.Name, country.Name,city.District, city.Population from city, country WHERE city.CountryCode=country.Code AND city.District='" + Ndis + "' ORDER BY Population DESC  " + limit;

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
     * Set Methods
     *
     * @return An array list of all countries
     */
    public ArrayList<City> getCcities(Statement stmt, String strSelect) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(strSelect);
        // Extract country information
        ArrayList<City> Ccities = new ArrayList<>();
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
     * //* @param Capital Cities The list of countries to display.
     */
    public void displayCCities(ArrayList<City> Ccities) {
        //Check cities is not null
        if (Ccities == null) {
            System.out.println("No Capital Cities");
            return;
        }
        System.out.println(String.format("%1$-20s %2$-25s %3$-25s", "Name", "Country","Population"));
        for (City ccy : Ccities) {
            if (ccy == null)
                continue;
            System.out.format("%1$-20s %2$-25s %3$-25s \n", ccy.getName(), ccy.getCountryCode(), ccy.getPopulation());
        }
    }

    /**
     * Gets all the Capitalcities in the world by largest population to smallest.
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> queryCC1() {
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

    /**
     * All the capital cities in the Continent organised by largest population to smallest.
     *
     * @return getCcities
     */
    public ArrayList<City> queryCC2() {
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

    /**
     * All the capital cities in the region  organised by largest population to smallest.
     *
     * @return getCcities
     */
    public ArrayList<City> queryCC3() {
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
     *
     * @return A list of capital cities and population, or null if there is an error.
     */
    public ArrayList<City> queryCC4() {
        System.out.println("4 - The top N populated capital cities in the world where N is provided by the user\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int limit = scanner.nextInt();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT city.Name, country.Name,city.Population from city, country WHERE city.CountryCode=country.Code ORDER BY city.Population DESC LIMIT " + limit;
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
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> queryCC5() {
        System.out.println("5 - The top N populated cities in a continent where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of  Cities - ");
        int input = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the Name of continent- ");
        String Ncon = scanner.nextLine();
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";
            String strSelect =
                    "SELECT city.Name, country.Name,city.Population from city, country WHERE city.CountryCode=country.Code AND country.Continent='" + Ncon + "' ORDER BY city.Population DESC  " + limit;
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
     *
     * @return A list of all cities and population, or null if there is an error.
     */
    public ArrayList<City> queryCC6() {
        System.out.println("6 - The top N populated cities in a region where N is provided by the user.\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of cities - ");
        int input = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the name of region - ");
        String Nreg = scanner.nextLine();

        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String limit = "LIMIT " + input + " ";
            String strSelect =
                    "SELECT city.Name, country.Name,city.Population from city, country WHERE city.CountryCode=country.Code AND country.region='" + Nreg + "' ORDER BY Population DESC   " + limit;

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
     * The population of people, people living in cities, and people not living in cities in each continent.
     *
     * @return populationPerCon
     */
    public ArrayList<PopulationPercent> query23() {
        System.out.println("1. Population of people, people living in cities, and people not living in cities in each continent");
        try {
            ArrayList<PopulationPercent> populationPerCon = new ArrayList<>();
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each region.
     *
     * @return populationPerReg
     */
    public ArrayList<PopulationPercent> query24() {
        System.out.println("1. Population of people, people living in cities, and people not living in cities in each region");
        ArrayList<PopulationPercent> populationPerReg = new ArrayList<>();
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each country.
     *
     * @return populationPerCou
     */
    public ArrayList<PopulationPercent> query25() {
        System.out.println("1. Population of people, people living in cities, and people not living in cities in each country");
        ArrayList<PopulationPercent> populationPerCou = new ArrayList<>();
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * The population of the world.
     */
    public void query26() {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
        }
    }

    /**
     * The population of a continent.
     *
     * @return continents
     */
    public ArrayList<Country> query27() {
        ArrayList<Country> continents = new ArrayList<>();
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
                Country cont = new Country();
                cont.setContinent(resultSet.getString("Continent"));
                cont.setPopulation(resultSet.getLong("SUM(Population)"));
                continents.add(cont);
            }
            return continents;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * The population of a region.
     *
     * @return regions
     */
    public ArrayList<Country> query28() {
        ArrayList<Country> regions = new ArrayList<>();
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
                Country reg = new Country();
                reg.setRegion(resultSet.getString("Region"));
                reg.setPopulation((int) resultSet.getLong("SUM(Population)"));
                regions.add(reg);
            }
            return regions;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * The population of a country.
     *
     * @return countries
     */
    public ArrayList<Country> query29() {
        ArrayList<Country> countries = new ArrayList<>();
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
                Country cs = new Country();
                cs.setName(resultSet.getString("Name"));
                cs.setPopulation((int) resultSet.getLong("Population"));
                countries.add(cs);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * The population of a district.
     *
     * @return districts
     */
    public ArrayList<City> query30() {
        ArrayList<City> districts = new ArrayList<>();
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
                City d = new City();
                d.setDistrict(resultSet.getString("district"));
                d.setPopulation(resultSet.getInt("SUM(Population)"));
                districts.add(d);
            }
            return districts;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * The population of a city.
     *
     * @return cities
     */
    public ArrayList<City> query31() {
        ArrayList<City> cities = new ArrayList<>();
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
                City cc = new City();
                cc.setName(resultSet.getString("name"));
                cc.setPopulation(resultSet.getInt("Population"));
                cities.add(cc);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * @return Total population with the respective language used.
     */
    public ArrayList<Countrylanguage> Languagelist()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            Statement stmt1 = con.createStatement();
            // Create string for SQL statement LIMIT 5";
            String strSelect=
                    "SELECT  countrylanguage.Language, SUM((country.Population *( countrylanguage.Percentage /100))) from countrylanguage, country WHERE countrylanguage.CountryCode= country.Code GROUP By countrylanguage.Language ORDER By (SUM(100*(country.Population *( countrylanguage.Percentage /100))/6078749450)) DESC LIMIT 5";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract Population information
            ArrayList<Countrylanguage> language = new ArrayList<>();
            while (rset.next())
            {
                Countrylanguage lang = new Countrylanguage();
                lang.setName(rset.getString(1));
                lang.setTotallang(rset.getLong(2));
                String strSelect1=
                        "SELECT SUM(country.population) FROM country";
                ResultSet rset1 = stmt1.executeQuery(strSelect1);
                while (rset1.next()) {
                    lang.setPercentage((float)((rset.getLong(2))) * 100 / rset1.getLong(1));
                }
                language.add(lang);
            }

            return language;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
    /**
     * Display a list of languages.
     * /return languages The list of countries to display.
     */
    public void displaylangauge(ArrayList<Countrylanguage> language)
    {
        // Check population is not null
        if (language == null)
        {
            System.out.println("No languages");
            return;
        }
        // Print header
        System.out.println("Number of people that used following languages with percentage");
        System.out.println("Number of Languages - " + language.size());
        System.out.println(String.format("%-40s %-40s %-20s", "Language Name", "Total number of people","Percentage of world"));
        // Loop over all the answer in the list
        for (Countrylanguage langs : language)
        {
            if (langs == null)
                continue;
            String lang_string =
                    String.format("%-40s %-40s %-20s",
                            langs.getName(), langs.getTotallang(),langs.getPercentage()+"%");
            System.out.println(lang_string);
        }
    }
}