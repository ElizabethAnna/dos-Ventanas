/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Producto;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import static javax.swing.JOptionPane.*;

public class CProducto implements ActionListener, MouseListener {

    Vistas.vProducto v;
    
    Dao.DProducto dao;
    Modelos.Producto p, p1;
    int id = 0;

    public CProducto() {
        v = new Vistas.vProducto();
        
        v.setVisible(true);
        dao = new Dao.DProducto();
        p1 = new Modelos.Producto();

        v.btnAgregar.addActionListener(this);
        v.btnEliminar.addActionListener(this);
        v.btnGuardar.addActionListener(this);
        v.btnPDF.addActionListener(this);
        v.etiLimpiar.addActionListener(this);
        v.tblDatos.addMouseListener(this);
        v.btnBuscar.addActionListener(this);
        v.btnProve.addActionListener(this);

        refrescarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == v.btnAgregar) {
            p = new Producto();
            p.setNombre(v.txtNombre.getText());
            p.setPrecio(v.spPrecio.getValue().toString());
            p.setCantidad(v.spCantidad.getValue().toString());
            p.setProveedor(v.Preveedor.getSelectedItem().toString());
            if (dao.Create(p)) {
                JOptionPane.showMessageDialog(this.v, "Se inserto registro");

            } else {
                JOptionPane.showMessageDialog(this.v, "No se inserto ");
            }

        }
        LimpiarCampos();
        if (ae.getSource() == v.btnEliminar) {
            int x = JOptionPane.showConfirmDialog(this.v, "ESTAS SEGURO DE ELIMINAR REGISTRO?");
            if (x == 0 && id > 0) {
                if (dao.delete(id)) {
                    JOptionPane.showConfirmDialog(this.v, "Se elimino registro");

                } else {
                    JOptionPane.showConfirmDialog(this.v, "NO SE ELIMINO REGISTRO");

                }
            }

        }
        if (ae.getSource() == v.btnBuscar) {

        }

        if (ae.getSource() == v.btnProve) {
           Vistas.vProveedor pver;
            pver = new Vistas.vProveedor();
            pver.setVisible(true);
        }

        if (ae.getSource() == v.btnGuardar) {
            p1.setNombre(v.txtNombre.getText());
            p1.setPrecio(v.spPrecio.getValue().toString());
            p1.setCantidad(v.spCantidad.getValue().toString());
            p1.setProveedor(v.Preveedor.getSelectedItem().toString());
            if (!dao.update(p1)) {
                JOptionPane.showConfirmDialog(this.v, "no se actualizo registro");

            }

        }
        LimpiarCampos();

        if (ae.getSource() == v.btnPDF) {

            try {
                FileOutputStream archivo;
                File file = new File("C:\\Users\\Alumnos\\Desktop\\Crud_java\\src\\pdf\\Reporte.pdf");
                archivo = new FileOutputStream(file);
                Document doc = new Document();
                PdfWriter.getInstance(doc, archivo);
                doc.open();

                Image img = Image.getInstance("C:\\Users\\Alumnos\\Desktop\\Crud_java\\src\\IMAGENES\\Paramore.png");
                img.setAlignment(Element.ALIGN_CENTER);
                img.scaleToFit(500, 500);
                doc.add(img);
                Paragraph p = new Paragraph(10);
                Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
                p.add(Chunk.NEWLINE);
                p.add("Catalogo de productos");
                p.setAlignment(Element.ALIGN_CENTER);
                doc.add(p);
                p.add(Chunk.NEWLINE);
                p.add(Chunk.NEWLINE);
                p.setAlignment(Element.ALIGN_CENTER);
                doc.add(p);

                PdfPTable tabla = new PdfPTable(5);
                tabla.setWidthPercentage(100);
                PdfPCell c1 = new PdfPCell(new Phrase("ID_PRODUCTO", negrita));
                PdfPCell c2 = new PdfPCell(new Phrase("NOMBRE", negrita));
                PdfPCell c3 = new PdfPCell(new Phrase("PRECIO", negrita));
                PdfPCell c4 = new PdfPCell(new Phrase("CANTIDAD", negrita));
                PdfPCell c5 = new PdfPCell(new Phrase("PROVEEDOR", negrita));

                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c2.setHorizontalAlignment(Element.ALIGN_CENTER);
                c3.setHorizontalAlignment(Element.ALIGN_CENTER);
                c4.setHorizontalAlignment(Element.ALIGN_CENTER);
                c5.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                c2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                c3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                c4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                c5.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.addCell(c1);
                tabla.addCell(c2);
                tabla.addCell(c3);
                tabla.addCell(c4);
                tabla.addCell(c5);

                ArrayList< Modelos.Producto> lista = dao.read();

                for (Modelos.Producto pro : lista) {

                    tabla.addCell("" + pro.getId_producto());
                    tabla.addCell(pro.getNombre());
                    tabla.addCell("" + pro.getPrecio());
                    tabla.addCell("" + pro.getCantidad());
                    tabla.addCell(pro.getProveedor());

                }
                doc.add(tabla);

                Paragraph p1 = new Paragraph(10);

                p1.add(Chunk.NEWLINE);
                p1.add("NUMERO DE REGISTROS: " + lista.size());
                p1.add(Chunk.NEWLINE);
                p1.add(Chunk.NEWLINE);
                p1.setAlignment(Element.ALIGN_RIGHT);
                doc.add(p1);

                doc.close();
                archivo.close();
                Desktop.getDesktop().open(file);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this.v, "ERROR AL CREAR ARCHIVO");
            } catch (DocumentException ex) {
                JOptionPane.showMessageDialog(this.v, "ERROR AL CREAR DOCUMENTO");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this.v, "ERROR AL CREAR I/O");
            }
        }
        if (ae.getSource() == v.etiLimpiar) {
            LimpiarCampos();
        }
        refrescarTabla();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == v.tblDatos) {
            int fila = v.tblDatos.getSelectedRow();
            id = Integer.parseInt(v.tblDatos.getValueAt(fila, 0).toString());
            p1 = dao.read(id);
            v.eti_id.setText("" + p1.getId_producto());
            v.txtNombre.setText(p1.getNombre());
            v.spPrecio.setValue(p1.getPrecio());
            v.spCantidad.setValue(p1.getCantidad());
            v.Preveedor.setSelectedItem(p1.getProveedor());

        }

    }

    public void refrescarTabla() {
        while (v.model.getRowCount() > 0) {
            v.model.removeRow(0);

        }
        ArrayList< Modelos.Producto> Lista = dao.read();
        for (Modelos.Producto p : Lista) {
            Object item[] = new Object[5];
            item[0] = p.getId_producto();
            item[1] = p.getNombre();
            item[2] = p.getPrecio();
            item[3] = p.getCantidad();
            item[4] = p.getProveedor();
            v.model.addRow(item);

        }
        v.tblDatos.setModel(v.model);
    }

    public void LimpiarCampos() {
        v.txtNombre.setText("");
        v.spPrecio.setValue(0);
        v.spCantidad.setValue(0);
        v.Preveedor.setSelectedIndex(0);
        v.eti_id.setText(" ");

    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

    public static void main(String[] args) {
        CProducto cd = new CProducto();

    }
}
