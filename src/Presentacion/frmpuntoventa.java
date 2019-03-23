/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.datosarticulo;
import Datos.datoscaja;
import Datos.datosdetalleventa;
import Datos.datosventa;
import Logica.CellRenderer;
import Logica.logarticulo;
import Logica.logcaja;
import Logica.logcliente;
import Logica.logcommon;
import Logica.logdetalleventa;
import Logica.logventa;
import Logica.logimpuesto;
import Logica.logticket;
import Logica.servicio_impresion;
import static Presentacion.frminicio.escritorio;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ZAIR
 */
public class frmpuntoventa extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmpuntoventa
     */
    public frmpuntoventa() {
       initComponents();
       //setCellRender(tablaventa);
       titulostabla();
       tablaventa.getModel().addTableModelListener(tablaventa);
       lblfecha.setText(logcommon.fechaactual());
      
       txtcliente.setEditable(false);
       txttipodocumento.setEditable(false);
       lbl_idcliente.setVisible(false);
       lbl_idcaja.setVisible(false);
       lbl_idtrabajador.setVisible(false);
       lbladeudo.setVisible(false);
       lblcambio.setVisible(false);
       lblefectivo.setVisible(false);
       lblefectivo2.setVisible(false);
       lblnombrecliente.setVisible(false);
       lblnombrenegocio.setVisible(false);
       Color myColor = new Color(255,255,255);
       tablaventa.setBackground(myColor);
       jScrollPane1.getViewport().setBackground(myColor);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        txttipodocumento = new javax.swing.JTextField();
        lblfecha = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnagregarproducto = new javax.swing.JButton();
        btnagregarcliente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtlistaprecio = new javax.swing.JTextField();
        btneliminar = new javax.swing.JButton();
        btncerrarventa = new javax.swing.JButton();
        lblcerrar = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txttarjeta = new javax.swing.JTextField();
        panelvariables = new javax.swing.JPanel();
        lbl_idtrabajador = new javax.swing.JLabel();
        lbl_idcaja = new javax.swing.JLabel();
        lblefectivo = new javax.swing.JLabel();
        lblcambio = new javax.swing.JLabel();
        lbladeudo = new javax.swing.JLabel();
        lblefectivo2 = new javax.swing.JLabel();
        lbl_idcliente = new javax.swing.JLabel();
        lblnombrecliente = new javax.swing.JLabel();
        lblnombrenegocio = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        lblcambiovista = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventa = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setForeground(new java.awt.Color(0, 204, 0));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Punto de venta");
        setOpaque(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 204, 51));

        txtbuscar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtbuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtbuscarFocusGained(evt);
            }
        });
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/64x64/buscarproducto.png"))); // NOI18N

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/buscarproducto.png"))); // NOI18N
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Tipo de documento");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Precio Aplic");

        txtcliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtcliente.setOpaque(false);
        txtcliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtclienteFocusGained(evt);
            }
        });
        txtcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtclienteMouseClicked(evt);
            }
        });
        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });

        txttipodocumento.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttipodocumento.setText("Ticket");
        txttipodocumento.setOpaque(false);
        txttipodocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttipodocumentoMouseClicked(evt);
            }
        });

        lblfecha.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblfecha.setText("DD/MM/AA");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Fecha: ");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14)))); // NOI18N
        jPanel2.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Productos");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Cliente");

        btnagregarproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/add.png"))); // NOI18N
        btnagregarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarproductoActionPerformed(evt);
            }
        });

        btnagregarcliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/user.png"))); // NOI18N
        btnagregarcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarclienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6))
                            .addComponent(btnagregarcliente))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(btnagregarproducto))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnagregarcliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(8, 8, 8)
                .addComponent(btnagregarproducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(21, 21, 21))
        );

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Cliente");

        txtlistaprecio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtlistaprecio.setFocusable(false);
        txtlistaprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlistaprecioActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/cart (1).png"))); // NOI18N
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btncerrarventa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/pay-per-click.png"))); // NOI18N
        btncerrarventa.setToolTipText("Cobrar");
        btncerrarventa.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btncerrarventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrarventaActionPerformed(evt);
            }
        });

        lblcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/icons8_Close_Window_32px.png"))); // NOI18N
        lblcerrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcerrarMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Tarjeta");

        txttarjeta.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttarjeta.setText("1");
        txttarjeta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttarjetaFocusGained(evt);
            }
        });
        txttarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttarjetaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btncerrarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(458, 458, 458))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcliente)
                            .addComponent(txttipodocumento))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtlistaprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(lblfecha)
                                .addGap(177, 177, 177)
                                .addComponent(lblcerrar))
                            .addComponent(txttarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtlistaprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txttipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btncerrarventa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33))))
        );

        panelvariables.setBackground(new java.awt.Color(3, 79, 132));
        panelvariables.setForeground(new java.awt.Color(255, 255, 255));

        lbl_idtrabajador.setText("idTrabajador");

        lbl_idcaja.setText("idcaja");

        lblefectivo.setText("No borrar, sirve para saber estado de venta");

        lblcambio.setText("cambio");
        lblcambio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblcambioPropertyChange(evt);
            }
        });

        lbladeudo.setText("adeudo");

        lblefectivo2.setText("Efectivo 2");

        lbl_idcliente.setText("idCliente");

        lblnombrecliente.setText("nombrecliente");

        lblnombrenegocio.setText("nombrenegocio");

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total:$");

        lbltotal.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        lbltotal.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal.setText("0.0");

        lblcambiovista.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        lblcambiovista.setForeground(new java.awt.Color(255, 255, 255));
        lblcambiovista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcambiovista.setText("SU CAMBIO: ");

        jLabel11.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("PUNTO VENTA 1");

        javax.swing.GroupLayout panelvariablesLayout = new javax.swing.GroupLayout(panelvariables);
        panelvariables.setLayout(panelvariablesLayout);
        panelvariablesLayout.setHorizontalGroup(
            panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelvariablesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelvariablesLayout.createSequentialGroup()
                        .addGroup(panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_idtrabajador)
                            .addComponent(lbl_idcliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelvariablesLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lblcambio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblefectivo2)
                                .addGap(18, 18, 18)
                                .addComponent(lblefectivo))
                            .addGroup(panelvariablesLayout.createSequentialGroup()
                                .addComponent(lblnombrecliente)
                                .addGap(18, 18, 18)
                                .addComponent(lblnombrenegocio)
                                .addGap(18, 18, 18)
                                .addComponent(lbladeudo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_idcaja)))
                        .addContainerGap(815, Short.MAX_VALUE))
                    .addGroup(panelvariablesLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(65, 65, 65)
                        .addComponent(lblcambiovista, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        panelvariablesLayout.setVerticalGroup(
            panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelvariablesLayout.createSequentialGroup()
                .addGroup(panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_idtrabajador)
                    .addComponent(lblefectivo2)
                    .addComponent(lblefectivo)
                    .addComponent(lblcambio))
                .addGap(6, 6, 6)
                .addGroup(panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_idcliente)
                    .addComponent(lblnombrecliente)
                    .addComponent(lblnombrenegocio)
                    .addComponent(lbladeudo)
                    .addComponent(lbl_idcaja))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelvariablesLayout.createSequentialGroup()
                .addGap(0, 81, Short.MAX_VALUE)
                .addGroup(panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotal)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcambiovista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        tablaventa.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        tablaventa.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaventa.setSelectionBackground(new java.awt.Color(0, 51, 255));
        tablaventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaventaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablaventaMouseEntered(evt);
            }
        });
        tablaventa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tablaventaPropertyChange(evt);
            }
        });
        tablaventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaventaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaventa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(panelvariables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(panelvariables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Creando objeto de metodos comunes
    logcommon comun = new logcommon();
    logventa logvent = new logventa();
    datosventa dtsventa = new datosventa();
    datosdetalleventa dtsdetventa = new datosdetalleventa();
    logdetalleventa logdetventa = new logdetalleventa();
    logimpuesto logimp = new logimpuesto();
    logarticulo logart = new logarticulo();
     logcliente logcliente = new logcliente();
    datosarticulo dts = new datosarticulo();
    servicio_impresion ticket = new servicio_impresion();
    //Declarando variables publicas
    public static String Agentenombre="",agenteapellidos="",agentetelefono="";//DAtos agente, devueltos de dialog
    public  static ImageIcon logo,imagenagua;
   // public static Double pago;
    public Integer totalregistros;//Variable a utilizar como contador
    DefaultTableModel modelo= new DefaultTableModel(){
    
     public boolean isCellEditable(int row, int column) {return false;}
    };//CReando el objeto de la tabla
    

    
    void titulostabla(){
    modelo.addColumn("Cantidad");
    modelo.addColumn("Codigo");
    modelo.addColumn("Descripcion");
    modelo.addColumn("P. Uni");
    modelo.addColumn("Importe");
    modelo.addColumn("Existencia");
    modelo.addColumn("Observaciones");
    modelo.addColumn("P. Compra");
    modelo.addColumn("Impuesto");
    modelo.addColumn("Fecha");
    modelo.addColumn("Hora");
    modelo.addColumn("P. Com");
    tablaventa.setModel(modelo);
    formatodetabla();
    }

    //Metodo para dar formato a la tabla
    void formatodetabla(){
    //Columna cantidad
    tablaventa.getColumnModel().getColumn(0).setPreferredWidth(100);
    //Columna codigo
    tablaventa.getColumnModel().getColumn(1).setPreferredWidth(200);
    //colunma Descripcion
    tablaventa.getColumnModel().getColumn(2).setPreferredWidth(400);
    
    //Columna Precio unitario
    tablaventa.getColumnModel().getColumn(3).setPreferredWidth(200);
    //Columna importe
    tablaventa.getColumnModel().getColumn(4).setPreferredWidth(200);
    //Columna Existencia
    tablaventa.getColumnModel().getColumn(5).setPreferredWidth(100);
     //Columna observaciones
    tablaventa.getColumnModel().getColumn(6).setPreferredWidth(600);
    //Columna Precio compra
    tablaventa.getColumnModel().getColumn(7).setPreferredWidth(0);
    tablaventa.getColumnModel().getColumn(7).setMaxWidth(0);
    tablaventa.getColumnModel().getColumn(7).setMinWidth(0);
     //Columna Impuesto
    tablaventa.getColumnModel().getColumn(8).setPreferredWidth(0);
    tablaventa.getColumnModel().getColumn(8).setMaxWidth(0);
    tablaventa.getColumnModel().getColumn(8).setMinWidth(0);
     //Columna Fecha
    tablaventa.getColumnModel().getColumn(9).setPreferredWidth(0); 
    tablaventa.getColumnModel().getColumn(9).setMaxWidth(0);
    tablaventa.getColumnModel().getColumn(9).setMinWidth(0);
//Columna Hora
    tablaventa.getColumnModel().getColumn(10).setPreferredWidth(0);
    tablaventa.getColumnModel().getColumn(10).setMaxWidth(0);
    tablaventa.getColumnModel().getColumn(10).setMinWidth(0);
    //Columna PrecioCompra
    tablaventa.getColumnModel().getColumn(11).setPreferredWidth(0);
    tablaventa.getColumnModel().getColumn(11).setMaxWidth(0);
    tablaventa.getColumnModel().getColumn(11).setMinWidth(0);
    
    }
    //DAr colores a tabla
    public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
    }
    
   //Obteniendo datos cliente
    void obtenrdatosclientetarjeta(){
     String []datoscliente = new String[19];
     datoscliente =logcliente.mostrararreglo(txttarjeta.getText());
    }
    //Metodo para insertar un nuevo producto a la tabla
    void llenandotabla(){
        try {
        
        String []datos = new String[19];
        String []datosseleccionados = new String[19];
        datos =logart.mostrarselectivo(txtbuscar.getText());
        //String idart=dts.getIdArt();
        
        datosseleccionados[0]= "1";//Cantidad 
        datosseleccionados[1]= datos[0];//codigo
        datosseleccionados[2]= datos[1];//descripcion
       
        
        //Ahora vemos cual precio de venta es el que corresponde al cliente
        String pvAplicable= txtlistaprecio.getText();
        
        datosseleccionados[3]= "Precio Desconocido";//Precio de venta
            if (pvAplicable.equals("Precio 1")) {
                datosseleccionados[3]=datos[6];
            }
            if (pvAplicable.equals("Precio 2"))  {
                 datosseleccionados[3]=datos[7];
            }
            if (pvAplicable.equals("Precio 3"))  {
                 datosseleccionados[3]=datos[8];
              
            }
            if (pvAplicable.equals("Precio 4"))  {
                 datosseleccionados[3]=datos[9];
            }
            if (pvAplicable.equals("Precio 5"))  {
                 datosseleccionados[3]=datos[9];
            }
        datosseleccionados[4]=datosseleccionados[3];//Esto corresponde al importe
        datosseleccionados[5]=datos[12];//Esto es la existencia
        datosseleccionados[6]=datos[15];//Observaciones
         datosseleccionados[7]= datos[5];//Precio de compra Este dato se oculta en la tabla
        datosseleccionados[8]=datos[4];//Impuesto
        datosseleccionados[9]=comun.fechaactual();
        datosseleccionados[10]=comun.horaactual();
        datosseleccionados[11]=datos[5];
        String validacion = datos[1];
        if (validacion.isEmpty()) {
        JOptionPane.showConfirmDialog(null,"No encontramos el producto solicitado con la clave: " + txtbuscar.getText());
        }else{
            modelo.addRow(datosseleccionados);
        }
        
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"No encontramos el producto solicitado");
        }
    }
    //Metodo que calcula el monto total
    void calculototal(){
    
        double sumatoria1=0.0,redondeando;
        int totalRow= tablaventa.getRowCount();
        totalRow-=1;
        for(int i=0;i<=(totalRow);i++)
        {
             double sumatoria= Double.parseDouble(String.valueOf(tablaventa.getValueAt(i,4)));
//en la parte de arriba indica el primer parametro la fila y el segundo la columna la cual estaras //manejando
             sumatoria1+=sumatoria;
        }
        redondeando=comun.redondeando(sumatoria1);
        lbltotal.setText(redondeando+"");
    }
  
    public boolean existendatosentabla(){
    Double total= Double.parseDouble(lbltotal.getText());
    if(total>0){
    return true;
    }else{
    return false;
    }
    }
    
    
    void abrirventanacobro(){
    try {
        /*Esta ventana se habre de manera especial
        se creo un dialog, el contenido del dialogo sera el que se encuentra dentro del frame
        frmcobro, estos elementos se pasan con la propiedad .getContenPane
        Dentro del frmcobro se creo un nuevo contructor con un elemento dialog
        esto sirve para poder manupular el dialog desde el frame
        ademas se agrego una cadena que se desea pasar
        */
       dialogvacio dialogo = new dialogvacio(null, true);
        frmcobro ventanacobro = new frmcobro(dialogo,lbltotal.getText());//Se envia el importe a cobrar mediante el contructor
        dialogo.add(ventanacobro.getContentPane());
        dialogo.setModal(true);
       
        dialogo.setTitle("Ventana de cobro(Compra de "+txtcliente.getText()+")");
        dialogo.setSize(ventanacobro.getSize());
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = ventanacobro.getSize();
        dialogo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        dialogo.setVisible(true);
        ventanacobro.dispose();
       
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al abrir dialog: " + e);
        }
    }
      void abrirdialogocambio(){
    try {
        dialogvacio dialogo = new dialogvacio(null, true);
        frmcambio ventanacambio = new frmcambio(dialogo,lblcambio.getText());//Se envia el importe a cobrar mediante el contructor
        dialogo.add(ventanacambio.getContentPane());
        dialogo.setModal(true);
      
       
        dialogo.setSize(ventanacambio.getSize());
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = ventanacambio.getSize();
        dialogo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
       
        dialogo.setVisible(true);
        ventanacambio.dispose();
        
        
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al abrir dialog: " + e);
        }
    }
    void abrirdialogtrabajador(){
     //primero abrimos el dialogo para seleccionar agente
             Frame f = JOptionPane.getFrameForComponent(this);
                dialogtrabajador dialog = new dialogtrabajador(f, true);
                dialog.setSize(600, 300);
                dialog.setLocationRelativeTo(null);
                dialog.setTitle("Eliga al Agente de ventas");
                dialog.padre="puntoventa";
                dialog.setVisible(true);
    }
    void guardandoventa(){
    //Empezamos seteando los valores necesarios
        
        
        
        Double efectivo, importe;
        efectivo= Double.parseDouble(lblefectivo.getText());
        importe= Double.parseDouble(lbltotal.getText());
        
        try {
            //Calculando dato que se pondra en estado, segun el valor que se genero del efectivo
            if (efectivo.equals(importe)) {
                dtsventa.setEstado("Finalizada");
            }
            if (efectivo<importe) {
                dtsventa.setEstado("Por pagar");
            }
            dtsventa.setImporte(importe);
            dtsventa.setPago(efectivo);
            dtsventa.setFecha(comun.fechaactual());
            dtsventa.setHora(comun.horaactual());
            dtsventa.setIdCliente(Integer.parseInt(lbl_idcliente.getText()));
            dtsventa.setIdTrab(Integer.parseInt(lbl_idtrabajador.getText()));
            dtsventa.setIdCaja(lbl_idcaja.getText());
            try {//Comienza try
                 if (logvent.insertar(dtsventa)) {
                // JOptionPane.showMessageDialog(rootPane, "venta registrada");
            }
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(rootPane, "No puedo llamar a guardar venta: "+e);
            }//Fin try
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo setear datos de venta, motivo: "+e);
        }
    
    }  
    void guardardetalleventa(){
   
    TableModel mitabla = tablaventa.getModel();
  //  logarticulo logart = new logarticulo();
        try {
                int cols = mitabla.getColumnCount();
                int fils = mitabla.getRowCount();
                for(int i=0; i<fils; i++) {
                Integer ultimaventa=Integer.parseInt(logvent.mostrarultima());//Comezamos por obtener el ultimo idventa invocando y asignando la funcion mostrarultima
                dtsdetventa.setIdVenta(ultimaventa);
                dtsdetventa.setIdArt(mitabla.getValueAt(i,1).toString());
                dtsdetventa.setPrecio(Double.parseDouble(mitabla.getValueAt(i,3).toString()));
                dtsdetventa.setPrecioCompra(Double.parseDouble(mitabla.getValueAt(i,11).toString()));
                dtsdetventa.setUnidades(Integer.parseInt(mitabla.getValueAt(i,0).toString()));
                Double impuesto = Double.parseDouble(logimp.consultarimpuestoselectivo(mitabla.getValueAt(i,8).toString()));
                dtsdetventa.setImpuesto(impuesto);
                dtsdetventa.setSubtotal(Double.parseDouble(mitabla.getValueAt(i,4).toString()));
                dtsdetventa.setFecha(logcommon.fechaactual());
                dtsdetventa.setHora(logcommon.horaactual());
                //Actualizando existencia
                logart.existenciaresta(Double.parseDouble(mitabla.getValueAt(i,0).toString()), mitabla.getValueAt(i,1).toString());
                if (logdetventa.insertar(dtsdetventa)) {
                   // JOptionPane.showMessageDialog(rootPane,"Venta realizada");//Borrar
                }

        }//Fin for
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo guardar detalle de venta :"+e);
        }
   
    }
    
    void updatecajaPVTA(){
    logcaja func = new logcaja();
    datoscaja dts = new datoscaja();
    Double dineroactual= Double.parseDouble( func.consultadinero(lbl_idcaja.getText()));
    Double agregado= Double.parseDouble(lbltotal.getText());
    Double update = dineroactual+agregado;
    dts.setDinero(update);
    dts.setIdcaja(lbl_idcaja.getText());
    func.updatedinero(dts);
    
    
    }
    

    
    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
     if(txtcliente.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Debes ingresar un cliente");
           
            return;
        }
     //LIMPIANDO LBLCAMBIOVISTA
     lblcambiovista.setText("");
     
     llenandotabla();
     //setCellRender(tablaventa);
     txtbuscar.selectAll();
     calculototal();
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btnagregarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarproductoActionPerformed
       try {
        frmarticuloxpress ventana = new frmarticuloxpress();
        escritorio.add(ventana);
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.toFront();
        ventana.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        ventana.setVisible(true);  
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error: " + e);
        }
    }//GEN-LAST:event_btnagregarproductoActionPerformed

    private void btnagregarclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarclienteActionPerformed
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
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error: " + e);
        }
    }//GEN-LAST:event_btnagregarclienteActionPerformed

    private void txtlistaprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlistaprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlistaprecioActionPerformed

    private void tablaventaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaventaKeyReleased
        
        if (evt.getKeyCode() == evt.VK_F5) {
            try {
             cobrar();
            } catch (Exception e) {
            }
        }
        if (evt.getKeyCode() == evt.VK_DELETE) {
            try {
                DefaultTableModel dtm = (DefaultTableModel) tablaventa.getModel(); //TableProducto es el nombre de mi tabla ;) 
                int fila = tablaventa.getSelectedRow();
                dtm.removeRow(fila);
                calculototal();
                txtbuscar.requestFocus();
            } catch (Exception e) {
            }
        }
        //cambiar cantidad
        if (evt.getKeyCode() == evt.VK_C) {
            try {
                DefaultTableModel dtm = (DefaultTableModel) tablaventa.getModel(); //TableProducto es el nombre de mi tabla ;) 
                int fila = tablaventa.getSelectedRow();

                //En caso de presionar ssobre la cantidad de productos
                int valor = Integer.parseInt("" + tablaventa.getValueAt(fila, 0));
                int nuevacantidad = Integer.parseInt(JOptionPane.showInputDialog("CANTIDAD DE PRODUCTOS"));
                //Indicando el nuevo valor de la cantidad
                tablaventa.setValueAt(nuevacantidad, fila, 0);
                //Indicando el nuevo valor del importe
                double importe = Double.parseDouble("" + tablaventa.getValueAt(fila, 0)) * Double.parseDouble("" + tablaventa.getValueAt(fila, 3));
                tablaventa.setValueAt(comun.redondeando(importe), fila, 4);
                txtbuscar.requestFocus(true);//Le regreso el foco a la caja de busqueda

            } catch (Exception e) {
            }
        }

        //cambiar precio
        if (evt.getKeyCode() == evt.VK_P) {
            try {
                DefaultTableModel dtm = (DefaultTableModel) tablaventa.getModel(); //TableProducto es el nombre de mi tabla ;) 
                int fila = tablaventa.getSelectedRow();
                Double unidades = Double.parseDouble("" + tablaventa.getValueAt(fila, 0));
                Double preciocompra = Double.parseDouble("" + tablaventa.getValueAt(fila, 7));
                Double precioventa = Double.parseDouble("" + tablaventa.getValueAt(fila, 0));
                Double nuevoprecio = Double.parseDouble(JOptionPane.showInputDialog("PRECIO"));
                if (nuevoprecio < preciocompra) {
                    JOptionPane.showMessageDialog(null, "Ingrese un precio mayor al precio de compra $ " + preciocompra);
                } else {
                    //Indicando el nuevo valor de la cantidad
                    tablaventa.setValueAt(nuevoprecio, fila, 3);
                    //Indicando el nuevo valor del importe
                    double importe = unidades * nuevoprecio;
                    tablaventa.setValueAt(comun.redondeando(importe), fila, 4);
                    txtbuscar.requestFocus(true);//Le regreso el foco a la caja de busqueda
                }
            } catch (Exception e) {
            }
        }
         if (evt.getKeyCode() == 39) {
         txtbuscar.requestFocus();
         }
    }//GEN-LAST:event_tablaventaKeyReleased

    private void tablaventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaventaMouseClicked
       DefaultTableModel dtm = (DefaultTableModel) tablaventa.getModel(); //TableProducto es el nombre de mi tabla ;) 
       int fila= tablaventa.getSelectedRow();
       int columna = tablaventa.getSelectedColumn();
       
       //En caso de presionar ssobre la cantidad de productos
       if (columna==0) {
       int valor= Integer.parseInt(""+tablaventa.getValueAt(fila, 0));
       int nuevacantidad= Integer.parseInt(JOptionPane.showInputDialog("CANTIDAD DE PRODUCTOS"));
       //Indicando el nuevo valor de la cantidad
       tablaventa.setValueAt(nuevacantidad, fila, 0);
       //Indicando el nuevo valor del importe
       double importe = Double.parseDouble(""+tablaventa.getValueAt(fila, 0)) * Double.parseDouble(""+tablaventa.getValueAt(fila, 3));
       tablaventa.setValueAt(comun.redondeando(importe), fila, 4);    
       txtbuscar.requestFocus(true);//Le regreso el foco a la caja de busqueda
        }
       
        //En caso de presionar ssobre la el precio unitario
        if (columna==3) {
       Double unidades= Double.parseDouble(""+tablaventa.getValueAt(fila, 0));  
       Double preciocompra= Double.parseDouble(""+tablaventa.getValueAt(fila, 7));     
       Double precioventa= Double.parseDouble(""+tablaventa.getValueAt(fila, 0));
       Double nuevoprecio= Double.parseDouble(JOptionPane.showInputDialog("PRECIO"));
            if (nuevoprecio<preciocompra) {
                JOptionPane.showMessageDialog(null,"Ingrese un precio mayor al precio de compra $ "+preciocompra);
            }else{
             //Indicando el nuevo valor de la cantidad
       tablaventa.setValueAt(nuevoprecio, fila, 3);
       //Indicando el nuevo valor del importe
       double importe = unidades*nuevoprecio;
       tablaventa.setValueAt(comun.redondeando(importe), fila, 4);
        txtbuscar.requestFocus(true);//Le regreso el foco a la caja de busqueda
            }
      
       }
      
         calculototal();
    }//GEN-LAST:event_tablaventaMouseClicked

    public void tableChanged(java.awt.event.MouseEvent evt) {
         calculototal();
      }
    
    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
       DefaultTableModel dtm = (DefaultTableModel) tablaventa.getModel(); //TableProducto es el nombre de mi tabla ;) 
       int fila= tablaventa.getSelectedRow();
       dtm.removeRow(fila); 
       calculototal();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void tablaventaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablaventaPropertyChange
       
    }//GEN-LAST:event_tablaventaPropertyChange

    private void btncerrarventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrarventaActionPerformed
        //No iniciar a guardar en caso de no haber compra
        if (existendatosentabla()) {
            //Si hay datos en tabla no hago nada
        }else{
             JOptionPane.showMessageDialog(rootPane, "Primero agrege productos a la venta");
            return;}
        try {
        abrirventanacobro();
            try {
                guardandoventa();
                guardardetalleventa();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Tenemos un problema al guardar carrito de compra(btncerrarventa) "+e);
            }
            //Generando impresion de comprobante
             try {
                 //Esto genera un ticket
                if(txttipodocumento.getText().equals("Ticket")){
                    ticket.imprimiendo_ticket_venta(Integer.parseInt(logvent.mostrarultima()),Double.parseDouble(lblefectivo2.getText()));
                }
            //Se genera la nota de venta
           if(txttipodocumento.getText().equals("Nota")){
           abrirdialogtrabajador();
           ticket.imprimiendo_nota_venta(Agentenombre, agenteapellidos, agentetelefono);
                    }
            //   abrirdialogocambio();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "OOPPSS... Poblemas con el documento (btncerrarventa) "+e);
            }
        //Update dinero en caja
        updatecajaPVTA();
            try {
            //Limpiando tabla
            DefaultTableModel modelo2=(DefaultTableModel) tablaventa.getModel();
            int filas = tablaventa.getRowCount();
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
            lbltotal.setText("0.00");//
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo cerrar la venta: "+e);
        }
        txtbuscar.selectAll();
        txtbuscar.requestFocus();
    }//GEN-LAST:event_btncerrarventaActionPerformed

    private void txtclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtclienteMouseClicked
        try {
        Frame f = JOptionPane.getFrameForComponent(this);
        dialogpvcliente dialog = new dialogpvcliente(f, true);
       // dialog.setSize(600, 300);
        dialog.setLocationRelativeTo(null);
        dialog.accion="Venta";
        dialog.setVisible(true);
        txtcliente.requestFocus();
       
        //JOptionPane.showMessageDialog(this,ventanacobro.getContentPane());
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al abrir ventana clientes: " + e);
        }
    }//GEN-LAST:event_txtclienteMouseClicked

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteActionPerformed

    private void txttipodocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttipodocumentoMouseClicked
         try {
        Frame f = JOptionPane.getFrameForComponent(this);
         dialogpvtipodoc dialog = new dialogpvtipodoc(f, true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(null);
        dialog.accion="Venta";
        dialog.setVisible(true);
        
        txtcliente.requestFocus();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error: " + e);
        }
    }//GEN-LAST:event_txttipodocumentoMouseClicked

    private void lblcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcerrarMouseClicked
      
        this.dispose();
    }//GEN-LAST:event_lblcerrarMouseClicked

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

    }//GEN-LAST:event_formKeyReleased
    
    void buscartarjeta(String tarjeta){
      try {
            String [] arreglo;
            logcliente func = new logcliente();
            arreglo = func.mostrararreglo(tarjeta);
            String variable =arreglo[0];
            if (variable.isEmpty()) {
        JOptionPane.showConfirmDialog(null,"No encontramos el cliente solicitado con el numero de tarjeta: " + txttarjeta.getText());
        }else{
          lbl_idcliente.setText(arreglo[0]);
            txtcliente.setText(arreglo[1]+" "+arreglo[2]+" - "+arreglo[7]);
            lblnombrecliente.setText(arreglo[1]+" "+arreglo[2]);
            lblnombrenegocio.setText(arreglo[7]);
            txtlistaprecio.setText(arreglo[14]);
        }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    private void txttarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttarjetaActionPerformed
    buscartarjeta(txttarjeta.getText());
    txtbuscar.requestFocus();
    txtbuscar.selectAll();
    }//GEN-LAST:event_txttarjetaActionPerformed
    void cobrar() {
 //No iniciar a guardar en caso de no haber compra
            if (existendatosentabla()) {
                //Si hay datos en tabla no hago nada
            } else {
                JOptionPane.showMessageDialog(rootPane, "Primero agrege productos a la venta");
                return;
            }
            try {
                abrirventanacobro();

                try {
                    guardandoventa();
                    guardardetalleventa();
                    lblcambiovista.setText("SU CAMBIO: $" + lblcambio.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Tenemos un problema al guardar carrito de compra(btncerrarventa) " + e);
                }

                //Update dinero en caja
                updatecajaPVTA();
                try {
                    //Limpiando tabla
                    DefaultTableModel modelo2 = (DefaultTableModel) tablaventa.getModel();
                    int filas = tablaventa.getRowCount();
                    try {
                        for (int i = 0; i <= filas; i++) {
                            modelo2.removeRow(0);
                        }
                        //Fin de limpiar las filas
                    } catch (Exception e) {
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Esta tabla me da problemas (btncerrarventa) " + e);
                }
                lbltotal.setText("0.00");//
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "No puedo cerrar la venta: " + e);
            }
            txtbuscar.selectAll();
            txtbuscar.requestFocus();
            //Generando impresion de comprobante
            try {
                //Esto genera un ticket
                if (txttipodocumento.getText().equals("Ticket")) {
                    ticket.imprimiendo_ticket_venta(Integer.parseInt(logvent.mostrarultima()), Double.parseDouble(lblefectivo2.getText()));
                }
                //Se genera la nota de venta
                if (txttipodocumento.getText().equals("Nota")) {
                    abrirdialogtrabajador();
                    ticket.imprimiendo_nota_venta(Agentenombre, agenteapellidos, agentetelefono);
                }
                //   abrirdialogocambio();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "OOPPSS... Poblemas con el documento (btncerrarventa) " + e);
            }
    }
    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        if (evt.getKeyCode() == evt.VK_F5) {
            try {
                  cobrar();
            } catch (Exception e) {
            }
        }

        //Abriendo ventana de busqueda de producto
        if (evt.getKeyCode() == evt.VK_F1 || evt.getKeyCode() == 40) {
            try {
                //Se crea una variable que contiene el texto de txtbuscar,
                //y lo comparara con el mismo txtbuscar despues abrir el dialog para verificar si
                //existio modificacion o no
                String contenidotxtbuscar=txtbuscar.getText();
                /*Esta ventana se habre de manera especial
        se creo un dialog, el contenido del dialogo sera el que se encuentra dentro del frame
        frmcobro, estos elementos se pasan con la propiedad .getContenPane
        Dentro del frmcobro se creo un nuevo contructor con un elemento dialog
        esto sirve para poder manupular el dialog desde el frame
        ademas se agrego una cadena que se desea pasar
                 */
                dialogvacio dialogo = new dialogvacio(null, true);
                frmproductopuntoventa ventanaproducto = new frmproductopuntoventa(dialogo, txtbuscar.getText(), "puntoventa");//Se envia el importe a cobrar mediante el contructor
                dialogo.add(ventanaproducto.getContentPane());
                dialogo.setModal(true);

                dialogo.setTitle("Busqueda de producto " + txtbuscar.getText());
                dialogo.setSize(ventanaproducto.getSize());
                Dimension desktopSize = escritorio.getSize();
                Dimension FrameSize = ventanaproducto.getSize();
                dialogo.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                dialogo.setVisible(true);
                ventanaproducto.dispose();

                //Despues de cerrar el dialogo se realiza la consulta a la base de datos
                if (txtcliente.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un cliente");

                    return;
                }
                if (contenidotxtbuscar.equals(txtbuscar.getText())) {
                    
                }else{
                llenandotabla();
                //setCellRender(tablaventa);
                txtbuscar.selectAll();
                calculototal();
                }
                

            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "Error al abrir dialog: " + e);
            }
        }
        if ( evt.getKeyCode() == 38) {
            tablaventa.requestFocus();
            int totalRow= tablaventa.getRowCount();
             totalRow-=1;
             tablaventa.changeSelection(totalRow, 1, false, false);
        }
 
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
 try {
        /*Esta ventana se habre de manera especial
        se creo un dialog, el contenido del dialogo sera el que se encuentra dentro del frame
        frmcobro, estos elementos se pasan con la propiedad .getContenPane
        Dentro del frmcobro se creo un nuevo contructor con un elemento dialog
        esto sirve para poder manupular el dialog desde el frame
        ademas se agrego una cadena que se desea pasar
        */
        dialogvacio dialogo = new dialogvacio(null, true);
        frmproductopuntoventa ventanaproducto = new frmproductopuntoventa(dialogo,txtbuscar.getText(),"puntoventa");//Se envia el importe a cobrar mediante el contructor
        dialogo.add(ventanaproducto.getContentPane());
        dialogo.setModal(true);
        
        dialogo.setTitle("Busqueda de producto "+txtbuscar.getText());
        dialogo.setSize(ventanaproducto.getSize());
        Dimension desktopSize = escritorio.getSize();
        Dimension FrameSize = ventanaproducto.getSize();
        dialogo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        dialogo.setVisible(true);
        ventanaproducto.dispose();
        //Despues de llenar el cuadro de busqueda se realiza la consulta a la base de datos
         if(txtcliente.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Debes ingresar un cliente");
           
            return;
        }
       llenandotabla();
      // setCellRender(tablaventa);
       txtbuscar.selectAll();
        calculototal();
        
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al abrir dialog: " + e);
        }        
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
      
    }//GEN-LAST:event_formFocusGained

    private void txtclienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtclienteFocusGained
    txtbuscar.requestFocus();
    int contador=1;
        if (contador ==1) {
        buscartarjeta(txttarjeta.getText()); 
        contador=2;
        }
    
    }//GEN-LAST:event_txtclienteFocusGained

    private void txtbuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbuscarFocusGained
