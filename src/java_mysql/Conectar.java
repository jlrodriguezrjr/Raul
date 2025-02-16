/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_mysql;

/**
 *
 * @author raul
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conectar {

    public static final String URL = "jdbc:mysql://192.168.1.6:3306/base_alumnos";
    public static final String USER = "jr";
    public static final String CLAVE = "$Wvqe87ia";
    public Connection con;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }

    public void desconectar() {
        if (con != null) {
            try {
                con.close();
                con = null;
                JOptionPane.showMessageDialog(null, "Conexion cerrada con exito");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error:" + e.getMessage());
            }
        }
    }
}
