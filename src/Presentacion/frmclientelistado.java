/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.logcliente;
import Logica.logtrabajador;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZAIR
 */
public class frmclientelistado extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmlistadoclientes
     */
    public frmclientelistado() {
        initComponents();
        //Iniciando el metodo mostrar el cual llena la tabla de clientes
        mostrar("");
        Color myColor = new Color(255,255,255);
         tablaclientes.setBackground(myColor);
         jScrollPane1.getViewport().setBackground(myColor);
          ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);//Con esto quito el title
    }
    void ocultar_columnas(){
        //Col 0
    tablaclientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            //Col 1
    tablaclientes.getColumnModel().getColumn(1).setPreferredWidth(100);
            //Col 2
    tablaclientes.getColumnModel().getColumn(2).setPreferredWidth(100);
    //Col 3
    tablaclientes.getColumnModel().getColumn(3).setPreferredWidth(100);
      //Col 4
    tablaclientes.getColumnModel().getColumn(4).setMaxWidth(0);
    tablaclientes.getColumnModel().getColumn(4).setMinWidth(0);
    tablaclientes.getColumnModel().getColumn(4).setPreferredWidth(0);
    
      //Col 5
    tablaclientes.getColumnModel().getColumn(5).setMaxWidth(0);
    tablaclientes.getColumnModel().getColumn(5).setMinWidth(0);
    tablaclientes.getColumnModel().getColumn(5).setPreferredWidth(0);
    
      //Col 6
    tablaclientes.getColumnModel().getColumn(6).setMaxWidth(0);
    tablaclientes.getColumnModel().getColumn(6).setMinWidth(0);
    tablaclientes.getColumnModel().getColumn(6).setPreferredWidth(0);
    
      //Col 7
    tablaclientes.getColumnModel().getColumn(7).setMaxWidth(0);
    tablaclientes.getColumnModel().getColumn(7).setMinWidth(0);
    tablaclientes.getColumnModel().getColumn(7).setPreferredWidth(0);
    
      //Col 8
    tablaclientes.getColumnModel().getColumn(8).setMaxWidth(0);
    tablaclientes.getColumnModel().getColumn(8).setMinWidth(0);
    tablaclientes.getColumnModel().getColumn(8).setPreferredWidth(0);
    
      //Col 9
    tablaclientes.getColumnModel().getColumn(9).setMaxWidth(0);
    tablaclientes.getColumnModel().getColumn(9).setMinWidth(0);
    tablaclientes.getColumnModel().getColumn(9).setPreferredWidth(0);
    
      //Col 10
    tablaclientes.getColumnModel().getColumn(10).setMaxWidth(0);
    tablaclientes.getColumnModel().getColumn(10).setMinWidth(0);
    tablaclientes.getColumnModel().getColumn(10).setPreferredWidth(0);
     //Col 11
    tablaclientes.getColumnModel().getColumn(11).setMaxWidth(0);
    tablaclientes.getColumnModel().getColumn(11).setMinWidth(0);
    tablaclientes.getColumnModel().getColumn(11).setPreferredWidth(0);
     //Col 12
    tablaclientes.getColumnModel().getColumn(12).setMaxWidth(0);
    tablaclientes.getColumnModel().getColumn(12).setMinWidth(0);
    tablaclientes.getColumnModel().getColumn(12).setPreferredWidth(0);
     //Col 13
    tablaclientes.getColumnModel().getColumn(13).setMaxWidth(0);
    tablaclientes.getColumnModel().getColumn(13).setMinWidth(0);
    tablaclientes.getColumnModel().getColumn(13).setPreferredWidth(0);
     //Col 14
    tablaclientes.getColumnModel().getColumn(14).setPreferredWidth(100);
  
    }
    logcliente func = new logcliente();
     void mostrar(String buscar){
        try {
            DefaultTableModel modelo;
            
            modelo=func.mostrar(buscar);
            tablaclientes.setModel(modelo);
            ocultar_columnas();
           lbltotal.setText("Total de clientes: "+ Integer.toString(func.totalregistros));
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaclientes = new javax.swing.JTable();
        lbltotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar1 = new javax.swing.JButton();
        btnnuevo1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanelencabezado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(218, 111, 11), null));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listado de clientes");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        tablaclientes.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaclientes.setToolTipText("Doble clic para editar");
        tablaclientes.setOpaque(false);
        tablaclientes.setSelectionBackground(new java.awt.Color(74, 189, 172));
        tablaclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaclientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaclientes);

        lbltotal.setText("Total");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        btnbuscar1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnbuscar1.setText("Buscar");
        btnbuscar1.setToolTipText("Buscar cliente ");
        btnbuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar1ActionPerformed(evt);
            }
        });

        btnnuevo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/user.png"))); // NOI18N
        btnnuevo1.setToolTipText("Agregar trabajador");
        btnnuevo1.setBorderPainted(false);
        btnnuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevo1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/64x64/user.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Nombre");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnnuevo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(980, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnuevo1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(1, 1, 1)))
        );

        jPanelencabezado.setBackground(new java.awt.Color(3, 79, 132));

        jLabel1.setBackground(new java.awt.Color(3, 79, 132));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listado de clientes");
        jLabel1.setOpaque(true);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/icons8_Close_Window_32px_1_blanco.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelencabezadoLayout = new javax.swing.GroupLayout(jPanelencabezado);
        jPanelencabezado.setLayout(jPanelencabezadoLayout);
        jPanelencabezadoLayout.setHorizontalGroup(
            jPanelencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelencabezadoLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(jLabel5))
        );
        jPanelencabezadoLayout.setVerticalGroup(
            jPanelencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelencabezadoLayout.createSequentialGroup()
                .addGroup(jPanelencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanelencabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelencabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnbuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar1ActionPerformed
        // TODO add your handling code here:
        mostrar(txtbuscar.getText());
    }//GEN-LAST:event_btnbuscar1ActionPerformed

    private void btnnuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevo1ActionPerformed
        try {
            //Abriendo ventana trabajador
            frmcliente cliente = new frmcliente();
            frminicio.escritorio.add(cliente);
            cliente.toFront();
            Dimension desktopSize = frminicio.escritorio.getSize();
            Dimension FrameSize = cliente.getSize();
            cliente.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            cliente.toFront();
            cliente.setVisible(true);
            //Enviando la accion que se requerira segun la funcion
            frmcliente.lblaccion.setText("guardar");
            frmcliente.btnaccion.setText("Guardar");
            frmcliente.txtid.setVisible(false);
            frmcliente.lblidcliente.setVisible(false);
            frmcliente.btneliminar.setVisible(false);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error: " + e.toString());
        }
    }//GEN-LAST:event_btnnuevo1ActionPerformed

    private void tablaclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaclientesMouseClicked
        if (evt.getClickCount()==1 ) {
            try {
                 mostrar(txtbuscar.getText());
            } catch (Exception e) {
            }
        }
        if (evt.getClickCount()==2 ) {
            try {
         //  this.dispose();
        //Abriendo ventana trabajador
        int fila= tablaclientes.rowAtPoint(evt.getPoint());
        frmcliente ventana = new frmcliente();
        frminicio.escritorio.add(ventana);
        ventana.toFront();
        Dimension desktopSize = frminicio.escritorio.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        ventana.toFront();
      
        ventana.setVisible(true);  
       
       //Enviando la accion que se requerira segun la funcion
       frmcliente.lblaccion.setText("editar");
       frmcliente.btnaccion.setText("Editar");
       frmcliente.txtid.setEnabled(false);
       frmcliente.lblidcliente.setEnabled(false);
       
       //Asignando datos a elementos ventana trabajador
       frmcliente.txtid.setText(tablaclientes.getValueAt(fila, 0).toString());
       frmcliente.txtnombre.setText(tablaclientes.getValueAt(fila, 1).toString());
       frmcliente.txtapellidos.setText(tablaclientes.getValueAt(fila, 2).toString());
       frmcliente.txttelefono.setText(tablaclientes.getValueAt(fila, 3).toString());
       frmcliente.txttelefono2.setText(tablaclientes.getValueAt(fila, 4).toString());
       frmcliente.txtrfc.setText(tablaclientes.getValueAt(fila, 5).toString());
       frmcliente.txtcorreo.setText(tablaclientes.getValueAt(fila, 6).toString());
       frmcliente.txtnegocio.setText(tablaclientes.getValueAt(fila, 7).toString());
       frmcliente.txtcalle.setText(tablaclientes.getValueAt(fila, 8).toString());
       frmcliente.txtpoblacion.setText(tablaclientes.getValueAt(fila, 9).toString());
       frmcliente.txtCP.setText(tablaclientes.getValueAt(fila, 10).toString());
       frmcliente.txtmunicipio.setText(tablaclientes.getValueAt(fila, 11).toString());
       frmcliente.txtestado.setText(tablaclientes.getValueAt(fila, 12).toString());
       frmcliente.cbotipo.setSelectedItem(tablaclientes.getValueAt(fila, 13).toString());
       frmcliente.cboprecio.setSelectedItem(tablaclientes.getValueAt(fila, 14).toString());
       frmcliente.txttarjeta.setText(tablaclientes.getValueAt(fila, 15).toString());
       //Cerrando la ventana      
     
       
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: " + e.toString());
        }
      }//Fin if
    }//GEN-LAST:event_tablaclientesMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        dispose();

    }//GEN-LAST:event_jLabel5MouseClicked

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        mostrar("");
    }//GEN-LAST:event_formFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmclientelistado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmclientelistado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmclientelistado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmclientelistado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmclientelistado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar1;
    private javax.swing.JButton btnnuevo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelencabezado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JTable tablaclientes;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
}