txtbuscar.selectAll();
    }//GEN-LAST:event_txtbuscarFocusGained

    private void txttarjetaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttarjetaFocusGained
    txttarjeta.selectAll();        // TODO add your handling code here:
    }//GEN-LAST:event_txttarjetaFocusGained

    private void tablaventaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaventaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaventaMouseEntered

    private void lblcambioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblcambioPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lblcambioPropertyChange

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
            java.util.logging.Logger.getLogger(frmpuntoventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmpuntoventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmpuntoventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmpuntoventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmpuntoventa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarcliente;
    private javax.swing.JButton btnagregarproducto;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncerrarventa;
    private javax.swing.JButton btneliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lbl_idcaja;
    public static javax.swing.JLabel lbl_idcliente;
    public static javax.swing.JLabel lbl_idtrabajador;
    public static javax.swing.JLabel lbladeudo;
    public static javax.swing.JLabel lblcambio;
    private javax.swing.JLabel lblcambiovista;
    private javax.swing.JLabel lblcerrar;
    public static javax.swing.JLabel lblefectivo;
    public static javax.swing.JLabel lblefectivo2;
    private javax.swing.JLabel lblfecha;
    public static javax.swing.JLabel lblnombrecliente;
    public static javax.swing.JLabel lblnombrenegocio;
    public static javax.swing.JLabel lbltotal;
    private javax.swing.JPanel panelvariables;
    public static javax.swing.JTable tablaventa;
    public static javax.swing.JTextField txtbuscar;
    public static javax.swing.JTextField txtcliente;
    public static javax.swing.JTextField txtlistaprecio;
    public static javax.swing.JTextField txttarjeta;
    public static javax.swing.JTextField txttipodocumento;
    // End of variables declaration//GEN-END:variables
}
