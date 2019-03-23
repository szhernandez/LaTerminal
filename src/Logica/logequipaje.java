/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.datosarticulo;
import Datos.datosdetalleventa;
import Datos.datosequipaje;
import Datos.datosventa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ZAIR
 */
public class logequipaje {
    private conexion mysql=new conexion();
    private Connection cn=mysql.conectar();
    private String sSql="";
    public Integer totalregistros;
     public Double Totalimporte=0.0;
    
    
      
      public boolean insertar(datosequipaje dts){
        sSql="insert into equipaje(propietario,estado,importe,pago,fecha,hora,idCliente,"
                + "idTrab,idCaja)"+
                "values(?,?,?,?,?,?,?,?,?)";
        
        //No se inserta el valod de IdVenta devido a que este es un Int autoincrementable
        try {
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getPropietario());
            pst.setString(2, dts.getEstado());
            pst.setDouble(3, dts.getImporte());
            pst.setDouble(4, dts.getPago());
            pst.setString(5,dts.getFecha());
            pst.setString(6, dts.getHora());
            pst.setDouble(7, dts.getIdCliente());
            pst.setDouble(8, dts.getIdTrab());
            pst.setString(9, dts.getIdCaja());
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
        }
    }
      
       public boolean editar(datosequipaje dts){
        sSql="update equipaje set  propietario=?,estado=?, importe=?, pago=?,fecha=?,hora=?,idCliente=?,"
                + "idTrab=?, idCaja=? where idequipaje=?";
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getPropietario());
            pst.setString(2, dts.getEstado());
            pst.setDouble(3, dts.getImporte());
            pst.setDouble(4, dts.getPago());
            pst.setString(5,dts.getFecha());
            pst.setString(6, dts.getHora());
            pst.setDouble(7, dts.getIdCliente());
            pst.setDouble(8, dts.getIdTrab());
            pst.setString(9, dts.getIdCaja());
            pst.setInt(10,dts.getIdEquipaje());
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
        }
    }
        public boolean eliminar(datosequipaje dts){
        sSql="delete from equipaje where idequipaje=?";
        
        
            try {
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdEquipaje());
           
            
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
        }
    }
        
        
      public String mostrarultima(){
   
    String idequipaje= new String();
    totalregistros=0;
   
    
    sSql="SELECT MAX(	idEquipaje) FROM equipaje";
    
    try {
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
           
            idequipaje =rs.getString("MAX(	idEquipaje)");
           
            }
           return idequipaje;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al ultimo registro de equipaje: "+e);
            return null;
        }
    }
 
     public String [] mostrarconsultaequipaje(String buscar){
   
    String [] registro = new String [30];
    totalregistros=0;
   
    datosarticulo datos = new datosarticulo();
    sSql="SELECT equipaje.idEquipaje, equipaje.propietario, equipaje.estado, equipaje.importe, equipaje.pago, equipaje.fecha, "
            + "equipaje.hora,equipaje.idCaja," +
    "cliente.idCliente,cliente.nombre,cliente.apellidos,cliente.tipoCliente,cliente.precio," +
    "trabajador.idTrab,trabajador.nombre,trabajador.apellidos," +
    "detalle_equipaje.idArt,articulo.descripcion,detalle_equipaje.precio, detalle_equipaje.precioCompra," +
    "detalle_equipaje.unidades, detalle_equipaje.tiempo, detalle_equipaje.subtotal, detalle_equipaje.observ," +
    "detalle_equipaje.fechainicio, detalle_equipaje.fechafin " +
    "FROM equipaje,detalle_equipaje,articulo,cliente,trabajador WHERE " +
    "equipaje.idEquipaje = detalle_equipaje.idEquipaje AND detalle_equipaje.idArt=articulo.idArt " +
    "and equipaje.idCliente=cliente.idCliente and equipaje.idTrab=trabajador.idTrab " +
    "and equipaje.idEquipaje='"+buscar+"'";
    
    try {
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
           registro [0]=rs.getString("equipaje.idEquipaje");
            registro [1]=rs.getString("equipaje.propietario");
            registro [2]=rs.getString("equipaje.estado");
            registro [3]=rs.getString("equipaje.importe");
            registro [4]=rs.getString("equipaje.pago");
            registro [5]=rs.getString("equipaje.fecha");
            registro [6]=rs.getString("equipaje.hora");
            registro [7]=rs.getString("equipaje.idCaja");
            registro [8]=rs.getString("cliente.idCliente");
            registro [9]=rs.getString("cliente.nombre");
            registro [10]=rs.getString("cliente.apellidos");
            registro [11]=rs.getString("cliente.tipoCliente");
            registro [12]=rs.getString("cliente.precio");
            registro [13]=rs.getString("trabajador.idTrab");
            registro [14]=rs.getString("trabajador.nombre");
            registro [15]=rs.getString("trabajador.apellidos");
            registro [16]=rs.getString("detalle_equipaje.idArt");
            registro [17]=rs.getString("articulo.descripcion");
            registro [18]=rs.getString("detalle_equipaje.precio");
            registro [19]=rs.getString("detalle_equipaje.precioCompra");
            registro [20]=rs.getString("detalle_equipaje.unidades");
            registro [21]=rs.getString("detalle_equipaje.tiempo");
            registro [22]=rs.getString("detalle_equipaje.subtotal");
            registro [23]=rs.getString("detalle_equipaje.observ");
            registro [24]=rs.getString("detalle_equipaje.fechainicio");
            registro [25]=rs.getString("detalle_equipaje.fechafin");
            totalregistros=totalregistros+1;
           
           
            }
           return registro;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar articulo seleccionado en venta: "+e);
            return null;
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
    sSql="SELECT venta.idVenta, venta.estado, venta.importe,venta.pago,venta.fecha,venta.hora,venta.idCaja,"
            + "cliente.idCliente,cliente.nombre,cliente.apellidos,cliente.negocio,cliente.tipoCliente,cliente.precio "
            + "FROM venta,cliente where "
            + " venta.idCliente=cliente.idCliente and venta.fecha='"+fecha+"' ORDER BY venta.fecha desc ";
            
    
    try {
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
            Totalimporte=Totalimporte+Double.parseDouble(registro [3]);
            modelo.addRow(registro);
           
            }
           return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar articulo seleccionado en venta: "+e);
            return null;
        }
    }
 
}
