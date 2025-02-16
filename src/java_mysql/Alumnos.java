/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java_mysql;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author raul
 */
public class Alumnos {

    static JTextField txt_control, txt_nombre, txt_ap_paterno, txt_ap_materno;
    static com.toedter.calendar.JDateChooser fecha;
    static JButton guardar, desconectar, conectar;
    static Conectar conectaBD;
    static Connection con;
    public static void main(String[] args) {

        JFrame frame = new JFrame("Pantalla");
        frame.setSize(350, 310);
        frame.setLayout(null);

        JLabel n_control = new JLabel("Numero de Control:");
        n_control.setBounds(20, 50, 130, 20);
        JLabel nombre = new JLabel("Nombre:");
        nombre.setBounds(20, 80, 130, 20);
        JLabel ap_paterno = new JLabel("Apellido Paterno:");
        ap_paterno.setBounds(20, 110, 130, 20);
        JLabel ap_materno = new JLabel("Apellido Materno:");
        ap_materno.setBounds(20, 140, 130, 20);
        JLabel fecha_nacimiento = new JLabel("Fecha Nacimiento:");
        fecha_nacimiento.setBounds(20, 170, 130, 20);

        txt_control = new JTextField();
        txt_control.setBounds(140, 50, 150, 20);
        txt_nombre = new JTextField();
        txt_nombre.setBounds(140, 80, 150, 20);
        txt_ap_paterno = new JTextField();
        txt_ap_paterno.setBounds(140, 110, 150, 20);
        txt_ap_materno = new JTextField();
        txt_ap_materno.setBounds(140, 140, 150, 20);
        fecha = new com.toedter.calendar.JDateChooser();
        fecha.setBounds(140, 170, 150, 20);

        conectar = new JButton("Conectar a serivdor");
        conectar.setBounds(10, 10, 200, 30);

        desconectar = new JButton("Cerrar conexion");
        desconectar.setBounds(10, 200, 140, 30);

        guardar = new JButton("Guardar");
        guardar.setBounds(220, 200, 100, 30);

        frame.add(n_control);
        frame.add(nombre);
        frame.add(ap_paterno);
        frame.add(ap_materno);
        frame.add(fecha_nacimiento);
        frame.add(txt_control);
        frame.add(txt_nombre);
        frame.add(txt_ap_paterno);
        frame.add(txt_ap_materno);
        frame.add(fecha);
        frame.add(conectar);
        frame.add(guardar);
        frame.add(desconectar);

        frame.setVisible(true);

        ActionListener clic, conectar_bd_clic, desconectar_bd_clic;
        clic = (ActionEvent e) -> {
            guardar_datos();
        };
        
        conectar_bd_clic = (ActionEvent e) -> {
            conectar_bd();
        };
        
        desconectar_bd_clic = (ActionEvent e) -> {
            desconectar_bd();
        };

        conectar.addActionListener(conectar_bd_clic);
        guardar.addActionListener(clic);
        desconectar.addActionListener(desconectar_bd_clic);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void guardar_datos() {
        try {
            if (con != null) {
             PreparedStatement consulta;
            consulta = con.prepareStatement("INSERT INTO base_alumnos.tabla_alumnos(Numero_control,Nombre,Apellido_paterno,Apellido_materno,Fecha_nacimiento)VALUES(?,?,?,?,?)");
            consulta.setString(1, txt_control.getText());
            consulta.setString(2, txt_nombre.getText());
            consulta.setString(3, txt_ap_paterno.getText());
            consulta.setString(4, txt_ap_materno.getText());
            consulta.setDate(5, new java.sql.Date(fecha.getDate().getTime()));
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se guardo con exito");
            
            txt_control.setText("");
            txt_nombre.setText("");
            txt_ap_paterno.setText("");
            txt_ap_materno.setText("");
            fecha.setDate(null);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha establecido una conexion");
        }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar, Error:" + e.getMessage());
        }
    }

    public static void conectar_bd() {
        conectaBD = new Conectar();
        con = conectaBD.getConexion();
        if (con != null) {
            JOptionPane.showMessageDialog(null, "Se establecio la conexion con exito");
        } else {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }
    
      public static void desconectar_bd() {
        if (conectaBD != null) {
            conectaBD.desconectar();
            conectaBD = null;
            con = null;
        } else {
            JOptionPane.showMessageDialog(null, "No hay conexion que cerrar");
        }
    }
}
