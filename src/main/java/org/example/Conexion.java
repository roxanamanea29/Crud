package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Roxana
 * @date 04/04/2024
 */
public class Conexion {
    String url = "jdbc:mysql://localhost:3306/tarea";
    String user = "root";
    String pass = "";
    Connection con;

    public Connection conectar() throws SQLException {
        con=  DriverManager.getConnection(url, user, pass);
        return con;
    }
}
