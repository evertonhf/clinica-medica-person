package br.edu.imepac.clinica_medica.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDao {

    private static final String URL = "jdbc:mysql://localhost:3306/clinica_medica";
    private static final String USER = "root";
    private static final String PASSWORD = "AzSx718293!";

    protected static Connection connection;

    public BaseDao() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
