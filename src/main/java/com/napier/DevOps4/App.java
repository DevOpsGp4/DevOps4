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
                        subMenu1();
                    }

                    if (n == 2)
                    {
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


            public static void subMenu1() {
                Scanner console = new Scanner(System.in);
                // Create new Application
                App a = new App();
                // Connect to database
                a.connect();
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
                    System.out.print("\n Please enter option 1-6 to continue...: ");
                    n = Integer.parseInt(System.console().readLine());
                    // Reads user input and takes them to selected code.
                    if (n > 6 || n < 1) {
                        System.out.print("Invalid input, please try again...");
                    }
                    if (n == 1)
                    {
                        ArrayList<country> countries = a.query1();
                        a.displayCountries(countries);
                        continue;
                    }

                    if (n == 2)
                    {
                        ArrayList<country> countries = a.query2();
                        a.displayCountries(countries);
                        continue;
                    }
                    if (n == 3)
                    {
                        ArrayList<country> countries = a.query3();
                        a.displayCountries(countries);
                        continue;
                    }
                    if (n == 4)
                    {
                        ArrayList<country> countries = a.query4();
                        a.displayCountries(countries);
                        continue;
                    }
                    if (n == 5)
                    {
                        ArrayList<country> countries = a.query5();
                        a.displayCountries(countries);
                        continue;
                    }
                    if (n == 6)
                    {
                        ArrayList<country> countries = a.query6();
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
                public void connect ()
                {
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
                public void displayCountries (ArrayList < country > countries) {
                    // Check employees is not null
                    if (countries == null)
                    {
                        System.out.println("No countries");
                        return;
                    }
                    for (country cy : countries) {
                        System.out.println(cy);
                    }
                }
                /**
                 * Set Methods
                 * @return An array list of all countries
                 */
                public ArrayList<country> getCountries (Statement stmt, String strSelect) throws SQLException {
                    ResultSet resultSet = stmt.executeQuery(strSelect);
                    // Extract country information
                    ArrayList<country> countries = new ArrayList<>();
                    while (resultSet.next()) {
                        country cy = new country();
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

                public ArrayList<country> query1 () {
                    System.out.println("Query1 - All the countries in a continent organised by largest population to smallest.\n");
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
                public ArrayList<country> query2 () {
                    System.out.println("Query2 - All the countries in a region organised by largest population to smallest.\n");
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
                public ArrayList<country> query3 () {
                    System.out.println("Query3 - All the countries in the world organised by largest population to smallest.\n");
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
                public ArrayList<country> query4 () {
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
                public ArrayList<country> query5 () {
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
                public ArrayList<country> query6 () {
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

}