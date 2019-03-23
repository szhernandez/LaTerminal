/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.datoscaja;
import Datos.datostrabajador;
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
public class logcaja {
    //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    String [] titulos = {"ID","Nombre","Estado","dinero"};
    String [] registro = new String [4];
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
           cn = metodospool.dataSource.getConnection();
           sSql="select * from caja where nombre like'%"+buscar+"%' order by idTrab";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            registro [0]=rs.getString("idcaja");
            registro [1]=rs.getString("nombre");
            registro [2]=rs.getString("estado");
            registro [3]=rs.getString("dinero");
            totalregistros=totalregistros+1;
            modelo.addRow(registro);
            }
           return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar usuario: "+e);
            return null;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    
    public boolean insertar(datoscaja dts){
        try {
            cn = metodospool.dataSource.getConnection();
             sSql="insert into caja(idcaja,nombre,estado,dinero)"+
                "values(?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1,dts.getIdcaja());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getEstado());
            pst.setDouble(4, dts.getDinero());
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
    
    public boolean editar(datoscaja dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update caja set  nombre=?, estado=?, dinero=? where idcaja=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getEstado());
            pst.setDouble(3, dts.getDinero());
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
    
    
    public boolean eliminar(datoscaja dts){
            try {
                cn = metodospool.dataSource.getConnection();
                sSql="delete from caja where idCaja=?";
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
    
    public boolean updatedinero(datoscaja dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update caja set   dinero=? where idcaja=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setDouble(1, dts.getDinero());
            pst.setString(2, dts.getIdcaja());
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
    
    public String consultadinero(String idcaja){
           String dinero="";
           try {
                cn = metodospool.dataSource.getConnection();
                sSql="Select * from caja where idcaja='"+idcaja+"'";
                Statement st = cn.createStatement();
                ResultSet rs=st.executeQuery(sSql);
                while(rs.next()){
                dinero=rs.getString("dinero");
                return dinero;
                 }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar usuario: "+e);
             return dinero;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    dinero= "No pude consultar el dinero";
    return dinero;
    }
   
    public void cajasuma(Double cantidad, String idcaja){
           try {
               cn = metodospool.dataSource.getConnection();
               sSql="update caja set dinero=dinero+? where idcaja=?"; 
               PreparedStatement pst=cn.prepareStatement(sSql);
               pst.setDouble(1, cantidad);
               pst.setString(2,idcaja);
               int n=pst.executeUpdate();
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error al sumar existencia "+e);
      }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
  }
     public void cajaresta(Double cantidad, String idcaja){
           try {
               cn = metodospool.dataSource.getConnection();
               sSql="update caja set dinero=dinero-? where idcaja=?";
               PreparedStatement pst=cn.prepareStatement(sSql);
               pst.setDouble(1, cantidad);
               pst.setString(2,idcaja);
               int n=pst.executeUpdate();
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error al sumar existencia "+e);
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
