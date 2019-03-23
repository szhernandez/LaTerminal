/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.datosarticulo;
import Datos.datosdetalleventa;
import Datos.datosventa;
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
public class logventa {
    //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    public Double Totalimporte=0.0;
    
    
      
      public boolean insertar(datosventa dts){
        
        //No se inserta el valod de IdVenta devido a que este es un Int autoincrementable
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into venta(estado,importe,pago,fecha,hora,idCliente,"
                + "idTrab,idCaja)"+
                "values(?,?,?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getEstado());
            pst.setDouble(2, dts.getImporte());
            pst.setDouble(3, dts.getPago());
            pst.setString(4,dts.getFecha());
            pst.setString(5, dts.getHora());
            pst.setDouble(6, dts.getIdCliente());
            pst.setDouble(7, dts.getIdTrab());
            pst.setString(8, dts.getIdCaja());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
            
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al cerrar la venta:(prueba venta) "+ e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
      
       public boolean editar(datosventa dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update venta set  estado=?, importe=?, pago=?,fecha=?,hora=?,idCliente=?,"
                + "idTrab=?, idCaja=? where idVenta=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getEstado());
            pst.setDouble(2, dts.getImporte());
            pst.setDouble(3, dts.getPago());
            pst.setString(4,dts.getFecha());
            pst.setString(5, dts.getHora());
            pst.setDouble(6, dts.getIdCliente());
            pst.setDouble(7, dts.getIdTrab());
            pst.setString(8, dts.getIdCaja());
            pst.setInt(9,dts.getIdVenta());
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
        public boolean eliminar(datosventa dts){
            try {
                cn = metodospool.dataSource.getConnection();
                sSql="delete from venta where idventa=?";
                PreparedStatement pst=cn.prepareStatement(sSql);
                pst.setInt(1,dts.getIdVenta());
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
          sSql="SELECT MAX(idventa) FROM venta";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            idventa =rs.getString("MAX(idventa)");
            }
           return idventa;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al ultimaventa: "+e);
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
    String [] registro = new String [19];
    totalregistros=0;
    datosarticulo datos = new datosarticulo();
    try {
        cn = metodospool.dataSource.getConnection();
        sSql="SELECT venta.idVenta, venta.estado, venta.importe,venta.pago,venta.fecha,venta.hora,venta.idCaja,"
            + "cliente.idCliente,cliente.nombre,cliente.apellidos,cliente.negocio, cliente.tipoCliente,cliente.precio,"
            + "trabajador.idTrab,trabajador.nombre,trabajador.apellidos,"
            + "detalleventa.idSubventa,detalleventa.idArt,articulo.descripcion,detalleventa.precio,detalleventa.precioCompra,"
            + "detalleventa.unidades,detalleventa.impuesto,detalleventa.subtotal "
            + "FROM venta, detalleventa,articulo,cliente,trabajador where "
            + "venta.idVenta = detalleventa.idVenta AND detalleventa.idArt=articulo.idArt "
            + "and venta.idCliente=cliente.idCliente and venta.idTrab=trabajador.idTrab "
            + "and venta.idVenta='"+buscar+"'";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
           registro [0]=rs.getString("venta.idVenta");
            registro [1]=rs.getString("venta.estado");
            registro [2]=rs.getString("venta.importe");
            registro [3]=rs.getString("venta.pago");
            registro [4]=rs.getString("venta.fecha");
            registro [5]=rs.getString("venta.hora");
            registro [6]=rs.getString("venta.idCaja");
            registro [7]=rs.getString("cliente.idCliente");
            registro [8]=rs.getString("cliente.nombre");
            registro [9]=rs.getString("cliente.apellidos");
            registro [10]=rs.getString("cliente.negocio");
            registro [11]=rs.getString("cliente.tipoCliente");
            registro [12]=rs.getString("cliente.precio");
            registro [13]=rs.getString("trabajador.idTrab");
            registro [14]=rs.getString("trabajador.nombre");
            registro [15]=rs.getString("trabajador.apellidos");
            totalregistros=totalregistros+1;
            }
           return registro;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar articulo seleccionado en venta: "+e);
            return null;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
  
    public DefaultTableModel mostrartablaventa(String fecha){
    DefaultTableModel modelo;
    
    String [] titulos = {"ID","Estado","Importe","Pago","Fecha","Hora",
                        "ID Cliente","Nombre","Apellidos","Negocio"};
    String [] registro = new String [16];
    totalregistros=0;
   
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
        cn = metodospool.dataSource.getConnection();
        sSql="SELECT venta.idVenta, venta.estado, venta.importe,venta.pago,venta.fecha,venta.hora,venta.idCaja,"
            + "cliente.idCliente,cliente.nombre,cliente.apellidos,cliente.negocio,cliente.tipoCliente,cliente.precio "
            + "FROM venta,cliente where "
            + " venta.idCliente=cliente.idCliente and venta.fecha='"+fecha+"' ORDER BY venta.fecha desc ";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
           registro [0]=rs.getString("venta.idVenta");
            registro [1]=rs.getString("venta.estado");
            registro [2]=rs.getString("venta.importe");
            registro [3]=rs.getString("venta.pago");
            registro [4]=rs.getString("venta.fecha");
            registro [5]=rs.getString("venta.hora");
            registro [6]=rs.getString("cliente.idCliente");
            registro [7]=rs.getString("cliente.nombre");
            registro [8]=rs.getString("cliente.apellidos");
            registro [9]=rs.getString("cliente.negocio");
            totalregistros=totalregistros+1;
            Totalimporte=Totalimporte+Double.parseDouble(registro [2]);
            modelo.addRow(registro);
            }
           return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar articulo seleccionado en venta: "+e);
            return null;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    
    //Funcion para devolver todas las ventas con estado igual a preventa
    public DefaultTableModel mostrartablapreventa(String fecha){
    DefaultTableModel modelo;
    
    String [] titulos = {"ID","Estado","Importe","Pago","Fecha","Hora",
                        "ID Cliente","Nombre","Apellidos","Negocio"};
    String [] registro = new String [16];
    totalregistros=0;
   
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
        cn = metodospool.dataSource.getConnection();
        sSql="SELECT venta.idVenta, venta.estado, venta.importe,venta.pago,venta.fecha,venta.hora,venta.idCaja,"
            + "cliente.idCliente,cliente.nombre,cliente.apellidos,cliente.negocio,cliente.tipoCliente,cliente.precio "
            + "FROM venta,cliente where "
            + " venta.idCliente=cliente.idCliente and venta.estado='Preventa' and venta.fecha='"+fecha+"' ORDER BY venta.fecha desc ";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
           registro [0]=rs.getString("venta.idVenta");
            registro [1]=rs.getString("venta.estado");
            registro [2]=rs.getString("venta.importe");
            registro [3]=rs.getString("venta.pago");
            registro [4]=rs.getString("venta.fecha");
            registro [5]=rs.getString("venta.hora");
            registro [6]=rs.getString("cliente.idCliente");
            registro [7]=rs.getString("cliente.nombre");
            registro [8]=rs.getString("cliente.apellidos");
            registro [9]=rs.getString("cliente.negocio");
            totalregistros=totalregistros+1;
            Totalimporte=Totalimporte+Double.parseDouble(registro [2]);
            modelo.addRow(registro);
            }
           return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar articulo seleccionado en venta: "+e);
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
