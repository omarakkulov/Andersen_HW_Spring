package ru.akkulov.connection;

import java.sql.Connection;

public interface ConnectionPool {
    Connection getConnection();
}