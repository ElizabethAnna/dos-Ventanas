/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    Connection cx;
    String bd="prove";
    String url="jdbc:mysql://localhost:3306/"+bd;
    String user="root";
    String pass="";
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cx=(Connection)DriverManager.getConnection(url,user,pass);
             System.out.println("conectado");
        } catch (ClassNotFoundException ex) {
             System.out.println("NO conectado");
        } catch (SQLException ex) {
            System.out.println(" NO conectado");
        }
        return cx;
    }
    public void Cerrar(){
        try {       
            cx.close();
        } catch (SQLException ex) {
             System.out.println("NO CERRAR conectado");
        }
        
    }
    public static void main(String[] args) {
        Conexion c=new Conexion();
        c.conectar();
        c.Cerrar();
    }
}

