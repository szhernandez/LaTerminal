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
import Logica.logcommon;
import Logica.logdetalleventa;
import Logica.logventa;
import Logica.logimpuesto;
import Logica.logticket;
import Logica.servicio_impresion;
import static Presentacion.frminicio.escritorio;
import java.awt.Dimension;
import java.awt.Frame;
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
public class frmpuntoconsultapreventa extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmpuntoventa
     */
    public frmpuntoconsultapreventa() {
        initComponents();
          setCellRender(tablaventa);
         ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);//Con esto quito el title
       tablaventa.getModel().addTableModelListener(tablaventa);
       lblfecha.setText(logcommon.fechaactual());
       txttipocliente.setEditable(false);
       txttipodocumento.setEditable(false);
       txtidventa.requestFocus();
       txtnumventa.setText(idventa);
        try {
          obteniendodatosventa();
          mostrardetalleventa(txtnumventa.getText());
        } catch (Exception e) {
        }
    }
    public  static ImageIcon logoconsultaventa,imagenaguaconsultaventa,logo, imagenagua;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtbuscar = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txttipocliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtlistaprecio = new javax.swing.JTextField();
        txtidcliente = new javax.swing.JTextField();
        txtnombrecliente = new javax.swing.JTextField();
        txtclientenegocio = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        txtnumventa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtestadoventa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtidventa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txttipodocumento = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txttrabajadorid = new javax.swing.JTextField();
        txttrabajadornombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtidcaja = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblsobrante = new javax.swing.JLabel();
        lblimporte = new javax.swing.JLabel();
        lblpago = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblfecha = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btndevolucion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtbuscarproducto = new javax.swing.JTextField();
        btneliminar = new javax.swing.JButton();
        btneliminar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setForeground(new java.awt.Color(0, 204, 0));
        setTitle("Punto de venta");

        tablaventa.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
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
        tablaventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaventaMouseClicked(evt);
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(242, 124, 13))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 204, 51));
        jPanel1.setFocusable(false);

        txtbuscar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Precio Aplic");

        txttipocliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttipocliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttipoclienteMouseClicked(evt);
            }
        });
        txttipocliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttipoclienteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Cliente");

        txtlistaprecio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtlistaprecio.setFocusable(false);
        txtlistaprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlistaprecioActionPerformed(evt);
            }
        });

        txtidcliente.setEditable(false);
        txtidcliente.setBackground(new java.awt.Color(255, 255, 255));
        txtidcliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtidcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtidclienteMouseClicked(evt);
            }
        });
        txtidcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidclienteActionPerformed(evt);
            }
        });

        txtnombrecliente.setEditable(false);
        txtnombrecliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtnombrecliente.setSelectionColor(new java.awt.Color(242, 124, 13));
        txtnombrecliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnombreclienteMouseClicked(evt);
            }
        });
        txtnombrecliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreclienteActionPerformed(evt);
            }
        });

        txtclientenegocio.setEditable(false);
        txtclientenegocio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtclientenegocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtclientenegocioMouseClicked(evt);
            }
        });
        txtclientenegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclientenegocioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(txtbuscar)
                .addGap(635, 635, 635))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel8)
                .addGap(5, 5, 5)
                .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtclientenegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtlistaprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txttipocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombrecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtclientenegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlistaprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttipocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(285, 285, 285)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        txtnumventa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtnumventa.setCaretColor(new java.awt.Color(242, 124, 13));
        txtnumventa.setSelectionColor(new java.awt.Color(242, 124, 13));
        txtnumventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtnumventaMouseClicked(evt);
            }
        });
        txtnumventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumventaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel9.setText("PREVENTAS");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Numero de preventa");

        btnsalir.setBackground(new java.awt.Color(255, 255, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/icons8_Close_Window_32px.png"))); // NOI18N
        btnsalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(502, 502, 502)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(257, 257, 257)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(537, 537, 537)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnumventa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(555, 555, 555))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnumventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(242, 124, 13))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Numero de venta");

        txtestadoventa.setEditable(false);
        txtestadoventa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtestadoventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtestadoventaMouseClicked(evt);
            }
        });
        txtestadoventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtestadoventaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Estado");

        txtidventa.setEditable(false);
        txtidventa.setBackground(new java.awt.Color(255, 255, 255));
        txtidventa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtidventa.setFocusable(false);
        txtidventa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtidventaMouseClicked(evt);
            }
        });
        txtidventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidventaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Tipo de documento");

        txttipodocumento.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttipodocumento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttipodocumentoMouseClicked(evt);
            }
        });
        txttipodocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttipodocumentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(10, 10, 10)
                .addComponent(txtidventa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtestadoventa, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtidventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txttipodocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtestadoventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vendedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(242, 124, 13))); // NOI18N

        txttrabajadorid.setEditable(false);
        txttrabajadorid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttrabajadorid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttrabajadoridMouseClicked(evt);
            }
        });
        txttrabajadorid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttrabajadoridActionPerformed(evt);
            }
        });

        txttrabajadornombre.setEditable(false);
        txttrabajadornombre.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txttrabajadornombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txttrabajadornombreMouseClicked(evt);
            }
        });
        txttrabajadornombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttrabajadornombreActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Vendedor");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Caja");

        txtidcaja.setEditable(false);
        txtidcaja.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtidcaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtidcajaMouseClicked(evt);
            }
        });
        txtidcaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidcajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttrabajadorid, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txttrabajadornombre, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtidcaja, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txttrabajadornombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txttrabajadorid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtidcaja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(3, 79, 132));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Total $");

        lbltotal.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lbltotal.setForeground(new java.awt.Color(255, 255, 255));
        lbltotal.setText("0.0");

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Sobrante $");

        lblsobrante.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblsobrante.setForeground(new java.awt.Color(255, 255, 255));
        lblsobrante.setText("0.0");

        lblimporte.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblimporte.setForeground(new java.awt.Color(255, 255, 255));
        lblimporte.setText("0.0");

        lblpago.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        lblpago.setForeground(new java.awt.Color(255, 255, 255));
        lblpago.setText("0.0");

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pago $");

        jLabel4.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Importe $");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha compra: ");

        lblfecha.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblfecha.setForeground(new java.awt.Color(255, 255, 255));
        lblfecha.setText("DD/MM/AA");

        lblhora.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblhora.setForeground(new java.awt.Color(255, 255, 255));
        lblhora.setText("hh:mm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lblpago, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(lblimporte, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblsobrante, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblfecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblhora)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblfecha)
                    .addComponent(lblhora))
                .addGap(2, 2, 2)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbltotal)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblsobrante))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblimporte)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblpago))))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Articulos"));

        btndevolucion.setBackground(new java.awt.Color(255, 255, 255));
        btndevolucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/checkmark.png"))); // NOI18N
        btndevolucion.setText("COMPLETAR");
        btndevolucion.setToolTipText("Realizar devolucion");
        btndevolucion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btndevolucion.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btndevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndevolucionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/64x64/buscarproducto.png"))); // NOI18N

        txtbuscarproducto.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtbuscarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarproductoActionPerformed(evt);
            }
        });

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/cart (1).png"))); // NOI18N
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btneliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/cart add 1.png"))); // NOI18N
        btneliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtbuscarproducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar1)
                .addGap(18, 18, 18)
                .addComponent(btneliminar)
                .addGap(35, 35, 35)
                .addComponent(btndevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(294, 294, 294))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btndevolucion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btneliminar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtbuscarproducto, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Creando objeto de metodos comunes
    logcommon comun = new logcommon();
    logventa logvent = new logventa();
    datosventa dtsvent = new datosventa();
    datosdetalleventa dtsdetventa = new datosdetalleventa();
    logdetalleventa logdetventa = new logdetalleventa();
    logimpuesto logimp = new logimpuesto();
    logarticulo logart = new logarticulo();
    datosarticulo dtsart = new datosarticulo(); 
    logcaja funcCaja = new logcaja();
    datoscaja dtsCaja = new datoscaja();
    servicio_impresion ticket = new servicio_impresion();
    //Declarando variables publicas
    //---------DATOS DE LA VENTA
    public static String idventa="";
    public static String Agentenombre="",agenteapellidos="",agentetelefono="";//DAtos agente, devueltos de dialog
    public static String accion="";
    public Integer totalregistros;//Variable a utilizar como contador
    DefaultTableModel modelo= new DefaultTableModel(){
     public boolean isCellEditable(int row, int column) {return false;}
    };//CReando el objeto de la tabla
    
     //Metodo para insertar un nuevo producto a la tabla
   void mostrardetalleventa(String buscar){
        try {
            modelo=logdetventa.mostrar(buscar);
            tablaventa.setModel(modelo);
            setCellRender(tablaventa);
            formatodetabla();
            calculototal();//Realizando el canculo del importe total
            //setCellRender(tablaventa);
           
        } catch (Exception e) {
          //  JOptionPane.showConfirmDialog(rootPane,"Error llenado tabla"+ e);
        }
    }

    //Metodo para dar formato a la tabla
    void formatodetabla(){
    //Columna isubventa
    tablaventa.getColumnModel().getColumn(0).setMaxWidth(0);
      tablaventa.getColumnModel().getColumn(0).setMinWidth(0);
    tablaventa.getColumnModel().getColumn(0).setPreferredWidth(0);
    //Columna idventa
    tablaventa.getColumnModel().getColumn(1).setMaxWidth(0);
    tablaventa.getColumnModel().getColumn(1).setMinWidth(0);
    tablaventa.getColumnModel().getColumn(1).setPreferredWidth(0);
    //colunma unidades
    tablaventa.getColumnModel().getColumn(2).setPreferredWidth(100);
    //Columna codigo
    tablaventa.getColumnModel().getColumn(3).setPreferredWidth(300);
    //Columna descripcion
    tablaventa.getColumnModel().getColumn(4).setPreferredWidth(1000);
    //Columna Precio unitario
    tablaventa.getColumnModel().getColumn(5).setPreferredWidth(300);
     //Columna precio compra
     tablaventa.getColumnModel().getColumn(6).setMaxWidth(0);
      tablaventa.getColumnModel().getColumn(6).setMinWidth(0);
    tablaventa.getColumnModel().getColumn(6).setPreferredWidth(0);
    //Columna impuesto
    tablaventa.getColumnModel().getColumn(7).setMaxWidth(0);
      tablaventa.getColumnModel().getColumn(7).setMinWidth(0);
    tablaventa.getColumnModel().getColumn(7).setPreferredWidth(0);
     //Columna subtotal
    tablaventa.getColumnModel().getColumn(8).setPreferredWidth(300);
     //Columna observaciones
     tablaventa.getColumnModel().getColumn(9).setMaxWidth(0);
      tablaventa.getColumnModel().getColumn(9).setMinWidth(0);
    tablaventa.getColumnModel().getColumn(9).setPreferredWidth(0); 
    //fecha
     tablaventa.getColumnModel().getColumn(10).setMaxWidth(0);
      tablaventa.getColumnModel().getColumn(10).setMinWidth(0);
    tablaventa.getColumnModel().getColumn(10).setPreferredWidth(0);
    //hora
    tablaventa.getColumnModel().getColumn(11).setMaxWidth(0);
      tablaventa.getColumnModel().getColumn(11).setMinWidth(0);
    tablaventa.getColumnModel().getColumn(11).setPreferredWidth(0);
     //unidades duplicada
    tablaventa.getColumnModel().getColumn(12).setMaxWidth(0);
      tablaventa.getColumnModel().getColumn(12).setMinWidth(0);
    tablaventa.getColumnModel().getColumn(12).setPreferredWidth(0);
    
    }
    //DAr colores a tabla
    public void setCellRender(JTable table) {
        Enumeration<TableColumn> en = table.getColumnModel().getColumns();
        while (en.hasMoreElements()) {
            TableColumn tc = en.nextElement();
            tc.setCellRenderer(new CellRenderer());
        }
    }
    
   
      void obteniendodatosventa(){
          try {
        String []datos = new String[15];
        datos =logvent.mostrarconsultaventas(txtnumventa.getText());
        //Asignandovalores
         txtidventa.setText(datos[0]);
         txtestadoventa.setText(datos[1]);
         lblimporte.setText(datos[2]);
         lblpago.setText(datos[3]);
         lblfecha.setText(datos[4]);
         lblhora.setText(datos[5]);
         txtidcaja.setText(datos[6]);
         txtidcliente.setText(datos[7]);
         txtnombrecliente.setText(datos[8]+" "+datos[9]);
         txtclientenegocio.setText(datos[10]);
         txttipocliente.setText(datos[11]);
         txtlistaprecio.setText(datos[12]);
         txttrabajadorid.setText(datos[13]);
         txttrabajadornombre.setText(datos[14]+" "+datos[15]);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"No encontramosla venta con la clave: " + txtbuscar.getText());
          }
        
    }
    //Metodo que calcula el monto total
    void calculototal(){
    
        double sumatoria=0.0,sobrante=0.0,pagoanterior= Double.parseDouble(lblpago.getText());
        int totalRow= tablaventa.getRowCount();
        totalRow-=1;
        for(int i=0;i<=(totalRow);i++)
        {
           Double  sumatoria1= Double.parseDouble(String.valueOf(tablaventa.getValueAt(i,8)));
//en la parte de arriba indica el primer parametro la fila y el segundo la columna la cual estaras //manejando
             sumatoria+=sumatoria1;
        }
        sobrante=pagoanterior-sumatoria;
        lblsobrante.setText(sobrante+"");
        lbltotal.setText(sumatoria+"");
    }
  
    public boolean existendatosentabla(){
    Double total= Double.parseDouble(lblimporte.getText());
    if(total>0){
    return true;
    }else{
    return false;
    }
    }
    
    void abrirdialogtrabajador(){
     //primero abrimos el dialogo para seleccionar agente
             Frame f = JOptionPane.getFrameForComponent(this);
                dialogtrabajador dialog = new dialogtrabajador(f, true);
                dialog.setSize(600, 300);
                dialog.setLocationRelativeTo(null);
                dialog.setTitle("Eliga al Agente de ventas");
                dialog.padre="consultaventa";
                dialog.setVisible(true);
    }
    void updateventa(){
    //Empezamos seteando los valores necesarios
      
        dtsvent.setIdVenta(Integer.parseInt(txtidventa.getText()));
        Double efectivo, importe, sobrante,pago;
        efectivo= Double.parseDouble(lblpago.getText());
        importe= Double.parseDouble(lbltotal.getText());
        sobrante= Double.parseDouble(lblsobrante.getText());
        pago=efectivo-sobrante;
        try {
            //Calculando dato que se pondra en estado, segun el valor que se genero del efectivo
            if (efectivo>=importe) {
                dtsvent.setEstado("Finalizada");
            }
            if (efectivo<importe) {
                dtsvent.setEstado("Por pagar");
            }
            dtsvent.setImporte(importe);
            dtsvent.setPago(pago);
            dtsvent.setFecha(lblfecha.getText());
            dtsvent.setHora(lblhora.getText());
            dtsvent.setIdCliente(Integer.parseInt(txtidcliente.getText()));
            dtsvent.setIdTrab(Integer.parseInt(txttrabajadorid.getText()));
            dtsvent.setIdCaja(txtidcaja.getText());
            try {//Comienza try
                 if (logvent.editar(dtsvent)) {
                // JOptionPane.showMessageDialog(rootPane, "venta registrada");
            }
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(rootPane, "No puedo llamar a actualizar venta: "+e);
            }//Fin try
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo setear datos de venta, motivo: "+e);
        }
    
    }
    
    void updatedetalleventa(){
   
    TableModel mitabla = tablaventa.getModel();
    logarticulo logart = new logarticulo();
        try {
                int cols = mitabla.getColumnCount();
                int fils = mitabla.getRowCount();
                for(int i=0; i<fils; i++) {
                dtsdetventa.setIdSubventa(Integer.parseInt(mitabla.getValueAt(i,0).toString()));
                Integer ultimaventa=Integer.parseInt(logvent.mostrarultima());//Comezamos por obtener el ultimo idventa invocando y asignando la funcion mostrarultima
                dtsdetventa.setIdVenta(Integer.parseInt(mitabla.getValueAt(i,2).toString()));
                dtsdetventa.setIdArt(mitabla.getValueAt(i,3).toString());
                dtsdetventa.setPrecio(Double.parseDouble(mitabla.getValueAt(i,5).toString()));
                dtsdetventa.setPrecioCompra(Double.parseDouble(mitabla.getValueAt(i,6).toString()));
                dtsdetventa.setUnidades(Integer.parseInt(mitabla.getValueAt(i,2).toString()));
                Double impuesto = Double.parseDouble(mitabla.getValueAt(i,7).toString());
                dtsdetventa.setImpuesto(impuesto);
                dtsdetventa.setSubtotal(Double.parseDouble(mitabla.getValueAt(i,8).toString()));
                dtsdetventa.setFecha(logcommon.fechaactual());
                dtsdetventa.setHora(logcommon.horaactual());
                //Actualizando existencia
                Double comprados, nuevaorden, devueltos;
                comprados=Double.parseDouble(mitabla.getValueAt(i,12).toString());
                nuevaorden=Double.parseDouble(mitabla.getValueAt(i,2).toString());
                devueltos=comprados-nuevaorden;
                logart.existenciasuma(devueltos, mitabla.getValueAt(i,3).toString());//Metodo que modifica existencias
                if (logdetventa.editar(dtsdetventa)) {
                   // JOptionPane.showMessageDialog(rootPane,"Venta realizada");//Borrar
                }

        }//Fin for
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo guardar detalle de venta :"+e);
        }
   
    }
    
    void updatecajaPVTA(){
   
    Double dineroactual= Double.parseDouble(funcCaja.consultadinero(txtidcaja.getText()));
    Double agregado= Double.parseDouble(lblimporte.getText());
    Double update = dineroactual+agregado;
    dtsCaja.setDinero(update);
    dtsCaja.setIdcaja(txtidcaja.getText());
    funcCaja.updatedinero(dtsCaja);
    
    
    }
    
      void llenandotabla(){
        try {
        
        String []datos = new String[19];
        String []datosseleccionados = new String[19];
        datos =logart.mostrarselectivo(txtbuscarproducto.getText());
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
      
      void guardardetalleventa(){
        try {
            String []datos = new String[19];
        String []datosseleccionados = new String[19];
        datos =logart.mostrarselectivo(txtbuscarproducto.getText());
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
            Integer idpreventa_actual=Integer.parseInt(txtidventa.getText());//Comezamos por obtener el  idventaobteniendolo de la caja de texto correspondiente
                dtsdetventa.setIdVenta(idpreventa_actual);
                dtsdetventa.setIdArt(datosseleccionados[1]);
                dtsdetventa.setPrecio(Double.parseDouble(datosseleccionados[3]));
                dtsdetventa.setPrecioCompra(Double.parseDouble(datosseleccionados[7]));
                dtsdetventa.setUnidades(1);
                Double impuesto = Double.parseDouble(datosseleccionados[8]);
                dtsdetventa.setImpuesto(impuesto);
                //dtsdetventa.setSubtotal(Double.parseDouble(mitabla.getValueAt(i,4).toString()));
                dtsdetventa.setFecha(logcommon.fechaactual());
                dtsdetventa.setHora(logcommon.horaactual());
                //Actualizando existencia
                // logart.existenciaresta(Double.parseDouble(mitabla.getValueAt(i,0).toString()), mitabla.getValueAt(i,1).toString());
                if (logdetventa.insertar(dtsdetventa)) {
                   // JOptionPane.showMessageDialog(rootPane,"Venta realizada");//Borrar
                }
        }
               

        
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo guardar detalle de venta :"+e);
        }
   
    }

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
    
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtlistaprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlistaprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlistaprecioActionPerformed

    private void tablaventaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaventaKeyReleased
      
    }//GEN-LAST:event_tablaventaKeyReleased

    private void tablaventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaventaMouseClicked
       DefaultTableModel dtm = (DefaultTableModel) tablaventa.getModel(); //TableProducto es el nombre de mi tabla ;) 
       int fila= tablaventa.getSelectedRow();
       int columna = tablaventa.getSelectedColumn();
       
       //En caso de presionar ssobre la cantidad de productos
       if (columna==2) {
       int valor= Integer.parseInt(""+tablaventa.getValueAt(fila, 12));
       int nuevacantidad= Integer.parseInt(JOptionPane.showInputDialog("CANTIDAD DE PRODUCTOS"));
           if (nuevacantidad<=valor) {
               //Indicando el nuevo valor de la cantidad
       tablaventa.setValueAt(nuevacantidad, fila, 2);
       //Indicando el nuevo valor del importe
       double importe = Double.parseDouble(""+tablaventa.getValueAt(fila, 2)) * Double.parseDouble(""+tablaventa.getValueAt(fila, 5));
       tablaventa.setValueAt(importe, fila, 8);
           }else{
            JOptionPane.showMessageDialog(null,"El cantidad de articulos debe ser menor al vendido, solo vendio "+valor);
           }
       
        }
       
        //En caso de presionar ssobre la el precio unitario
        //El numero se debe cambiar a 5 si desea cambiar precio, para el caso de las devoluciones no por el momento
        if (columna==13) {
       Double unidades= Double.parseDouble(""+tablaventa.getValueAt(fila, 2));  
       Double preciocompra= Double.parseDouble(""+tablaventa.getValueAt(fila, 6));     
       Double precioventa= Double.parseDouble(""+tablaventa.getValueAt(fila, 5));
       Double nuevoprecio= Double.parseDouble(JOptionPane.showInputDialog("PRECIO"));
            if (nuevoprecio<preciocompra) {
                JOptionPane.showMessageDialog(null,"Ingrese un precio mayor al precio de compra $ "+preciocompra);
            }else{
             //Indicando el nuevo valor de la cantidad
       tablaventa.setValueAt(nuevoprecio, fila, 5);
       //Indicando el nuevo valor del importe
       double importe = unidades*nuevoprecio;
       tablaventa.setValueAt(importe, fila, 8);
        txtbuscar.requestFocus(true);//Le regreso el foco a la caja de busqueda
            }
      
       }
      
         calculototal();
    }//GEN-LAST:event_tablaventaMouseClicked

    public void tableChanged(java.awt.event.MouseEvent evt) {
         
                 
         
      }
    
    private void tablaventaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tablaventaPropertyChange

    }//GEN-LAST:event_tablaventaPropertyChange

    private void btndevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndevolucionActionPerformed
        //No iniciar a guardar en caso de no haber compra
        if (existendatosentabla()) {
            //Si hay datos en tabla no hago nada
        }else{
             JOptionPane.showMessageDialog(rootPane, "Primero agrege productos a la venta");
            return;}
        if (txttipodocumento.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un tipo de documento");
            return;
        }
        try {
            try {
                updateventa();
                updatedetalleventa();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Tenemos un problema al guardar carrito de compra(btncerrarventa) "+e);
            }
             try {
                if(txttipodocumento.getText().equals("Ticket")){
                     ticket.imprimiendo_ticket_venta(Integer.parseInt(txtnumventa.getText()),Double.parseDouble(frmpuntoconsultapreventa.lblpago.getText()));
                }
           //Se genera la nota de venta
           if(txttipodocumento.getText().equals("Nota")){
         abrirdialogtrabajador();
          //Class.forName("com.mysql.jdbc.Driver");
          Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartpos", "root", "");
          JasperReport jr= (JasperReport)JRLoader.loadObject(getClass().getResource("/Reportes/Notaventa.jasper"));
          Map parametros = new HashMap<String,Object>();
          logoconsultaventa=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/logo.jpg"));
          imagenaguaconsultaventa=new javax.swing.ImageIcon(frmpuntoconsultapreventa.class.getResource("/Img/Logo/agua.png"));  
          parametros.put("idventa", Integer.parseInt(txtidventa.getText()));
          parametros.put("nombreagente", Agentenombre);
          parametros.put("apellidoagente", agenteapellidos);
          parametros.put("telagente", agentetelefono);
          parametros.put("obs", "Reimpresión y/o devolución");
          parametros.put("logo", logoconsultaventa.getImage());
          parametros.put("marcaagua", imagenaguaconsultaventa.getImage());
            JasperPrint jp=  JasperFillManager.fillReport(jr, parametros,conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            conexion.close();
               
         /* Class.forName("com.mysql.jdbc.Driver");
           Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartpos", "root", "");
            JasperReport jr= (JasperReport)JRLoader.loadObject(frmpruebareportes.class.getResource("/Reportes/Notaventa.jasper"));
            Map parametros = new HashMap<String,Object>();
            logo=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/fm.jpg"));
            imagenagua=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/fm.jpg"));
            parametros.put("nombreagente", frminicio.lblnombretrabajador.getText());
            parametros.put("logo", logo.getImage());
            parametros.put("marcaagua", imagenagua.getImage());
            JasperPrint jp=  JasperFillManager.fillReport(jr, parametros,conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            conexion.close();
         */
            }
               
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "OOPPSS... Poblemas con el documento  "+e);
            }
        
        //Update dinero en caja
          funcCaja.cajaresta(Double.parseDouble(lblsobrante.getText()),txtidcaja.getText());
            try {
            //Limpiando tabla
           // DefaultTableModel modelo2=(DefaultTableModel) tablaventa.getModel();
            int filas = tablaventa.getRowCount();
            try {
                  for (int i = 0;i<=filas; i++) {
           modelo.removeRow(0);
         }
        //Fin de limpiar las filas
        
            } catch (Exception e) {
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Esta tabla me da problemas (btncerrarventa) "+e);
            }
            lblimporte.setText("0.00");//
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo cerrar la venta: "+e);
        }
        
    }//GEN-LAST:event_btndevolucionActionPerformed

    private void txttipoclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttipoclienteMouseClicked
       
    }//GEN-LAST:event_txttipoclienteMouseClicked

    private void txttipoclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttipoclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttipoclienteActionPerformed

    private void txttipodocumentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttipodocumentoMouseClicked
        //Acion al dar clic sobre la caja de texto tipo de documento
        try {
        Frame f = JOptionPane.getFrameForComponent(this);
         dialogpvtipodoc dialog = new dialogpvtipodoc(f, true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(null);
        dialog.accion="Modificar";
        dialog.setVisible(true);
        
        txttipocliente.requestFocus();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error: " + e);
        }
    }//GEN-LAST:event_txttipodocumentoMouseClicked

    private void txttipodocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttipodocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttipodocumentoActionPerformed

    private void txtnumventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnumventaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumventaMouseClicked

    private void txtnumventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumventaActionPerformed
     obteniendodatosventa();
     mostrardetalleventa(txtnumventa.getText());
    }//GEN-LAST:event_txtnumventaActionPerformed

    private void txtestadoventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtestadoventaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtestadoventaMouseClicked

    private void txtestadoventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtestadoventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtestadoventaActionPerformed

    private void txtidventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtidventaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidventaMouseClicked

    private void txtidventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidventaActionPerformed

    private void txtidclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtidclienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidclienteMouseClicked

    private void txtidclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidclienteActionPerformed

    private void txtnombreclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtnombreclienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreclienteMouseClicked

    private void txtnombreclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreclienteActionPerformed

    private void txttrabajadoridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttrabajadoridMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txttrabajadoridMouseClicked

    private void txttrabajadoridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttrabajadoridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttrabajadoridActionPerformed

    private void txttrabajadornombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txttrabajadornombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txttrabajadornombreMouseClicked

    private void txttrabajadornombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttrabajadornombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttrabajadornombreActionPerformed

    private void txtidcajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtidcajaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidcajaMouseClicked

    private void txtidcajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidcajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidcajaActionPerformed

    private void txtclientenegocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtclientenegocioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclientenegocioMouseClicked

    private void txtclientenegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclientenegocioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclientenegocioActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtbuscarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarproductoActionPerformed
        
        llenandotabla();
        setCellRender(tablaventa);
        txtbuscar.selectAll();
        calculototal();
    }//GEN-LAST:event_txtbuscarproductoActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tablaventa.getModel(); //TableProducto es el nombre de mi tabla ;)
        int fila= tablaventa.getSelectedRow();
        dtm.removeRow(fila);
        calculototal();
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btneliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminar1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmpuntoconsultapreventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmpuntoconsultapreventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmpuntoconsultapreventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmpuntoconsultapreventa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmpuntoconsultapreventa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndevolucion;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btneliminar1;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblhora;
    public static javax.swing.JLabel lblimporte;
    public static javax.swing.JLabel lblpago;
    public static javax.swing.JLabel lblsobrante;
    public static javax.swing.JLabel lbltotal;
    public static javax.swing.JTable tablaventa;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtbuscarproducto;
    public static javax.swing.JTextField txtclientenegocio;
    public static javax.swing.JTextField txtestadoventa;
    public static javax.swing.JTextField txtidcaja;
    public static javax.swing.JTextField txtidcliente;
    public static javax.swing.JTextField txtidventa;
    public static javax.swing.JTextField txtlistaprecio;
    public static javax.swing.JTextField txtnombrecliente;
    public static javax.swing.JTextField txtnumventa;
    public static javax.swing.JTextField txttipocliente;
    public static javax.swing.JTextField txttipodocumento;
    public static javax.swing.JTextField txttrabajadorid;
    public static javax.swing.JTextField txttrabajadornombre;
    // End of variables declaration//GEN-END:variables
}
