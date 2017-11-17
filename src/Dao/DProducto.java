/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DProducto {

    Gestion.Conexion cx;
    Modelos.Producto p;

    public DProducto() {
        cx = new Gestion.Conexion();

    }

    public boolean Create(Modelos.Producto p) {
        try {
            String sql="INSERT INTO producto(Nombre,Precio,Cantidad,Proveedor) VALUES(?,?,?,?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getPrecio());
            ps.setString(3, p.getCantidad());
            ps.setString(4, p.getProveedor());
            
            ps.execute();
            ps.close();
            ps=null;
            cx.Cerrar();
             return true;
        } catch (SQLException e) {
            
            return false;
        }
       
    }
    public ArrayList<Modelos.Producto> read(){
         ArrayList<Modelos.Producto>Lista= new ArrayList<Modelos.Producto>();
        try {
           
            String sql="SELECT * FROM producto";
            PreparedStatement ps=cx.conectar().prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Modelos.Producto p=new Modelos.Producto();
            p.setId_producto(rs.getInt("id_producto"));
            p.setNombre(rs.getString("Nombre"));
            p.setPrecio(rs.getString("Precio"));
            p.setCantidad(rs.getString("Cantidad"));
            p.setProveedor(rs.getString("Proveedor"));
            Lista.add(p);
            
        }
        ps.close();
        ps=null;
        cx.Cerrar();
        
        } catch (SQLException ex) {
            System.out.println("fallo moto read");
        }
        return Lista;
        
    }
    public boolean delete(int id){
        try {
            String sql="DELETE FROM producto WHERE id_producto=?";
            PreparedStatement ps=cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            ps=null;
            cx.Cerrar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
       
        
    }
    public boolean update(Modelos.Producto p ){
        try {
            String sql="UPDATE producto SET Nombre=?,Precio=?,Cantidad=?,Proveedor=? WHERE id_producto=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getPrecio());
            ps.setString(3, p.getCantidad());
            ps.setString(4, p.getProveedor());
             ps.setInt(4, p.getId_producto());
            
            ps.execute();
            ps.close();
            ps=null;
            cx.Cerrar();
             return true;
        } catch (SQLException e) {
            
            return false;
        }
        
    }
    public Modelos.Producto read(int id){
        Modelos.Producto p=new Modelos.Producto();
        try {
           
            String sql="SELECT * FROM producto WHERE id_producto=?";
            PreparedStatement ps=cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
          
            p.setId_producto(rs.getInt("id_producto"));
            p.setNombre(rs.getString("Nombre"));
            p.setPrecio(rs.getString("Precio"));
            p.setCantidad(rs.getString("Cantidad"));
            p.setProveedor(rs.getString("Proveedor"));
           
            
        }
        ps.close();
        ps=null;
        cx.Cerrar();
        
        } catch (SQLException ex) {
            System.out.println("fallo moto read producto");
        }
        return p;
        
    }

}
