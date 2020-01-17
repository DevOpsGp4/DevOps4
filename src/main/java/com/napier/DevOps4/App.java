package com.napier.DevOps4;

import java.sql.*;

public class App
{
    public static void main(String[] args)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            // If Class not found exception,DB driver loading fail
            System.out.println("Could not load SQL driver");
            System.exit(-1); // exit
        }

        // Connection to the database
        Connection con = null;
        int retries = 100;
        for (int i = 0; i < retries; ++i)// Trying to connect database by looping
        {
            System.out.println("Connecting to database...");
            try
            {
                // Waiting stage to startup database
                Thread.sleep(30000);
                // Connecting to database by user root and password example
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(10000);
                // Exit for loop
                break;
            }
            catch (SQLException sqle)
            {   //if thr is no exception about connecting DB,attempt fail error
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                //If there something interrupted,print out
                System.out.println("Thread interrupted? Should not happen.");
            }
        }//Exit loop

        if (con != null)//if conection is null,make loop to to close DB
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
}