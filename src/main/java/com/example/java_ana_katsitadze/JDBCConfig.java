package com.example.java_ana_katsitadze;

import java.sql.*;

public class JDBCConfig {
    public static final String DB_URL = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7588522";
    public static final String USER = "sql7588522";
    public static final String PASSWORD = "yMCcVJDIss";

    private static Connection connection;
    private static Statement statement;

    static {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
    }
    public static Statement getStatement() throws SQLException {
        try {
            statement = connection.createStatement();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        return statement;
    }

    public static boolean TableExists(String tableName) throws SQLException {
        DatabaseMetaData dbm = connection.getMetaData();
        ResultSet resultSet = dbm.getTables(null,null,tableName,new String[]{"TABLE"});

        return resultSet.next();


    }
}
