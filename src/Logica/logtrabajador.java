/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.datostrabajador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ZAIR
 */
public class logtrabajador {
    //private conexion mysql=new conexion();
    Pool_conexion metodospool = new Pool_conexion();
    private Connection cn = null;
    private String sSql="";
    public Integer totalregistros;
    
    
    public DefaultTableModel mostrar(String buscar){
    DefaultTableModel modelo;
    String [] titulos = {"ID","Nombre","Apellidos","Telefono","Domicilio","Usuario","Contraseña","Rol","Estado","Comision"};
    String [] registro = new String [10];
    totalregistros=0;
    modelo= new DefaultTableModel(null,titulos){
        //Haciendo la tabla no editable
    public boolean isCellEditable(int row, int column) {return false;}};
    try {
        cn = metodospool.dataSource.getConnection();
        sSql="select * from trabajador where nombre like'%"+buscar+"%' order by idTrab";
           Statement st = cn.createStatement();
           ResultSet rs=st.executeQuery(sSql);
            while(rs.next()){
            registro [0]=rs.getString("idtrab");
            registro [1]=rs.getString("nombre");
            registro [2]=rs.getString("apellidos");
            registro [3]=rs.getString("telefono");
            registro [4]=rs.getString("domicilio");
            registro [5]=rs.getString("usuario");
            registro [6]=rs.getString("contrasena");
            registro [7]=rs.getString("rol");
            registro [8]=rs.getString("estado");
            registro [9]=rs.getString("comision");
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
    
    public boolean insertar(datostrabajador dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="insert into trabajador(idTrab,nombre,apellidos,telefono,domicilio,usuario,contrasena,rol,estado,comision)"+
                "values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdTrab());
            pst.setString(2, dts.getNombre());
            pst.setString(3, dts.getApellidos());
            pst.setString(4, dts.getTelefono());
            pst.setString(5, dts.getDomicilio());
            pst.setString(6, dts.getUsuario());
            pst.setString(7, dts.getContrasena());
            pst.setString(8, dts.getRol());
            pst.setString(9, dts.getEstado());
            pst.setString(10, dts.getComision());
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
    
    public boolean editar(datostrabajador dts){
        try {
            cn = metodospool.dataSource.getConnection();
            sSql="update trabajador set  nombre=?, apellidos=?, telefono=?,domicilio=?,usuario=?,contrasena=?,rol=?,estado=?, comision=?"+
                   "where idTrab=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApellidos());
            pst.setString(3, dts.getTelefono());
            pst.setString(4, dts.getDomicilio());
            pst.setString(5, dts.getUsuario());
            pst.setString(6, dts.getContrasena());
            pst.setString(7, dts.getRol());
            pst.setString(8, dts.getEstado());
            pst.setString(9, dts.getComision());
            pst.setInt(10,dts.getIdTrab());
            int n=pst.executeUpdate();
            if(n!=0){
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error al editar trabajador *logtra* "+ e);
            return false;
        }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
    }
    
    public boolean eliminar(datostrabajador dts){
        try {
            cn = metodospool.dataSource.getConnection();    
            sSql="delete from trabajador where idTrab=?";
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdTrab());
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
    
    public ArrayList<datostrabajador> consultatrabajador() {
        datostrabajador dts;
        ArrayList<datostrabajador> impuestosList = new ArrayList<>();
   try {
        cn = metodospool.dataSource.getConnection();
        sSql="SELECT * FROM impuesto order by valor";
        Statement st = cn.createStatement();
        ResultSet rs=st.executeQuery(sSql);
     
        while(rs.next()==true){
            dts=new datostrabajador();
            dts.setIdTrab(rs.getInt("idTrab"));
            dts.setNombre(rs.getString("nombre"));
            dts.setApellidos(rs.getString("apellidos"));
            impuestosList.add(dts);
        }  
        
    } catch (SQLException e) {
   System.out.println("Error en la consulta de impuestos: "+e.getMessage());
  }finally{
        try {
            cn.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión pool", JOptionPane.ERROR_MESSAGE);

        }
        }
   return impuestosList;
   }
    
    //Se utiliza para cuando pasa el recolector de basura
    public void finalize() throws SQLException{
        cn.close();
    }
}
