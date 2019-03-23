/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.datoscompra;
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
public class logcompra {
     //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    public Double Totalimporte=0.0;
    
    
      
      public boolean insertar(datoscompra dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into compra(estado,importe,idTrab,idProveedor,fecha)"+
                "values(?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getEstado());
            pst.setDouble(2, dts.getImporte());
            pst.setInt(3, dts.getIdTrab());
            pst.setInt(4, dts.getIdProveedor());
            pst.setString(5, dts.getFecha());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al registrar compra "+ e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
      
       public boolean editar(datoscompra dts){      
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update compra set  estado=?, importe=?, idTrab=?,idProveedor=?,fecha=?,"+
                   "where idcompra=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getEstado());
            pst.setDouble(2, dts.getImporte());
            pst.setInt(3, dts.getIdTrab());
            pst.setInt(4, dts.getIdProveedor());
            pst.setString(5, dts.getFecha());
            pst.setInt(6,dts.getIdcompra());
            int n=pst.executeUpdate();
            
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al modificar compra"+ e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
        public boolean eliminar(datoscompra dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from compra where idcompra=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdcompra());
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
       
        try {
            cn = metodospool.dataSource.getConnection();
            String idcompra= new String();
            totalregistros=0;
            sSql="SELECT MAX(idCompra) FROM compra";
               Statement st = cn.createStatement();
               ResultSet rs=st.executeQuery(sSql);
               while(rs.next()){
               idcompra =rs.getString("MAX(idCompra)");
             }
              return idcompra;
            } catch (Exception e) {
              JOptionPane.showConfirmDialog(null, "Su error al mostrar ultima compra: "+e);
              return null;         
            }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
        
        
          public DefaultTableModel mostrartablacompra(String fecha){
    DefaultTableModel modelo;
    
    String [] titulos = {"ID","Estado","Importe","Fecha","Proveedor","Representante",
                        "Telefono","Id Trabj","Nombre Trab","Apellidos Trab"};
    String [] registro = new String [16];
    totalregistros=0;
   
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
        cn = metodospool.dataSource.getConnection();
        sSql="SELECT compra.idCompra, compra.estado, compra.importe,compra.idTrab,compra.fecha,compra.idProveedor," +
"proveedor.idProveedor,proveedor.nombre as nombreproveedor,proveedor.direccion,proveedor.tel1,proveedor.tel2,proveedor.correo, proveedor.representante," +
"trabajador.idTrab, trabajador.nombre as nommbretrabajador, trabajador.apellidos as apellidostrabajador FROM compra,proveedor, trabajador where " +
"            compra.idTrab=trabajador.idTrab and compra.idProveedor=proveedor.idProveedor and "
                + "compra.fecha like '"+fecha+"%' ORDER BY compra.fecha desc";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
           registro [0]=rs.getString("compra.idCompra");
            registro [1]=rs.getString("compra.estado");
            registro [2]=rs.getString("compra.importe");
            registro [3]=rs.getString("compra.fecha");
            registro [4]=rs.getString("nombreproveedor");
            registro [5]=rs.getString("proveedor.representante");
            registro [6]=rs.getString("proveedor.tel1");
            registro [7]=rs.getString("trabajador.idTrab");
            registro [8]=rs.getString("nommbretrabajador")+" "+rs.getString("apellidostrabajador");
            registro [9]=rs.getString("apellidostrabajador");
            
            
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
