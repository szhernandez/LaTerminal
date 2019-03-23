/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Datos.datosarticulo;
import Datos.datosdetalleventa;
import Datos.datosdetalleventacongelada;
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
public class logdetalleventacongelada {
    //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    //Con este metodo llenare la tabla para devolver todos los datos de una venta congelada
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    String [] titulos = {"Cantidad","Codigo","Descripcion","P. Uni","Importe",
                        "Existencia","Observaciones","P. Compra","Impuesto","Fecha","Hora","P. Com"};
    String [] registro = new String [19];
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
        cn = metodospool.dataSource.getConnection();
        sSql="select * from detalleventacongelada,articulo where detalleventacongelada.idArt=articulo.idart and detalleventacongelada.idventacongelada ='"+buscar+"'";
    
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            registro [0]=rs.getString("detalleventacongelada.unidades");
            registro [1]=rs.getString("detalleventacongelada.idArt");
            registro [2]=rs.getString("articulo.descripcion");
            registro [3]=rs.getString("detalleventacongelada.pUnitario");
            registro [4]=rs.getString("detalleventacongelada.importe");
            registro [5]=rs.getString("articulo.existencia");
            registro [6]=rs.getString("detalleventacongelada.observaciones");
            registro [7]=rs.getString("articulo.precioCompra");
            registro [8]=rs.getString("detalleventacongelada.impuesto");
            registro [9]=rs.getString("detalleventacongelada.fecha");
            registro [10]=rs.getString("detalleventacongelada.hora");
            registro [11]=rs.getString("articulo.precioCompra");
            totalregistros=totalregistros+1;
            modelo.addRow(registro);
            }
           return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar articulo: "+e);
            return null;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
        
    public boolean insertar(datosdetalleventacongelada dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into detalleventacongelada(idVentaCongelada,unidades,idArt,pUnitario,importe,observaciones,"
                + "impuesto,fecha,hora)"+
                "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
           // pst.setInt(1,dts.getIdSubventa());
            pst.setInt(1, dts.getIdVentaCongelada());
            pst.setInt(2, dts.getUnidades());
            pst.setString(3, dts.getIdart());
            pst.setString(4, dts.getpUnitario());
            pst.setString(5, dts.getImporte());
            pst.setString(6, dts.getObservaciones());
            pst.setString(7, dts.getImpuesto());
            pst.setString(8, dts.getFecha());
            pst.setString(9,dts.getHora());
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
      
       public boolean editar(datosdetalleventacongelada dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update detalleventacongelada set idVentaCongelada=?,unidades=?, idArt=?, pUnitario=?,importe=?,observaciones=? ,impuesto=? ,fecha=?,hora=?"
                    + " where iddetalleVentaCongelada=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1, dts.getIdVentaCongelada());
            pst.setInt(2, dts.getUnidades());
            pst.setString(3, dts.getIdart());
            pst.setString(4, dts.getpUnitario());
            pst.setString(5, dts.getImporte());
            pst.setString(6, dts.getObservaciones());
            pst.setString(7, dts.getImpuesto());
            pst.setString(8, dts.getFecha());
            pst.setString(9,dts.getHora());
             pst.setInt(1, dts.getIdVentaCongelada());
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
        public boolean eliminar(datosdetalleventacongelada dts){
        
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from detalleventacongelada where iddetalleVentaCongelada=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIddetalleVentaCongelada());
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
        //Se utiliza para cuando pasa el recolector de basura
    public void finalize() throws SQLException{
        cn.close();
    }
}
