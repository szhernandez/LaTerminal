/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.datosarticulo;
import Datos.datoscaja;
import Datos.datosdetalle_equipaje;
import Datos.datosdetalleventa;
import Datos.datosequipaje;
import Datos.datosimpresoras;
import Datos.datosventa;
import Logica.CellRenderer;
import Logica.logarticulo;
import Logica.logcaja;
import Logica.logcommon;
import Logica.logdetalleequipaje;
import Logica.logdetalleventa;
import Logica.logequipaje;
import Logica.logimpresoras;
import Logica.logventa;
import Logica.logimpuesto;
import Logica.logticket;
import Logica.servicio_impresion;
import static Presentacion.frminicio.escritorio;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Window;
import java.awt.print.PrinterJob;
import static java.lang.Math.log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.swing.ImageIcon;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ZAIR
 */
public class frmpv_equipaje extends javax.swing.JFrame {

    /**
     * Creates new form frmpuntoventa
     */
    public frmpv_equipaje() {
        initComponents();
       
      
       txtcliente.setEditable(false);
      
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
       Spinnerunidades.setValue(1);
        
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        txtlistaprecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Spinnerunidades = new javax.swing.JSpinner();
        btngenerar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtpropietario = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtobservaciones = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        txtcobro_propietario = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txthorainicial = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txthorafinal = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtminutos = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtcosto = new javax.swing.JTextField();
        txtobservaciones1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtestado = new javax.swing.JTextField();
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
        jLabel5 = new javax.swing.JLabel();
        lblcantidad = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbltiempo = new javax.swing.JLabel();
        panelvariables1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Punto de venta");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(0, 204, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 204, 51));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generar servicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Propietario");

        txtcliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtcliente.setOpaque(false);
        txtcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtclienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtclienteMouseEntered(evt);
            }
        });
        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });

        txtlistaprecio.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtlistaprecio.setFocusable(false);
        txtlistaprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlistaprecioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Precio Aplic");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Maletas");

        Spinnerunidades.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Spinnerunidades.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SpinnerunidadesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SpinnerunidadesFocusLost(evt);
            }
        });
        Spinnerunidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SpinnerunidadesKeyReleased(evt);
            }
        });

        btngenerar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btngenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/32x32/icons8_Thumbs_Up_32px.png"))); // NOI18N
        btngenerar.setText("Generar");
        btngenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngenerarActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setText("Codigo");

        txtcodigo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtcodigo.setText("E001");
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Tipo Cliente");

        txtpropietario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtpropietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpropietarioActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setText("Observaciones");

        txtobservaciones.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtobservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtobservacionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jLabel13))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtobservaciones)
                    .addComponent(txtcliente, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtlistaprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(Spinnerunidades, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(btngenerar)
                .addGap(123, 123, 123))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlistaprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngenerar)
                    .addComponent(Spinnerunidades, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpropietario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtobservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Servicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/64x64/buscarproducto.png"))); // NOI18N

        txtbuscar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        txtcobro_propietario.setEditable(false);
        txtcobro_propietario.setBackground(new java.awt.Color(255, 255, 255));
        txtcobro_propietario.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtcobro_propietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcobro_propietarioActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Propietario");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setText("Hora Inicial");

        txthorainicial.setEditable(false);
        txthorainicial.setBackground(new java.awt.Color(255, 255, 255));
        txthorainicial.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txthorainicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthorainicialActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setText("Hora final");

        txthorafinal.setEditable(false);
        txthorafinal.setBackground(new java.awt.Color(255, 255, 255));
        txthorafinal.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txthorafinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthorafinalActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Minutos");

        txtminutos.setEditable(false);
        txtminutos.setBackground(new java.awt.Color(255, 255, 255));
        txtminutos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtminutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtminutosActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setText("Costo por maleta");

        txtcosto.setEditable(false);
        txtcosto.setBackground(new java.awt.Color(255, 255, 255));
        txtcosto.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtcosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcostoActionPerformed(evt);
            }
        });

        txtobservaciones1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtobservaciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtobservaciones1ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setText("Observaciones");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setText("Estado");

        txtestado.setEditable(false);
        txtestado.setBackground(new java.awt.Color(255, 255, 255));
        txtestado.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtestadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(393, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtobservaciones1)
                    .addComponent(txtcobro_propietario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txthorainicial, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthorafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txtminutos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcobro_propietario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthorainicial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthorafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtobservaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtminutos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelvariables.setBackground(new java.awt.Color(3, 79, 132));
        panelvariables.setForeground(new java.awt.Color(255, 255, 255));

        lbl_idtrabajador.setText("idTrabajador");

        lbl_idcaja.setText("idcaja");

        lblefectivo.setText("lblefectivo");

        lblcambio.setText("cambio");

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

        jLabel5.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Horas:");

        lblcantidad.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        lblcantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblcantidad.setText("\"\"");

        jLabel11.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Maletas:");

        lbltiempo.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        lbltiempo.setForeground(new java.awt.Color(255, 255, 255));
        lbltiempo.setText("\"\"");

        javax.swing.GroupLayout panelvariablesLayout = new javax.swing.GroupLayout(panelvariables);
        panelvariables.setLayout(panelvariablesLayout);
        panelvariablesLayout.setHorizontalGroup(
            panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelvariablesLayout.createSequentialGroup()
                .addGroup(panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelvariablesLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lbl_idtrabajador)
                        .addGap(10, 10, 10)
                        .addComponent(lblcambio)
                        .addGap(10, 10, 10)
                        .addComponent(lblefectivo2)
                        .addGap(29, 29, 29)
                        .addComponent(lblefectivo)
                        .addGap(33, 33, 33)
                        .addComponent(lbl_idcaja)
                        .addGap(30, 30, 30)
                        .addComponent(lblnombrenegocio)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelvariablesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addGap(31, 31, 31)
                        .addComponent(lblcantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbltiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                        .addGap(46, 46, 46)))
                .addGroup(panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelvariablesLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelvariablesLayout.createSequentialGroup()
                        .addComponent(lbladeudo)
                        .addGap(18, 18, 18)
                        .addComponent(lblnombrecliente)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_idcliente)))
                .addContainerGap())
        );
        panelvariablesLayout.setVerticalGroup(
            panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelvariablesLayout.createSequentialGroup()
                .addGroup(panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_idtrabajador)
                    .addComponent(lblcambio)
                    .addComponent(lblefectivo2)
                    .addGroup(panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblefectivo)
                        .addComponent(lbl_idcaja)
                        .addComponent(lblnombrenegocio)
                        .addComponent(lbladeudo)
                        .addComponent(lblnombrecliente)
                        .addComponent(lbl_idcliente)))
                .addGroup(panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelvariablesLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelvariablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(lbltiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(lblcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(panelvariablesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
        );

        panelvariables1.setBackground(new java.awt.Color(3, 79, 132));
        panelvariables1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("GUARDA EQUIPAJE");

        javax.swing.GroupLayout panelvariables1Layout = new javax.swing.GroupLayout(panelvariables1);
        panelvariables1.setLayout(panelvariables1Layout);
        panelvariables1Layout.setHorizontalGroup(
            panelvariables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelvariables1Layout.setVerticalGroup(
            panelvariables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelvariables1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelvariables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelvariables1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelvariables1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelvariables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Creando objeto de metodos comunes
    logcommon comun = new logcommon();
    logequipaje logequip = new logequipaje();
    datosdetalle_equipaje dtsdetalle_equi = new datosdetalle_equipaje();
    logdetalleequipaje logdet_equipaje = new logdetalleequipaje();
    logimpuesto logimp = new logimpuesto();
    logimpresoras logimpre = new logimpresoras();
    datosimpresoras dtsimpre = new datosimpresoras();
    servicio_impresion s_impresiones = new servicio_impresion();
    //Declarando variables publicas
    public static String Agentenombre="",agenteapellidos="",agentetelefono="";//DAtos agente, devueltos de dialog
    public  static ImageIcon logo,imagenagua;
    int a=0;//Esta variable a, sirve como contador para escuchar la tecla enter en el
            //Sppiner que asigna la cantidad de maletas. al obtener el foco el automatico lo muestra como enter y esto lo evita
     
   // public static Double pago;
    public Integer totalregistros;//Variable a utilizar como contador
    DefaultTableModel modelo= new DefaultTableModel(){
    
     public boolean isCellEditable(int row, int column) {return false;}
    };//CReando el objeto de la tabla
    
    void generarservicio(){
        try {
             if(txtcliente.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Debes ingresar un cliente"); 
            return;
        }
        guardandoequipaje();
        guardardetalleequipaje();
         txtpropietario.setText("");
       txtobservaciones.setText("");   
       Spinnerunidades.setValue(1);
       
        
      
        } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, "Tenemos un problema al generar un servicio"+e);
        }
        s_impresiones.imprimiendo_comprobante();
        int piezas=Integer.parseInt(Spinnerunidades.getValue().toString());
        for( int i=0 ; i<piezas; i++)
        {
            s_impresiones.imprimiendo_etiquetas();
        }
    
    }
    
    void cobrarservicio(){
     //No iniciar a guardar en caso de no haber compra
        if (lbltotal.getText().equals("0.00")) {
            JOptionPane.showMessageDialog(rootPane, "Debe de ingresar los datos de un servicio a cobrar");
            return;
        }
         if(txtestado.getText().equals("Finalizada")){
            JOptionPane.showMessageDialog(null,"Este ticket se ya ha sido cobrado anteriormente"); 
            return;
        }
        try {
        abrirventanacobro();
        
            try {
                updateequipaje();
                updatedetalleequipaje();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Tenemos un problema al guardar equipaje(btncerrarventa) "+e);
            }
             try {
               
            //Se genera la nota de venta
          s_impresiones.imprimiendo_ticket_equipaje();
               
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "OOPPSS... Poblemas con el documento (btncerrarventa) "+e);
            }
        
        //Update dinero en caja
        updatecajaPVTA();
        limpiando_despuesdelcobro();
           
       
         lbltotal.setText("0.00");//
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo cerrar la venta: "+e);
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
        frmcobro_equipaje ventanacobro = new frmcobro_equipaje(dialogo,lbltotal.getText());//Se envia el importe a cobrar mediante el contructor
        dialogo.add(ventanacobro.getContentPane());
        dialogo.setModal(true);
       
        dialogo.setTitle("Ventana de cobro(Equipaje de "+txtcobro_propietario.getText()+")");
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
      void abrirventanacambio(){
    try {
        /*Esta ventana se habre de manera especial
        se creo un dialog, el contenido del dialogo sera el que se encuentra dentro del frame
        frmcobro, estos elementos se pasan con la propiedad .getContenPane
        Dentro del frmcobro se creo un nuevo contructor con un elemento dialog
        esto sirve para poder manupular el dialog desde el frame
        ademas se agrego una cadena que se desea pasar
        */
       dialogvacio dialogo = new dialogvacio(null, true);
        frmcambio ventanacambio = new frmcambio(dialogo,lblcambio.getText());//Se envia el importe a cobrar mediante el contructor
        dialogo.add(ventanacambio.getContentPane());
        dialogo.setModal(true);
       
        dialogo.setTitle("Ventana de cobro(Equipaje de "+txtcobro_propietario.getText()+")");
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
    void guardandoequipaje(){
    //Empezamos seteando los valores necesarios
        datosequipaje dts = new datosequipaje();
        logequipaje log = new logequipaje();
        
        Double efectivo=0.00, importe=0.00;
        try {//En caso de que las labels ya tengan datos se realizara, de lo contrario no.
             efectivo= Double.parseDouble(lblefectivo.getText());
             importe= Double.parseDouble(lbltotal.getText());
        } catch (Exception e) {
        }
       
        
        try {
            dts.setPropietario(txtpropietario.getText());
            dts.setEstado("En curso");
            dts.setImporte(importe);
            dts.setPago(efectivo);
            dts.setFecha(comun.fechaactual());
            dts.setHora(comun.horaactual());
            dts.setIdCliente(Integer.parseInt(lbl_idcliente.getText()));
            dts.setIdTrab(Integer.parseInt(lbl_idtrabajador.getText()));
            dts.setIdCaja(lbl_idcaja.getText());
            try {//Comienza try
                 if (log.insertar(dts)) {
                // JOptionPane.showMessageDialog(rootPane, "equipaje registrado");
            }
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(rootPane, "No puedo llamar a guardar equipaje: "+e);
            }//Fin try
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo setear datos de equipaje, motivo: "+e);
        }
    
    }
    
    void updateequipaje(){
    //Empezamos seteando los valores necesarios
        datosequipaje dts = new datosequipaje();
        logequipaje log = new logequipaje();
        
        Double efectivo=0.00, importe=0.00;
        try {
            efectivo= Double.parseDouble(lblefectivo.getText());
            importe= Double.parseDouble(lbltotal.getText());
            dts.setPropietario(txtcobro_propietario.getText());
            dts.setEstado("Finalizada");
            dts.setImporte(importe);
            dts.setPago(efectivo);
            dts.setFecha(comun.fechaactual());
            dts.setHora(comun.horaactual());
            dts.setIdCliente(Integer.parseInt(lbl_idcliente.getText()));
            dts.setIdTrab(Integer.parseInt(lbl_idtrabajador.getText()));
            dts.setIdCaja(lbl_idcaja.getText());
            dts.setIdEquipaje(Integer.parseInt(txtbuscar.getText()));
            try {//Comienza try
                 if (log.editar(dts)) {
                // JOptionPane.showMessageDialog(rootPane, "equipaje modificado");
            }
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(rootPane, "No puedo llamar a guardar equipaje: "+e);
            }//Fin try
           
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo setear datos de equipaje, motivo: "+e);
        }
    
    }
    
    void guardardetalleequipaje(){
   
    logarticulo logart = new logarticulo();
       try {
       
            logarticulo ins = new logarticulo();
            datosarticulo dts = new datosarticulo();
            String []datos = new String[19];
            String []datosseleccionados = new String[19];
            datos =ins.mostrarselectivo(txtcodigo.getText());
           
            //Checando precio
            String pvAplicable= txtlistaprecio.getText();
            Double Precio; 
              dtsdetalle_equi.setPrecio(0.00);
               
        datosseleccionados[3]= "Precio Desconocido";//Precio de venta
            if (pvAplicable.equals("Precio 1")) {
                dtsdetalle_equi.setPrecio(Double.parseDouble(datos[6]));
            }
            if (pvAplicable.equals("Precio 2"))  {
                 dtsdetalle_equi.setPrecio(Double.parseDouble(datos[7]));
            }
            if (pvAplicable.equals("Precio 3"))  {
                  dtsdetalle_equi.setPrecio(Double.parseDouble(datos[8]));
            }
            if (pvAplicable.equals("Precio 4"))  {
               dtsdetalle_equi.setPrecio(Double.parseDouble(datos[9]));
            }
            if (pvAplicable.equals("Precio 5"))  {
               dtsdetalle_equi.setPrecio(Double.parseDouble(datos[10]));
            }
                Integer ultima=Integer.parseInt(logequip.mostrarultima());//Comezamos por obtener el ultimo idventa invocando y asignando la funcion mostrarultima
                dtsdetalle_equi.setIdEquipaje(ultima);
                dtsdetalle_equi.setIdArt(txtcodigo.getText());
                dtsdetalle_equi.setPrecioCompra(Double.parseDouble(datos[5]));
                
                dtsdetalle_equi.setUnidades(Integer.parseInt(Spinnerunidades.getValue().toString()));
                
                Double impuesto = (Double.parseDouble(datos[9]));
                dtsdetalle_equi.setImpuesto(impuesto);
                dtsdetalle_equi.setTiempo(0.00);
                dtsdetalle_equi.setSubtotal(0.00);
                dtsdetalle_equi.setObserv(txtobservaciones.getText());
                dtsdetalle_equi.setFechainicio(logcommon.fechayhora());
                dtsdetalle_equi.setFechafin(logcommon.fechayhora());
                //Actualizando existencia
             //   logart.existenciaresta(Double.parseDouble(mitabla.getValueAt(i,0).toString()), mitabla.getValueAt(i,1).toString());
                if (logdet_equipaje.insertar(dtsdetalle_equi)) {
                    JOptionPane.showMessageDialog(rootPane,"Detalles registrados");//Borrar
                }else{ JOptionPane.showMessageDialog(rootPane,"Venta NO realizada");}//Borrar}

     
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo guardar detalle de equipaje :"+e);
        }
               
   
    }
     void updatedetalleequipaje(){
   
    logarticulo logart = new logarticulo();
       try {
       
            logarticulo ins = new logarticulo();
            datosarticulo dts = new datosarticulo();
            String []datos = new String[19];
            String []datosseleccionados = new String[19];
            datos =ins.mostrarselectivo(txtcodigo.getText());
           
            //Checando precio
            String pvAplicable= txtlistaprecio.getText();
            Double Precio; 
              dtsdetalle_equi.setPrecio(0.00);
        
        datosseleccionados[3]= "Precio Desconocido";//Precio de venta
            if (pvAplicable.equals("Precio 1")) {
                dtsdetalle_equi.setPrecio(Double.parseDouble(datos[6]));
            }
            if (pvAplicable.equals("Precio 2"))  {
                 dtsdetalle_equi.setPrecio(Double.parseDouble(datos[7]));
            }
            if (pvAplicable.equals("Precio 3"))  {
                  dtsdetalle_equi.setPrecio(Double.parseDouble(datos[8]));
            }
            if (pvAplicable.equals("Precio 4"))  {
               dtsdetalle_equi.setPrecio(Double.parseDouble(datos[9]));
            }
            if (pvAplicable.equals("Precio 5"))  {
               dtsdetalle_equi.setPrecio(Double.parseDouble(datos[10]));
            }
                
                dtsdetalle_equi.setIdArt(txtcodigo.getText());
                dtsdetalle_equi.setPrecioCompra(Double.parseDouble(datos[5]));
                
               // dtsdetalle_equi.setUnidades(Integer.parseInt(Spinnerunidades.getValue().toString()));
                
                Double impuesto = (Double.parseDouble(datos[9]));
                dtsdetalle_equi.setImpuesto(impuesto);
                dtsdetalle_equi.setTiempo(Double.parseDouble(lbltiempo.getText()));
                dtsdetalle_equi.setSubtotal(Double.parseDouble(lbltotal.getText()));
                dtsdetalle_equi.setObserv(txtobservaciones.getText());
                dtsdetalle_equi.setFechainicio(txthorainicial.getText());
                dtsdetalle_equi.setFechafin(txthorafinal.getText());
                dtsdetalle_equi.setIdEquipaje(Integer.parseInt(txtbuscar.getText()));
                //Actualizando existencia
             //   logart.existenciaresta(Double.parseDouble(mitabla.getValueAt(i,0).toString()), mitabla.getValueAt(i,1).toString());
                if (logdet_equipaje.editar(dtsdetalle_equi)) {
                    JOptionPane.showMessageDialog(rootPane,"Venta realizada");//Borrar
                }else{ JOptionPane.showMessageDialog(rootPane,"Venta NO realizada");}//Borrar}

     
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "No puedo guardar detalle de equipaje :"+e);
        }
               
   
    }
    void consultaequipaje(){
    
     String []datos = new String[30];
        datos=logequip.mostrarconsultaequipaje(txtbuscar.getText());
         if (datos[2].length()==0) {
        JOptionPane.showConfirmDialog(null,"No encontramos el ticket solicitado con la clave: " + txtbuscar.getText());
        }
        txthorainicial.setText(datos[24]);
        txthorafinal.setText(logcommon.fechayhora());
        lblcantidad.setText(datos[20]);
        txtcosto.setText(datos[18]);
        lbl_idcliente.setText(datos[8]);
        txtobservaciones1.setText(datos[23]);
        txtestado.setText(datos[2]);
        txtcobro_propietario.setText(datos[1]);
        //Calculando tiempo
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strFecha1 = txthorainicial.getText();
        String strFecha2 = txthorafinal.getText();
        Date fechaInicio = null, fechaFin=null;
        try {
        fechaInicio = formatoDelTexto.parse(strFecha1);
        fechaFin = formatoDelTexto.parse(strFecha2);
        long FI,FF,RS;
        Double conversion,tiempo,total,cantidadmaletas,precio;
        FI=fechaInicio.getTime();
        FF=fechaFin.getTime();
        RS=(FF-FI)/(1000*60);
        txtminutos.setText(RS+"");
        //Redondeando tiempo
        conversion=(Double.parseDouble(RS+""));
        tiempo=Math.ceil(conversion/60);//Redondiamos de techo
        lbltiempo.setText(tiempo+"");
        cantidadmaletas=Double.parseDouble(datos[20]);
        precio=Double.parseDouble(datos[18]);
        total=tiempo*cantidadmaletas*precio;
        lbltotal.setText(""+total);
       
        } catch (ParseException ex) {
        ex.printStackTrace();
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
    
 
   
     
    public void limpiando_despuesdelcobro(){
      txtcobro_propietario.setText("");
      txthorainicial.setText("");
      txthorafinal.setText("");
      txtobservaciones1.setText("");
      txtestado.setText("");
      txtminutos.setText("");
      txtcosto.setText("");
      lblcantidad.setText("");
      lbltiempo.setText("");
      lbltotal.setText("");
      }

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
     if(txtcliente.getText().length()==0){
            JOptionPane.showMessageDialog(null,"Debes ingresar un cliente");
            return;
        }
     
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void txtlistaprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlistaprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlistaprecioActionPerformed

   
    
    private void txtclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtclienteMouseClicked
        try {
        Frame f = JOptionPane.getFrameForComponent(this);
        dialogpvcliente dialog = new dialogpvcliente(f, true);
       // dialog.setSize(600, 300);
        dialog.setLocationRelativeTo(null);
        dialog.accion="Equipaje";
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

    private void btngenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngenerarActionPerformed
        generarservicio();
    }//GEN-LAST:event_btngenerarActionPerformed

    private void txtclienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtclienteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteMouseEntered

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
    consultaequipaje();
    txtbuscar.selectAll();
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtpropietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpropietarioActionPerformed
       txtobservaciones.requestFocus();
    }//GEN-LAST:event_txtpropietarioActionPerformed

    private void txtcobro_propietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcobro_propietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcobro_propietarioActionPerformed

    private void txthorainicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthorainicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthorainicialActionPerformed

    private void txthorafinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthorafinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthorafinalActionPerformed

    private void txtobservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtobservacionesActionPerformed
        Spinnerunidades.requestFocus();
    }//GEN-LAST:event_txtobservacionesActionPerformed

    private void txtminutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtminutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtminutosActionPerformed

    private void txtcostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcostoActionPerformed

    private void txtobservaciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtobservaciones1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtobservaciones1ActionPerformed

    private void txtestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtestadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtestadoActionPerformed

    private void SpinnerunidadesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SpinnerunidadesKeyReleased
        
        if(evt.getKeyCode() == evt.VK_ENTER){ 
            a=a+1;
            if (a>1) {
            generarservicio();
            a=0;
            }
      
        } 
    }//GEN-LAST:event_SpinnerunidadesKeyReleased

    private void SpinnerunidadesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SpinnerunidadesFocusGained
       Spinnerunidades.getEditor().getComponent(0).setBackground(new java.awt.Color(155, 212, 253));
    }//GEN-LAST:event_SpinnerunidadesFocusGained

    private void SpinnerunidadesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SpinnerunidadesFocusLost
      Spinnerunidades.getEditor().getComponent(0).setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_SpinnerunidadesFocusLost

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        

    }//GEN-LAST:event_txtbuscarKeyPressed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
       if (evt.getKeyCode() == evt.VK_F5){
       cobrarservicio();
       }
    }//GEN-LAST:event_txtbuscarKeyReleased

    
    
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
            java.util.logging.Logger.getLogger(frmpv_equipaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmpv_equipaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmpv_equipaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmpv_equipaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmpv_equipaje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner Spinnerunidades;
    private javax.swing.JButton btngenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lbl_idcaja;
    public static javax.swing.JLabel lbl_idcliente;
    public static javax.swing.JLabel lbl_idtrabajador;
    public static javax.swing.JLabel lbladeudo;
    public static javax.swing.JLabel lblcambio;
    private javax.swing.JLabel lblcantidad;
    public static javax.swing.JLabel lblefectivo;
    public static javax.swing.JLabel lblefectivo2;
    public static javax.swing.JLabel lblnombrecliente;
    public static javax.swing.JLabel lblnombrenegocio;
    private javax.swing.JLabel lbltiempo;
    public static javax.swing.JLabel lbltotal;
    private javax.swing.JPanel panelvariables;
    private javax.swing.JPanel panelvariables1;
    public static javax.swing.JTextField txtbuscar;
    public static javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtcobro_propietario;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtcosto;
    private javax.swing.JTextField txtestado;
    private javax.swing.JTextField txthorafinal;
    private javax.swing.JTextField txthorainicial;
    public static javax.swing.JTextField txtlistaprecio;
    private javax.swing.JTextField txtminutos;
    private javax.swing.JTextField txtobservaciones;
    private javax.swing.JTextField txtobservaciones1;
    public static javax.swing.JTextField txtpropietario;
    // End of variables declaration//GEN-END:variables
}
