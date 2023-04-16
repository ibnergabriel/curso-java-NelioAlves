package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DB.getConnection();

            // Não confirmará a transação automaticamente
            connection.setAutoCommit(false);

            statement = connection.createStatement();

            int rows1 = statement.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            /*int x = 1;
            if (x < 2){
                throw new SQLException("AAAAAA");
            }*/

            int rows2 = statement.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            // Função que confirmará mudanças
            connection.commit();

            System.out.printf("rows1 = " + rows1);
            System.out.printf("rows2 = " + rows2);

        }
        catch (SQLException e) {
            // Lógica para retornar a transação, caso ocorra erro no meio
            try {
                connection.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            }
            catch (SQLException e1){
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        }
        finally {
            DB.closeStatement(statement);
            DB.closeConnection();
        }

    }
}
