/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.datoscaja;
import Datos.datosmovimientos_caja;
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
public class logmovimientos_caja {
    //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrarmovimientos(String caja){
    DefaultTableModel modelo;
    String [] titulos = {"ID","Monto","Concepto","Trabajador","Fecha"};
    String [] registro = new String [5];
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
   
    try {
        cn = metodospool.dataSource.getConnection();
         sSql="SELECT movimiento_caja.idmovimiento, movimiento_caja.Monto, movimiento_caja.Concepto, movimiento_caja.fecha, movimiento_caja.idCaja, "
            + "trabajador.nombre,trabajador.apellidos FROM movimiento_caja, trabajador "
            + "WHERE movimiento_caja.IdTrab= trabajador.idTrab and movimiento_caja.idCaja='"+caja+"' order by movimiento_caja.fecha";
    
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            registro [0]=rs.getString("movimiento_caja.idmovimiento");
            registro [1]=rs.getString("movimiento_caja.Monto");
            registro [2]=rs.getString("movimiento_caja.Concepto");
            registro [3]=rs.getString("trabajador.nombre")+" "+rs.getString("trabajador.apellidos");
            registro [4]=rs.getString("movimiento_caja.fecha");
            totalregistros=totalregistros+1;
            modelo.addRow(registro);
            }
           return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar movimientos de caja: "+e);
            return null;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    
     public DefaultTableModel mostrarmovimientosxfecha(String caja, String finicial, String ffinal){
    DefaultTableModel modelo;
    
    String [] titulos = {"ID","Monto","Concepto","Trabajador","Fecha"};
    String [] registro = new String [5];
    
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
        cn = metodospool.dataSource.getConnection();
        sSql="SELECT movimiento_caja.idmovimiento, movimiento_caja.Monto, movimiento_caja.Concepto, movimiento_caja.fecha, "
            + "movimiento_caja.idCaja,trabajador.nombre,trabajador.apellidos FROM movimiento_caja, trabajador "
            + "WHERE movimiento_caja.IdTrab=trabajador.idTrab and movimiento_caja.idCaja='"+caja+"'"
            + "and DATE(movimiento_caja.fecha) BETWEEN '"+finicial+"' and '"+ffinal+"' order BY movimiento_caja.fecha asc";
    
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            registro [0]=rs.getString("movimiento_caja.idmovimiento");
            registro [1]=rs.getString("movimiento_caja.Monto");
            registro [2]=rs.getString("movimiento_caja.Concepto");
            registro [3]=rs.getString("trabajador.nombre")+" "+rs.getString("trabajador.apellidos");
            registro [4]=rs.getString("movimiento_caja.fecha");
            totalregistros=totalregistros+1;
            modelo.addRow(registro);
            }
           return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al mostrar movimientos de caja: "+e);
            return null;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    
    public boolean insertar(datosmovimientos_caja dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into movimiento_caja(Monto,Concepto,fecha,IdTrab,idCaja)"+
                "values(?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setDouble(1, dts.getMonto());
            pst.setString(2, dts.getConcepto());
            pst.setString(3, dts.getFecha());
            pst.setDouble(4, dts.getIdTrab());
            pst.setString(5, dts.getIdcaja());
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
    
    public boolean editar(datosmovimientos_caja dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update movimiento_caja set  Monto=?, 	concepto=?, fecha=? where idmovimiento=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setDouble(1, dts.getMonto());
            pst.setString(2, dts.getConcepto());
            pst.setString(3, dts.getFecha());
            pst.setInt(4,dts.getIdmovimiento());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Fallo update *movimiento_caja* "+ e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    
    public boolean eliminar(datosmovimientos_caja dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="delete from movimiento_caja where idmovimiento=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdmovimiento());
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
    
    public String mostrarultimo(){
    String ultimoid= new String();
    totalregistros=0;
    try {
           cn = metodospool.dataSource.getConnection();
           sSql="SELECT MAX(idmovimiento) FROM movimiento_caja";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
           while(rs.next()){
           ultimoid =rs.getString("MAX(idmovimiento)");
            }
           return ultimoid;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Su error al ultimo movimiento: "+e);
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
