/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.datosproveedor;
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
public class logproveedor {
    //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    //Codigo para datos de tabla, creando tabla
    //La funcion buscar, recupera todos los datos de la tabla cientes
      public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    String [] titulos = {"ID","Nombre","Direccion","Telefono 1","Telefono 2","Correo","Representante"};
    String [] registro = new String [7];
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
        cn = metodospool.dataSource.getConnection();
         sSql="select * from proveedor where nombre like'%"+buscar+"%' order by idProveedor";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            registro [0]=rs.getString("idProveedor");
            registro [1]=rs.getString("nombre");
            registro [2]=rs.getString("direccion");
            registro [3]=rs.getString("tel1");
            registro [4]=rs.getString("tel2");
            registro [5]=rs.getString("correo");
            registro [6]=rs.getString("representante");
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
      
    public boolean insertar(datosproveedor dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into proveedor(idProveedor,nombre,direccion,tel1,tel2,correo,representante)"+
                "values(?,?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdProveedor());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getDireccion());
            pst.setString(4, dts.getTel1());
            pst.setString(5, dts.getTel2());
            pst.setString(6, dts.getCorreo());
            pst.setString(7, dts.getRepresentante());
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
      
       public boolean editar(datosproveedor dts){
        try {
            cn = metodospool.dataSource.getConnection();
             sSql="update proveedor set  nombre=?, direccion=?, tel1=?,tel2=?,correo=?,representante=?"+
                   "where idProveedor=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDireccion());
            pst.setString(3, dts.getTel1());
            pst.setString(4, dts.getTel2());
            pst.setString(5, dts.getCorreo());
            pst.setString(6, dts.getRepresentante());
            pst.setInt(7,dts.getIdProveedor());
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
        public boolean eliminar(datosproveedor dts){
            try {
                cn = metodospool.dataSource.getConnection();
                sSql="delete from proveedor where idProveedor=?";
                PreparedStatement pst=cn.prepareStatement(sSql);
                pst.setInt(1,dts.getIdProveedor());
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
