
package Paneles;

import Funciones.FuncionesAgregar;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

public class PnRegistroProducto extends javax.swing.JPanel {
    public PnRegistroProducto() {
        initComponents();
        cbxProvedor = Funciones.Funciones.LLenaCombo("SELECT descripcion FROM Proveedor", cbxProvedor);
        cbxUnidad = Funciones.Funciones.LLenaCombo("SELECT tipoUnidad FROM Unidad", cbxUnidad);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCodigoBarras = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        pnAgregarP = new javax.swing.JPanel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lbEtiqueta = new javax.swing.JLabel();
        txtContenidoNeto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnPrecioCompra = new javax.swing.JTextField();
        pnPrecioVenta = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbxProvedor = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        cbxUnidad = new javax.swing.JComboBox();
        jclCaduca = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtCantidadMin = new javax.swing.JTextField();
        txtCantidadMax = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtCantStock = new javax.swing.JTextField();
        checkAgranel = new javax.swing.JCheckBox();

        setPreferredSize(new java.awt.Dimension(610, 415));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(610, 415));

        jLabel1.setText("CODIGO DE BARRAS");

        jLabel2.setText("DESCRIPCION");

        jLabel3.setText("CANTIDAD");

        lbEtiqueta.setText("CONTENIDO NETO");

        jLabel5.setText("FECHA DE CADUCIDAD");

        jLabel6.setText("PRECIO DE COMPRA");

        jLabel7.setText("PRECIO VENTA");

        pnPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnPrecioVentaActionPerformed(evt);
            }
        });

        jLabel8.setText("PROVEDOR");

        cbxProvedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("UNIDAD");

        cbxUnidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("CANTIDAD MÍNIMA");

        jLabel19.setText("CANTIDAD MAXIMA");

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel10.setText("CANTIDAD EN STOCK");

        javax.swing.GroupLayout pnAgregarPLayout = new javax.swing.GroupLayout(pnAgregarP);
        pnAgregarP.setLayout(pnAgregarPLayout);
        pnAgregarPLayout.setHorizontalGroup(
            pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAgregarPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(txtDescripcion)
                    .addComponent(jLabel4)
                    .addComponent(jLabel19)
                    .addComponent(txtCantidadMin)
                    .addComponent(txtCantidadMax)
                    .addComponent(jLabel10)
                    .addComponent(txtCantStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAgregarPLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel7)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnAgregarPLayout.createSequentialGroup()
                                .addComponent(jclCaduca, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))
                            .addGroup(pnAgregarPLayout.createSequentialGroup()
                                .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnAgregarPLayout.createSequentialGroup()
                                        .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtContenidoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(cbxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnAgregarPLayout.createSequentialGroup()
                                        .addComponent(pnPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(pnPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8)
                                    .addComponent(cbxProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
        );
        pnAgregarPLayout.setVerticalGroup(
            pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnAgregarPLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(lbEtiqueta))
                .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnAgregarPLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContenidoNeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnAgregarPLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidadMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jclCaduca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnAgregarPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        checkAgranel.setText("Agranel");
        checkAgranel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAgranelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(350, 350, 350)
                                .addComponent(checkAgranel))
                            .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnAgregarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(checkAgranel))
                .addGap(16, 16, 16)
                .addComponent(txtCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(pnAgregarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 410));
    }// </editor-fold>//GEN-END:initComponents

    private void checkAgranelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAgranelActionPerformed
        if(checkAgranel.isSelected())
            txtCodigoBarras.setEditable(false);
        else
            txtCodigoBarras.setEditable(true);
    }//GEN-LAST:event_checkAgranelActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(txtCantidad.getText().equals("")
            || txtCantidadMin.getText().equals("") || txtCantidadMax.getText().equals(""))
        JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        else{
            int cant = Integer.parseInt(txtCantidad.getText());
            int cantMin = Integer.parseInt(txtCantidadMin.getText());
            int cantMax = Integer.parseInt(txtCantidadMax.getText());
            float cont =Float.parseFloat(txtContenidoNeto.getText());
            float precioV =Float.parseFloat(pnPrecioCompra.getText());
            float precioC =Float.parseFloat(pnPrecioVenta.getText());
            int cantS = Integer.parseInt(txtCantStock.getText());
            if(checkAgranel.isSelected()){
                FuncionesAgregar.AgregaAgranel(Funciones.Funciones.codAgranel(),
                    txtDescripcion.getText(),cant,cantMin,cantMax
                    ,cont,cbxUnidad.getSelectedItem().toString(),
                    RegresaF(),cbxProvedor.getSelectedItem().toString(),
                    precioV,precioC,cantS);
            }
            else{
                FuncionesAgregar.AgregaEmpaquetado(txtCodigoBarras.getText(),
                    txtDescripcion.getText(),cant,cantMin,cantMax
                    ,cont,cbxUnidad.getSelectedItem().toString(),
                    RegresaF(),cbxProvedor.getSelectedItem().toString(),
                    precioV,precioC,cantS);
            }
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void pnPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnPrecioVentaActionPerformed

    }//GEN-LAST:event_pnPrecioVentaActionPerformed
    
    public String RegresaF(){
        String fecha = Integer.toString(jclCaduca.getCalendar().get(Calendar.YEAR))
                +"/"+Integer.toString(jclCaduca.getCalendar().get(Calendar.MONTH))
                +"/"+Integer.toString(jclCaduca.getCalendar().get(Calendar.DAY_OF_MONTH));
        return fecha;
    }
    
    private void ActiviarDesactivar(boolean visibilidaad){
          
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JComboBox cbxProvedor;
    private javax.swing.JComboBox cbxUnidad;
    private javax.swing.JCheckBox checkAgranel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jclCaduca;
    private javax.swing.JLabel lbEtiqueta;
    private javax.swing.JPanel pnAgregarP;
    private javax.swing.JTextField pnPrecioCompra;
    private javax.swing.JTextField pnPrecioVenta;
    private javax.swing.JTextField txtCantStock;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadMax;
    private javax.swing.JTextField txtCantidadMin;
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JTextField txtContenidoNeto;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
