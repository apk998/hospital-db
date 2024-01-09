package com.solvd.hospitaldb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    private static final Logger LOGGER= LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        // Verify connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            // handle the error
        }

        // Testing the connection
        String url = "jdbc:mysql://localhost:3306/hospital_db";
        String username = "root";
        String password = "passw0rd";

        LOGGER.info("Connecting database ...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            LOGGER.info("Database connected");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database", e);
        }
    }
}