package com.solvd.hospitaldb.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool connectionPool = null;
    private final List<Connection> connections = new ArrayList<>();
    private static final int MAX_CONNECTIONS = 20;

    private ConnectionPool() {
        IntStream.range(0, MAX_CONNECTIONS).forEach(i -> {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/test?" +
                        "user=minty&password=greatsqldb");
                LOGGER.info("Connection created: " + connection.getClass());
            } catch (SQLException ex) {
                LOGGER.info("Error creating connection", ex);
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
        try {
            connection.close();
            LOGGER.info(Thread.currentThread().getName() + " released connection: " + connection.getClass());
        } catch (SQLException e) {
            LOGGER.info("Error releasing connection", e);
        }
        connections.add(connection);
        notify();
    }
}