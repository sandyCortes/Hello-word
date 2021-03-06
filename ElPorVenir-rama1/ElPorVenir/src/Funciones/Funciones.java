
package Funciones;

import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Funciones {
    
    public static int GenerarPass(){
        return new Random().nextInt();
    }
    
    public static void AbreCaja(int nCaja,float importeI){
        Connection c = Conexion.ObtenerConexion();
        if(c != null){
            try {
                CallableStatement cs = c.prepareCall("{Call dbo.AbreC(?,?)}");
                cs.setInt(1, nCaja);
                cs.setFloat(2, importeI);
                cs.execute();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            }
        }else
            System.err.println("Error de conexión");
    }
    
     public static void CerrarCaja(int nCaja,float importeI){
        Connection c = Conexion.ObtenerConexion();
        if(c != null){
            try {
                CallableStatement cs = c.prepareCall("{Call dbo.CerrarC(?,?)}");
                cs.setInt(1, nCaja);
                cs.setFloat(2, importeI);
                cs.execute();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            }
        }else
            System.err.println("Error de conexión");
    }
    
    public static String codAgranel(){
        String cod = "";
        Connection c = Conexion.ObtenerConexion();
        if(c != null){
            try {
                CallableStatement cs = c.prepareCall("{Call dbo.GeneraPass(?)}");
                cs.registerOutParameter(1, Types.VARCHAR);
                cs.execute();
                cod = cs.getString(1);
            } catch (Exception e) {
            }
        }else
            JOptionPane.showMessageDialog(null, "Error de conexión");
        return "A/"+cod;
    }
    
    public static String IDEmpleado(String query){
        String id ="";
        Connection c = Conexion.ObtenerConexion();
        if(c != null){
            try {
                Statement statement = c.createStatement();
                ResultSet rs = statement.executeQuery(query);
            if(rs.next())
                id = rs.getString(1);
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            }
        }else
            System.err.println("Error de conexión");
        return id;
    }
    
    public static TableModel LlenarTabla(String query,TableModel model){
        TableModel tb = 
                LlenadoDeTablas(query);
        if(tb!=null)
            return tb;
        
        return model;
    }
    
    public static int Loguea(String user,String pass){
       int tipoU = 0;
       Connection c = Conexion.ObtenerConexion();
       if(c != null){
           try {
               CallableStatement cs = c.prepareCall("{Call dbo.Loguea(?,?,?)}");
               cs.setString(1, user);
               cs.setString(2, pass);
               cs.registerOutParameter(3, Types.VARCHAR);
               cs.execute();
               tipoU = cs.getInt(3);
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
           }
       }else
            System.err.println("Error de conexión");
       return tipoU;
    }
    
     public static void AgragaCompania(String descripcion ){
        Connection conexion=Conexion.ObtenerConexion();
        if(conexion !=null){
            try {
                CallableStatement cs = conexion.prepareCall("{Call dbo.AgregaCompania(?)}");
                cs.setString(1, descripcion);
                cs.execute();
               } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
            }
         }
    }
    
    public static void AgregarProveedor(String marca,String telefono, String compania){
        Connection conexion=Conexion.ObtenerConexion();
        if(conexion !=null){
            try{
                CallableStatement cs=conexion.prepareCall("{Call dbo.AgregaProveedor(?,?,?,?)}");
                cs.setString(1,marca);
                cs.setString(2,telefono);
                cs.setString(3,compania);
                cs.registerOutParameter(4,Types.VARCHAR);
                cs.execute();
                JOptionPane.showMessageDialog(null,cs.getString(4));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
            }
        }
    }
        
    public static JComboBox LLenaCombo(String query,JComboBox jComboBox){
        Connection c = Conexion.ObtenerConexion();
        jComboBox.removeAllItems();
        if(c!=null)
            try {
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next())
                    jComboBox.addItem(rs.getString(1));
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        return jComboBox;
    }
    
    public static Integer obtenerID(String nombre, String apPaterno, String apMaterno, String correo){
        Integer id = null;
        Connection c = Conexion.ObtenerConexion();
        if(c != null)
            try{
                String idQuery = "Select idUsuario from Usuarios where"
                        + " nombreUse ='"+nombre+"'AND aPpUser = '"+apPaterno+"' AND"
                        + " aPmUser = '"+apMaterno+"'AND \n" +
                        " correo = '"+correo+"' ";
                Statement stObtenerID = c.createStatement();
                ResultSet rs = stObtenerID.executeQuery(idQuery);
                if(rs.next())
                    id = rs.getInt(1);
                   
            }catch(Exception e){
                System.out.println("Error de conexion" + e.getMessage());
        }
        return id;
    }
    
    private static DefaultTableModel LlenadoDeTablas(String query){
        Connection c = Conexion.ObtenerConexion();
        DefaultTableModel model = null;
        if(c!=null)
            try {
               Statement st = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                ResultSet.CONCUR_READ_ONLY);
               ResultSet rs = st.executeQuery(query);
               if(rs.next()){
                   int columnas = rs.getMetaData().getColumnCount();
                   rs.last();
                   int filas = rs.getRow();
                   String [] titulos = new String[columnas];
                   String [][] datos = new String[filas][columnas];
                   for(int i = 0;i<columnas;i++)
                        titulos[i] = rs.getMetaData().getColumnName(i+1);
                   rs.first();
                   for(int i = 0;i<filas;i++,rs.next())
                       for(int j = 0;j<columnas;j++)
                           datos[i][j] = rs.getString(j+1);
                   model = new DefaultTableModel(datos, titulos);
               }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        return model;
    }
}