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

public class DProveedor {

    Gestion.Conexion cx;
    Modelos.Proveedor p;

    public DProveedor() {
        cx = new Gestion.Conexion();

    }

    public boolean Create(Modelos.Proveedor p) {
        try {
            String sql="INSERT INTO proveedor(Nombre,Direccion,telefono) VALUES(?,?,?)";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDireccion());
            ps.setString(3, p.getTelefono());
            
            
            ps.execute();
            ps.close();
            ps=null;
            cx.Cerrar();
             return true;
        } catch (SQLException e) {
            
            return false;
        }
       
    }
    public ArrayList<Modelos.Proveedor> read(){
         ArrayList<Modelos.Proveedor>Lista= new ArrayList<Modelos.Proveedor>();
        try {
           
            String sql="SELECT * FROM proveedor";
            PreparedStatement ps=cx.conectar().prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            Modelos.Proveedor p=new Modelos.Proveedor();
            p.setId_proveedor(rs.getInt("id_proveedor"));
            p.setNombre(rs.getString("Nombre"));
            p.setDireccion(rs.getString("Direccion"));
            p.setTelefono(rs.getString("telefono"));
            
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
            String sql="DELETE FROM proveedor WHERE id_proveedor=?";
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
    
    
    
    
    
     public boolean Like(int id){
        try {
            String sql="SELECT producto.id_producto,producto.Nombre,producto.Precio,producto.Cantidad,proveedor.Nombre FROM producto, proveedor NATURAL JOIN  WHERE producto.nombre like (%?%) OR (producto.Precio like`%?%`)";
            PreparedStatement ps=cx.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDireccion());
            ps.setString(3, p.getTelefono());
            ps.execute();
            ps.close();
            ps=null;
            cx.Cerrar();
            return true;
        } catch (SQLException ex) {
            return false;
        }
       
        
    }
    public boolean update(Modelos.Proveedor p ){
        try {
            String sql="UPDATE proveedor SET Nombre=?,Direccion=?,Telefono=? WHERE id_proveedor=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getDireccion());
            ps.setString(3, p.getTelefono());
             ps.setInt(4, p.getId_proveedor());
            
            ps.execute();
            ps.close();
            ps=null;
            cx.Cerrar();
             return true;
        } catch (SQLException e) {
            
            return false;
        }
        
    }
    public Modelos.Proveedor read(int id){
        Modelos.Proveedor p=new Modelos.Proveedor();
        try {
           
            String sql="SELECT * FROM proveedor WHERE id_proveedor=?";
            PreparedStatement ps=cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
          
            p.setId_proveedor(rs.getInt("id_proveedor"));
            p.setNombre(rs.getString("Nombre"));
            p.setDireccion(rs.getString("Direccion"));
            p.setTelefono(rs.getString("Telefono"));
           
           
            
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

