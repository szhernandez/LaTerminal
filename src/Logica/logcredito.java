/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.datoscaja;
import Datos.datoscredito;
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
public class logcredito {
     //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    
    public DefaultTableModel tablacredito(String buscar){
    DefaultTableModel modelo;
    
    String [] titulos = {"ID","Nombre","Dinero","Fecha"};
    String [] registro = new String [4];
    
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
        cn = metodospool.dataSource.getConnection();
         sSql="select credito.idcliente,cliente.nombre,cliente.apellidos,credito.saldo,credito.limite,credito.fecha "
            + "FROM cliente, credito where cliente.idCliente=credito.idcliente and cliente.idCliente='"+buscar+"'";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            registro [0]=rs.getString("credito.idcliente");
            registro [1]=rs.getString("cliente.nombre")+" "+rs.getString("cliente.apellidos");
            registro [2]=rs.getString("credito.saldo");
            registro [3]=rs.getString("credito.limite");
            registro [4]=rs.getString("credito.fecha ");
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
    
     public String[] mostrar(String buscar){
    
    String [] registro = new String [10];
    try {
        cn = metodospool.dataSource.getConnection();
         sSql="select credito.idcliente,cliente.nombre,cliente.apellidos,credito.saldo,credito.limite,credito.fecha "
            + "FROM cliente, credito where cliente.idCliente=credito.idcliente and cliente.idCliente='"+buscar+"'";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            registro [0]=rs.getString("credito.idcliente");
            registro [1]=rs.getString("cliente.nombre")+" "+rs.getString("cliente.apellidos");
            registro [2]=rs.getString("credito.saldo");
            registro [3]=rs.getString("credito.limite");
            registro [4]=rs.getString("credito.fecha");
            }
           return registro;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar los datos del credito: "+e);
            return null;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    public boolean insertar(datoscredito dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into credito(idcliente,saldo,limite,fecha)"+
                "values(?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdcliente());
            pst.setDouble(2, dts.getSaldo());
            pst.setDouble(3, dts.getLimite());
            pst.setString(4, dts.getFecha());
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
    
    public boolean editar(datoscredito dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update credito set  saldo=?,limite=?, fecha=? where idcliente=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setDouble(1, dts.getSaldo());
            pst.setString(2, dts.getFecha());
            pst.setInt(3,dts.getIdcliente());
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
    
    
    public boolean eliminar(datoscredito dts){
            try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from caja where idCaja=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdcliente());
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
    
       public boolean updatelimite(datoscredito dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update credito set limite=? where idcliente=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setDouble(1, dts.getLimite());
            pst.setInt(2, dts.getIdcliente());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Fallo update credito "+ e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    public boolean updatecredito(datoscredito dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update credito set saldo=? where idcliente=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setDouble(1, dts.getSaldo());
            pst.setInt(2, dts.getIdcliente());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Fallo update credito "+ e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    
    public String creditoconsulta(String idcliente){
         String dinero="";   
        try {
           cn = metodospool.dataSource.getConnection();
           sSql="Select * from credito where idcaja='"+idcliente+"'";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            dinero=rs.getString("saldo");
            return dinero;
            }
         
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar credito: "+e);
             return dinero;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
           dinero= "No pude consultar el credito";
            return dinero;
    }
   
    public boolean abono(String fecha,Double cantidad, Integer idcliente){
          
           try {
           cn = metodospool.dataSource.getConnection();
           sSql="update credito set fecha=?,  saldo=saldo+? where idcliente=?";
           PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, fecha);
            pst.setDouble(2, cantidad);
            pst.setInt(3,idcliente);
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error al agregar credito  "+e);
          return false;
      }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
  }
     public boolean cargo(String fecha,Double cantidad, Integer idcliente){
           try {
            cn = metodospool.dataSource.getConnection();
            sSql="update credito set fecha=?, saldo=saldo-? where idcliente=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, fecha);
             pst.setDouble(2, cantidad);
             pst.setInt(3,idcliente);
                int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error al agregar pago "+e);
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
