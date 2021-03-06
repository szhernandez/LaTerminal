/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.CellRenderer;
import Logica.logcliente;
import Logica.logmovimientos_caja;
import Logica.logproveedor;
import Logica.logtrabajador;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Presentacion.frmpuntoventa;
import java.util.Enumeration;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author ZAIR
 */
public class dialogmovimientoscaja extends java.awt.Dialog {

    /**
     * Creates new form frmpvcliente
     */
    public dialogmovimientoscaja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        mostrar(frminicio.lblidcaja.getText(),finicial,ffinal);
         setCellRender(tablamovimientos);
    }
    public static String funcion="",finicial,ffinal;
    
    void ocultar_columnas(){
    tablamovimientos.getColumnModel().getColumn(0).setMaxWidth(0);
    tablamovimientos.getColumnModel().getColumn(0).setMinWidth(0);
    tablamovimientos.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
    }
     void mostrar(String caja, String finicial, String ffinal){
        try {
            DefaultTableModel modelo;
            logmovimientos_caja func = new logmovimientos_caja();
            modelo=func.mostrarmovimientosxfecha(caja,finicial,ffinal);
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
                      if (funcion=="puntoventa") {
                          frmpuntoventa.Agentenombre=(tablamovimientos.getValueAt(fila, 1).toString());
                      frmpuntoventa.agenteapellidos=(tablamovimientos.getValueAt(fila, 2).toString());
                      frmpuntoventa.agentetelefono=(tablamovimientos.getValueAt(fila, 3).toString());
                      }
                      if (funcion=="consultaventa") {
                      frmpuntoconsultaventa.Agentenombre=(tablamovimientos.getValueAt(fila, 1).toString());
                      frmpuntoconsultaventa.agenteapellidos=(tablamovimientos.getValueAt(fila, 2).toString());
                      frmpuntoconsultaventa.agentetelefono=(tablamovimientos.getValueAt(fila, 3).toString());
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
                dialogmovimientoscaja dialog = new dialogmovimientoscaja(new java.awt.Frame(), true);
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
