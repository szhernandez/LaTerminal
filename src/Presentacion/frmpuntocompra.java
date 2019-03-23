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
import Logica.servicio_impresion;
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
public class frmpuntocompra extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmpuntocompra
     */
    public frmpuntocompra() {
        initComponents();
        setCellRender(tablacompra);
        tablacompra.getModel().addTableModelListener(tablacompra);
        titulostabla();
        lbl_idproveedor.setVisible(false);
        lbl_idtrabajador.setVisible(false);
        lbl_nombreproveedor.setVisible(false);
        lbl_representante.setVisible(false);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);//Con esto quito el title
         Color myColor = new Color(255,255,255);
         tablacompra.setBackground(myColor);
         jScrollPane1.getViewport().setBackground(myColor);
         txttipodocumento.setEditable(false);
    }

    //Creando objetos y declarando variables
    logcommon comun = new logcommon();
    logarticulo logart = new logarticulo();
    datosarticulo dtsarticulo = new datosarticulo();
    datoscompra dtscompra = new datoscompra();
    logcompra logcomp = new logcompra();
    datosdetallecompra dtsdetalle = new datosdetallecompra();
    logdetallecompra logdetalle = new logdetallecompra();
    servicio_impresion ticket = new servicio_impresion();
    
    //Variables utilizadas
    public static String Agentenombre="",agenteapellidos="",agentetelefono="";//DAtos agente, devueltos de dialog
    
    DefaultTableModel modelo= new DefaultTableModel(){
     public boolean isCellEditable(int row, int column) {return false;}
    };//CReando el objeto de la tabla
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_idtrabajador = new javax.swing.JLabel();
        lbl_idproveedor = new javax.swing.JLabel();
        lbl_nombreproveedor = new javax.swing.JLabel();
        lbl_representante = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtdescripcion = new javax.swing.JTextField();
        btncerrarcompra = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtimporte = new javax.swing.JFormattedTextField();
        txttipodocumento = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablacompra = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtproveedor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnagregarproveedor = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnsalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setTitle("Registro de compras");

        jPanel1.setBackground(new java.awt.Color(3, 79, 132));

        lbl_idtrabajador.setText("idTrabajador");

        lbl_idproveedor.setText("idProveedor");

        lbl_nombreproveedor.setText("Nombreproovedor");

        lbl_representante.setText("Nombreproovedor");

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Total: $");

        lbltotal.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        lbltotal.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal.setText("0.0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_idtrabajador)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_idproveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_nombreproveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_representante)))
                .addContainerGap(998, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbl_idtrabajador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_idproveedor)
                    .addComponent(lbl_nombreproveedor)
                    .addComponent(lbl_representante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltotal)))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtbuscar.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/64x64/buscarproducto.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad");

        txtcantidad.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtcantidad.setText("0");
        txtcantidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcantidadFocusLost(evt);
            }
        });
        txtcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantidadActionPerformed(evt);
            }
        });
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Precio");

        txtprecio.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtprecio.setText("0.00");
        txtprecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtprecioFocusLost(evt);
            }
        });
        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });
        txtprecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Importe");

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

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/changing-money.png"))); // NOI18N
        jButton3.setToolTipText("Cambiar precio venta");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Cambio de precios");

        txtimporte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.00"))));

        txttipodocumento.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttipodocumento.setText("Ticket");
        txttipodocumento.setOpaque(false);
        txttipodocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttipodocumentoMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Tipo de documento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttipodocumento)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtimporte, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncerrarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btncerrarcompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtimporte, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        txtimporte.setFont(new java.awt.Font("Times New Roman", 1, 18));

        tablacompra.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tablacompra.setModel(new javax.swing.table.DefaultTableModel(
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
        tablacompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablacompraMouseClicked(evt);
            }
        });
        tablacompra.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablacompraPropertyChange(evt);
            }
        });
        tablacompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablacompraKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablacompra);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Proveedor");

        txtproveedor.setEditable(false);
        txtproveedor.setBackground(new java.awt.Color(255, 255, 255));
        txtproveedor.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtproveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtproveedorMouseClicked(evt);
            }
        });
        txtproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproveedorActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Fecha de compra: ");

        lblfecha.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblfecha.setText("DD/MM/AA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(20, 20, 20)
                .addComponent(txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblfecha)
                .addContainerGap(523, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 60, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lblfecha)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14)))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Proveedor");

        btnagregarproveedor.setBackground(new java.awt.Color(255, 255, 255));
        btnagregarproveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/user.png"))); // NOI18N
        btnagregarproveedor.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnagregarproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarproveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnagregarproveedor)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnagregarproveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(93, 93, 93))
        );

        btnsalir.setBackground(new java.awt.Color(255, 255, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/icons8_Close_Window_32px.png"))); // NOI18N
        btnsalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsalir))))))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsalir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void titulostabla(){
          modelo.addColumn("Unidades");
          modelo.addColumn("Codigo");
          modelo.addColumn("Descripcion");
          modelo.addColumn("P. Uni");
          modelo.addColumn("Importe");
          tablacompra.setModel(modelo);
          formatodetabla();
          }
    //Metodo para dar formato a la tabla
    void formatodetabla(){
    //Columna cantidad
    tablacompra.getColumnModel().getColumn(0).setPreferredWidth(100);
    //Columna codigo
    tablacompra.getColumnModel().getColumn(1).setPreferredWidth(200);
    //colunma Descripcion
    tablacompra.getColumnModel().getColumn(2).setPreferredWidth(400);
    
    //Columna Precio unitario
    tablacompra.getColumnModel().getColumn(3).setPreferredWidth(200);
    //Columna importe
    tablacompra.getColumnModel().getColumn(4).setPreferredWidth(200);
    
    }
   
     void abrirdialogtrabajador(){
     //primero abrimos el dialogo para seleccionar agente
             Frame f = JOptionPane.getFrameForComponent(this);
                dialogtrabajador dialog = new dialogtrabajador(f, true);
                dialog.setSize(600, 300);
                dialog.setLocationRelativeTo(null);
                dialog.setTitle("Eliga al Agente de ventas");
                dialog.padre="PuntoCompra";
                dialog.setVisible(true);
    }
    
    private void tablacompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablacompraMouseClicked
        DefaultTableModel dtm = (DefaultTableModel) tablacompra.getModel(); //TableProducto es el nombre de mi tabla ;)
        int fila= tablacompra.getSelectedRow();
        int columna = tablacompra.getSelectedColumn();

        //En caso de presionar ssobre la cantidad de productos
        if (columna==0) {
            int valor= Integer.parseInt(""+tablacompra.getValueAt(fila, 0));
            int nuevacantidad= Integer.parseInt(JOptionPane.showInputDialog("CANTIDAD DE PRODUCTOS"));
            //Indicando el nuevo valor de la cantidad
            tablacompra.setValueAt(nuevacantidad, fila, 0);
            //Indicando el nuevo valor del importe
            double importe = Double.parseDouble(""+tablacompra.getValueAt(fila, 0)) * Double.parseDouble(""+tablacompra.getValueAt(fila, 3));
            tablacompra.setValueAt(importe, fila, 4);
            txtbuscar.requestFocus(true);//Le regreso el foco a la caja de busqueda
        }

        //En caso de presionar ssobre la el precio unitario
        if (columna==3) {
            Double unidades= Double.parseDouble(""+tablacompra.getValueAt(fila, 0));
            Double preciocompra= Double.parseDouble(""+tablacompra.getValueAt(fila, 0));
            Double nuevoprecio= Double.parseDouble(JOptionPane.showInputDialog("PRECIO"));
            
                //Indicando el nuevo valor de la cantidad
                tablacompra.setValueAt(nuevoprecio, fila, 3);
                //Indicando el nuevo valor del importe
                double importe = unidades*nuevoprecio;
                tablacompra.setValueAt(importe, fila, 4);
                txtbuscar.requestFocus(true);//Le regreso el foco a la caja de busqueda
            

        }
        calculototal();
    }//GEN-LAST:event_tablacompraMouseClicked

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

        datosseleccionados[0]= txtcantidad.getText();//Cantidad 
        datosseleccionados[1]= datos[0];//codigo
        datosseleccionados[2]= datos[1];//descripcion
        datosseleccionados[3]= txtprecio.getText();//Precio de compra Este dato se oculta en la tabla
        datosseleccionados[4]= txtimporte.getText();
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
        int totalRow= tablacompra.getRowCount();
        totalRow-=1;
        for(int i=0;i<=(totalRow);i++)
        {
        double sumatoria= Double.parseDouble(String.valueOf(tablacompra.getValueAt(i,4)).replace(",", ""));//Remplazamos para poder realizar el calculo
        //en la parte de arriba indica el primer parametro la fila y el segundo la columna la cual estaras //manejando
             sumatoria1+=sumatoria;
        }
        lbltotal.setText(sumatoria1+"");
    }
    public boolean existendatosentabla(){
    Double total= Double.parseDouble(lbltotal.getText());
    if(total>0){
    return true;
    }else{
    return false;
    }
    }
     
    void guardandocompra(){
    //Empezamos seteando los valores necesarios
       
        
        try{
            double importe = Double.parseDouble(lbltotal.getText());
            dtscompra.setEstado("Finalizada");
            dtscompra.setImporte(importe);
            dtscompra.setIdTrab(Integer.parseInt(lbl_idtrabajador.getText()));
            dtscompra.setIdProveedor(Integer.parseInt(lbl_idproveedor.getText()));
            dtscompra.setFecha(comun.fechaactual()+" "+comun.horaactual());
            
            try {//Comienza try
                 if (logcomp.insertar(dtscompra)) {
               
            }
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(rootPane, "No puedo llamar a guardar compra 'PtoCompra': "+e);
            }//Fin try
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo setear datos de compra, motivo: "+e);
        }
}
    
     void guardardetallecompra(){
         
         TableModel mitabla = tablacompra.getModel();
         
        try {
             int cols = mitabla.getColumnCount();
            int fils = mitabla.getRowCount();
            for(int i=0; i<fils; i++) {
               
                Integer ultimacompra=Integer.parseInt(logdetalle.mostrarultima());//Comezamos por obtener el ultimo idventa invocando y asignando la funcion mostrarultima
                dtsdetalle.setIdCompra(ultimacompra);
                dtsdetalle.setIdArt(mitabla.getValueAt(i,1).toString());
                dtsdetalle.setUnidades(Integer.parseInt(mitabla.getValueAt(i,0).toString()));
                dtsdetalle.setPrecio(Double.parseDouble(mitabla.getValueAt(i,3).toString()));
                dtsdetalle.setImpuesto(Double.parseDouble("0"));
                //Actualizando existencia
                logart.existenciasuma(Double.parseDouble(mitabla.getValueAt(i,0).toString()), mitabla.getValueAt(i,1).toString());
                //Actualizando precio
                dtsarticulo.setIdArt(mitabla.getValueAt(i,1).toString());
                dtsarticulo.setPrecioCompra(Double.parseDouble(mitabla.getValueAt(i,3).toString()));
                if (logdetalle.insertar(dtsdetalle)) {
                   logart.actualizarpreciocompra(dtsarticulo);
                  
                }
        }//Fin for
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo guardar detalle de compra :"+e);
        }
   
    }
     
     void limpiando(){
         try {
          //Limpiando tabla
            DefaultTableModel modelo2=(DefaultTableModel) tablacompra.getModel();
            int filas = tablacompra.getRowCount();
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
       
            lbltotal.setText("0.00");
            txtbuscar.setText("");
            txtprecio.setText("");
            txtdescripcion.setText("");
            txtcantidad.setText("");
            txtimporte.setText("");
            txtproveedor.setText("");
         
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
        frmaarticulo_actualizaprecios ventana = new frmaarticulo_actualizaprecios(dialogo,txtbuscar.getText(),txtdescripcion.getText(),txtprecio.getText());//Se envia el importe a cobrar mediante el contructor
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
    
    private void tablacompraPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablacompraPropertyChange

    }//GEN-LAST:event_tablacompraPropertyChange

    private void tablacompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablacompraKeyReleased

    }//GEN-LAST:event_tablacompraKeyReleased

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        if(txtproveedor.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Debes ingresar un proveedor");

            return;
        }
      try {
        String []datos = new String[19];
        String []datosseleccionados = new String[19];
        datos =logart.mostrarselectivo(txtbuscar.getText());
        txtdescripcion.setText(datos[1]);//descripcion
        txtprecio.setText(datos[5]);//Precio de compra Este dato se oculta en la tabla
        String validacion = datos[1];
        if (validacion.isEmpty()) {
        JOptionPane.showConfirmDialog(null,"No encontramos el producto solicitado con la clave: " + txtbuscar.getText());
        setCellRender(tablacompra);
        }else{
          txtbuscar.transferFocus();  
        }
        
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"No encontramos el producto solicitado");
        }
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantidadActionPerformed
        txtcantidad.transferFocus();
    }//GEN-LAST:event_txtcantidadActionPerformed

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
       txtprecio.transferFocus();
    }//GEN-LAST:event_txtprecioActionPerformed

    private void txtproveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtproveedorMouseClicked
        try {
            Frame f = JOptionPane.getFrameForComponent(this);
            dialogproveedor dialog = new dialogproveedor(f, true);
            dialog.setSize(600, 300);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);

            txtproveedor.requestFocus();

            //JOptionPane.showMessageDialog(this,ventanacobro.getContentPane());
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al abrir ventana clientes: " + e);
        }
    }//GEN-LAST:event_txtproveedorMouseClicked

    private void txtproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproveedorActionPerformed

    private void btnagregarproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarproveedorActionPerformed
        try {
            frmproveedor ventana = new frmproveedor();
            escritorio.add(ventana);
            Dimension desktopSize = escritorio.getSize();
            Dimension FrameSize = ventana.getSize();
            ventana.toFront();
            ventana.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
            ventana.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error: " + e);
        }
    }//GEN-LAST:event_btnagregarproveedorActionPerformed

    private void txtdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        llenandotabla();
        calculototal();
        txtbuscar.requestFocus();
        txtbuscar.selectAll();
        setCellRender(tablacompra);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyPressed
      
    }//GEN-LAST:event_txtcantidadKeyPressed

    private void txtprecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyPressed
       
        
        
    }//GEN-LAST:event_txtprecioKeyPressed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
