/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.logarticulo;
import Logica.logcliente;
import Logica.logmovimientos_caja;
import Logica.logproveedor;
import Logica.logtrabajador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Presentacion.frmpuntoventa;

/**
 *
 * @author ZAIR
 */
public class dialogproducto extends java.awt.Dialog {

    /**
     * Creates new form frmpvcliente
     */
    public dialogproducto(java.awt.Frame parent, boolean modal, String producto) {
        super(parent, modal);
        initComponents();
        mostrar(producto);
    }
    public static String padre="";
    
    void ocultar_columnas(){
    tablamovimientos.getColumnModel().getColumn(0).setMaxWidth(0);
    tablamovimientos.getColumnModel().getColumn(0).setMinWidth(0);
    tablamovimientos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    
     void mostrar(String buscar){
        try {
            JOptionPane.showMessageDialog(jScrollPane1, buscar);
            
            DefaultTableModel modelo;
            logarticulo func = new logarticulo();
            modelo=func.mostrar(buscar);
            tablamovimientos.setModel(modelo);
            ocultar_columnas();
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablamovimientos = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        tablamovimientos.setModel(new javax.swing.table.DefaultTableModel(
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
        tablamovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablamovimientosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablamovimientos);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void tablamovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablamovimientosMouseClicked
              if (evt.getClickCount()==2 ) {
                  try {
                      int fila= tablamovimientos.rowAtPoint(evt.getPoint());
                      if (padre=="puntoventa") {
                      frmpuntoventa.Agentenombre=(tablamovimientos.getValueAt(fila, 1).toString());
                      frmpuntoventa.agenteapellidos=(tablamovimientos.getValueAt(fila, 2).toString());
                      frmpuntoventa.agentetelefono=(tablamovimientos.getValueAt(fila, 3).toString());
                      }
                      if (padre=="puntoventa2") {
                      frmpuntopreventa.Agentenombre=(tablamovimientos.getValueAt(fila, 1).toString());
                      frmpuntopreventa.agenteapellidos=(tablamovimientos.getValueAt(fila, 2).toString());
                      frmpuntopreventa.agentetelefono=(tablamovimientos.getValueAt(fila, 3).toString());
                      }
                      if (padre=="consultaventa") {
                      frmpuntoconsultaventa.Agentenombre=(tablamovimientos.getValueAt(fila, 1).toString());
                      frmpuntoconsultaventa.agenteapellidos=(tablamovimientos.getValueAt(fila, 2).toString());
                      frmpuntoconsultaventa.agentetelefono=(tablamovimientos.getValueAt(fila, 3).toString());
                      }
                       if (padre=="PuntoCompra") {
                      frmpuntocompra.Agentenombre=(tablamovimientos.getValueAt(fila, 1).toString());
                      frmpuntocompra.agenteapellidos=(tablamovimientos.getValueAt(fila, 2).toString());
                      frmpuntocompra.agentetelefono=(tablamovimientos.getValueAt(fila, 3).toString());
                      }
                        if (padre=="reporteguardaequipajexrangoxtrabajador") {
                      frmreporteequipajexrangoxtrabajador.idtrabajador=(tablamovimientos.getValueAt(fila, 0).toString());
                      frmreporteequipajexrangoxtrabajador.txttrabajador.setText(tablamovimientos.getValueAt(fila, 2).toString()+" "+tablamovimientos.getValueAt(fila, 3).toString());
                      }
                        
                        if (padre=="reporteventasxrangoxtrabajador") {
                      frmreporteventasxrangoxtrab.idtrabajador=(tablamovimientos.getValueAt(fila, 0).toString());
                      frmreporteventasxrangoxtrab.txttrabajador.setText(tablamovimientos.getValueAt(fila, 2).toString()+" "+tablamovimientos.getValueAt(fila, 3).toString());
                      }
                      
                      this.dispose();
                  } catch (Exception e) {
                  }
              }
    }//GEN-LAST:event_tablamovimientosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dialogproducto dialog = new dialogproducto(new java.awt.Frame(), true,String.valueOf(0));
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablamovimientos;
    // End of variables declaration//GEN-END:variables
}
