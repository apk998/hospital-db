package com.solvd.hospitaldb.util;

import com.solvd.hospitaldb.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Database {
    private static final Logger LOGGER= LogManager.getLogger(Database.class);

    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "passw0rd";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        connection.setAutoCommit(true);
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException exception) {
            LOGGER.error("Error closing the database connection", exception);
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException exception) {
            LOGGER.error("Error closing the statement", exception);
        }
    }

    public static void closePreparedStatement(PreparedStatement preparedstatement) {
        try {
            if (preparedstatement != null) {
                preparedstatement.close();
            }
        } catch (SQLException exception) {
            LOGGER.error("Error closing the prepared statement", exception);
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException exception) {
            LOGGER.error("Error closing the result set", exception);
        }
    }
}