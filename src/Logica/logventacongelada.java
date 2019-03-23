/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.datosarticulo;

import Datos.datosventacongelada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ZAIR
 */
public class logventacongelada {
    //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    public Double Totalimporte=0.0;
    
    
      
      public boolean insertar(datosventacongelada dts){
        
        //No se inserta el valod de IdVenta devido a que este es un Int autoincrementable
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into ventacongelada(idcliente,tipoDoc,precioAplic,idtrabajador,"
                + "preciototal,fecha,hora)"+
                "values(?,?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1, dts.getIdCliente());
            pst.setString(2,dts.getTipoDoc());
            pst.setString(3, dts.getPrecioAplic());
            pst.setInt(4, dts.getIdtrabajador());
            pst.setString(5, dts.getPreciototal());
            pst.setString(6, dts.getFecha());
            pst.setString(7, dts.getHora());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al guardar venta congelada "+ e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
      
       public boolean editar(datosventacongelada dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update ventacongelada set  idcliente=?, tipoDoc=?,precioAplic=?,idtrabajador=?,preciototal=?,"
                + " fecha=? where idventaCongelada=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1, dts.getIdCliente());
            pst.setString(2,dts.getTipoDoc());
            pst.setString(3, dts.getPrecioAplic());
            pst.setInt(4, dts.getIdtrabajador());
            pst.setString(5, dts.getPreciototal());
            pst.setString(6, dts.getFecha());
            pst.setString(7, dts.getHora());
            pst.setInt(8, dts.getIdventaCongelada());
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
        public boolean eliminar(Integer idventacongelada){
            try {
                cn = metodospool.dataSource.getConnection();
                sSql="delete from ventacongelada where idventaCongelada='"+idventacongelada +"'";
                PreparedStatement pst=cn.prepareStatement(sSql);
               
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
    String idventacongelada= new String();
    totalregistros=0;
    try {
          cn = metodospool.dataSource.getConnection();
          sSql="SELECT MAX(idventaCongelada) FROM ventacongelada";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            idventacongelada =rs.getString("MAX(idventaCongelada)");
            }
           return idventacongelada;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al ultimaventacongelada: "+e);
            return null;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
 
     public String [] mostrarconsultaventas(String buscar){
    String [] registro = new String [8];
    totalregistros=0;
    datosarticulo datos = new datosarticulo();
    try {
        cn = metodospool.dataSource.getConnection();
        sSql="SELECT * from ventacongelada,cliente where  ventacongelada.idcliente=cliente.idcliente and "
                + "ventacongelada.idVentacongelada='"+buscar+"'";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
           registro [0]=rs.getString("ventacongelada.idventaCongelada");
            registro [1]=rs.getString("cliente.nombre")+" "+rs.getString("cliente.apellidos");
            registro [2]=rs.getString("cliente.negocio");
            registro [3]=rs.getString("ventacongelada.tipoDoc");
            registro [4]=rs.getString("ventacongelada.precioAplic");
            registro [5]=rs.getString("ventacongelada.idtrabajador");
            registro [6]=rs.getString("ventacongelada.preciototal");
            registro [7]=rs.getString("ventacongelada.idcliente");
           
            totalregistros=totalregistros+1;
            }
           return registro;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar los datos de la venta "+buscar+" : "+e);
            return null;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
      }
    }
  
      public DefaultTableModel mostrartablaventacongelada(String fecha){
    DefaultTableModel modelo;
    
    String [] titulos = {"ID","Nombre Cliente","Nombre Negocio","Tipo Doc","Precio Aplicado","ID Trabajador",
                        "Precio Total","Fecha","Hora"};
    String [] registro = new String [9];
    totalregistros=0;
   
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
        cn = metodospool.dataSource.getConnection();
        sSql="SELECT ventacongelada.idventaCongelada, ventacongelada.idcliente, ventacongelada.tipoDoc," +
"                ventacongelada.precioAplic,ventacongelada.idtrabajador,ventacongelada.preciototal," +
"                ventacongelada.fecha,ventacongelada.hora," +
"                cliente.nombre,cliente.apellidos,cliente.negocio"
                + " FROM ventacongelada,cliente"
                + " where ventacongelada.idcliente = cliente.idCliente and ventacongelada.fecha='"+fecha+"' ORDER BY ventacongelada.fecha desc ";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
           registro [0]=rs.getString("ventacongelada.idventaCongelada");
            registro [1]=rs.getString("cliente.nombre")+" "+rs.getString("cliente.apellidos");
            registro [2]=rs.getString("cliente.negocio");
            registro [3]=rs.getString("ventacongelada.tipoDoc");
            registro [4]=rs.getString("ventacongelada.precioAplic");
            registro [5]=rs.getString("ventacongelada.idtrabajador");
            registro [6]=rs.getString("ventacongelada.preciototal");
            registro [7]=rs.getString("ventacongelada.fecha");
            registro [8]=rs.getString("ventacongelada.hora");
            totalregistros=totalregistros+1;
            //Totalimporte=Totalimporte+Double.parseDouble(registro [2]);
            modelo.addRow(registro);
            }
           return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar las ventas congeladas: "+e);
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
