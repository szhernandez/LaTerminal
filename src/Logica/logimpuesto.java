/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.datosimpuesto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZAIR
 */
public class logimpuesto {
    //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
   public ArrayList<datosimpuesto> consultarimpuesto() {
        datosimpuesto dts;
        ArrayList<datosimpuesto> impuestosList = new ArrayList<>();
   try {
        cn = metodospool.dataSource.getConnection();
        sSql="SELECT * FROM impuesto order by valor";
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(sSql);
     
        while(rs.next()==true){
            dts=new datosimpuesto();
            dts.setIdImpuesto(rs.getString("idImpuesto"));
            dts.setDescripcion(rs.getString("descripcion"));
            dts.setValor(rs.getDouble("valor"));
            impuestosList.add(dts);
        }  
        
    } catch (SQLException e) {
   System.out.println("Error en la consulta de impuestos: "+e.getMessage());
  }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
   return impuestosList;
   }
   
   public String consultarimpuestoselectivo(String impuesto) {
        String valorimpuesto= new String();
       try {
           cn = metodospool.dataSource.getConnection();
            sSql="SELECT * FROM impuesto where idImpuesto='"+impuesto+"'";
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(sSql);
            while(rs.next()==true){
            valorimpuesto=""+ rs.getDouble("valor");
            }  
         } catch (SQLException e) {
       System.out.println("Error en la consulta de impuestos: "+e.getMessage());
      }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
      }
    return valorimpuesto;
    }
   //Se utiliza para cuando pasa el recolector de basura
    public void finalize() throws SQLException{
        cn.close();
    }
}
