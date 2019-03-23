/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Presentacion.frmpuntoventa;
import Presentacion.frminicio;
import Presentacion.frmpuntocompra;
import Presentacion.frmpuntoconsultaventa;
import Presentacion.frmpuntopreventa;
import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ZAIR
 */
public class logticket {
    
    public void imprimirticketventa(){
        try {
        PrinterMatrix printer = new PrinterMatrix();
 
        Extenso e = new Extenso();
 
        e.setNumber(101.85);
        
        //Comienzo leyendo largo de la tabla para saber longitud del ticket
        //es suman 16 porque estas son las filas estaticas que se agregaron
        int largotabla = (1+ frmpuntoventa.tablaventa.getRowCount());
        int largo2= largotabla +11;
        //Ahora solo para evitar problemas con pocas filas
            if (frmpuntoventa.tablaventa.getRowCount()<2) {
                largo2=largo2+2;
            }
       
        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        printer.setOutSize(largo2, 64);
       
        //Imprimir * de la 2da linea a 25 en la columna 1;
       // printer.printCharAtLin(2, 25, 1, "*");
        //Imprimir * 1ra linea de la columa de 1 a 33
       
   
        //Imprimir Encabezado nombre del La EMpresa
       printer.printTextWrap(1, 1, 10, 32, "FARMA-MEDIC");
       //printer.printTextWrap(linI, linE, colI, colE, null);
       printer.printTextWrap(2, 2, 1, 64, "REFORMA #910, CENTRO CP. 40660  CD ALTAMIRANO GUERRERO" );
       printer.printTextWrap(3, 3, 1, 64, "RFC: GOAF910811G22              TEL. (01767) 672 0521");
     
       //Formateando longitud del nombre del trabajador
       String sCadena = frminicio.lblnombretrabajador.getText();
       Integer largo=sCadena.length();
            if (largo>19) {
       String CadenaSeteada = sCadena.substring(0,19);
       printer.printTextWrap(4, 4, 1, 32, "LE ATENDIO: "+CadenaSeteada);
            }else{
                printer.printTextWrap(4, 4, 1, 32, "LE ATENDIO: "+frminicio.lblnombretrabajador.getText());
            }
           
       printer.printTextWrap(4, 4, 33, 63, "CLIENTE: "+ frmpuntoventa.lblnombrecliente.getText());
       printer.printTextWrap(5, 5, 1 , 32, "         "+ frmpuntoventa.lblnombrenegocio.getText());
       logventa log = new logventa();
       printer.printTextWrap(5, 5, 33, 64, "Doc. Num. "+log.mostrarultima() );
       printer.printTextWrap(6, 6, 1, 32, "-------------------------------" );
       printer.printTextWrap(6, 6, 33, 63, "Cant | Desc. | Precio | Import");
     
       int filas = frmpuntoventa.tablaventa.getRowCount();
       
        for (int i = 0; i<filas; i++) { 
            //Vamos a extraer solo parte de la descripcion del producto
            String sDescripcion = frmpuntoventa.tablaventa.getValueAt(i,2).toString();
            Integer largoDes=sDescripcion.length();
            if (largoDes>20) {
             String SDescripcionSeteada = sDescripcion.substring(0,20);
              printer.printTextWrap(7 + i, 7 + i, 1, 32,"** "+ frmpuntoventa.tablaventa.getValueAt(i,0).toString()+
                "|"+SDescripcionSeteada);
            }else{
             printer.printTextWrap(7 + i, 7 + i, 1, 32,"** "+ frmpuntoventa.tablaventa.getValueAt(i,0).toString()+
                "|"+frmpuntoventa.tablaventa.getValueAt(i,2).toString());
            }
        printer.printTextWrap(7+i, 7+i, 33, 64, "| "+frmpuntoventa.tablaventa.getValueAt(i,3).toString()+
                "| "+frmpuntoventa.tablaventa.getValueAt(i,4).toString());
               
        }//Fin for
        
        printer.printTextWrap(7 + filas, 7 + filas, 1, 32, "---------------------------------");
        printer.printTextWrap(7 + filas, 7 + filas, 33, 64, "TOTAL $ "+ frmpuntoventa.lbltotal.getText());
        printer.printTextWrap(8 + filas, 8 + filas, 1, 32, "EFECTIVO $ "+frmpuntoventa.lblefectivo2.getText());
        printer.printTextWrap(8 + filas, 8 + filas, 33, 64, "CAMBIO $ "+frmpuntoventa.lblcambio.getText());
        printer.printTextWrap(9 + filas,9 + filas, 1, 64, "     GRACIAS POR SU COMPRA               VUELVA PRONTO");
        printer.printTextWrap(10 + filas,10 + filas, 1, 64, "  "+logcommon.fechaactual()+"     "+logcommon.horaactual());
        /*
      */
     
        
        printer.toFile("impresion.txt");
 
      FileInputStream inputStream = null;
     
        try {
            inputStream = new FileInputStream("impresion.txt");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error al intentar imprimir #0002 "+e);
        }
        if (inputStream == null) {
            return;
        }
 
        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);
 
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
        //PrintService dePrintService = PrintServiceLookup.
 
        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);
 
            } catch (PrintException ex) {
               JOptionPane.showMessageDialog(null,"Error al intentar imprimir #0001 ");
            }
        } else {  
            JOptionPane.showMessageDialog(null,"No encuentro una impresora disponible ");
        }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null,"no puedo ejecutar la accion para imprimir "+ e);
        }
        //inputStream.close();
     
    }
     public void imprimirticketventa2(){
        try {
        PrinterMatrix printer = new PrinterMatrix();
 
        Extenso e = new Extenso();
 
        e.setNumber(101.85);
        
        //Comienzo leyendo largo de la tabla para saber longitud del ticket
        //es suman 16 porque estas son las filas estaticas que se agregaron
        int largotabla = (1+ frmpuntopreventa.tablaventa.getRowCount());
        int largo2= largotabla +11;
        //Ahora solo para evitar problemas con pocas filas
            if (frmpuntopreventa.tablaventa.getRowCount()<2) {
                largo2=largo2+2;
            }
       
        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        printer.setOutSize(largo2, 64);
       
        //Imprimir * de la 2da linea a 25 en la columna 1;
       // printer.printCharAtLin(2, 25, 1, "*");
        //Imprimir * 1ra linea de la columa de 1 a 33
       
   
        //Imprimir Encabezado nombre del La EMpresa
       printer.printTextWrap(1, 1, 10, 32, "FARMA-MEDIC");
       //printer.printTextWrap(linI, linE, colI, colE, null);
       printer.printTextWrap(2, 2, 1, 64, "REFORMA #910, CENTRO CP. 40660  CD ALTAMIRANO GUERRERO" );
       printer.printTextWrap(3, 3, 1, 64, "RFC: GOAF910811G22              TEL. (01767) 672 0521");
     
       //Formateando longitud del nombre del trabajador
       String sCadena = frminicio.lblnombretrabajador.getText();
       Integer largo=sCadena.length();
            if (largo>19) {
       String CadenaSeteada = sCadena.substring(0,19);
       printer.printTextWrap(4, 4, 1, 32, "LE ATENDIO: "+CadenaSeteada);
            }else{
                printer.printTextWrap(4, 4, 1, 32, "LE ATENDIO: "+frminicio.lblnombretrabajador.getText());
            }
           
       printer.printTextWrap(4, 4, 33, 63, "CLIENTE: "+ frmpuntopreventa.lblnombrecliente.getText());
       printer.printTextWrap(5, 5, 1 , 32, "         "+ frmpuntopreventa.lblnombrenegocio.getText());
       logventa log = new logventa();
       printer.printTextWrap(5, 5, 33, 64, "Doc. Num. "+log.mostrarultima() );
       printer.printTextWrap(6, 6, 1, 32, "-------------------------------" );
       printer.printTextWrap(6, 6, 33, 63, "Cant | Desc. | Precio | Import");
     
       int filas = frmpuntopreventa.tablaventa.getRowCount();
       
        for (int i = 0; i<filas; i++) { 
            //Vamos a extraer solo parte de la descripcion del producto
            String sDescripcion = frmpuntopreventa.tablaventa.getValueAt(i,2).toString();
            Integer largoDes=sDescripcion.length();
            if (largoDes>20) {
             String SDescripcionSeteada = sDescripcion.substring(0,20);
              printer.printTextWrap(7 + i, 7 + i, 1, 32,"** "+ frmpuntopreventa.tablaventa.getValueAt(i,0).toString()+
                "|"+SDescripcionSeteada);
            }else{
             printer.printTextWrap(7 + i, 7 + i, 1, 32,"** "+ frmpuntopreventa.tablaventa.getValueAt(i,0).toString()+
                "|"+frmpuntopreventa.tablaventa.getValueAt(i,2).toString());
            }
        printer.printTextWrap(7+i, 7+i, 33, 64, "| "+frmpuntopreventa.tablaventa.getValueAt(i,3).toString()+
                "| "+frmpuntopreventa.tablaventa.getValueAt(i,4).toString());
               
        }//Fin for
        
        printer.printTextWrap(7 + filas, 7 + filas, 1, 32, "---------------------------------");
        printer.printTextWrap(7 + filas, 7 + filas, 33, 64, "TOTAL $ "+ frmpuntopreventa.lbltotal.getText());
        printer.printTextWrap(8 + filas, 8 + filas, 1, 32, "EFECTIVO $ "+frmpuntopreventa.lblefectivo2.getText());
        printer.printTextWrap(8 + filas, 8 + filas, 33, 64, "CAMBIO $ "+frmpuntopreventa.lblcambio.getText());
        printer.printTextWrap(9 + filas,9 + filas, 1, 64, "     GRACIAS POR SU COMPRA               VUELVA PRONTO");
        printer.printTextWrap(10 + filas,10 + filas, 1, 64, "  "+logcommon.fechaactual()+"     "+logcommon.horaactual());
        /*
      */
     
        
        printer.toFile("impresion.txt");
 
      FileInputStream inputStream = null;
     
        try {
            inputStream = new FileInputStream("impresion.txt");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error al intentar imprimir #0002 "+e);
        }
        if (inputStream == null) {
            return;
        }
 
        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);
 
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
        //PrintService dePrintService = PrintServiceLookup.
 
        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);
 
            } catch (PrintException ex) {
               JOptionPane.showMessageDialog(null,"Error al intentar imprimir #0001 ");
            }
        } else {  
            JOptionPane.showMessageDialog(null,"No encuentro una impresora disponible ");
        }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null,"no puedo ejecutar la accion para imprimir "+ e);
        }
        //inputStream.close();
     
    }
    
    public void reimprimirticketventa(){
        try {
        PrinterMatrix printer = new PrinterMatrix();
 
        Extenso e = new Extenso();
 
        e.setNumber(101.85);
        
        //Comienzo leyendo largo de la tabla para saber longitud del ticket
        //es suman 16 porque estas son las filas estaticas que se agregaron
        int largotabla = (1+ frmpuntoconsultaventa.tablaventa.getRowCount());
        int largo2= largotabla +11;
        //Ahora solo para evitar problemas con pocas filas
            if (frmpuntoconsultaventa.tablaventa.getRowCount()<2) {
                largo2=largo2+2;
            }
       
        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        printer.setOutSize(largo2, 64);
       
        //Imprimir * de la 2da linea a 25 en la columna 1;
       // printer.printCharAtLin(2, 25, 1, "*");
        //Imprimir * 1ra linea de la columa de 1 a 33
       
   
        //Imprimir Encabezado nombre del La EMpresa
       printer.printTextWrap(1, 1, 10, 32, "FARMA-MEDIC");
       printer.printTextWrap(1, 1, 33, 63, "***DEVOLUCION Y/O REIMPRESIÓN***");
       //printer.printTextWrap(linI, linE, colI, colE, null);
       printer.printTextWrap(2, 2, 1, 64, "REFORMA #910, CENTRO CP. 40660  CD ALTAMIRANO GUERRERO" );
       printer.printTextWrap(3, 3, 1, 64, "RFC: GOAF910811G22              TEL. (01767) 672 0521");
     
       //Formateando longitud del nombre del trabajador
       String sCadena = frminicio.lblnombretrabajador.getText();
       Integer largo=sCadena.length();
            if (largo>19) {
       String CadenaSeteada = sCadena.substring(0,19);
       printer.printTextWrap(4, 4, 1, 32, "LE ATENDIO: "+CadenaSeteada);
            }else{
                printer.printTextWrap(4, 4, 1, 32, "LE ATENDIO: "+frminicio.lblnombretrabajador.getText());
            }
           
       printer.printTextWrap(4, 4, 33, 63, "CLIENTE: "+ frmpuntoconsultaventa.txtnombrecliente.getText());
       printer.printTextWrap(5, 5, 1 , 32, "         "+ frmpuntoconsultaventa.txtclientenegocio.getText());
       logventa log = new logventa();
       printer.printTextWrap(5, 5, 33, 64, "Doc. Num. "+frmpuntoconsultaventa.txtnumventa.getText() );
       printer.printTextWrap(6, 6, 1, 32, "-------------------------------" );
       printer.printTextWrap(6, 6, 33, 63, "Cant | Desc. | Precio | Import");
     
       int filas = frmpuntoconsultaventa.tablaventa.getRowCount();
       
        for (int i = 0; i<filas; i++) { 
            //Vamos a extraer solo parte de la descripcion del producto
            String sDescripcion = frmpuntoconsultaventa.tablaventa.getValueAt(i,4).toString();
            Integer largoDes=sDescripcion.length();
            if (largoDes>20) {
             String SDescripcionSeteada = sDescripcion.substring(0,20);
              printer.printTextWrap(7 + i, 7 + i, 1, 32,"** "+ frmpuntoconsultaventa.tablaventa.getValueAt(i,2).toString()+
                "|"+SDescripcionSeteada);
            }else{
             printer.printTextWrap(7 + i, 7 + i, 1, 32,"** "+ frmpuntoconsultaventa.tablaventa.getValueAt(i,2).toString()+
                "|"+frmpuntoconsultaventa.tablaventa.getValueAt(i,4).toString());
            }
        printer.printTextWrap(7+i, 7+i, 33, 64, "| "+frmpuntoconsultaventa.tablaventa.getValueAt(i,5).toString()+
                "| "+frmpuntoconsultaventa.tablaventa.getValueAt(i,8).toString());
               
        }//Fin for
        
        printer.printTextWrap(7 + filas, 7 + filas, 1, 32, "---------------------------------");
        printer.printTextWrap(7 + filas, 7 + filas, 33, 64, "TOTAL $ "+ frmpuntoconsultaventa.lbltotal.getText());
        printer.printTextWrap(8 + filas, 8 + filas, 1, 32, "PAGO $ "+frmpuntoconsultaventa.lblpago.getText());
        printer.printTextWrap(8 + filas, 8 + filas, 33, 64, "SOBRANTE $ "+frmpuntoconsultaventa.lblsobrante.getText());
        printer.printTextWrap(9 + filas,9 + filas, 1, 64, "     GRACIAS POR SU COMPRA               VUELVA PRONTO");
        printer.printTextWrap(10 + filas,10 + filas, 1, 64, "  "+logcommon.fechaactual()+"     "+logcommon.horaactual());
        /*
      */
     
        
        printer.toFile("impresion.txt");
 
      FileInputStream inputStream = null;
     
        try {
            inputStream = new FileInputStream("impresion.txt");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error al intentar imprimir #0002 "+e);
        }
        if (inputStream == null) {
            return;
        }
 
        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);
 
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
        //PrintService dePrintService = PrintServiceLookup.
 
        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);
 
            } catch (PrintException ex) {
               JOptionPane.showMessageDialog(null,"Error al intentar imprimir #0001 ");
            }
        } else {  
            JOptionPane.showMessageDialog(null,"No encuentro una impresora disponible ");
        }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null,"no puedo ejecutar la accion para imprimir "+ e);
        }
        //inputStream.close();
     
    }
    
     public void imprimirticketcompra(){
        try {
        PrinterMatrix printer = new PrinterMatrix();
 
        Extenso e = new Extenso();
 
        e.setNumber(101.85);
        
        //Comienzo leyendo largo de la tabla para saber longitud del ticket
        //es suman 16 porque estas son las filas estaticas que se agregaron
        int largotabla = (1+ frmpuntocompra.tablacompra.getRowCount());
        int largo2= largotabla +11;
        //Ahora solo para evitar problemas con pocas filas
            if (frmpuntocompra.tablacompra.getRowCount()<2) {
                largo2=largo2+2;
            }
       
        //Definir el tamanho del papel para la impresion  aca 25 lineas y 80 columnas
        printer.setOutSize(largo2, 64);
       
        //Imprimir * de la 2da linea a 25 en la columna 1;
       // printer.printCharAtLin(2, 25, 1, "*");
        //Imprimir * 1ra linea de la columa de 1 a 33
       
   
        //Imprimir Encabezado nombre del La EMpresa
       printer.printTextWrap(1, 1, 10, 32, "FARMA-MEDIC");
       //printer.printTextWrap(linI, linE, colI, colE, null);
       printer.printTextWrap(2, 2, 1, 64, "REFORMA #910, CENTRO CP. 40660  CD ALTAMIRANO GUERRERO" );
       printer.printTextWrap(3, 3, 1, 64, "RFC: GOAF910811G22              TEL. (01767) 672 0521");
     
       //Formateando longitud del nombre del trabajador
       String sCadena = frminicio.lblnombretrabajador.getText();
       Integer largo=sCadena.length();
            if (largo>19) {
       String CadenaSeteada = sCadena.substring(0,19);
       printer.printTextWrap(4, 4, 1, 32, "REALIZO: "+CadenaSeteada);
            }else{
                printer.printTextWrap(4, 4, 1, 32, "REALIZO: "+frminicio.lblnombretrabajador.getText());
            }
           
       printer.printTextWrap(4, 4, 33, 63, "PROVEEDOR: "+ frmpuntocompra.txtproveedor.getText());
       printer.printTextWrap(5, 5, 1 , 32, "REPRESENTANTE "+ frmpuntocompra.lbl_representante.getText());
       logdetallecompra log = new logdetallecompra();
       printer.printTextWrap(5, 5, 33, 64, "Doc. Num. "+log.mostrarultima() );
       printer.printTextWrap(6, 6, 1, 32, "-------------------------------" );
       printer.printTextWrap(6, 6, 33, 63, "Cant | Desc. | Precio | Import");
     
       int filas = frmpuntocompra.tablacompra.getRowCount();
       
        for (int i = 0; i<filas; i++) { 
            //Vamos a extraer solo parte de la descripcion del producto
            String sDescripcion = frmpuntocompra.tablacompra.getValueAt(i,2).toString();
            Integer largoDes=sDescripcion.length();
            if (largoDes>20) {
             String SDescripcionSeteada = sDescripcion.substring(0,20);
              printer.printTextWrap(7 + i, 7 + i, 1, 32,"** "+ frmpuntocompra.tablacompra.getValueAt(i,0).toString()+
                "|"+SDescripcionSeteada);
            }else{
             printer.printTextWrap(7 + i, 7 + i, 1, 32,"** "+ frmpuntocompra.tablacompra.getValueAt(i,0).toString()+
                "|"+frmpuntocompra.tablacompra.getValueAt(i,2).toString());
            }
        printer.printTextWrap(7+i, 7+i, 33, 64, "| "+frmpuntocompra.tablacompra.getValueAt(i,3).toString()+
                "| "+frmpuntocompra.tablacompra.getValueAt(i,4).toString());
               
        }//Fin for
        
        printer.printTextWrap(7 + filas, 7 + filas, 1, 32, "---------------------------------");
        printer.printTextWrap(7 + filas, 7 + filas, 33, 64, "TOTAL $ "+ frmpuntocompra.lbltotal.getText());
        printer.printTextWrap(9 + filas,9 + filas, 1, 64, "LA COMPRA REALIZO UN AJUSTE EN LAS EXISTENCIAS DEL INVENTARIO");
        printer.printTextWrap(10 + filas,10 + filas, 1, 64, "  "+logcommon.fechaactual()+"     "+logcommon.horaactual());
        printer.toFile("impresion.txt");
 
      FileInputStream inputStream = null;
     
        try {
            inputStream = new FileInputStream("impresion.txt");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error al intentar imprimir #0002 "+e);
        }
        if (inputStream == null) {
            return;
        }
 
        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc document = new SimpleDoc(inputStream, docFormat, null);
 
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        
        PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
        //PrintService dePrintService = PrintServiceLookup.
 
        if (defaultPrintService != null) {
            DocPrintJob printJob = defaultPrintService.createPrintJob();
            try {
                printJob.print(document, attributeSet);
 
            } catch (PrintException ex) {
               JOptionPane.showMessageDialog(null,"Error al intentar imprimir #0001 ");
            }
        } else {  
            JOptionPane.showMessageDialog(null,"No encuentro una impresora disponible ");
        }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null,"no puedo ejecutar la accion para imprimir "+ e);
        }
        //inputStream.close();
     
    }
     
     
   
}
