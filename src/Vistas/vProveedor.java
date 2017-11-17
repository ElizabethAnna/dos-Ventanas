/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;


import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.*;
public class vProveedor extends JFrame{
    
    public JLabel etiidProducto, etiNombre, etiDireccion, etiTelefono,  eti_id;
    public JTextField txtNombre,txtDireccion, txtTelefono;
    public JButton btnAgregar, btnEliminar,btnGuardar, btnPDF, etiLimpiar;
    
    public JScrollPane scroll;
    public JTable tblDatos;
    public DefaultTableModel model;

    public vProveedor() {
        this.setVisible(true);
        this.setTitle("PROVEEDORES");
        this.setSize(700, 700);
        this.getContentPane().setLayout(new AbsoluteLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      
        
       
       Image icon = new ImageIcon(getClass().getResource("/IMAGENES/Paramore-Album.png")).getImage();
        this.setIconImage(icon);

        etiidProducto = new JLabel("id_Proveedor");
        this.getContentPane().add(etiidProducto, new AbsoluteConstraints(10, 10, 90, 20));
         eti_id = new JLabel("ID");
        this.getContentPane().add(eti_id, new AbsoluteConstraints(120, 10, 50, 20));

        etiNombre = new JLabel("Nombre");
        this.getContentPane().add(etiNombre, new AbsoluteConstraints(10, 50, 50, 20));
        etiDireccion = new JLabel("Direccion");
        this.getContentPane().add(etiDireccion, new AbsoluteConstraints(10, 90, 70, 20));

        etiTelefono = new JLabel("Telefono");
        this.getContentPane().add(etiTelefono, new AbsoluteConstraints(10, 130, 50, 20));
        

        txtNombre = new JTextField();
        this.getContentPane().add(txtNombre, new AbsoluteConstraints(120, 50, 130, 20));

        btnAgregar = new JButton("AGREGAR");
        this.getContentPane().add(btnAgregar, new AbsoluteConstraints(280, 10, 100, 20));
        btnEliminar = new JButton("ELIMINAR");
        this.getContentPane().add(btnEliminar, new AbsoluteConstraints(280, 60, 100, 20));
        btnGuardar = new JButton("GUARDAR");
        this.getContentPane().add(btnGuardar, new AbsoluteConstraints(280, 110, 100, 20));
        etiLimpiar = new JButton("LIMPIAR");
        this.getContentPane().add(etiLimpiar, new AbsoluteConstraints(280, 160, 100, 20));
        btnPDF = new JButton("PDF");
        this.getContentPane().add(btnPDF, new AbsoluteConstraints(280, 210, 100, 20));
        
                
        txtDireccion = new JTextField();
        this.getContentPane().add(txtDireccion, new AbsoluteConstraints(120, 90, 130, 20));
        txtTelefono = new JTextField();
        this.getContentPane().add(txtTelefono, new AbsoluteConstraints(120, 130, 130, 20));
        
        tblDatos = new JTable();
        scroll = new JScrollPane();
        model = new DefaultTableModel();
        model.addColumn("id_Proveedor");
        model.addColumn("Nombre");
        model.addColumn("Direccion");
        model.addColumn("Telefono");
       
        tblDatos.setModel(model);
        scroll.setViewportView(tblDatos);
        this.getContentPane().add(scroll, new AbsoluteConstraints(10, 270, 600,250));
        
        
        
        
         

    }
public static void main(String[] args) {
        vProveedor vv = new vProveedor();

    }
  
}

