/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ZAIR
 */
public class conexiontestsplas {
     public String db="smartpos";
     public String ip="127.0.0.1";
     public String url="jdbc:mysql://"+ip+"/"+db;
     public String user="root";
     public String pass="";
            Connection link=null;
    public conexiontestsplas() {
    }
     
   public Connection conectar(){
         Connection link=null;
         
         try {
             Class.forName("org.gjt.mm.mysql.Driver");
             link=DriverManager.getConnection(this.url, this.user, this.pass); 
         } catch (ClassNotFoundException | SQLException e) {
             //JOptionPane.showMessageDialog(null,"Error de conexion splash: "+ e);
         }
         return link;
     }
      
     public void  cerrar(){
         try {
             link.close();
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null,"Error de desconexion: "+ e);
         }
        
     }
}
