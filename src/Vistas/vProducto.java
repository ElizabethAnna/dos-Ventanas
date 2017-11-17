/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;


import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.*;

public class vProducto extends javax.swing.JFrame {

    public JLabel etiidProducto, etiNombre, etiPrecio, etiCantidad, etiproveedor, eti_id,etiBuscar;
    public JTextField txtNombre,txtBuscar;
    public JButton btnAgregar, btnEliminar,btnGuardar, btnPDF, etiLimpiar,btnProve, btnBuscar;
    public JSpinner spPrecio, spCantidad;
    public JComboBox Preveedor;
    public JScrollPane scroll;
    public JTable tblDatos;
    public DefaultTableModel model;

    public vProducto() {
        this.setVisible(true);
        this.setTitle("PRODUCTOS");
        this.setSize(700, 700);
        this.getContentPane().setLayout(new AbsoluteLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      
        
       
       Image icon = new ImageIcon(getClass().getResource("/IMAGENES/Paramore-Album.png")).getImage();
        this.setIconImage(icon);

        etiidProducto = new JLabel("id_Producto");
        this.getContentPane().add(etiidProducto, new AbsoluteConstraints(10, 10, 90, 20));
         eti_id = new JLabel("ID");
        this.getContentPane().add(eti_id, new AbsoluteConstraints(120, 10, 50, 20));

        etiNombre = new JLabel("Nombre");
        this.getContentPane().add(etiNombre, new AbsoluteConstraints(10, 50, 50, 20));
        etiPrecio = new JLabel("Precio");
        this.getContentPane().add(etiPrecio, new AbsoluteConstraints(10, 90, 50, 20));

        etiCantidad = new JLabel("Cantidad");
        this.getContentPane().add(etiCantidad, new AbsoluteConstraints(10, 130, 50, 20));
        etiproveedor = new JLabel("Proveedor");
        this.getContentPane().add(etiproveedor, new AbsoluteConstraints(10, 170, 70, 20));
        
        
        
        etiBuscar = new JLabel("BUSCAR");
        this.getContentPane().add(etiBuscar, new AbsoluteConstraints(10, 210, 70, 20));
        
        txtBuscar = new JTextField();
        this.getContentPane().add(txtBuscar, new AbsoluteConstraints(120, 210, 90, 20));
         btnProve = new JButton("+");
        this.getContentPane().add(btnProve, new AbsoluteConstraints(220, 170, 50, 20));
        
         btnBuscar = new JButton("Buscar");
        this.getContentPane().add(btnBuscar, new AbsoluteConstraints(10, 230, 90, 20));
        
        

        txtNombre = new JTextField();
        this.getContentPane().add(txtNombre, new AbsoluteConstraints(120, 50, 90, 20));

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
        
                
        spPrecio = new JSpinner();
        this.getContentPane().add(spPrecio, new AbsoluteConstraints(120, 90, 90, 20));
        spCantidad = new JSpinner();
        this.getContentPane().add(spCantidad, new AbsoluteConstraints(120, 130, 90, 20));
        
        ArrayList<String> nombreProvedores=new ArrayList<String>();
        
        //consulta provedores where *  funcion
        //me va a regresar una lista for en donde vas a llenar objetos 
        //mandas a llamar a read de provedores
        Dao.DProveedor consultaProvedor=new Dao.DProveedor();
        ArrayList<Modelos.Proveedor> listaProvedores=new ArrayList<Modelos.Proveedor>();
        listaProvedores=consultaProvedor.read();
            for (int i = 0; i < listaProvedores.size(); i++) {
                nombreProvedores.add(listaProvedores.get(i).getNombre());
        }
        
        
        Preveedor = new JComboBox();
        for (int i = 0; i < nombreProvedores.size(); i++) {
            Preveedor.addItem(nombreProvedores.get(i));
        }
        
        this.getContentPane().add(Preveedor, new AbsoluteConstraints(120, 170, 90, 20));

        tblDatos = new JTable();
        scroll = new JScrollPane();
        model = new DefaultTableModel();
        model.addColumn("id_Producto");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Cantidad");
        model.addColumn("Proveedor");
        tblDatos.setModel(model);
        scroll.setViewportView(tblDatos);
        this.getContentPane().add(scroll, new AbsoluteConstraints(10, 270, 400,250));
        
        
        
        
         

    }
public static void main(String[] args) {
        vProducto vD = new vProducto();

    }
  
}
