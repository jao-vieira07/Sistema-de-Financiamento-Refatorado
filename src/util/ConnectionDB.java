package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/db_jfinance";
    private static final String USER = "postgres";
    private static final String PASSWORD = "coloque_sua_senha_aqui";

    public static Connection getConnection() { //Faz a conexão
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD); /**Verifica se as informações estão
             corretas no postgre **/
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 }
