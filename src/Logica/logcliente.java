/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.datoscliente;
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
public class logcliente {
   //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    
    //Codigo para datos de tabla, creando tabla
    //La funcion buscar, recupera todos los datos de la tabla cientes
    public DefaultTableModel mostrar(String buscar) throws SQLException{
    DefaultTableModel modelo;
    
    String [] titulos = {"ID","Nombre","Apellidos","Telefono 1","Telefono 2","RFC","Correo","Negocio","Calle","Poblacion","CP","Municipio","Estado","Tipo", "Precio","Tarjeta"};
    String [] registro = new String [16];
    
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
         cn = metodospool.dataSource.getConnection();
         sSql="select * from cliente where nombre like'%"+buscar+"%' order by nombre";
         Statement st = cn.createStatement();
         ResultSet rs=st.executeQuery(sSql);
         while(rs.next()){
            registro [0]=rs.getString("idCliente");
            registro [1]=rs.getString("nombre");
            registro [2]=rs.getString("apellidos");
            registro [3]=rs.getString("tel1");
            registro [4]=rs.getString("tel2");
            registro [5]=rs.getString("rfc");
            registro [6]=rs.getString("correo");
            registro [7]=rs.getString("negocio");
            registro [8]=rs.getString("calle");
            registro [9]=rs.getString("poblacion");
            registro [10]=rs.getString("cp");
            registro [11]=rs.getString("municipio");
            registro [12]=rs.getString("estado");
            registro [13]=rs.getString("tipoCliente");
            registro [14]=rs.getString("precio");  
            registro [15]=rs.getString("tarjeta");   
            totalregistros=totalregistros+1;
            modelo.addRow(registro);
           
         }
         rs.close();
         st.close();
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
      
    public boolean insertar(datoscliente dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into cliente(idCliente,nombre,apellidos,tel1,tel2,rfc,correo,negocio,calle,poblacion,cp,municipio,estado,tipoCliente, precio,tarjeta)"+
                "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdCliente());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getApellidos());
            pst.setString(4, dts.getTel1());
            pst.setString(5, dts.getTel2());
            pst.setString(6, dts.getRfc());
            pst.setString(7, dts.getCorreo());
            pst.setString(8, dts.getNegocio());
            pst.setString(9, dts.getCalle());
            pst.setString(10, dts.getPoblacion());
            pst.setString(11, dts.getCodigopostal());
            pst.setString(12, dts.getMunicipio());
            pst.setString(13, dts.getEstado());
            pst.setString(14, dts.getTipoCliente());
            pst.setString(15, dts.getPrecio());
            pst.setString(16, dts.getTarjeta());
            int n=pst.executeUpdate();
            pst.close();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al guardar cliente: "+ e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
      
    public boolean editar(datoscliente dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update cliente set  nombre=?, apellidos=?, tel1=?,tel2=?,rfc=?,correo=?,negocio=?,calle=?,poblacion=?,cp=?,"
                + "municipio=?,estado=?,tipoCliente=?, precio=?,tarjeta=?  "+
                   "where idCliente=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getTel1());
            pst.setString(4, dts.getTel2());
            pst.setString(5, dts.getRfc());
            pst.setString(6, dts.getCorreo());
            pst.setString(7, dts.getNegocio());
            pst.setString(8, dts.getCalle());
            pst.setString(9, dts.getPoblacion());
            pst.setString(10, dts.getCodigopostal());
            pst.setString(11, dts.getMunicipio());
            pst.setString(12, dts.getEstado());
            pst.setString(13, dts.getTipoCliente());
            pst.setString(14, dts.getPrecio());
            pst.setString(15, dts.getTarjeta());
            pst.setInt(16,dts.getIdCliente());
            int n=pst.executeUpdate();
            pst.close();
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
    public boolean eliminar(datoscliente dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from cliente where idCliente=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdCliente());
            int n=pst.executeUpdate();
            pst.close();
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
    
    
    public String [] mostrararreglo(String buscar){
    String [] titulos = {"ID","Nombre","Apellidos","Telefono 1","Telefono 2","RFC","Correo","Negocio","Calle","Poblacion","CP","Municipio","Estado","Tipo", "Precio","Tarjeta"};
    String [] registro = new String [16];
    totalregistros=0;
    try {
         cn = metodospool.dataSource.getConnection();
         sSql="select * from cliente where tarjeta='"+buscar+"'";
         Statement st = cn.createStatement();
         ResultSet rs=st.executeQuery(sSql);
         while(rs.next()){
            registro [0]=rs.getString("idCliente");
            registro [1]=rs.getString("nombre");
            registro [2]=rs.getString("apellidos");
            registro [3]=rs.getString("tel1");
            registro [4]=rs.getString("tel2");
            registro [5]=rs.getString("rfc");
            registro [6]=rs.getString("correo");
            registro [7]=rs.getString("negocio");
            registro [8]=rs.getString("calle");
            registro [9]=rs.getString("poblacion");
            registro [10]=rs.getString("cp");
            registro [11]=rs.getString("municipio");
            registro [12]=rs.getString("estado");
            registro [13]=rs.getString("tipoCliente");
            registro [14]=rs.getString("precio");
            registro [15]=rs.getString("tarjeta"); 
            totalregistros=totalregistros+1;
         }
         rs.close();
         st.close();
         return registro;
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
    //Se utiliza para cuando pasa el recolector de basura
    public void finalize() throws SQLException{
        cn.close();
    }
}
