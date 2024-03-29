package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection(){
        if(connection == null){
            try{
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                connection = DriverManager.getConnection(url, props);
            }
            catch (SQLException e){
                // SQLException é derivado da classe Exception == obrigado a tratar.
                throw new DbException(e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            }
            catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(fs);
            return properties;
        }
        catch (IOException e){
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement statement){
        if (statement != null){
            try {
                statement.close();
            }
            catch (SQLException e) {
                // Para lançar uma RunTimeException
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet resultSet){
        if (resultSet != null){
            try {
                resultSet.close();
            }
            catch (SQLException e) {
                // Para lançar uma RunTimeException
                throw new DbException(e.getMessage());
            }
        }
    }

}

