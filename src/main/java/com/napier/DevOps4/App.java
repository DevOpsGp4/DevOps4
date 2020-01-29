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
        System.out.println("5. Languages ");
        System.out.println("6. EXIT PROGRAM");
        System.out.println("===============================================");

        while (n != 6)// Exits the program when 4 is pressed
        {
            System.out.print("\n Please enter option 1-5 to continue or 6 to exit...: ");
            n = Integer.parseInt(System.console().readLine());
            // Reads user input and takes them to selected code.
            if (n > 7 || n < 1) {
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
                //subMenu1();
            }

            if (n == 2) {
                // city report
         /*       subMenu2();*/
            }
            if (n == 3) {
            }
            // capital city report
/*            subMenu3();*/
            if (n == 4) {
                // population report

            }
            if (n == 5) {
                // population report
                subMenu5();

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

    /*sub Menus 5*/
    public static void subMenu5() {
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
                ArrayList<countrylanguage> languages = a.chineseL();
                a.displayLanguage(languages);
                continue;
            }

            if (n == 2)
            {
                ArrayList<countrylanguage> languages = a.englishL();
                a.displayLanguage(languages);
                continue;
            }
            if (n == 3)
            {
                ArrayList<countrylanguage> languages = a.hindiL();
                a.displayLanguage(languages);
                continue;
            }
            if (n == 4)
            {
                ArrayList<countrylanguage> languages = a.spanishL();
                a.displayLanguage(languages);
                continue;
            }
            if (n == 5)
            {
                ArrayList<countrylanguage> languages = a.arabicL();
                a.displayLanguage(languages);
                continue;
            }
        }
    }
    /**
     * Set Methods
     * @return An array list of all countries
     */
    public ArrayList<countrylanguage> getLanguage  (Statement stmt, String strSelect) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(strSelect);
        // Extract country information
        ArrayList<countrylanguage> languages = new ArrayList<>();
        while (resultSet.next()) {
            countrylanguage cl = new countrylanguage();
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
    public void displayLanguage (ArrayList < countrylanguage > languages) {
        //Check languages is not null
        if (languages == null)
        {
            System.out.println("No Languages");
            return;
        }
        for (countrylanguage cl : languages) {
            if (cl == null)
                continue;
            System.out.format("%1$-20s %2$-25s %3$-25s %4$-25s %5$-25s\n", cl.getName(),cl.getCountryCode(),cl.getPopulation(),cl.getIsOfficial(),cl.getPercentage());
        }
    }
    /**
     * Gets Chinese Language usage by largest number to smallest.
     * @return A list of Chinese Language usage, or null if there is an error.
     */

    public ArrayList<countrylanguage> chineseL () {
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

    public ArrayList<countrylanguage> englishL () {
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

    public ArrayList<countrylanguage> hindiL () {
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

    public ArrayList<countrylanguage> spanishL () {
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

    public ArrayList<countrylanguage> arabicL () {
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