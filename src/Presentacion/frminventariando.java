/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.datosarticulo;
import Datos.datoscompra;
import Datos.datosdetallecompra;
import Logica.CellRenderer;
import Logica.logarticulo;
import Logica.logcommon;
import Logica.logcompra;
import Logica.logdetallecompra;
import Logica.logticket;
import static Presentacion.frminicio.escritorio;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Frame;
import java.util.Enumeration;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 *
 * @author ZAIR
 */
public class frminventariando extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmpuntocompra
     */
    public frminventariando() {
      
        initComponents();
           txtbuscar.requestFocus();
        setCellRender(tablainventario);
        tablainventario.getModel().addTableModelListener(tablainventario);
        titulostabla();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);//Con esto quito el title
         Color myColor = new Color(255,255,255);
         tablainventario.setBackground(myColor);
         jScrollPane1.getViewport().setBackground(myColor);
        
    }

    //Creando objetos y declarando variables
    logcommon comun = new logcommon();
    logarticulo logart = new logarticulo();
    datosarticulo dtsarticulo = new datosarticulo();
    datoscompra dtscompra = new datoscompra();
    logcompra logcomp = new logcompra();
    datosdetallecompra dtsdetalle = new datosdetallecompra();
    logdetallecompra logdetalle = new logdetallecompra();
    
    DefaultTableModel modelo= new DefaultTableModel(){
     public boolean isCellEditable(int row, int column) {return false;}
    };//CReando el objeto de la tabla
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnuevacantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcantidadactual = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtdiferencia = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtdescripcion = new javax.swing.JTextField();
        btncerrarcompra = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablainventario = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnsalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setTitle("Registro de compras");

        jPanel1.setBackground(new java.awt.Color(3, 79, 132));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtbuscar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad");

        txtnuevacantidad.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtnuevacantidad.setText("0");
        txtnuevacantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnuevacantidadFocusLost(evt);
            }
        });
        txtnuevacantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnuevacantidadActionPerformed(evt);
            }
        });
        txtnuevacantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnuevacantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnuevacantidadKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("C. Actual");

        txtcantidadactual.setEditable(false);
        txtcantidadactual.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtcantidadactual.setText("0.00");
        txtcantidadactual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadactualActionPerformed(evt);
            }
        });
        txtcantidadactual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadactualKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadactualKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Diferencia");

        txtdiferencia.setEditable(false);
        txtdiferencia.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtdiferencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdiferenciaFocusGained(evt);
            }
        });
        txtdiferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiferenciaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/bag delete.png"))); // NOI18N
        jButton1.setToolTipText("Eliminar seleccionado");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/bag add.png"))); // NOI18N
        jButton2.setToolTipText("Agregar producto a compra");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtdescripcion.setEditable(false);
        txtdescripcion.setBackground(new java.awt.Color(255, 255, 255));
        txtdescripcion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtdescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdescripcionFocusGained(evt);
            }
        });
        txtdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescripcionActionPerformed(evt);
            }
        });

        btncerrarcompra.setBackground(new java.awt.Color(255, 255, 255));
        btncerrarcompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/like (1).png"))); // NOI18N
        btncerrarcompra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btncerrarcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarcompraActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/64x64/buscarproducto.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnuevacantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtcantidadactual, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtdiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncerrarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnuevacantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtdiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcantidadactual, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5))
                    .addComponent(jButton1)
                    .addComponent(btncerrarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tablainventario.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tablainventario.setModel(new javax.swing.table.DefaultTableModel(
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
        tablainventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablainventarioMouseClicked(evt);
            }
        });
        tablainventario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablainventarioPropertyChange(evt);
            }
        });
        tablainventario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablainventarioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablainventario);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnsalir.setBackground(new java.awt.Color(255, 255, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/icons8_Close_Window_32px.png"))); // NOI18N
        btnsalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnsalir))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnsalir))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void titulostabla(){
         
          modelo.addColumn("Codigo");
          modelo.addColumn("Descripcion");
          modelo.addColumn("Unidades");
          modelo.addColumn("Nueva Existencia");
          modelo.addColumn("Diferencia");
          tablainventario.setModel(modelo);
          formatodetabla();
          }
    //Metodo para dar formato a la tabla
    void formatodetabla(){
    //Columna Codigo
    tablainventario.getColumnModel().getColumn(0).setPreferredWidth(100);
    //Columna Descripcion
    tablainventario.getColumnModel().getColumn(1).setPreferredWidth(200);
    //colunma Unidades
    tablainventario.getColumnModel().getColumn(2).setPreferredWidth(200);
    //Columna nueva existencia
    tablainventario.getColumnModel().getColumn(3).setPreferredWidth(200);
  //Columna diferencia
    tablainventario.getColumnModel().getColumn(4).setPreferredWidth(200);
    }
   
    
    private void tablainventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablainventarioMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) tablainventario.getModel(); //TableProducto es el nombre de mi tabla ;)
        int fila= tablainventario.getSelectedRow();
        int columna = tablainventario.getSelectedColumn();
        
        //En caso de presionar ssobre la el precio unitario
        if (columna==3) {
            
            Double nuevaexistencia= Double.parseDouble(JOptionPane.showInputDialog("UNIDADES"));
             Double existenciactual=Double.parseDouble(String.valueOf(dtm.getValueAt(fila, 2)));
                //Indicando el nuevo valor de la cantidad
                tablainventario.setValueAt(nuevaexistencia, fila, 3);
                //Indicando el nuevo valor del importe
                double diferencia = nuevaexistencia-existenciactual;
                tablainventario.setValueAt(diferencia, fila, 4);
                txtbuscar.requestFocus(true);//Le regreso el foco a la caja de busqueda
        }
    }//GEN-LAST:event_tablainventarioMouseClicked

     //DAr colores a tabla
    public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
    }
    void llenandotabla(){
        try {
        String []datos = new String[19];
        String []datosseleccionados = new String[19];
        datos =logart.mostrarselectivo(txtbuscar.getText());

       
        datosseleccionados[0]= datos[0];//codigo
        datosseleccionados[1]= datos[1];//descripcion
        datosseleccionados[2]= datos[12];//existencia
        datosseleccionados[3]= txtnuevacantidad.getText();
        datosseleccionados[4]= txtdiferencia.getText();
        String validacion = datos[1];
        if (validacion.isEmpty()) {
        JOptionPane.showConfirmDialog(null,"No encontramos el producto solicitado con la clave: " + txtbuscar.getText());
        }else{
            modelo.addRow(datosseleccionados);
        }
        
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al agregar a tabla compra " +e);
        }
    }
    
    void calculototal(){
    
        double sumatoria1=0.0;
        int totalRow= tablainventario.getRowCount();
        totalRow-=1;
        for(int i=0;i<=(totalRow);i++)
        {
        double sumatoria= Double.parseDouble(String.valueOf(tablainventario.getValueAt(i,4)));
        //en la parte de arriba indica el primer parametro la fila y el segundo la columna la cual estaras //manejando
             sumatoria1+=sumatoria;
        }
       
    }
    public boolean existendatosentabla(){
    int total= tablainventario.getRowCount();
    if(total>0){
    return true;
    }else{
    return false;
    }
    }
     
  
    
     void actualizarexistencia(){
         
         TableModel mitabla = tablainventario.getModel();
         
        try {
             int cols = mitabla.getColumnCount();
            int fils = mitabla.getRowCount();
            for(int i=0; i<fils; i++) {
            Double existencia=Double.parseDouble(mitabla.getValueAt(i,3).toString());
            String idarticulos=mitabla.getValueAt(i,0).toString();
            logart.existenciasupdate(existencia, idarticulos);
        }//Fin for
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo guardar detalle de compra :"+e);
        }
   
    }
     
     void limpiando(){
         try {
          //Limpiando tabla
            DefaultTableModel modelo2=(DefaultTableModel) tablainventario.getModel();
            int filas = tablainventario.getRowCount();
            try {
                  for (int i = 0;i<=filas; i++) {
           modelo2.removeRow(0);
         }
        //Fin de limpiar las filas
        
            } catch (Exception e) {
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Esta tabla me da problemas (btncerrarventa) "+e);
            }
            txtbuscar.setText("");
            txtcantidadactual.setText("");
            txtdescripcion.setText("");
            txtnuevacantidad.setText("");
            txtdiferencia.setText("");
         
     }
       void dialogcambioprecios(){
    try {
        /*Esta ventana se habre de manera especial
        se creo un dialog, el contenido del dialogo sera el que se encuentra dentro del frame
        frmcobro, estos elementos se pasan con la propiedad .getContenPane
        Dentro del frmcobro se creo un nuevo contructor con un elemento dialog
        esto sirve para poder manupular el dialog desde el frame
        ademas se agrego una cadena que se desea pasar
        */
        dialogvacio dialogo = new dialogvacio(null, true);
        frmaarticulo_actualizaprecios ventana = new frmaarticulo_actualizaprecios(dialogo,txtbuscar.getText(),txtdescripcion.getText(),txtcantidadactual.getText());//Se envia el importe a cobrar mediante el contructor
        //JOptionPane.showMessageDialog(rootPane, "ok");
        dialogo.add(ventana.getContentPane());
        dialogo.setModal(true);
        dialogo.setTitle("Ventana cambio de precios");
        dialogo.setSize(ventana.getSize());
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = ventana.getSize();
        dialogo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        dialogo.setVisible(true);
        ventana.dispose();
        
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al abrir dialog: " + e);
        }
    }
    
    private void tablainventarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablainventarioPropertyChange

    }//GEN-LAST:event_tablainventarioPropertyChange

    private void tablainventarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablainventarioKeyReleased

    }//GEN-LAST:event_tablainventarioKeyReleased

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
       
      try {
        String []datos = new String[19];
        datos =logart.mostrarselectivo(txtbuscar.getText());
        txtdescripcion.setText(datos[1]);//descripcion
        txtcantidadactual.setText(datos[12]);//Precio de compra Este dato se oculta en la tabla
        String validacion = datos[1];
        if (validacion.isEmpty()) {
        JOptionPane.showConfirmDialog(null,"No encontramos el producto solicitado con la clave: " + txtbuscar.getText());
        }else{
          txtbuscar.transferFocus();  
          setCellRender(tablainventario);
        }
        
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"No encontramos el producto solicitado");
        }
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtnuevacantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnuevacantidadActionPerformed

        Double nueva=Double.parseDouble(txtnuevacantidad.getText()),actual=Double.parseDouble(txtcantidadactual.getText()),diferencia;
       diferencia=nueva-actual;
       txtdiferencia.setText(diferencia.toString());
       transferFocus();
      llenandotabla();
      calculototal();
      txtbuscar.requestFocus();
      txtbuscar.selectAll();
    }//GEN-LAST:event_txtnuevacantidadActionPerformed

    private void txtcantidadactualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadactualActionPerformed
       txtcantidadactual.transferFocus();
    }//GEN-LAST:event_txtcantidadactualActionPerformed

    private void txtdiferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiferenciaActionPerformed

    private void txtdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        llenandotabla();
        calculototal();
        txtbuscar.requestFocus();
        txtbuscar.selectAll();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtnuevacantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnuevacantidadKeyPressed
      
    }//GEN-LAST:event_txtnuevacantidadKeyPressed

    private void txtcantidadactualKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadactualKeyPressed
       
        
        
    }//GEN-LAST:event_txtcantidadactualKeyPressed

    private void txtnuevacantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnuevacantidadKeyTyped
