/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.datosdetallecompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ZAIR
 */
public class logdetallecompra {
    //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    
    
      
      public boolean insertar(datosdetallecompra dts){
        
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into detallecompra(idCompra,idArt,unidades,precio,impuesto)"+
                "values(?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1, dts.getIdCompra());
            pst.setString(2, dts.getIdArt());
            pst.setInt(3, dts.getUnidades());
            pst.setDouble(4, dts.getPrecio());
            pst.setDouble(5, dts.getImpuesto());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }finally{
        try {
            cn.close();

            } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
      
       public boolean editar(datosdetallecompra dts){
       
        
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update detallecompra set  idCompra=?, idArt=?, unidades=?,precio=?, impuesto=? where idSubCompra=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1, dts.getIdSubCompra());
            pst.setString(2, dts.getIdArt());
            pst.setInt(3, dts.getUnidades());
            pst.setDouble(4, dts.getPrecio());
            pst.setDouble(5, dts.getImpuesto());
            pst.setInt(6, dts.getIdCompra());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
  
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
        public boolean eliminar(datosdetallecompra dts){
       

            try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from detallecompra where idsubcompra=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdSubCompra());

            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
             return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
        
 
  public String mostrarultima(){
   
    String idventa= new String();
    totalregistros=0;
   
    
    
    
    try {
           cn = metodospool.dataSource.getConnection();
           sSql="SELECT MAX(idcompra) FROM compra";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
           
            idventa =rs.getString("MAX(idcompra)");
           
           
            }
           return idventa;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al buscar ultima compra: "+e);
            return null;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
 //Se utiliza para cuando pasa el recolector de basura
    public void finalize() throws SQLException{
        cn.close();
    }
}
