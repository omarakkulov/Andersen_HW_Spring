package ru.akkulov.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyConnectionPool implements ConnectionPool {
    private final String url;
    private final String user;
    private final String password;
    private final List<Connection> connectionPool;
    private final List<Connection> usedConnections = new ArrayList<>();
    private static final int INITIAL_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 30;
    private static final int MAX_TIMEOUT = 3;

    public MyConnectionPool(String url, String user, String password, List<Connection> pool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = pool;
    }

    public static MyConnectionPool create() {
        String url = "jdbc:postgresql://localhost:5432/andersen_hw2";
        String user = "postgres";
        String password = "root";

        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        try {
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                pool.add(createConnection(url, user, password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new MyConnectionPool(url, user, password, pool);
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            if (connectionPool.isEmpty()) {
                if (usedConnections.size() < MAX_POOL_SIZE) {
                    connectionPool.add(createConnection(url, user, password));
                } else {
                    throw new RuntimeException("Maximum pool size reached, no available connections!");
                }
            }

            connection = connectionPool.remove(connectionPool.size() - 1);

            if (!connection.isValid(MAX_TIMEOUT)) {
                connection = createConnection(url, user, password);
            }

            usedConnections.add(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, user, password);
    }
}