char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '.'))
      {
         evt.consume();  // ignorar el evento de teclado
      }  
   
    }//GEN-LAST:event_txtnuevacantidadKeyTyped

    private void txtcantidadactualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadactualKeyTyped
         char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '.' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
    }//GEN-LAST:event_txtcantidadactualKeyTyped

    private void txtdescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdescripcionFocusGained
       txtdescripcion.transferFocus();
       txtnuevacantidad.selectAll();
    }//GEN-LAST:event_txtdescripcionFocusGained

    private void txtdiferenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdiferenciaFocusGained
       Double nueva=Double.parseDouble(txtnuevacantidad.getText()),actual=Double.parseDouble(txtcantidadactual.getText()),diferencia;
       diferencia=nueva-actual;
       txtdiferencia.setText(diferencia.toString());
    }//GEN-LAST:event_txtdiferenciaFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      DefaultTableModel dtm = (DefaultTableModel) tablainventario.getModel(); //TableProducto es el nombre de mi tabla ;) 
       int fila= tablainventario.getSelectedRow();
       dtm.removeRow(fila); 
       calculototal();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btncerrarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarcompraActionPerformed
       //No iniciar a guardar en caso de no haber compra
        if (existendatosentabla()) {
            //Si hay datos en tabla no hago nada
        }else{
             JOptionPane.showMessageDialog(rootPane, "Primero agrege productos al inventario");
            return;}
        actualizarexistencia();
        
           limpiando();
          JOptionPane.showMessageDialog(rootPane, "ACTUALIZACION DE INVENTARIO EXITOSA");
    }//GEN-LAST:event_btncerrarcompraActionPerformed

    private void txtnuevacantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnuevacantidadFocusLost
      Double nueva=Double.parseDouble(txtnuevacantidad.getText()),actual=Double.parseDouble(txtcantidadactual.getText()),diferencia;
       diferencia=nueva-actual;
       txtdiferencia.setText(diferencia.toString());
    }//GEN-LAST:event_txtnuevacantidadFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncerrarcompra;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablainventario;
    public static javax.swing.JTextField txtbuscar;
    public static javax.swing.JTextField txtcantidadactual;
    public static javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtdiferencia;
    private javax.swing.JTextField txtnuevacantidad;
    // End of variables declaration//GEN-END:variables
}
