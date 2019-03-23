/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.conexion;
import Logica.logcommon;
import Logica.logsplash;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ZAIR
 */
public class login_sin_uso extends javax.swing.JFrame {

    
     
    public login_sin_uso() {
        initComponents();
        //Dar posicion pantalla
        this.setLocationRelativeTo(null);
        txtusuario.requestFocus();
        
    }
  
         //-------------------------Metodos------------------------------------------------
    
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSql="";
    
   
    public void acceder(){
    try {
         String usuario = txtusuario.getText();
         String clave = String.valueOf(txtcontraseña.getPassword());
        String SSQL="SELECT * FROM trabajador WHERE usuario='"+usuario+"' AND contrasena='"+clave+"'";
        //Connection conect = null;
         String [] registro = new String [9];
        //conect = metodospool.dataSource.getConnection();
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SSQL);
        if(rs.next()){
            registro [0]=rs.getString("idtrab");
            registro [1]=rs.getString("nombre");
            registro [2]=rs.getString("apellidos");
            registro [3]=rs.getString("telefono");
            registro [4]=rs.getString("domicilio");
            registro [5]=rs.getString("usuario");
            registro [6]=rs.getString("contrasena");
            registro [7]=rs.getString("rol");
            registro [8]=rs.getString("estado");
            frminicio ventana = new frminicio();
            ventana.lblidTrab.setText(registro[0]);
            ventana.lblnombretrabajador.setText(registro[1]+" "+registro[2]);
            ventana.lblidcaja.setText(combocaja.getSelectedItem().toString());
            if (registro [7].equals("Administrador")) {             
            }//Fin if evaluando si es administrador
            if (registro [7].equals("Vendedor")) {
               // ventana.menuutilerias.setVisible(false);
               ventana.menureportesdeutilidad.setVisible(false);
               ventana.menuutilidadxrangoxarticulo.setVisible(false);
               ventana.menuventasxrango.setVisible(false);
                ventana.menusugeridocompras.setVisible(false);
                ventana.menuexistencias.setVisible(false);
                ventana.menuprecios.setVisible(false);
                ventana.menuvalorinventario.setVisible(false);
                ventana.menucortecaja.setVisible(true);
                ventana.menuinventario.setVisible(false);
                ventana.menureportesdeutilidad.setVisible(false);
                
                
            }
            ventana.setVisible(true);
            cn.close();
            this.dispose();
        }
        else{
        JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
        + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
        JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);

    
    }} 
    //-------------------------FIN METODOS---------------------------------------------
    @SuppressWarnings("unchecked")
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jpsuperior = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtusuario = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        combocaja = new javax.swing.JComboBox<>();
        lblacceder = new javax.swing.JLabel();
        lblcancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(0, 255, 255));
        setIconImages(null);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/fm-iloveimg-resized.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 166, -1, 236));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 166, 12, 284));

        jpsuperior.setBackground(new java.awt.Color(242, 124, 13));
        jpsuperior.setMinimumSize(new java.awt.Dimension(20, 20));
        jpsuperior.setName(""); // NOI18N
        jpsuperior.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SISTEMA DE VENTAS");
        jpsuperior.add(jLabel2);
        jLabel2.setBounds(10, 70, 830, 56);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FARMA-MEDIC");
        jpsuperior.add(jLabel1);
        jLabel1.setBounds(0, 20, 830, 56);

        getContentPane().add(jpsuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 150));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(242, 124, 13));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CONTROL");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 124, 13));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DE ACCESO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 550, -1));

        jPanel4.add(jPanel1);
        jPanel1.setBounds(280, 20, 550, 58);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        txtusuario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(242, 124, 13));
        txtusuario.setPreferredSize(new java.awt.Dimension(7, 23));
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtusuario);
        txtusuario.setBounds(157, 22, 200, 30);

        txtcontraseña.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtcontraseña.setForeground(new java.awt.Color(242, 124, 13));
        txtcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseñaActionPerformed(evt);
            }
        });
        jPanel2.add(txtcontraseña);
        txtcontraseña.setBounds(157, 72, 200, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 124, 13));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/icons8_User_32px.png"))); // NOI18N
        jLabel5.setText("USUARIO");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(3, 24, 150, 32);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(242, 124, 13));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/icons8_Password_32px.png"))); // NOI18N
        jLabel7.setText("CONTRASEÑA");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(24, 74, 129, 32);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(242, 124, 13));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("CAJA");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(88, 120, 60, 30);

        combocaja.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        combocaja.setForeground(new java.awt.Color(242, 124, 13));
        combocaja.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
        combocaja.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(combocaja);
        combocaja.setBounds(160, 120, 201, 25);

        jPanel4.add(jPanel2);
        jPanel2.setBounds(370, 90, 400, 160);

        lblacceder.setBackground(new java.awt.Color(255, 255, 255));
        lblacceder.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblacceder.setForeground(new java.awt.Color(242, 124, 13));
        lblacceder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblacceder.setText("ACCEDER");
        lblacceder.setToolTipText("CLIC ACCEDER");
        lblacceder.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblacceder.setOpaque(true);
        lblacceder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblaccederMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblaccederMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblaccederMouseExited(evt);
            }
        });
        jPanel4.add(lblacceder);
        lblacceder.setBounds(630, 270, 150, 32);

        lblcancelar.setBackground(new java.awt.Color(255, 255, 255));
        lblcancelar.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblcancelar.setForeground(new java.awt.Color(242, 124, 13));
        lblcancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcancelar.setText("CANCELAR");
        lblcancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblcancelar.setOpaque(true);
        lblcancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblcancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblcancelarMouseExited(evt);
            }
        });
        jPanel4.add(lblcancelar);
        lblcancelar.setBounds(380, 270, 150, 28);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 830, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseñaActionPerformed
      acceder();
              
    }//GEN-LAST:event_txtcontraseñaActionPerformed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        txtusuario.transferFocus();
    }//GEN-LAST:event_txtusuarioActionPerformed

    private void lblcancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblcancelarMouseClicked

    private void lblaccederMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccederMouseClicked
        acceder();
    }//GEN-LAST:event_lblaccederMouseClicked

    private void lblcancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcancelarMouseEntered
       lblcancelar.setBackground(new java.awt.Color(242,124,13));
       lblcancelar.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_lblcancelarMouseEntered

    private void lblcancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcancelarMouseExited
       lblcancelar.setForeground(new java.awt.Color(242,124,13));
       lblcancelar.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_lblcancelarMouseExited

    private void lblaccederMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccederMouseEntered
       lblacceder.setBackground(new java.awt.Color(242,124,13));
       lblacceder.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_lblaccederMouseEntered

    private void lblaccederMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblaccederMouseExited
       lblacceder.setForeground(new java.awt.Color(242,124,13));
       lblacceder.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_lblaccederMouseExited

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
            java.util.logging.Logger.getLogger(login_sin_uso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_sin_uso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_sin_uso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_sin_uso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new logsplash().animar();                 
         //new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> combocaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpsuperior;
    private javax.swing.JLabel lblacceder;
    private javax.swing.JLabel lblcancelar;
    public static javax.swing.JPasswordField txtcontraseña;
    public static javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
