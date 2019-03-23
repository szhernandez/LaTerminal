/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.datoscaja;
import Datos.datosimpresoras;
import Presentacion.frmcaja_corte;
import Presentacion.frminicio;
import Presentacion.frmpuntoventa;
import Presentacion.frmpv_equipaje;
import static Presentacion.frmpv_equipaje.logo;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
public class servicio_impresion {
    logequipaje logequip = new logequipaje();
    logventa logvent = new logventa();
     logcompra logcompra = new logcompra();
    public static String imp_tickets,imp_notas,imp_etiquetas;//Definiendo impresoras
    //creando objetos
    logimpresoras logimpre = new logimpresoras();
    logmovimientos_caja logmov = new logmovimientos_caja();
    //variables para logos
     public  static ImageIcon logo,imagenagua;
    public void obteniendoimpresoras(){
    String [] registro = new String [19];
    registro=logimpre.mostrar(frminicio.lblidcaja.getText());//Esta funcion siempre debe de tener la impresora definida
    imp_tickets=(registro[1]);
    imp_notas=(registro[2]);
    imp_etiquetas=(registro[3]);
    }
   public void imprimiendo_comprobante(){
        try {
            obteniendoimpresoras();
            logo=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/logo.jpg"));
          //imagenagua=new javax.swing.ImageIcon(frmpv_equipaje.class.getResource("/Img/Logo/agua.png")); 
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartpos_terminal", "root", "");
            JasperReport jr= (JasperReport)JRLoader.loadObject(frmpv_equipaje.class.getResource("/Reportes/comprobante_guardaequipaje.jasper"));
            Map parametros = new HashMap<String,Object>();
            parametros.put("idequipaje", Integer.parseInt(logequip.mostrarultima().toString()));
            parametros.put("Logo", logo.getImage());
            JasperPrint print=  JasperFillManager.fillReport(jr, parametros,conexion);
   
            PrinterJob job = PrinterJob.getPrinterJob();
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for(int i = 0; i <services.length;i++){
            if(services[i].getName().contains(imp_tickets)){
            /*If the service is named as what we are querying we select it */
             selectedService = i;
             }
            }
            job.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            //MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
            //printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(1));
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            /* We set the selected service and pass it as a paramenter */
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,
                services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
                printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,
                Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,
                Boolean.FALSE);//Si dessea que aparesca el dialogo poner true, en caso de false se imprimira en automatico
            exporter.exportReport();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al imprimir: "+ e);
                    
        }
   
    }
    public void imprimiendo_etiquetas(){
        try {
            obteniendoimpresoras();
            logo=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/logo.jpg"));
          //imagenagua=new javax.swing.ImageIcon(frmpv_equipaje.class.getResource("/Img/Logo/agua.png")); 
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartpos_terminal", "root", "");
            JasperReport jr= (JasperReport)JRLoader.loadObject(frmpv_equipaje.class.getResource("/Reportes/guardaequipaje_etiquetas.jasper"));
            Map parametros = new HashMap<String,Object>();
            parametros.put("idequipaje", Integer.parseInt(logequip.mostrarultima().toString()));
            parametros.put("Logo", logo.getImage());
            JasperPrint print=  JasperFillManager.fillReport(jr, parametros,conexion);
   
            PrinterJob job = PrinterJob.getPrinterJob();
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for(int i = 0; i <services.length;i++){
            if(services[i].getName().contains(imp_etiquetas)){
            /*If the service is named as what we are querying we select it */
             selectedService = i;
             }
            }
            job.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            //MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
            //printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(2));
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            /* We set the selected service and pass it as a paramenter */
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,
                services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
                printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,
                Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,
                Boolean.FALSE);//Si dessea que aparesca el dialogo poner true, en caso de false se imprimira en automatico
            exporter.exportReport();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al imprimir: "+ e);
                    
        }
   
    }
    public void imprimiendo_ticket_equipaje(){
        try {
            obteniendoimpresoras();
            logo=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/logo.jpg"));
          //imagenagua=new javax.swing.ImageIcon(frmpv_equipaje.class.getResource("/Img/Logo/agua.png")); 
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartpos_terminal", "root", "");
            JasperReport jr= (JasperReport)JRLoader.loadObject(frmpv_equipaje.class.getResource("/Reportes/guardaequipaje_ticket.jasper"));
            Map parametros = new HashMap<String,Object>();
            parametros.put("idequipaje", Integer.parseInt(frmpv_equipaje.txtbuscar.getText()));
            parametros.put("Logo", logo.getImage());
            JasperPrint print=  JasperFillManager.fillReport(jr, parametros,conexion);
   
            PrinterJob job = PrinterJob.getPrinterJob();
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for(int i = 0; i <services.length;i++){
            if(services[i].getName().contains(imp_tickets)){
            /*If the service is named as what we are querying we select it */
             selectedService = i;
             }
            }
            job.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            //MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
            //printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(2));
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            /* We set the selected service and pass it as a paramenter */
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,
                services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
                printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,
                Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,
                Boolean.FALSE);//Si dessea que aparesca el dialogo poner true, en caso de false se imprimira en automatico
            exporter.exportReport();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al imprimir: "+ e);
                    
        }
   
    }
    public void imprimiendo_ticket_venta(int venta,double efectivo){
        try {
            obteniendoimpresoras();
            logo=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/logo.jpg"));
          //imagenagua=new javax.swing.ImageIcon(frmpv_equipaje.class.getResource("/Img/Logo/agua.png")); 
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartpos_terminal", "root", "");
            JasperReport jr= (JasperReport)JRLoader.loadObject(frminicio.class.getResource("/Reportes/ticket_venta.jasper"));
            Map parametros = new HashMap<String,Object>();
            parametros.put("idvent", venta);
            parametros.put("efectivo", efectivo);
            parametros.put("Logo", logo.getImage());
            JasperPrint print=  JasperFillManager.fillReport(jr, parametros,conexion);
   
            PrinterJob job = PrinterJob.getPrinterJob();
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for(int i = 0; i <services.length;i++){
            if(services[i].getName().contains(imp_tickets)){
            /*If the service is named as what we are querying we select it */
             selectedService = i;
             }
            }
            job.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            //MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
            //printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(1));
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            /* We set the selected service and pass it as a paramenter */
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,
                services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
                printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,
                Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,
                Boolean.FALSE);//Si dessea que aparesca el dialogo poner true, en caso de false se imprimira en automatico
            exporter.exportReport();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al imprimir ticket de venta: "+ e);
                    
        }
   
    }
    public void imprimiendo_ticket_compra(int compra){
        try {
            obteniendoimpresoras();
            logo=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/logo.jpg"));
          //imagenagua=new javax.swing.ImageIcon(frmpv_equipaje.class.getResource("/Img/Logo/agua.png")); 
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartpos_terminal", "root", "");
            JasperReport jr= (JasperReport)JRLoader.loadObject(frminicio.class.getResource("/Reportes/ticket_compra.jasper"));
            Map parametros = new HashMap<String,Object>();
            parametros.put("idcompra", compra);
            parametros.put("Logo", logo.getImage());
            JasperPrint print=  JasperFillManager.fillReport(jr, parametros,conexion);
   
            PrinterJob job = PrinterJob.getPrinterJob();
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for(int i = 0; i <services.length;i++){
            if(services[i].getName().contains(imp_tickets)){
            /*If the service is named as what we are querying we select it */
             selectedService = i;
             }
            }
            job.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            //MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
            //printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(1));
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            /* We set the selected service and pass it as a paramenter */
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,
                services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
                printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,
                Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,
                Boolean.FALSE);//Si dessea que aparesca el dialogo poner true, en caso de false se imprimira en automatico
            exporter.exportReport();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al imprimir ticket de compra: "+ e);
                    
        }
   
    }
    public void imprimiendo_ultimo_movimiento_caja(){
        try {
            obteniendoimpresoras();
            logmovimientos_caja movcaja = new logmovimientos_caja();
            
            logo=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/logo.jpg"));
          //imagenagua=new javax.swing.ImageIcon(frmpv_equipaje.class.getResource("/Img/Logo/agua.png")); 
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartpos_terminal", "root", "");
            JasperReport jr= (JasperReport)JRLoader.loadObject(frmcaja_corte.class.getResource("/Reportes/caja_movimiento.jasper"));
            Map parametros = new HashMap<String,Object>();
            parametros.put("id_movimiento",movcaja.mostrarultimo());
            parametros.put("Logo", logo.getImage());
            JasperPrint print=  JasperFillManager.fillReport(jr, parametros,conexion);
   
            PrinterJob job = PrinterJob.getPrinterJob();
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for(int i = 0; i <services.length;i++){
            //Se escribe el nombre de la impresora a usar, para este caso tickets
            if(services[i].getName().contains(imp_tickets)){
            /*If the service is named as what we are querying we select it */
             selectedService = i;
             }
            }
            job.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            //MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
            //printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(1));
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            /* We set the selected service and pass it as a paramenter */
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,
                services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
                printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,
                Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,
                Boolean.FALSE);//Si dessea que aparesca el dialogo poner true, en caso de false se imprimira en automatico
            exporter.exportReport();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al imprimir: "+ e);
                    
        }
   
    }
    public void imprimiendo_corte_caja(){
        try {
            obteniendoimpresoras();
            logmovimientos_caja movcaja = new logmovimientos_caja();
            
            logo=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/logo.jpg"));
          //imagenagua=new javax.swing.ImageIcon(frmpv_equipaje.class.getResource("/Img/Logo/agua.png")); 
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartpos_terminal", "root", "");
            JasperReport jr= (JasperReport)JRLoader.loadObject(frminicio.class.getResource("/Reportes/corte_caja.jasper"));
            Map parametros = new HashMap<String,Object>();
            parametros.put("id_movimiento",movcaja.mostrarultimo());
            parametros.put("Logo", logo.getImage());
            JasperPrint print=  JasperFillManager.fillReport(jr, parametros,conexion);
   
            PrinterJob job = PrinterJob.getPrinterJob();
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for(int i = 0; i <services.length;i++){
            //Se escribe el nombre de la impresora a usar, para este caso tickets
            if(services[i].getName().contains(imp_tickets)){
            /*If the service is named as what we are querying we select it */
             selectedService = i;
             }
            }
            job.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            //MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
            //printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(1));
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            /* We set the selected service and pass it as a paramenter */
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,
                services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
                printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,
                Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,
                Boolean.FALSE);//Si dessea que aparesca el dialogo poner true, en caso de false se imprimira en automatico
            exporter.exportReport();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al imprimir: "+ e);
                    
        }
   
    }
    public void imprimiendo_nota_venta(String Agentenombre,String agenteapellidos, String agentetelefono){
        try {
            obteniendoimpresoras();
           logo=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/logo.jpg"));
           imagenagua=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/agua.png"));
              
           Class.forName("com.mysql.jdbc.Driver");
           Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartpos_terminal", "root", "");
            JasperReport jr= (JasperReport)JRLoader.loadObject(frminicio.class.getResource("/Reportes/Notaventa.jasper"));
            Map parametros = new HashMap<String,Object>();
            parametros.put("idventa", Integer.parseInt(logvent.mostrarultima().toString()));
            parametros.put("nombreagente", Agentenombre);
            parametros.put("apellidoagente", agenteapellidos);
            parametros.put("telagente", agentetelefono);
            parametros.put("obs", " ");
            parametros.put("logo", logo.getImage());
            parametros.put("marcaagua", imagenagua.getImage());
            //--------------Visualizando-----------------------------
            
            JasperPrint jp=  JasperFillManager.fillReport(jr, parametros,conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            
            //--------------Imprimiendo------------------------------
             PrinterJob job = PrinterJob.getPrinterJob();
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for(int i = 0; i <services.length;i++){
            //Se escribe el nombre de la impresora a usar, para este caso tickets
            if(services[i].getName().contains(imp_notas)){
            /*If the service is named as what we are querying we select it */
             selectedService = i;
             }
            }
            job.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            //MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
            //printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(1));
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            /* We set the selected service and pass it as a paramenter */
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,
                services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
                printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,
                Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,
                Boolean.FALSE);//Si dessea que aparesca el dialogo poner true, en caso de false se imprimira en automatico
            exporter.exportReport();
            conexion.close();
            conexion.close(); 
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Error al imprimir nota de venta: "+ e);
        }
  
       
     }
    
     public void imprimiendo_nota_compra(String Agentenombre,String agenteapellidos, String agentetelefono){
        try {
            obteniendoimpresoras();
           logo=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/logo.jpg"));
           imagenagua=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/agua.png"));
              
           Class.forName("com.mysql.jdbc.Driver");
           Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartpos_terminal", "root", "");
            JasperReport jr= (JasperReport)JRLoader.loadObject(frminicio.class.getResource("/Reportes/Nota_compra.jasper"));
            Map parametros = new HashMap<String,Object>();
            parametros.put("idcompra", Integer.parseInt(logcompra.mostrarultima().toString()));
            parametros.put("nombreagente", Agentenombre);
            parametros.put("apellidoagente", agenteapellidos);
            parametros.put("telagente", agentetelefono);
            parametros.put("obs", " ");
            parametros.put("logo", logo.getImage());
            parametros.put("marcaagua", imagenagua.getImage());
            //--------------Visualizando-----------------------------
            
            JasperPrint jp=  JasperFillManager.fillReport(jr, parametros,conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            
            //--------------Imprimiendo------------------------------
             PrinterJob job = PrinterJob.getPrinterJob();
            /* Create an array of PrintServices */
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;
            /* Scan found services to see if anyone suits our needs */
            for(int i = 0; i <services.length;i++){
            //Se escribe el nombre de la impresora a usar, para este caso tickets
            if(services[i].getName().contains(imp_notas)){
            /*If the service is named as what we are querying we select it */
             selectedService = i;
             }
            }
            job.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            //MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
            //printRequestAttributeSet.add(mediaSizeName);
            printRequestAttributeSet.add(new Copies(1));
            JRPrintServiceExporter exporter;
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            /* We set the selected service and pass it as a paramenter */
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE,
                services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET,
                services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,
                printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG,
                Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG,
                Boolean.FALSE);//Si dessea que aparesca el dialogo poner true, en caso de false se imprimira en automatico
            exporter.exportReport();
            conexion.close();
            conexion.close(); 
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Error al imprimir nota de venta: "+ e);
        }
     }
          public void reimprimiendo_nota_compra(String Agentenombre,String agenteapellidos, String agentetelefono,String num_compra){
        try {
            obteniendoimpresoras();
           logo=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/logo.jpg"));
           imagenagua=new javax.swing.ImageIcon(getClass().getResource("/Img/Logo/agua.png"));
              
           Class.forName("com.mysql.jdbc.Driver");
           Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartpos_terminal", "root", "");
            JasperReport jr= (JasperReport)JRLoader.loadObject(frminicio.class.getResource("/Reportes/Nota_compra.jasper"));
            Map parametros = new HashMap<String,Object>();
            parametros.put("idcompra", Integer.parseInt(num_compra));
            parametros.put("nombreagente", Agentenombre);
            parametros.put("apellidoagente", agenteapellidos);
            parametros.put("telagente", agentetelefono);
            parametros.put("obs", " ");
            parametros.put("logo", logo.getImage());
            parametros.put("marcaagua", imagenagua.getImage());
            //--------------Visualizando-----------------------------
            
            JasperPrint jp=  JasperFillManager.fillReport(jr, parametros,conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            
            conexion.close(); 
        } catch (Exception e) {
               JOptionPane.showMessageDialog(null,"Error al imprimir nota de venta: "+ e);
        }
     }
}
