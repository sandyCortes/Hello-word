package Funciones;

import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.text.Document;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Reportes {
    JFileChooser selecArch;
    JEditorPane editos;
    
    public Reportes(){
        selecArch = new JFileChooser();
        editos = new JEditorPane();
    }
    
    public void Reportes(String query,ArrayList<String> celdas,String nombreA){
        int opcion = selecArch.showSaveDialog(null);
        if(opcion == JFileChooser.APPROVE_OPTION){
            File f = selecArch.getSelectedFile();
            String fl = f.toString();
            CrearPDFFinal(fl,fl, query, celdas, nombreA);
        }
    }
    
    public void CrearPDFFinal(String ruta,String nombreR,
            String query,ArrayList<String> celdas,String nombreA){
         try {
             com.itextpdf.text.Document documento = new com.itextpdf.text.Document();
             PdfWriter writer  = null;
            writer = PdfWriter.getInstance(documento, 
            new FileOutputStream(ruta));
            documento.open();
             
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial",30,Font.ITALIC,BaseColor.CYAN));
            parrafo.add("\n\n\n"+nombreR+"\n\n\n\n");
            documento.add(parrafo);
            Paragraph parrafo2 = new Paragraph();
            parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo2.setFont(FontFactory.getFont("Arial",12,Font.ITALIC,BaseColor.BLACK));
            parrafo2.add("\n\n"+nombreR+"\n\n\n\n");
            documento.add(parrafo2);
            
            PdfPTable tabla = new PdfPTable(celdas.size());
            for(int i=0;i<celdas.size();i++)
                tabla.addCell(celdas.get(i));
            
            //Crear consulta
            Connection cn = Conexion.ObtenerConexion();
            Statement cs = cn.createStatement();
            ResultSet rs = cs.executeQuery(query);
            //PreparedStatement ps = cn.prepareStatement(query);
            //ResultSet rs = ps.executeQuery();
            while(rs.next()){
                for(int i=1; i <= celdas.size(); i++){
                    tabla.addCell(rs.getString(i));
                }
            }
            documento.add(tabla);
            documento.close();
            System.out.println("Reporte creado");
            try {
                String file = new String(ruta);
                //definiendo la ruta en la propiedad file
                Runtime.getRuntime().exec("cmd /c start"+file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }       
    }
}
