package application;

import db.DB;

import java.sql.Connection;

public class Program {

    public static void main(String[] args) {

        // Conecta com o Banco de Dados
        Connection connection = DB.getConnection();
        // Fecha conexão com o banco
        DB.closeConnection();
    }
}
