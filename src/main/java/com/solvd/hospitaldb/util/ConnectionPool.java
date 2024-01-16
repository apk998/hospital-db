package com.solvd.hospitaldb.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.IntStream;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool connectionPool = null;
    private final List<Connection> connections = new ArrayList<>();
    private static final int MAX_CONNECTIONS = 50;

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    private ConnectionPool() {
        loadDatabaseProperties();
        initializeConnections();
    }

    private void loadDatabaseProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            if (input == null) {
                LOGGER.error("Unable to find config.properties");
                return;
            }

            properties.load(input);
            URL = properties.getProperty("url");
            USERNAME = properties.getProperty("username");
            PASSWORD = properties.getProperty("password");
        } catch (IOException ex) {
            LOGGER.error("Error loading database properties", ex);
        }
    }

    private void initializeConnections() {
        IntStream.range(0, MAX_CONNECTIONS).forEach(i -> {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                LOGGER.info("Connection created: " + connection.getClass());
            } catch (SQLException ex) {
                LOGGER.error("Error creating connection", ex);
            }
            connections.add(connection);
        });
    }

    public synchronized static ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public synchronized Connection getConnection(long timeoutMillis) {
        long endTime = System.currentTimeMillis() + timeoutMillis;
        while (connections.isEmpty() && System.currentTimeMillis() < endTime) {
            try {
                wait(endTime - System.currentTimeMillis());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return connections.remove(0);
    }

    public synchronized void releaseConnection(Connection connection) {
        if (connection == null) {
            LOGGER.warn("Attempted to release a null connection.");
            return;
        }

        try {
            connection.close();
            LOGGER.info(Thread.currentThread().getName() + " released connection: " + connection.getClass());
        } catch (SQLException e) {
            LOGGER.info("Error releasing connection", e);
        } finally {
            connections.add(connection);
            notify();
        }
    }
}