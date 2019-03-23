/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Presentacion.login_sin_uso;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ZAIR
 */
public class logcommon {
    
  
    
    //Fecha Actual
    public static String fechaactual() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    
    //Hora actual
     public static String horaactual() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
     
      public static String fechayhora() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date())+ " "
                + new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
     
    public static Color ColorPrincipal(){
     Color CPrincipal = new java.awt.Color(242, 124, 13);
     return CPrincipal;
    }
    public static Color ColorBotones(){
     Color CPrincipal = new java.awt.Color(204,229,255);
     return CPrincipal;
    }
    //Este metodo permite redondear una cantidad 
    public static double redondeando(Double cantidad)
    {
      return (double)Math.round(cantidad * 100d) / 100d;  
    }
}
