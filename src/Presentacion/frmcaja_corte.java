/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.datoscaja;
import Datos.datosmovimientos_caja;
import Logica.logcaja;
import Logica.logcommon;
import Logica.logmovimientos_caja;
import Logica.servicio_impresion;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ZAIR
 */
public class frmcaja_corte extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmcortecaja
     */
    public frmcaja_corte() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);//Con esto quito el title  
    }

    //
    logcaja funccaja = new logcaja();
    datoscaja dtscaja = new datoscaja();
    logmovimientos_caja funmovimientos = new logmovimientos_caja();
    datosmovimientos_caja dtsmovimientos =  new datosmovimientos_caja();
    servicio_impresion impresion = new servicio_impresion();
    public static Double efectivoactual,montoretirado,montoconservado;
    public  static ImageIcon logo,imagenagua;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelencabezado = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_montoconservado = new javax.swing.JTextField();
        btncorte = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelencabezado.setBackground(new java.awt.Color(3, 79, 132));

        jLabel3.setBackground(new java.awt.Color(74, 189, 172));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CORTE DE CAJA");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/icons8_Close_Window_32px_1_blanco.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelencabezadoLayout = new javax.swing.GroupLayout(jPanelencabezado);
        jPanelencabezado.setLayout(jPanelencabezadoLayout);
        jPanelencabezadoLayout.setHorizontalGroup(
            jPanelencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelencabezadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6))
        );
        jPanelencabezadoLayout.setVerticalGroup(
            jPanelencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelencabezadoLayout.createSequentialGroup()
                .addGroup(jPanelencabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("CORTE"));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("¿Desea conservar efectivo en caja? ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Monto");

        txt_montoconservado.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_montoconservado.setText("0");
        txt_montoconservado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_montoconservadoKeyTyped(evt);
            }
        });

        btncorte.setText("REALIZAR CORTE");
        btncorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncorteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btncorte, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(28, 28, 28)
                            .addComponent(txt_montoconservado, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_montoconservado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 19, Short.MAX_VALUE)
                .addComponent(btncorte, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelencabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelencabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncorteActionPerformed
          
        try {
        efectivoactual= Double.parseDouble(funccaja.consultadinero(""+frminicio.lblidcaja.getText()));
        montoconservado= Double.parseDouble(txt_montoconservado.getText());
        montoretirado = efectivoactual-montoconservado;
        if (efectivoactual<=montoconservado) {
            JOptionPane.showMessageDialog(null,"Actualmente solo hay $"+efectivoactual+
                    " en caja. \n Seleccione un monto menor a conservar");
            return;
              }
      
      //Actualizando  efectivo en caja
      dtscaja.setDinero(montoconservado);
      dtscaja.setIdcaja(""+frminicio.lblidcaja.getText());
      funccaja.updatedinero(dtscaja);
      
      //Insertando el movimiento en caja
      dtsmovimientos.setMonto(montoretirado);
      dtsmovimientos.setConcepto("Corte de caja");
      dtsmovimientos.setFecha(logcommon.fechayhora());
      dtsmovimientos.setIdTrab(Integer.parseInt(frminicio.lblidTrab.getText()));
      dtsmovimientos.setIdcaja(frminicio.lblidcaja.getText());
        if (funmovimientos.insertar(dtsmovimientos)) {
            impresion.imprimiendo_corte_caja();
        }

     
      //Limpiando textbox
      
      txt_montoconservado.setText("0");
        } catch (Exception e) {
               JOptionPane.showMessageDialog(rootPane, e);
        }
      
    }//GEN-LAST:event_btncorteActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
      dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void txt_montoconservadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoconservadoKeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if(((caracter < '0') ||
            (caracter > '9')) &&
        (caracter != '.' /*corresponde a BACK_SPACE*/))
        {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txt_montoconservadoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncorte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelencabezado;
    private javax.swing.JTextField txt_montoconservado;
    // End of variables declaration//GEN-END:variables
}
