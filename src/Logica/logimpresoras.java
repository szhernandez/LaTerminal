/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.datoscaja;
import Datos.datosimpresoras;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZAIR
 */
public class logimpresoras {
    //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    
      public String[] mostrar(String buscar){
    String [] registro = new String [10];
    try {
        cn = metodospool.dataSource.getConnection();
         sSql="select impresoras.idCaja,impresoras.impresora_tickets, impresoras.impresora_notas, impresoras.impresora_etiquetas"
            + " FROM impresoras where impresoras.idCaja='"+buscar+"'";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            registro [0]=rs.getString("impresoras.idCaja");
            registro [1]=rs.getString("impresoras.impresora_tickets");
            registro [2]=rs.getString("impresoras.impresora_notas");
            registro [3]=rs.getString("impresoras.impresora_etiquetas");
            }
           return registro;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar los datos de impresoras: "+e);
            return null;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    
    public boolean insertar(datosimpresoras dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into impresoras(idcaja,impresora_tickets,impresora_notas,impresora_etiquetas)"+
                "values(?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1,dts.getIdcaja());
            pst.setString(2, dts.getImpresora_tickets());
            pst.setString(3, dts.getImpresora_notas());
            pst.setString(4, dts.getImpresora_etiquetas());
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
    
    public boolean editar(datosimpresoras dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update impresoras set  impresora_tickets=?, impresora_notas=?,impresora_etiquetas=? where idcaja=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getImpresora_tickets());
            pst.setString(2, dts.getImpresora_notas());
             pst.setString(3, dts.getImpresora_etiquetas());
            pst.setString(4, dts.getIdcaja());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Fallo update *logcaja* "+ e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    
    public boolean eliminar(datosimpresoras dts){
            try {
                cn = metodospool.dataSource.getConnection();
                sSql="delete from impresoras where idCaja=?";
                PreparedStatement pst=cn.prepareStatement(sSql);
                pst.setString(1,dts.getIdcaja());
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
    
    public boolean updatetickets(datosimpresoras dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update impresoras set   impresora_tickets=? where idcaja=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getImpresora_tickets());
            pst.setString(2, dts.getIdcaja());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Fallo update datosimpresoras "+ e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    
      public boolean updatenotas(datosimpresoras dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update impresoras set   impresora_notas=? where idcaja=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getImpresora_notas());
            pst.setString(2, dts.getIdcaja());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Fallo update datosimpresoras "+ e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
      
      public boolean updateetiquetas(datosimpresoras dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update impresoras set   impresora_etiquetas=? where idcaja=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getImpresora_etiquetas());
            pst.setString(2, dts.getIdcaja());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Fallo update datosimpresoras "+ e);
            return false;
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