char caracter = evt.getKeyChar();

      // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '.'))
      {
         evt.consume();  // ignorar el evento de teclado
      }  
   
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void txtprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioKeyTyped
         char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
      if(((caracter < '0') ||
         (caracter > '9')) &&
         (caracter != '.' /*corresponde a BACK_SPACE*/))
      {
         evt.consume();  // ignorar el evento de teclado
      }
    }//GEN-LAST:event_txtprecioKeyTyped

    private void txtdescripcionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdescripcionFocusGained
       txtdescripcion.transferFocus();
       txtcantidad.selectAll();
    }//GEN-LAST:event_txtdescripcionFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      DefaultTableModel dtm = (DefaultTableModel) tablacompra.getModel(); //TableProducto es el nombre de mi tabla ;) 
       int fila= tablacompra.getSelectedRow();
       dtm.removeRow(fila); 
       calculototal();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btncerrarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarcompraActionPerformed
       //No iniciar a guardar en caso de no haber compra
        if (existendatosentabla()) {
            //Si hay datos en tabla no hago nada
        }else{
             JOptionPane.showMessageDialog(rootPane, "Primero agrege productos a la compra");
            return;}
        guardandocompra();
        guardardetallecompra();
       //Generando impresion de comprobante
             try {
                 //Esto genera un ticket
                if(txttipodocumento.getText().equals("Ticket")){
                    ticket.imprimiendo_ticket_compra(Integer.parseInt(logcomp.mostrarultima()));
                }
                
            //Se genera la nota de venta
           if(txttipodocumento.getText().equals("Nota")){
           abrirdialogtrabajador();
           ticket.imprimiendo_nota_compra(Agentenombre, agenteapellidos, agentetelefono); }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "OOPPSS... Poblemas con el documento (btncerrarventa) "+e);
            }
            
           limpiando();
           
    }//GEN-LAST:event_btncerrarcompraActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       dialogcambioprecios();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtprecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtprecioFocusLost
        Double cantidad=Double.parseDouble(txtcantidad.getText()),precio=Double.parseDouble(txtprecio.getText()),importe;
       importe=cantidad*precio;
       txtimporte.setText(importe.toString());
    }//GEN-LAST:event_txtprecioFocusLost

    private void txtcantidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcantidadFocusLost
       Double cantidad=Double.parseDouble(txtcantidad.getText()),precio=Double.parseDouble(txtprecio.getText()),importe;
       importe=cantidad*precio;
       txtimporte.setText(importe.toString());
    }//GEN-LAST:event_txtcantidadFocusLost

    private void txttipodocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttipodocumentoMouseClicked
        try {
            Frame f = JOptionPane.getFrameForComponent(this);
            dialogpvtipodoc dialog = new dialogpvtipodoc(f, true);
            dialog.setSize(400, 300);
            dialog.setLocationRelativeTo(null);
            dialog.accion="Compra";
            dialog.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error: " + e);
        }
    }//GEN-LAST:event_txttipodocumentoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarproveedor;
    private javax.swing.JButton btncerrarcompra;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lbl_idproveedor;
    public static javax.swing.JLabel lbl_idtrabajador;
    public static javax.swing.JLabel lbl_nombreproveedor;
    public static javax.swing.JLabel lbl_representante;
    private javax.swing.JLabel lblfecha;
    public static javax.swing.JLabel lbltotal;
    public static javax.swing.JTable tablacompra;
    public static javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcantidad;
    public static javax.swing.JTextField txtdescripcion;
    private javax.swing.JFormattedTextField txtimporte;
    public static javax.swing.JTextField txtprecio;
    public static javax.swing.JTextField txtproveedor;
    public static javax.swing.JTextField txttipodocumento;
    // End of variables declaration//GEN-END:variables
}
