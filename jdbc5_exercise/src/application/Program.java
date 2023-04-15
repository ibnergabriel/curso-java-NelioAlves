package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program {

    public static void main(String[] args) {

        Connection connection;
        PreparedStatement preparedStatement = null;

        try {
            connection = DB.getConnection();

           preparedStatement = connection.prepareStatement("DELETE FROM department "
                   + "WHERE "
                   +"Id = ?");

           preparedStatement.setInt(1,5);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.printf("Done! Rows Affected: " + rowsAffected);

        }
        catch (DbException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeStatement(preparedStatement);
            DB.closeConnection();
        }

    }
}
