/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.datoscaja;
import Datos.datoscredito;
import Datos.datosimpresoras;
import Logica.logcaja;
import Logica.logcommon;
import Logica.logcredito;
import Logica.logimpresoras;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;

/**
 *
 * @author ZAIR
 */
public class frmimpresoras extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmcortecaja
     */
    public frmimpresoras() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);//Con esto quito el title
        comprobandoimpresoras();
    }

    //
    logimpresoras func = new logimpresoras();
    datosimpresoras dts = new datosimpresoras();
    public void comprobandoimpresoras(){
    String [] registro = new String [19];
    registro=func.mostrar(frminicio.lblidcaja.getText());
    String idcaja = registro[0];
    if (idcaja == null) {
                   dts.setIdcaja(frminicio.lblidcaja.getText());
                   dts.setImpresora_tickets("");
                    dts.setImpresora_notas("");
                    dts.setImpresora_etiquetas("");
                   
                   if (func.insertar(dts)) {
                   JOptionPane.showMessageDialog(rootPane, "Seleccione la(s) impresora(s) a utilizar");
                   
                   }else{
                       JOptionPane.showConfirmDialog(rootPane, "ERROR: No se agrego el el registro de impresoras");
                       return;
                   }
                   cargadatos();
                   obteniendo_impresoras_seleccionadas();
               }else{
                   cargadatos();
                   obteniendo_impresoras_seleccionadas();
            }
    }
    
    public void obteniendo_impresoras_seleccionadas(){
    String [] registro = new String [19];
    registro=func.mostrar(frminicio.lblidcaja.getText());
    combo_tickets.setSelectedItem(registro[1]);
    combo_notas.setSelectedItem(registro[2]);
    combo_etiquetas.setSelectedItem(registro[3]);
    }
    //Este metodo sirve para buscar todas las impresoras en el sistema y ponerlas en el comboBox
    public void cargadatos(){
      PrintService[] ps = PrintServiceLookup.lookupPrintServices( null , null);
        for( int i=0 ; i< ps.length; i++)
        {
           combo_tickets.addItem(ps[i].getName());
           combo_notas.addItem(ps[i].getName());
           combo_etiquetas.addItem(ps[i].getName());
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelencabezado = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnimp_tickets = new javax.swing.JButton();
        combo_tickets = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnimp_notas = new javax.swing.JButton();
        combo_notas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnimp_etiquetas = new javax.swing.JButton();
        combo_etiquetas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);

        jPanelencabezado.setBackground(new java.awt.Color(3, 79, 132));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/icons8_Close_Window_32px_1_blanco.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(74, 189, 172));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("IMPRESORAS");

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("TICKETS"));

        btnimp_tickets.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnimp_tickets.setText("Asignar impresora");
        btnimp_tickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimp_ticketsActionPerformed(evt);
            }
        });

        combo_tickets.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Impresora de Tickets");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnimp_tickets, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_tickets, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_tickets))
                .addGap(18, 18, 18)
                .addComponent(btnimp_tickets, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("NOTAS"));

        btnimp_notas.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnimp_notas.setText("Asignar impresora");
        btnimp_notas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimp_notasActionPerformed(evt);
            }
        });

        combo_notas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Impresora de Notas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnimp_notas, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_notas, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_notas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnimp_notas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnsalir.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("ETIQUETAS"));

        btnimp_etiquetas.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnimp_etiquetas.setText("Asignar impresora");
        btnimp_etiquetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimp_etiquetasActionPerformed(evt);
            }
        });

        combo_etiquetas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Impresora de etiquetas");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnimp_etiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_etiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_etiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnimp_etiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelencabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelencabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnimp_ticketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimp_ticketsActionPerformed
        dts.setIdcaja(frminicio.lblidcaja.getText());
        dts.setImpresora_tickets((String)combo_tickets.getSelectedItem());
     
        if (func.updatetickets(dts)) {
            JOptionPane.showMessageDialog(rootPane, "Se ha cambiado la impresora definida para Tickets");
        }else{
        JOptionPane.showMessageDialog(rootPane, "Hubo un problema al cambiar la impresora definida para Tickets");
        }

    }//GEN-LAST:event_btnimp_ticketsActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
      dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btnimp_notasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimp_notasActionPerformed
dts.setIdcaja(frminicio.lblidcaja.getText());
                  
                    dts.setImpresora_notas((String)combo_notas.getSelectedItem());
        if (func.updatenotas(dts)) {
            JOptionPane.showMessageDialog(rootPane, "Se ha cambiado la impresora definida para Notas");
        }else{
        JOptionPane.showMessageDialog(rootPane, "Hubo un problema al cambiar la impresora definida para Notas");
        }       
    }//GEN-LAST:event_btnimp_notasActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnimp_etiquetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimp_etiquetasActionPerformed
dts.setIdcaja(frminicio.lblidcaja.getText());
        dts.setImpresora_etiquetas((String)combo_etiquetas.getSelectedItem());
     
        if (func.updateetiquetas(dts)) {
            JOptionPane.showMessageDialog(rootPane, "Se ha cambiado la impresora definida para etiquetas");
        }else{
        JOptionPane.showMessageDialog(rootPane, "Hubo un problema al cambiar la impresora definida para etiquetas");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnimp_etiquetasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnimp_etiquetas;
    private javax.swing.JButton btnimp_notas;
    private javax.swing.JButton btnimp_tickets;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> combo_etiquetas;
    private javax.swing.JComboBox<String> combo_notas;
    private javax.swing.JComboBox<String> combo_tickets;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelencabezado;
    // End of variables declaration//GEN-END:variables
}
