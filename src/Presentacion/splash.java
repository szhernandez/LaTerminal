/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.conexiontestsplas;
import Logica.logcommon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ZAIR
 */
public class splash extends javax.swing.JFrame{

    public splash() {
        initComponents();
        //Dar posicion pantalla
        this.setLocationRelativeTo(null);
        iniciarhilo();
    }
       conexiontestsplas c=new conexiontestsplas();
     private void iniciarhilo(){
      Thread hilo = new Thread(new Runnable() {
          int x=0;
          String cad=".";
          @Override
          public void run() {
              try {
               
                  Process p = Runtime.getRuntime().exec ("C:/xampp/mysql_start.bat");
                  Thread.sleep(100);
                  while(x<=100){
                     if (c.conectar()!=null) {
                      mensajes.setText("Conectado");
                      
                      try {
                  c.cerrar();
                  } catch (Exception e) {
                       System.out.println("error: "+e);
                  }
                   
                  }else{
                      
                      mensajes.setText("Conectando...Intento "+x);
                      Thread.sleep(5);
                     }
                  barraprogreso.setValue(x);
                  porcentaje.setText(x+"%");
                  x++;
                  Thread.sleep(5);
                  cad+=".";
                     
                  }
                  
                  dispose();
                  login_pool milogin = new login_pool();
                  milogin.setVisible(true);
                  
              } catch (Exception e) {
                  System.out.println("error: "+e.getMessage());
              }
          }
      });
      hilo.start();
     }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpsuperior = new javax.swing.JPanel();
        barraprogreso = new javax.swing.JProgressBar();
        mensajes = new javax.swing.JLabel();
        porcentaje = new javax.swing.JLabel();
        logosmart = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jpsuperior1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(0, 255, 255));
        setIconImages(null);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpsuperior.setBackground(new java.awt.Color(3, 79, 132));
        jpsuperior.setMinimumSize(new java.awt.Dimension(20, 20));
        jpsuperior.setName(""); // NOI18N
        jpsuperior.setLayout(null);

        barraprogreso.setBackground(new java.awt.Color(255, 255, 255));
        barraprogreso.setForeground(new java.awt.Color(146, 168, 209));
        barraprogreso.setBorderPainted(false);
        jpsuperior.add(barraprogreso);
        barraprogreso.setBounds(180, 10, 310, 14);

        mensajes.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        mensajes.setForeground(new java.awt.Color(255, 255, 255));
        mensajes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mensajes.setText("SmartTech");
        jpsuperior.add(mensajes);
        mensajes.setBounds(10, 10, 170, 10);

        porcentaje.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        porcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        porcentaje.setText("%");
        jpsuperior.add(porcentaje);
        porcentaje.setBounds(490, 10, 50, 10);

        logosmart.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        logosmart.setForeground(new java.awt.Color(255, 255, 255));
        logosmart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logosmart.setText("SmartTech");
        jpsuperior.add(logosmart);
        logosmart.setBounds(380, 40, 170, 20);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DEVELOPED BY");
        jpsuperior.add(jLabel4);
        jLabel4.setBounds(0, 20, 650, 56);

        getContentPane().add(jpsuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 650, 80));

        jpsuperior1.setBackground(new java.awt.Color(3, 79, 132));
        jpsuperior1.setMinimumSize(new java.awt.Dimension(20, 20));
        jpsuperior1.setName(""); // NOI18N
        jpsuperior1.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/icons8_Receive_Cash_32px.png"))); // NOI18N
        jpsuperior1.add(jLabel5);
        jLabel5.setBounds(530, 20, 50, 32);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/icons8_Cursor_32px_1.png"))); // NOI18N
        jpsuperior1.add(jLabel6);
        jLabel6.setBounds(560, 40, 50, 32);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jpsuperior1.add(jLabel1);
        jLabel1.setBounds(0, 20, 650, 0);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADMINISTRACIÓN A UN CLIC");
        jpsuperior1.add(jLabel2);
        jLabel2.setBounds(0, 0, 650, 80);

        getContentPane().add(jpsuperior1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 80));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/splash.png"))); // NOI18N
        jPanel4.add(jLabel3);
        jLabel3.setBounds(-10, -10, 650, 240);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 650, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new splash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraprogreso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jpsuperior;
    private javax.swing.JPanel jpsuperior1;
    private javax.swing.JLabel logosmart;
    private javax.swing.JLabel mensajes;
    private javax.swing.JLabel porcentaje;
    // End of variables declaration//GEN-END:variables
}
