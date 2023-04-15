package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public static void main(String[] args) {

        // Conecta ao banco
        Connection connection;
        // Prepara a consulta SQL
        Statement statement = null;
        // Resultado da consulta
        ResultSet resultSet = null;

        try{
            connection = DB.getConnection();
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from department");

            // Enquanto existir um próximo
            while(resultSet.next()){
                // Para percorrer cada coluna da tabela, basta usar o método .get
                System.out.println(resultSet.getInt("Id") + " " + resultSet.getString("Name"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeResultSet(resultSet);
            DB.closeStatement(statement);
            DB.closeConnection();
        }
    }
}
