package Funciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;

    public class FuncionesAgregar {
        private Connection c;
        public FuncionesAgregar(){
            c = Conexion.ObtenerConexion();
        }
        
        public static void GeneraVenta(ArrayList<Ventas> datos, float total,int nCaja){
            FuncionesAgregar fn = new FuncionesAgregar();
            if(fn.c != null){
                try {
                    String msg = "";
                    for(int i=0;i<datos.size();i++){
                        CallableStatement cs = fn.c.prepareCall
                        ("{Call dbo.GeneraVenta(?,?,?,?,?,?,?)}");
                        cs.setFloat(1, total);
                        cs.setInt(2, nCaja);
                        cs.setInt(3, datos.get(i).getCantidad());
                        cs.setString(4, datos.get(i).getCodigo());
                        cs.setFloat(5,datos.get(i).getPrecio());
                        cs.setInt(6, i);
                        cs.registerOutParameter(7,Types.VARCHAR);
                        cs.execute();
                        msg = cs.getString(7);
                    }
                    JOptionPane.showMessageDialog(null,msg);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
                }
            }else
                System.err.println("Error de conexión");
        }
        
        public static void AgregaEmpaquetado(String codigo,String nom,int cant,
                int cantMin,int cantMax,float contN,String unidad,String fechaCad,
                String proveedor,float precioV, float precioCom,int cantStock){
            FuncionesAgregar fn = new FuncionesAgregar();
            if(fn.c != null){
                try {
                    CallableStatement cs = fn.c.prepareCall
            ("{Call dbo.RegistraProd(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                    cs.setString(1, codigo);
                    cs.setString(2, nom);
                    cs.setInt(3, cant);
                    cs.setFloat(4, contN);
                    cs.setString(5, unidad);
                    cs.setString(6, fechaCad);
                    cs.setString(7, proveedor);
                    cs.setFloat(8, precioV);
                    cs.setFloat(9, precioCom);
                    cs.setInt(10, cantMin);
                    cs.setInt(11, cantMax);
                    cs.setInt(12, cantStock);
                    cs.registerOutParameter(13, Types.VARCHAR);
                    cs.execute();
                    JOptionPane.showMessageDialog(null, cs.getString(13));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error: "+ e.getMessage());
                }
            }
            System.err.println("Error de conexión");
        }
        
        public static void AgregaAgranel(String codigo,String nom,int cant,
                int cantMin,int cantMax,float contN,String unidad,String fechaCad,
                String proveedor,float precioV, float precioCom,int cantStock){
            FuncionesAgregar fn = new FuncionesAgregar();
            if(fn.c != null){
                try {
                    CallableStatement cs = fn.c.prepareCall
            ("{Call dbo.AgregaAgranel(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
                    cs.setString(1, codigo);
                    cs.setString(2, nom);
                    cs.setInt(3, cant);
                    cs.setFloat(4, contN);
                    cs.setString(5, unidad);
                    cs.setString(6, fechaCad);
                    cs.setString(7, proveedor);
                    cs.setFloat(8, precioV);
                    cs.setFloat(9, precioCom);
                    cs.setInt(10, cantMin);
                    cs.setInt(11, cantMax);
                    cs.setInt(12, cantStock);
                    cs.registerOutParameter(13, Types.VARCHAR);
                    cs.execute();
                    JOptionPane.showMessageDialog(null, cs.getString(13));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error: "+ e.getMessage());
                }
            }
            System.err.println("Error de conexión");
        }
}
