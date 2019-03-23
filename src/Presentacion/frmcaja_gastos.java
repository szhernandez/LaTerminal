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
public class frmcaja_gastos extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmcortecaja
     */
    public frmcaja_gastos() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);//Con esto quito el title  
    }

    //
    logcaja funccaja = new logcaja();
    datoscaja dtscaja = new datoscaja();
    logmovimientos_caja funmovimientos = new logmovimientos_caja();
    datosmovimientos_caja dtsmovimientos =  new datosmovimientos_caja();
    servicio_impresion imprimir = new servicio_impresion();
    public Double dineroactual,retiro;
    public  static ImageIcon logo,imagenagua;
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelencabezado = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtconcepto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtretiro = new javax.swing.JTextField();
        btncorte = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanelencabezado.setBackground(new java.awt.Color(3, 79, 132));

        jLabel3.setBackground(new java.awt.Color(3, 79, 132));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Gastos");
        jLabel3.setOpaque(true);

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
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
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
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("RETIRO"));

        txtconcepto.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtconcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtconceptoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Concepto");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Monto");

        txtretiro.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtretiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtretiroKeyTyped(evt);
            }
        });

        btncorte.setText("Aceptar");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtretiro)
                    .addComponent(txtconcepto))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 144, Short.MAX_VALUE)
                .addComponent(btncorte, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtretiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
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
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncorteActionPerformed
       if(txtconcepto.getText().length()==0){
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar un concepto");
            txtconcepto.requestFocus();
            return;
         }
      
      dineroactual= Double.parseDouble(funccaja.consultadinero(""+frminicio.lblidcaja.getText()));
      retiro= Double.parseDouble(txtretiro.getText());
      Double update = dineroactual-retiro;
       if (dineroactual<retiro) {
            JOptionPane.showMessageDialog(null,"Actualmente solo hay $"+dineroactual+
                    " en caja. \n Seleccione un monto menor a retirar");
            return;
              }
      //Actualizando  efectivo en caja
      dtscaja.setDinero(update);
      dtscaja.setIdcaja(""+frminicio.lblidcaja.getText());
      funccaja.updatedinero(dtscaja);
      
      //Insertando el movimiento en caja
      dtsmovimientos.setMonto(retiro);
      dtsmovimientos.setConcepto(txtconcepto.getText());
      dtsmovimientos.setFecha(logcommon.fechayhora());
      dtsmovimientos.setIdTrab(Integer.parseInt(frminicio.lblidTrab.getText()));
      dtsmovimientos.setIdcaja(frminicio.lblidcaja.getText());
        if (funmovimientos.insertar(dtsmovimientos)) {
            imprimir.imprimiendo_ultimo_movimiento_caja();
        }

     
      //Limpiando textbox
      txtconcepto.setText("");
      txtretiro.setText("");
    }//GEN-LAST:event_btncorteActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
      dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void txtretiroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtretiroKeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '.' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
    }//GEN-LAST:event_txtretiroKeyTyped

    private void txtconceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtconceptoActionPerformed
       txtretiro.requestFocus();
    }//GEN-LAST:event_txtconceptoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncorte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelencabezado;
    private javax.swing.JTextField txtconcepto;
    private javax.swing.JTextField txtretiro;
    // End of variables declaration//GEN-END:variables
}
