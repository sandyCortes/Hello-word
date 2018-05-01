
package proveedores;

import Paneles.ModificacionUsuario;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import javax.swing.JOptionPane;

public class ModificarProveedor extends javax.swing.JPanel {


    public ModificarProveedor() {
        initComponents();
        groupProveedores.add(rbtnEliminar);
        groupProveedores.add(rbtnModificar);
        ActualizarTablas();
    
    }

    private void ActualizarTablas(){
        tbProveedores.setModel(Funciones.Funciones.LlenarTabla(
                "select descripcion,telefono,estatus from ProveedoresCompanias where "
                        + "estatus = 1"
                ,tbProveedores.getModel()));
        tbCompanias.setModel(Funciones.Funciones.LlenarTabla(
                "select Compania from ProveedoresCompanias group by Compania",
                tbCompanias.getModel()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupProveedores = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProveedores = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCompanias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBusProveedor = new javax.swing.JTextField();
        btnBuscarProveedor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btnBuscarGrupo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rbtnModificar = new javax.swing.JRadioButton();
        rbtnEliminar = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(610, 415));

        tbProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProveedores);

        tbCompanias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbCompanias);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setText("Modificar proveedores");

        jLabel2.setText("buscar");

        btnBuscarProveedor.setText("buscar");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        jLabel3.setText("buscar");

        btnBuscarGrupo.setText("Buscar");
        btnBuscarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarGrupoActionPerformed(evt);
            }
        });

        jLabel4.setText("proveedores");

        jLabel5.setText("grupos");

        rbtnModificar.setText("modificar");

        rbtnEliminar.setText("eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(txtBusProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarProveedor))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbtnModificar)
                                .addGap(18, 18, 18)
                                .addComponent(rbtnEliminar)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(183, 183, 183))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarGrupo)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnModificar)
                    .addComponent(rbtnEliminar)
                    .addComponent(jLabel5))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtBusProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarProveedor))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscarGrupo)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarGrupoActionPerformed
            tbProveedores.setModel(Funciones.Funciones.LlenarTabla(
                "select descripcion,telefono,estatus from ProveedoresCompanias where "
                        + "estatus = 1 AND descripcion = '"
                        +txtBusProveedor.getText().toString()+"'"
                ,tbProveedores.getModel()));
    }//GEN-LAST:event_btnBuscarGrupoActionPerformed

    private void tbProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProveedoresMouseClicked
        if(rbtnModificar.isSelected())
            Modificar(evt);
        else if(rbtnEliminar.isSelected())
            Eliminar(evt);
        else
            JOptionPane.showMessageDialog(null,"por favor seleccione una opcion");
    }//GEN-LAST:event_tbProveedoresMouseClicked

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void Eliminar(MouseEvent evt){
        int res = JOptionPane.showConfirmDialog(null,"Estas seguro de eliminar"
        + " este proveedor","Eliminar",JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION){
            Point point = evt.getPoint();
            int fila = tbProveedores.rowAtPoint(point);
            Connection c = Funciones.Conexion.ObtenerConexion();
            if(c!=null)
                try {
                    String query = "{Call dbo.EliminarProveedor(?,?)}";
                    CallableStatement cs = c.prepareCall(query);
                    cs.setString(1,tbProveedores.getModel().getValueAt(fila,0).toString());
                    cs.registerOutParameter(2,Types.VARCHAR);
                    cs.execute();
                    JOptionPane.showMessageDialog(null, cs.getString(2));
                    ActualizarTablas();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"error: "+ e.getMessage());
                }
        }
        
    }
    
    private void Modificar(MouseEvent evt) {
        int res = JOptionPane.showConfirmDialog(null,"Estas seguro",
                "Modificar",JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION){
            Point point = evt.getPoint();
            int fila = tbProveedores.rowAtPoint(point);
            new ModificarDatosProveedor(
                tbProveedores.getModel().getValueAt(fila,0).toString(), 
                tbProveedores.getModel().getValueAt(fila,1).toString()).
                setVisible(true);
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarGrupo;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.ButtonGroup groupProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton rbtnEliminar;
    private javax.swing.JRadioButton rbtnModificar;
    private javax.swing.JTable tbCompanias;
    private javax.swing.JTable tbProveedores;
    private javax.swing.JTextField txtBusProveedor;
    // End of variables declaration//GEN-END:variables
}
