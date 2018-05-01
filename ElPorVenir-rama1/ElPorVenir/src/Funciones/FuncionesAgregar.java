package Funciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import javax.swing.JOptionPane;

    public class FuncionesAgregar {
        private Connection c;
        public FuncionesAgregar(){
            c = Conexion.ObtenerConexion();
        }
        
        public static void AgregaEmpaquetado(String codigo,String nom,int cant,
                int cantMin,int cantMax,float contN,String unidad,String fechaCad,
                String proveedor,float precioV, float precioCom){
            FuncionesAgregar fn = new FuncionesAgregar();
            if(fn.c != null){
                try {
                    CallableStatement cs = fn.c.prepareCall
            ("{Call dbo.RegistraProd(?,?,?,?,?,?,?,?,?,?,?,?)}");
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
                    cs.registerOutParameter(12, Types.VARCHAR);
                    cs.execute();
                    JOptionPane.showMessageDialog(null, cs.getString(12));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error: "+ e.getMessage());
                }
            }
            System.err.println("Error de conexión");
        }
        
        public static void AgregaAgranel(String codigo,String nom,int cant,
                int cantMin,int cantMax,float contN,String unidad,String fechaCad,
                String proveedor,float precioV, float precioCom){
            FuncionesAgregar fn = new FuncionesAgregar();
            if(fn.c != null){
                try {
                    CallableStatement cs = fn.c.prepareCall
            ("{Call dbo.AgregaAgranel(?,?,?,?,?,?,?,?,?,?,?,?)}");
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
                    cs.registerOutParameter(12, Types.VARCHAR);
                    cs.execute();
                    JOptionPane.showMessageDialog(null, cs.getString(12));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error: "+ e.getMessage());
                }
            }
            System.err.println("Error de conexión");
        }
        
}
